/*
 * Esta clase se encarga de realizar consultas en las distintas tablas en la DB
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Brandon Pineda
 * @author Jaasiel Guerra
 */
public class CConsultar {

	// atributos
	private Connection objConector = null;
	private PreparedStatement preConsulta;
	private ResultSet resultadoConsulta;
	private StringBuilder SQL;

	private String nombreTab;

	// constantes publicas para el order by
	public static final int ASCENDENTE = 1;
	public static final int DESCENDENTE = 0;

	public CConsultar(Connection objConector, String nombreTab_) {// constructor

		this.objConector = objConector;
		this.nombreTab = nombreTab_;

		initVariables();

	}
	
	public void consultarGeneral(String sql)// para cualquier consulta
	{
		initVariables();// limpiar antes de cada consulta
		SQL.append(sql);// SQL

		try {

			System.out.println("SQL ejecutado " + SQL.toString());// imprimir SQL
			preConsulta = objConector.prepareStatement(SQL.toString());
			resultadoConsulta = preConsulta.executeQuery();// ejecutar la consulta
			// preConsulta.close();
		} catch (SQLException ex) {
			System.err.println("Error al leer desde la base de datos: " + ex.getMessage());
			System.err.println("Tabla :" + this.nombreTab);
			resultadoConsulta = null;
		} 

		// return resultadoConsulta;//retorna toda la consulta
	}

	public void consultar(String ResultColumna)// para consultas generales
	{
		initVariables();// limpiar antes de cada consulta
		SQL.append("SELECT ").append(ResultColumna).append(" FROM ").append(nombreTab);// SQL

		try {

			System.out.println("SQL ejecutado " + SQL.toString());// imprimir SQL
			preConsulta = objConector.prepareStatement(SQL.toString());
			resultadoConsulta = preConsulta.executeQuery();// ejecutar la consulta
			// preConsulta.close();
		} catch (SQLException ex) {
			System.err.println("Error al leer desde la base de datos: " + ex.getMessage());
			System.err.println("Tabla :" + this.nombreTab);
			resultadoConsulta = null;
		} 

		// return resultadoConsulta;//retorna toda la consulta
	}

	public void consultar(String ResultColumna, String campOrderBy, int AscDesc)// para consultas con orden especifico
	{
		String ascDesc = "";
		if (AscDesc == 0) {
			ascDesc = " DESC "; // descendente
		} else if (AscDesc == 1) {
			ascDesc = " ASC "; // ascendente
		}

		initVariables();// limpiar antes de cada consulta
		SQL.append("SELECT ").append(ResultColumna).append(" FROM ").append(nombreTab).append(" ORDER BY ")
				.append(campOrderBy).append(ascDesc);// SQL

		try {

			System.out.println("SQL ejecutado " + SQL.toString());// imprimir SQL
			preConsulta = objConector.prepareStatement(SQL.toString());
			resultadoConsulta = preConsulta.executeQuery();// ejecutar la consulta
			//preConsulta.close();

		} catch (SQLException ex) {
			System.err.println("Error al leer desde la base de datos: " + ex.getMessage());
			System.err.println("Tabla :" + this.nombreTab);
			resultadoConsulta = null;
		}

		// return resultadoConsulta;//retorna toda la consulta
	}

	public void consultar(String ResultColumna, String campo, String condicion, String buscar)// para consultas
																								// especificas
	{
		initVariables();
		SQL.append("SELECT ").append(ResultColumna).append(" FROM ").append(nombreTab).append(" WHERE ").append(campo)
				.append(" ").append(condicion).append(" '").append(buscar).append("'");// SQL

		try {

			System.out.println("SQL ejecutado " + SQL.toString());// imprimir SQL
			preConsulta = objConector.prepareStatement(SQL.toString());
			resultadoConsulta = preConsulta.executeQuery();// ejecutar la consulta
			System.out.println("Datos consultado correctamente de la tabla: " + this.nombreTab);
			//preConsulta.close();

		} catch (SQLException ex) {
			System.err.println("Error al leer desde la base de datos: " + ex.getMessage());
			resultadoConsulta = null;
		}

		// return resultadoConsulta;//retorna toda la consulta
	}

	public void consultar(String ResultColumna, String campo, String SubCadenabuscar)// para consultas de subcadenas
	{
		initVariables();
		SQL.append("SELECT ").append(ResultColumna).append(" FROM ").append(nombreTab).append(" WHERE ").append(campo)
				.append(" ").append(" LIKE ").append(" '").append(SubCadenabuscar).append("%'");// SQL

		try {

			System.out.println("SQL ejecutado " + SQL.toString());// imprimir SQL
			preConsulta = objConector.prepareStatement(SQL.toString());
			resultadoConsulta = preConsulta.executeQuery();// ejecutar la consulta
			System.out.println("Datos consultado correctamente de la tabla: " + this.nombreTab);
			//preConsulta.close();

		} catch (SQLException ex) {
			System.err.println("Error al leer desde la base de datos: " + ex.getMessage());
			resultadoConsulta = null;
		}

	}

	public ResultSet getResultadoConsulta() {
		return resultadoConsulta;// retorna la consulta
	}

	public StringBuilder getSQL() {
		return SQL;
	}

	private void initVariables() {// para limpiar las variables
		this.preConsulta = null;
		this.resultadoConsulta = null;
		this.SQL = new StringBuilder();
	}

}
