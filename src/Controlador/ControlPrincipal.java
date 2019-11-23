package Controlador;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import Modelo.ClaseConsultar;
import Modelo.ClaseInsertar;
import Modelo.ClaseModificar;
import Modelo.Conexion;
import Vista.FormVistaPrincipal;
import Vista.PnlCuadreFinal;
import Vista.PnlDesglose;
import Vista.PnlHistorialCuadre;
import Vista.PnlInicioCuadre;

public class ControlPrincipal extends FormVistaPrincipal implements ActionListener {

	private CambiarPanel cambiar;
	private ControlInicioCuadre CtrlInicioCuadre;
	private ControlDesglose CtrlDesglose;
	private ControlCuadreFinal CtrlCuadreFinal;
	private ControlHistorial CtrlHistorialCuadre;
	private int pnlSiguiente = 0;

	public ControlPrincipal() {

		this.cambiar = new CambiarPanel();
		this.CtrlInicioCuadre = new ControlInicioCuadre();
		this.CtrlDesglose = new ControlDesglose();
		this.CtrlCuadreFinal = new ControlCuadreFinal();
		this.CtrlHistorialCuadre = new ControlHistorial();

		BtnCuadrar.addActionListener(this);
		BtnHistorial.addActionListener(this);
		BtnAtras.addActionListener(this);
		BtnSig.addActionListener(this);
		BtnGuardar.addActionListener(this);

		BtnAtras.setEnabled(false);
		PanelInferior.setVisible(false);
		BtnGuardar.setVisible(false);

		// BtnCuadrar.doClick();//hacer clic a cuadrar

	}

	private void operarInicio() {// se encarga de la operacion para calcular el dinero que deberia existir en
									// caja

	}

	private void escogerPanel(int nPanel) {// para escoger los paneles

		switch (nPanel) {

		case 0:// panel de cuadre
			cambiar.cambiarPNL(PanelCentral, CtrlInicioCuadre);
			BtnAtras.setEnabled(false);
			BtnGuardar.setVisible(false);
			break;
		case 1:// panel de desglose
			cambiar.cambiarPNL(PanelCentral, CtrlDesglose);
			BtnAtras.setEnabled(true);
			BtnSig.setEnabled(true);
			BtnGuardar.setVisible(false);
			break;
		case 2:// resumen del cuadre
			cambiar.cambiarPNL(PanelCentral, CtrlCuadreFinal);
			BtnSig.setEnabled(false);
			BtnGuardar.setVisible(true);
			CtrlCuadreFinal.calcularCuadre(CtrlInicioCuadre.getDatos(), CtrlInicioCuadre.getSumaTotal(),
					CtrlDesglose.getSumaTotal());
			CtrlCuadreFinal.presentarResumen();
			break;
		}
	}

	private void actualizarResumen() {

		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursos en espera

		Conexion ObjConector = new Conexion("data/sqlitedatabase");
		ClaseModificar mod = new ClaseModificar(ObjConector.conectar(), "registro_cuadres");

		mod.agregarValor("fecha", CtrlInicioCuadre.getDatos().get(0));
		mod.agregarValor("inicio_caja", CtrlInicioCuadre.getDatos().get(1));
		mod.agregarValor("ventas", CtrlInicioCuadre.getDatos().get(2));
		mod.agregarValor("gastos", CtrlInicioCuadre.getDatos().get(3));
		mod.agregarValor("dinero_real", CtrlDesglose.getSumaTotal());
		mod.agregarValor("sobra_falta", CtrlCuadreFinal.getDatos().get(0));
		mod.agregarValor("cuadre_final", CtrlCuadreFinal.getDatos().get(1));

		mod.setDonde("fecha", CtrlInicioCuadre.getDatos().get(0));

		if (!mod.ejecutarSQL()) {
			JOptionPane.showMessageDialog(this, "Error al actualizar en la Base de Datos", "Error Sqlite",
					JOptionPane.ERROR_MESSAGE);
		}

		ObjConector.cerrar();// cerrar la conexion
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// cursor por defecto
	}

	private void guardarResumen() {

		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursos en espera
		Conexion ObjConector = new Conexion("data/sqlitedatabase");
		ClaseConsultar con = new ClaseConsultar(ObjConector.conectar(), "registro_cuadres");

		con.consultar("fecha", "fecha", "=", CtrlInicioCuadre.getDatos().get(0));// consultar la fecha

		ResultSet rs = con.getResultadoConsulta();

		try {
			while (rs.next()) {// en busca de un cuadre que ya exista con la fecha que se esta registrando el
								// resumen actualmente

				if (rs.getString("fecha").equals(CtrlInicioCuadre.getDatos().get(0))) {
					// si el cuadre ya existe

					ObjConector.cerrar();// cerrar la conexion

					this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// poner cursos por default

					int opcion = JOptionPane.showConfirmDialog(this,
							"Ya existe un registro con la misma fecha." + "\n¿Quiere actualizar el registro?",
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

		ClaseInsertar in = new ClaseInsertar(ObjConector.conectar(), "registro_cuadres");

		// agregando los valores
		in.agregarValor("fecha", CtrlInicioCuadre.getDatos().get(0));
		in.agregarValor("inicio_caja", CtrlInicioCuadre.getDatos().get(1));
		in.agregarValor("ventas", CtrlInicioCuadre.getDatos().get(2));
		in.agregarValor("gastos", CtrlInicioCuadre.getDatos().get(3));
		in.agregarValor("dinero_real", CtrlDesglose.getSumaTotal());
		in.agregarValor("sobra_falta", CtrlCuadreFinal.getDatos().get(0));
		in.agregarValor("cuadre_final", CtrlCuadreFinal.getDatos().get(1));

		if (!in.ejecutarSQL()) {
			JOptionPane.showMessageDialog(this, "Error al guardar en la Base de Datos", "Error Sqlite",
					JOptionPane.ERROR_MESSAGE);
		}
		ObjConector.cerrar();// cerrar la conexion
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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

			PanelInferior.setVisible(false);
			this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursor en espera
			cambiar.cambiarPNL(PanelCentral, CtrlHistorialCuadre);
			CtrlHistorialCuadre.presentarHistorial();// presentar el historial
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
	}

}
