package Controlador;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelo.ConstBaseDatos;
import Modelo.CConsultar;
import Modelo.CContarRegistros;
import Modelo.CInsertar;
import Modelo.CModificar;
import Modelo.Conexion;
import Vista.CambiarPanel;
import Vista.FrameVistaPrincipal;

public class ControlPrincipal extends FrameVistaPrincipal implements ActionListener {

	private CambiarPanel cambiar;
	private ControlInicioCuadre CtrlInicioCuadre;
	private ControlDesglose CtrlDesglose;
	private ControlCuadreFinal CtrlCuadreFinal;
	private ControlHistorial CtrlHistorialCuadre;
	private ControlNota CtrlNota;
	private ControlConfig CtrlConfig;
	private int pnlSiguiente = 0;
	private boolean visibleOnTop = false;

	public ControlPrincipal(boolean visibleOnTop) {
		
		this.visibleOnTop = visibleOnTop;
		this.setAlwaysOnTop(visibleOnTop);
		this.cambiar = new CambiarPanel();
		this.CtrlInicioCuadre = new ControlInicioCuadre();
		this.CtrlDesglose = new ControlDesglose();
		this.CtrlCuadreFinal = new ControlCuadreFinal();
		this.CtrlHistorialCuadre = new ControlHistorial(visibleOnTop);
		this.CtrlNota = new ControlNota();
		this.CtrlNota.setAlwaysOnTop(this.visibleOnTop);
		
		this.CtrlConfig = new ControlConfig();

		BtnCuadrar.addActionListener(this);
		BtnHistorial.addActionListener(this);
		BtnAtras.addActionListener(this);
		BtnSig.addActionListener(this);
		BtnGuardar.addActionListener(this);
		BtnConfig.addActionListener(this);

		BtnAtras.setEnabled(false);
		PanelInferior.setVisible(false);
		BtnGuardar.setVisible(false);
		CheckNota.setVisible(false);

		// BtnCuadrar.doClick();//hacer clic a cuadrar

	}

	private void escogerPanel(int nPanel) {// para escoger los paneles con los botones siguiente y atras

		switch (nPanel) {

		case 0:// panel de inicio cuadre
			cambiar.cambiarPNL(PanelCentral, CtrlInicioCuadre);
			BtnAtras.setEnabled(false);
			BtnGuardar.setVisible(false);
			CheckNota.setVisible(false);

			break;
		case 1:// panel de desglose
			if (CtrlInicioCuadre.getDatos() != null) {// comprobar si esta valido el formulario
				cambiar.cambiarPNL(PanelCentral, CtrlDesglose);
				BtnAtras.setEnabled(true);
				BtnSig.setEnabled(true);
				BtnGuardar.setVisible(false);
				CheckNota.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(this, "Formulario inválido. Por favor verifique", "Formulario",
						JOptionPane.WARNING_MESSAGE);
				pnlSiguiente = 0;// reiniciar la variable
			}
			break;
		case 2:// resumen del cuadre

			cambiar.cambiarPNL(PanelCentral, CtrlCuadreFinal);
			BtnSig.setEnabled(false);
			BtnGuardar.setVisible(true);
			CheckNota.setVisible(true);

			CtrlCuadreFinal.calcularCuadre(CtrlInicioCuadre.getDatos(), CtrlInicioCuadre.getSumaTotal(),
					CtrlDesglose.getSumaTotal());
			CtrlCuadreFinal.presentarResumen();

			break;
		}
	}

	private void actualizarResumen() {

		if (CheckNota.isSelected())// si esta chequeado para insertar nota
		{
			CtrlNota.setTexto("");// limpiar
			CtrlNota.setModal(true);
			CtrlNota.setVisible(true);
		} else {
			CtrlNota.setTexto("- Sin nota que mostrar -");// indicar que esta vacio
		}

		String _nota = CtrlNota.getTexto();// guardar el texto del texArea

		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursos en espera

		Conexion ObjConector = new Conexion(ConstBaseDatos.rutaBD);
		CModificar mod = new CModificar(ObjConector.conectar(), "registro_cuadres");

		mod.agregarValor("fecha", CtrlInicioCuadre.getDatos().get(0));
		mod.agregarValor("inicio_caja", CtrlInicioCuadre.getDatos().get(1));
		mod.agregarValor("ventas", CtrlInicioCuadre.getDatos().get(2));
		mod.agregarValor("gastos", CtrlInicioCuadre.getDatos().get(3));
		mod.agregarValor("dinero_real", CtrlDesglose.getSumaTotal());
		mod.agregarValor("sobra_falta", CtrlCuadreFinal.getDatos().get(0));
		mod.agregarValor("cuadre_final", CtrlCuadreFinal.getDatos().get(1));
		mod.agregarValor("nota", _nota);

		mod.setDonde("fecha", CtrlInicioCuadre.getDatos().get(0));

		if (!mod.ejecutarSQL()) {
			JOptionPane.showMessageDialog(this, "Error al actualizar en la Base de Datos", "Error Sqlite",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Resumen actualizado correctamente.", "Actualizar",
					JOptionPane.INFORMATION_MESSAGE);
		}

		ObjConector.cerrar();// cerrar la conexion
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// cursor por defecto
		BtnHistorial.doClick();// hacer click en el historial
	}

	private void guardarResumen() {

		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursos en espera
		Conexion ObjConector = new Conexion(ConstBaseDatos.rutaBD);
		CConsultar con = new CConsultar(ObjConector.conectar(), "registro_cuadres");

		con.consultar("fecha", "fecha", "=", CtrlInicioCuadre.getDatos().get(0));// consultar la fecha

		ResultSet rs = con.getResultadoConsulta();

		try {
			while (rs.next()) {// en busca de un cuadre que ya exista con la fecha que se esta registrando el
								// resumen actualmente

				if (rs.getString("fecha").equals(CtrlInicioCuadre.getDatos().get(0))) {
					// si el cuadre ya existe

					ObjConector.cerrar();// cerrar la conexion

					this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// poner cursos por default

					String _msjNota = "";

					if (CheckNota.isSelected())// si esta chequeado para indicar el mensaje
					{
						_msjNota = " (Tenga en cuenta\nque debe volver a escribir la nota si escribió una antes)";
					}

					int opcion = JOptionPane.showConfirmDialog(
							this, "Ya existe un registro con la misma fecha." + "\n¿Quiere actualizar el registro"
									+ _msjNota + "?",
							"Actualizar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (opcion == JOptionPane.YES_OPTION) {
						actualizarResumen();// si la opcion es que si pues se actualiza
					}
					return;// retornar
				}

			}
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(this, "Error al buscar un registro existente \n" + e.getMessage(),
					"Error Sqlite", JOptionPane.ERROR_MESSAGE);
		}

		if (CheckNota.isSelected())// si esta chequeado para insertar nota
		{
			CtrlNota.setTexto("");// limpiar
			CtrlNota.setModal(true);
			CtrlNota.setVisible(true);
		} else {
			CtrlNota.setTexto("- Sin nota que mostrar -");// indicar que esta vacio
		}

		String _nota = CtrlNota.getTexto();// guardar el texto del texArea

		CInsertar in = new CInsertar(ObjConector.conectar(), "registro_cuadres");

		// agregando los valores
		in.agregarValor("fecha", CtrlInicioCuadre.getDatos().get(0));
		in.agregarValor("inicio_caja", CtrlInicioCuadre.getDatos().get(1));
		in.agregarValor("ventas", CtrlInicioCuadre.getDatos().get(2));
		in.agregarValor("gastos", CtrlInicioCuadre.getDatos().get(3));
		in.agregarValor("dinero_real", CtrlDesglose.getSumaTotal());
		in.agregarValor("sobra_falta", CtrlCuadreFinal.getDatos().get(0));
		in.agregarValor("cuadre_final", CtrlCuadreFinal.getDatos().get(1));
		in.agregarValor("nota", _nota);

		if (!in.ejecutarSQL()) {
			JOptionPane.showMessageDialog(this, "Error al guardar en la Base de Datos", "Error Sqlite",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Resumen guardado correctamente.", "Guardado",
					JOptionPane.INFORMATION_MESSAGE);
		}
		ObjConector.cerrar();// cerrar la conexion
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		BtnHistorial.doClick();// hacer click
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/////////// boton cuadrar////////////////
		if (e.getSource().equals(BtnCuadrar)) {

			escogerPanel(pnlSiguiente);
			PanelInferior.setVisible(true);

		}

		/////////// boton historial////////////////
		if (e.getSource().equals(BtnHistorial)) {

			this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursor en espera
			CContarRegistros contar = new CContarRegistros();// para contar si existe un registro

			if (contar.contarReg(ConstBaseDatos.rutaBD, "registro_cuadres") > 0) {// si existen registros

				PanelInferior.setVisible(false);

				this.CtrlHistorialCuadre.Ordenar.setSelectedIndex(1);// presentar en orden descendente
				this.CtrlHistorialCuadre.Fecha.setDate(new Date());
				cambiar.cambiarPNL(PanelCentral, CtrlHistorialCuadre);

			} else {
				this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// cursor por defecto
				JOptionPane.showMessageDialog(this, "Sin registros que mostrar.", "Vista",
						JOptionPane.INFORMATION_MESSAGE);
			}
			this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// cursor por defecto
		}

		//////////////// boton atras///////////////
		if (e.getSource().equals(BtnAtras)) {

			escogerPanel(--pnlSiguiente);
		}

		////////// boton siguiente
		if (e.getSource().equals(BtnSig)) {

			escogerPanel(++pnlSiguiente);

		}

		////////////// boton guardar resumen////////////////
		if (e.getSource().equals(BtnGuardar)) {
			guardarResumen();
		}

		////////////// boton configuracion////////////////
		if (e.getSource().equals(BtnConfig)) {
			PanelInferior.setVisible(false);
			cambiar.cambiarPNL(PanelCentral, CtrlConfig);
		}
	}

}
