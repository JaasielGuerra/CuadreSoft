package Controlador;

import java.util.StringTokenizer;

/*
 * para formatear la fecha leida desde el txt
 */

public class FormatoFecha {
	
	StringTokenizer fecha;
	
	public FormatoFecha() {

	}
	
	public String formato(String _fecha) {
		
		this.fecha = new StringTokenizer(_fecha,"/");
		
		String dia = fecha.nextToken();
		String mes = fecha.nextToken();
		String anio = fecha.nextToken();		
		
		return anio + "-" + mes + "-" + dia;
		
	}

}
