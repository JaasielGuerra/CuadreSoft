package Controlador;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Modelo.CConsultar;
import Modelo.CEliminar;
import Modelo.Conexion;
import Modelo.ConstBaseDatos;
import Modelo.GenerarReporte;
import Vista.PnlHistorialCuadre;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ControlHistorial extends PnlHistorialCuadre implements ActionListener, MouseListener {

	private ControlNota CtrlNota;
	private RellenarTabla rt;

	// para generar el reporte
	private JasperReport reporte;// donde se cargara el .jasper
//	private String RUTA = Utils.class.getResource("/Reporte/reporte.jasper").getPath();
	private JasperPrint documento; // objeto que representa el documento para imprimir
	private JasperViewer vistaPrevia; // esta es la vista previa del reporte
	private Conexion con = new Conexion(ConstBaseDatos.rutaBD);// objeto de conexion
	private GenerarReporte generarReporte = new GenerarReporte();

	public ControlHistorial(boolean visibleTop) {

		/*
		 * try {
		 * 
		 * this.reporte = (JasperReport) JRLoader
		 * .loadObject(ControlHistorial.class.getResource("/Reporte/reporte.jasper"));
		 * 
		 * } catch (JRException ex) { // TODO Auto-generated catch block
		 * JOptionPane.showMessageDialog(this, "Error al acceder binario del reporte: "
		 * + ex.getMessage(), "Error JasperReport", JOptionPane.ERROR_MESSAGE); }
		 */
		initCombobox();// llenar el combo
		panFiltar.setVisible(false);// poner oculto al principio

		this.CtrlNota = new ControlNota();
		this.CtrlNota.setAlwaysOnTop(visibleTop);
		this.rt = new RellenarTabla();

		this.BtnEliminar.setEnabled(false);

		// agragar la escucha de acciones
		this.Ordenar.addActionListener(this);
		this.BtnBuscar.addActionListener(this);
		this.BtnEliminar.addActionListener(this);
		this.btnFiltrar.addActionListener(this);
		this.btnImprimir.addActionListener(this);

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

	public void presentarHistorial(String fecha1, String fecha2) {

		this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursor en espera

		this.BtnEliminar.setEnabled(false);// desactivar boton de eliminar

		Conexion ObjConector = new Conexion(ConstBaseDatos.rutaBD);
		CConsultar con = new CConsultar(ObjConector.conectar(), "registro_cuadres");

		// consultar por rango de fecha
		con.consultarGeneral("SELECT * FROM registro_cuadres WHERE fecha BETWEEN '"+fecha1+"' AND '"+fecha2+"';");

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
			if (fechaInicio.getDatoFecha() != null && fechaFin.getDatoFecha() != null) {// validar que no sea null la fecha
				
				
				
				DateFormat formato = new SimpleDateFormat(fechaInicio.getFormatoFecha());
				DateFormat formato2 = new SimpleDateFormat(fechaFin.getFormatoFecha());
				
				
				
				presentarHistorial(formato.format(fechaInicio.getDatoFecha()), formato2.format(fechaFin.getDatoFecha()));
			}

		}

		//////////// boton de eliminar//////////////
		if (e.getSource().equals(BtnEliminar)) {
			eliminarRegistro();
		}

		///////// boton de filtrar//////////
		if (e.getSource().equals(btnFiltrar)) {

			if (panFiltar.isVisible())
				btnFiltrar.setText("Filtrar <<");
			else
				btnFiltrar.setText("Filtrar >>");
			panFiltar.setVisible(!panFiltar.isVisible());
		}

		///////// boton de imprimir//////////
		if (e.getSource().equals(btnImprimir)) {

			this.setCursor(new Cursor(Cursor.WAIT_CURSOR));// cursor en espera

			ArrayList<ArrayList<String>> row = new ArrayList<>();
			DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
			double sumaTotal = 0.00D;
			double sumaFaltante = 0.00D;
			double sumaSobrante = 0.00D;
			double difGlobal = 0.00D;

			for (int i = 0; i < model.getRowCount(); i++) {

				ArrayList<String> colData = new ArrayList<>();

				colData.add(model.getValueAt(i, 0).toString());
				colData.add(model.getValueAt(i, 1).toString());
				colData.add(model.getValueAt(i, 2).toString());
				colData.add(model.getValueAt(i, 3).toString());
				colData.add(model.getValueAt(i, 4).toString());
				colData.add(model.getValueAt(i, 5).toString());
				colData.add(model.getValueAt(i, 6).toString());

				sumaTotal += Double.parseDouble(model.getValueAt(i, 6).toString());
				sumaFaltante += (Double.parseDouble(model.getValueAt(i, 5).toString()) < 0)
						? Double.parseDouble(model.getValueAt(i, 5).toString())
						: 0;

				sumaSobrante += (Double.parseDouble(model.getValueAt(i, 5).toString()) > 0)
						? Double.parseDouble(model.getValueAt(i, 5).toString())
						: 0;

				row.add(colData);

			}

			difGlobal = sumaSobrante + (sumaFaltante);

			ArrayList<String> header = new ArrayList<>();

			header.add("Fecha");
			header.add("Inicio Caja");
			header.add("Ventas");
			header.add("Gastos");
			header.add("Dinero real");
			header.add("Diferencia");
			header.add("Cuadre final");

			this.generarReporte.generarReporte("Reporte - Historial de cuadres", row, header, "User", "" + sumaTotal,
					"" + sumaFaltante, "" + sumaSobrante, "" + (double) Math.round(difGlobal * 100d) / 100d);
			/*
			 * try { this.documento = JasperFillManager.fillReport(reporte, null,
			 * con.conectar()); this.vistaPrevia = new JasperViewer(documento, false);
			 * this.vistaPrevia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			 * //this.vistaPrevia.setAlwaysOnTop(true);
			 * //this.vistaPrevia.setResizable(false);
			 * 
			 * this.vistaPrevia.setExtendedState(JFrame.MAXIMIZED_BOTH);
			 * this.vistaPrevia.setTitle("Vista previa"); this.vistaPrevia .setIconImage(new
			 * ImageIcon(ControlHistorial.class.getResource("/Img/icono.png")).getImage());
			 * 
			 * this.vistaPrevia.setVisible(true);
			 * 
			 * con.cerrar();// cerrar la conexion
			 * 
			 * } catch (JRException ex) { // TODO Auto-generated catch block
			 * JOptionPane.showMessageDialog(this,
			 * "Ocurrió un problema al generar el reporte: " + ex.getMessage(),
			 * "Error JasperReport", JOptionPane.ERROR_MESSAGE); }
			 */
			this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));// cursor por defecto

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
