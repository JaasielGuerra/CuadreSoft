package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/*
 * Esta clase sirve para correr script de un archivo .sql
 */

public class RunScriptSQL {

	// atributos
	private Connection con;
	private FileReader file;
	private BufferedReader buffer;
	private String pathFile;
	private String line;
	private String SQL;
	private Statement st;

	public RunScriptSQL(Connection con) {
		this.con = con;
	}

	// devolver el SQL del archivo
	public String getSQL() {
		return this.SQL;
	}

	// dar la ruta del archivo
	public void setPathFile(String path) {
		this.pathFile = path;
	}

	// correr el SQL
	public boolean runSQL() {
		boolean res = false;

		if (this.pathFile == null) {// validar la ruta

			System.err.println("No se ha especificado la ruta del archivo: path \"" + pathFile + "\"");

		} else {

			try {

				this.SQL = new String();// inicializar

				// preparar el archivo
				this.file = new FileReader(this.pathFile);
				this.buffer = new BufferedReader(file);

				// leer el script
				while ((line = buffer.readLine()) != null) {
					SQL += line + "\n";
				}

				st = con.createStatement();// crear statement
				st.execute(SQL);

				res = true;

			} catch (IOException m) {

				JOptionPane.showMessageDialog(null, "Error al leer el script:\n" + m.getMessage(), "Error Script",
						JOptionPane.ERROR_MESSAGE);

			} catch (SQLException m) {

				JOptionPane.showMessageDialog(null, "Error al ejecutar Script SQL:\n" + m.getMessage(), "Error SQL",
						JOptionPane.ERROR_MESSAGE);

			} finally {
				try {
					st.close();

					buffer.close();
				} catch (Exception m) {

					JOptionPane.showMessageDialog(null, "Error al cerrar los recursos:\n" + m.getMessage(),
							"Error Resource", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		return res;
	}

	public void closeConnectionScrip() {
		try {
			con.close();
		} catch (SQLException m) {

			JOptionPane.showMessageDialog(null, "Error al cerrar conecxion a BD:\n" + m.getMessage(), "Error BD",
					JOptionPane.ERROR_MESSAGE);

		}
	}

}
