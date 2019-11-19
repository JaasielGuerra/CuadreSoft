package Controlador;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jaasiel Guerra Sirve para rellenar tablas dado los datos
 */
public class RellenarTabla {

	// atributos privados
	private ResultSet datos;
	private DefaultTableModel modelo;
	private JTable tabla;
	private Object fila[];
	private ResultSetMetaData metaDatos;
	// private Object datos_[];

	////////////// constructores/////////////////
	public RellenarTabla() {

	}

	public RellenarTabla(ResultSet datos, JTable tabla) {

		this.datos = datos;
		this.tabla = tabla;
		// this.metaDatos = null;
	}

	public RellenarTabla(JTable tabla) {
		this.tabla = tabla;
		this.modelo = (DefaultTableModel) this.tabla.getModel();

		int filas = tabla.getRowCount();// numero de filas

		for (int i = 0; i < filas; i++) {
			modelo.removeRow(0);// limpiar la tabla, fila cero
		}
	}
	/////////////////////////////////////////////

	// metodos setters
	public void setDatos(ResultSet datos, JTable tabla) {// para resulset
		this.datos = datos;
		this.tabla = tabla;
	}

	public void setDatos(JTable tabla) {// para datos simples

		this.tabla = tabla;
		this.modelo = (DefaultTableModel) this.tabla.getModel();

		int filas = tabla.getRowCount();// numero de filas

		for (int i = 0; i < filas; i++) {
			modelo.removeRow(0);// limpiar la tabla, fila cero
		}
	}

	////// ----------------------------////////////

	// para rellenar la tabla
	public void llenarTabla() {

		this.modelo = (DefaultTableModel) this.tabla.getModel();

		/*
		 * Todo lo que se hace en DefaultModel se refresca automaticamente en el Jtable
		 */
		try {

			int filas = tabla.getRowCount();// numero de filas

			for (int i = 0; i < filas; i++) {
				modelo.removeRow(0);// limpiar la tabla, fila cero
			}

			this.metaDatos = datos.getMetaData();// obtener informacion de la tabla en la BD

			while (datos.next()) {

				// se crea un arreglo que sera una de las filas en la tabla
				this.fila = new Object[metaDatos.getColumnCount()];

				// se rellena cada pos del array con una de las columnas de la tabla en la BD
				for (int i = 0; i < metaDatos.getColumnCount(); i++) {

					fila[i] = datos.getObject(i + 1);// el primer indice en datos es 1, no el 0, por eso se le suma

				}

				// se aniade al modelo la fila completa
				modelo.addRow(fila);

			}
		} catch (SQLException ex) {
			System.out.println("Error al llenar la tabla: " + ex.getMessage());
		}

	}

	// llenar tabla con datos simples
	public void llenarTabla(Object datos[]) {

		// arreglo que representa una de las filas en la tabla
		this.fila = datos;

		// se aniade al modelo la fila completa
		modelo.addRow(fila);
	}

}
