package Controlador;

import java.awt.Cursor;

import Modelo.ClaseConsultar;
import Modelo.Conexion;
import Vista.PnlHistorialCuadre;

public class ControlHistorial extends PnlHistorialCuadre {

	public ControlHistorial() {

	}

	public void presentarHistorial() {
		
		Conexion ObjConector = new Conexion("data/sqlitedatabase");
		ClaseConsultar con = new ClaseConsultar(ObjConector.conectar(), "registro_cuadres");

		con.consultar("*");// consultar todo

		RellenarTabla rt = new RellenarTabla(con.getResultadoConsulta(), this.Tabla);
		rt.llenarTabla();
		
	}
}
