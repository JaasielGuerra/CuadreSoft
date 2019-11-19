package Controlador;

import java.util.ArrayList;

/*
 * Control para mostrar detalles resumidos sobre el cuadre final
 */

import Vista.PnlCuadreFinal;

public class ControlCuadreFinal extends PnlCuadreFinal {

	// atributos
	private ArrayList<String> datos;
	private float diferenciaDinero;
	private float dineroReal;
	private float totalSacarCaja;
	private float ganancia;
	private RellenarTabla llenarT;

	public ControlCuadreFinal() {

	}

	// recibe los datos para realizar el calculo del cuadre y el resumen final
	public void calcularCuadre(ArrayList<String> datosIniciales, float dineroHipotetico, float dineroReal) {

		this.datos = new ArrayList<String>();

		this.dineroReal = dineroReal;
		this.diferenciaDinero = dineroReal - dineroHipotetico;// la resta determina si sobra o falta dinero
		
		this.ganancia = dineroHipotetico - Float.parseFloat(datosIniciales.get(1));// calcular la ganancia
		
		this.totalSacarCaja = ganancia + (diferenciaDinero);// determinar el total para sacar de la caja

		// lista de datos
		this.datos.add("Inicio Caja");// etiqueta
		this.datos.add(datosIniciales.get(1));// inicio caja
		this.datos.add("Ventas");// etiqueta
		this.datos.add(datosIniciales.get(2));// ventas
		this.datos.add("Gastos");// etiqueta
		this.datos.add(datosIniciales.get(3));// gastos
		this.datos.add("Dinero Real");// etiqueta
		this.datos.add(String.valueOf(dineroReal) + "0");// dinero real
		if (diferenciaDinero > 0)
			this.datos.add("Dinero Sobrante");// etiqueta
		else if (diferenciaDinero < 0)
			this.datos.add("Dinero Faltante");// etiqueta
		else
			this.datos.add("Cuadre Exacto");// etiqueta 
		this.datos.add(String.valueOf(diferenciaDinero).replaceAll("-", "") + "0");// sobra o falta dinero(si sale negativo se
																				// elimina el sigono)
		this.datos.add("Total Sacar de Caja");// etiqueta
		if (totalSacarCaja > 0) {// poner total solo si es mayor a cero
			this.datos.add(String.valueOf(totalSacarCaja) + "0");
		} else {// de lo contraro se pone cero
			this.datos.add("0.00");
		}

	}

	public void presentarResumen() {

		this.llenarT = new RellenarTabla(this.Tabla);

		Object fila[] = new Object[2];// crear fila con dos posiciones (en este caso representan columnas)

		String etiqueta = "";
		int i = 0;// indice de filas
		do {

			for (int j = 0; j < 2; j++) {// para asignar valor a cada columna en cada fila
				if (j == 0)
					fila[j] = datos.get(i * 2);// numeros pares
				else
					fila[j] = datos.get((i * 2) + 1);// numeros impares
			}

			llenarT.llenarTabla(fila);// enviamos la fila

			i++;// incrementar indice de fila
		} while (Tabla.getRowCount() < 6);// recorrer las filas

	}

}
