/*
 * Sirve para contar los registros contenidos en una tabla de la base de datos
 * Esta clase depende de alguna de las clases del framework EMIC
 */
package Modelo;

import Modelo.CConsultar;
import Modelo.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaasiel Guerra
 */
public class CContarRegistros {

    private Conexion conec = null;
    private CConsultar con = null;

    public CContarRegistros() {
        this.con = null;
        this.conec = null;
    }

    public int contarReg(String nombreDB, String nomTab) {// contar registros en general

        int contador = 0;
        this.conec = new Conexion(nombreDB);
        this.con = new CConsultar(conec.conectar(), nomTab);

        //fufncion COUTN devuelve el numero de veces que se repite X registro
        con.consultar("COUNT(*) As total");

        try {
            contador = con.getResultadoConsulta().getInt("total");
        } catch (SQLException ex) {
            Logger.getLogger(CContarRegistros.class.getName()).log(Level.SEVERE, null, ex);
            contador = -1;
        } finally {
            this.conec.cerrar();
            this.con = null;
            this.conec = null;
            System.gc();
        }
        return contador;
    }
    
    public int contarReg(String nombreDB, String nomTab, String campo,String valContar) {// contar registro especifico

        int contador = 0;
        this.conec = new Conexion(nombreDB);
        this.con = new CConsultar(conec.conectar(), nomTab);

        //fufncion COUTN devuelve el numero de veces que se repite X registro
        con.consultar("COUNT(*) As total",campo,"=","'"+valContar+"'");

        try {
            contador = con.getResultadoConsulta().getInt("total");
        } catch (SQLException ex) {
            Logger.getLogger(CContarRegistros.class.getName()).log(Level.SEVERE, null, ex);
            contador = -1;
        } finally {
            this.conec.cerrar();
            this.con = null;
            this.conec = null;
            System.gc();
        }
        return contador;
    }

}
