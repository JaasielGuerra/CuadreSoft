package Controlador;

import java.io.File;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.ConstBaseDatos;
import Modelo.CConsultar;
import Modelo.CContarRegistros;
import Modelo.Conexion;
import Modelo.RunScriptSQL;

/*
 * Controla el inicio de la aplicacion, comprobando si ya esta configurado el primer uso
 * de lo contrario lo lleva a el asistente de configuracion
 */

public class ControlInicio {

	private CContarRegistros contador;
	private Conexion objConector;
	private RunScriptSQL runSQL;

	private File creaDir;

	public ControlInicio() {

		contador = new CContarRegistros();
		crearBD();
		verificarBD();
	}

	// este metodo crea la base de datos si no existe
	private void crearBD() {

		// para crear el directorio si no existe
		creaDir = new File(System.getProperty("user.dir") + "\\app\\data");
		creaDir.mkdirs();

		// crea o se conecta a la DB
		objConector = new Conexion(ConstBaseDatos.rutaBD);

		runSQL = new RunScriptSQL(objConector.conectar());

		runSQL.setPathFile(ConstBaseDatos.script00);

		runSQL.runSQL();

		runSQL.setPathFile(ConstBaseDatos.script01);

		runSQL.runSQL();

	}

	private void cargarConfig() {// servira para cargar la configuracion de la base de datos

		ControlPrincipal c = new ControlPrincipal();

		Conexion con = new Conexion(ConstBaseDatos.rutaBD);
		CConsultar consulta = new CConsultar(con.conectar(), "config");

		consulta.consultar("*");

		try {
			while (consulta.getResultadoConsulta().next()) {

				c.setAlwaysOnTop(consulta.getResultadoConsulta().getInt("visible_top") == 1);

			}

			c.setVisible(true);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problemas al cargar la configucarion: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	// veririfca la base de datos para saber si ya se configuro la aplicacion por
	// primera vez
	private void verificarBD() {

		if (contador.contarReg(ConstBaseDatos.rutaBD, "config") > 0) {
			cargarConfig();
		} else {
			new ControlAsistente().setVisible(true);
		}

	}

}
