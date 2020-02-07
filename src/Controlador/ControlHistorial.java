package Controlador;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.ConstBaseDatos;
import Modelo.CConsultar;
import Modelo.CEliminar;
import Modelo.Conexion;
import Vista.PnlHistorialCuadre;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ControlHistorial extends PnlHistorialCuadre implements ActionListener, MouseListener {

	private ControlNota CtrlNota;
	private RellenarTabla rt;
	
	public ControlHistorial(boolean visibleTop) {

		initCombobox();// llenar el combo

		this.CtrlNota = new ControlNota();
		this.CtrlNota.setAlwaysOnTop(visibleTop);
		this.rt = new RellenarTabla();

		this.BtnEliminar.setEnabled(false);

		// agragar la escucha de acciones
		this.Ordenar.addActionListener(this);
		this.BtnBuscar.addActionListener(this);
		this.BtnEliminar.addActionListener(this);

		this.Tabla.addMouseListener(this);

	}

	private void initCombobox() {

		// iniciar los item del combobox
		for (int i = 0; i < 3; i++) {

			this.Ordenar.removeAllItems();// limpiar el combobox
			this.Ordenar.addItem("Ascendente");
			this.Ordenar.addItem("Descendente");

		}

		this.Ordenar.setSelectedIndex(1);// seleccionado por defecto en el combo

	}

	public void presentarHistorial(int orden) {

		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursor en espera

		this.BtnEliminar.setEnabled(false);// desactivar boton de eliminar

		Conexion ObjConector = new Conexion(ConstBaseDatos.rutaBD);
		CConsultar con = new CConsultar(ObjConector.conectar(), "registro_cuadres");

		// consultar por orden de fecha
		con.consultar("fecha, inicio_caja, ventas, gastos, dinero_real, sobra_falta, cuadre_final", "fecha", orden);

		rt.setDatos(con.getResultadoConsulta(), this.Tabla);
		rt.llenarTabla();
		ObjConector.cerrar();// cerrar conexion
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// cursor por defecto
	}

	public void presentarHistorial(String fecha) {

		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursor en espera

		this.BtnEliminar.setEnabled(false);// desactivar boton de eliminar

		Conexion ObjConector = new Conexion(ConstBaseDatos.rutaBD);
		CConsultar con = new CConsultar(ObjConector.conectar(), "registro_cuadres");

		// consultar por fecha especifica
		con.consultar("fecha, inicio_caja, ventas, gastos, dinero_real, sobra_falta, cuadre_final", "fecha", "=",
				fecha);

		rt.setDatos(con.getResultadoConsulta(), this.Tabla);
		rt.llenarTabla();
		ObjConector.cerrar();// cerrar conexion
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// cursor por defecto
	}

	private void presentarNota() {

		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursor en espera

		// this.BtnEliminar.setEnabled(false);// desactivar boton de eliminar

		Conexion ObjConector = new Conexion(ConstBaseDatos.rutaBD);
		CConsultar con = new CConsultar(ObjConector.conectar(), "registro_cuadres");

		con.consultar("nota", "fecha", "=", Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());// colunma 0 fila
																									// seleccionada

		try {
			CtrlNota.setTexto(con.getResultadoConsulta().getString("nota").toString());
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(this, "Error al mostrar la nota" + e.getMessage(), "Error Sqlite",
					JOptionPane.ERROR_MESSAGE);
		}

		CtrlNota.setModal(true);// que sea modal
		CtrlNota.bloquearTextArea(true);
		CtrlNota.setVisible(true);
		ObjConector.cerrar();// cerrar la conexion
		this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// cursor por defecto
	}

	private void eliminarRegistro() {

		int opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminarlo?", "Eliminar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (opcion == JOptionPane.YES_OPTION) {
			Conexion ObjConector = new Conexion(ConstBaseDatos.rutaBD);
			CEliminar el = new CEliminar(ObjConector.conectar(), "registro_cuadres");

			el.borrar("fecha", Tabla.getValueAt(Tabla.getSelectedRow(), 0).toString());

			ObjConector.cerrar();// cerrar conexion

			presentarHistorial(CConsultar.DESCENDENTE);// listar datos
		}

	}

	// manejo de eventos
	@Override
	public void actionPerformed(ActionEvent e) {

		///////// combobox de order //////////////////
		if (e.getSource().equals(Ordenar)) {

			if (Ordenar.getSelectedItem().toString().equals("Ascendente")) {

				presentarHistorial(CConsultar.ASCENDENTE);// presentar en orden ascendente

			} else {
				presentarHistorial(CConsultar.DESCENDENTE);// presentar en orden descendente
			}

		}

		/////////// boton de ir/////////////
		if (e.getSource().equals(BtnBuscar)) {
			if (Fecha.getDatoFecha() != null) {// validar que no sea null la fecha
				DateFormat formato = new SimpleDateFormat(Fecha.getFormatoFecha());
				presentarHistorial(formato.format(Fecha.getDatoFecha()));
			}

		}

		//////////// boton de eliminar//////////////
		if (e.getSource().equals(BtnEliminar)) {
			eliminarRegistro();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		this.BtnEliminar.setEnabled(true);

		if (Tabla.getSelectedColumn() == 7 && Tabla.getSelectedRow() > -1) {

			System.out.println("Se pulso el boton de ver nota");

			presentarNota();
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
