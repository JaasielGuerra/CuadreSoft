package Controlador;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Vista.PnlInicioCuadre;

import java.util.Date;
import java.util.zip.DataFormatException;
/*
 * Control para el inicio de los datos del cuadre
 */

public class ControlInicioCuadre extends PnlInicioCuadre implements FocusListener, KeyListener {

	// lista para los datos
	private ArrayList<String> listaDatos = null;

	public ControlInicioCuadre() {

		// agregar la escucha de foco
		InicioCaja.addFocusListener(this);
		Ventas.addFocusListener(this);
		Gastos.addFocusListener(this);

		// eventos del teclado
		InicioCaja.addKeyListener(this);
		Ventas.addKeyListener(this);
		Gastos.addKeyListener(this);

	}

	// para devolver la lista de datos
	public ArrayList<String> getDatos() {

		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");// para formatear la fecha

		// validando datos
		if (Fecha.getDate() != null && InicioCaja.getText().length() > 0 && Ventas.getText().length() > 0
				&& Gastos.getText().length() > 0) {

			this.listaDatos = new ArrayList<String>();
			this.listaDatos.add(formato.format(Fecha.getDate()));
			this.listaDatos.add(InicioCaja.getText().replaceAll(",", ""));// eliminar las comas
			this.listaDatos.add(Ventas.getText().replaceAll(",", ""));
			this.listaDatos.add(Gastos.getText().replaceAll(",", ""));

		}

		return listaDatos;
	}

	public float getSumaTotal() {// devolver la suma de la operacion
		float sumaTotal = 0f;

		// esta operacion da como resultado el dinero que deberia existir en caja
		sumaTotal = (Float.parseFloat(InicioCaja.getText()) + Float.parseFloat(Ventas.getText()))
				- Float.parseFloat(Gastos.getText());

		return sumaTotal;// retorna el resultado
	}

	@Override
	public void focusGained(FocusEvent e) {// cuando el componente gana el foco

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InicioCaja.selectAll();
				Ventas.selectAll();
				Gastos.selectAll();
			}
		});
	}

	@Override
	public void focusLost(FocusEvent e) {// cuando el componente pierde el foco

		JTextField text = (JTextField) e.getSource();// obtener el objeto que emite el evento

		if (text.getText().isEmpty()) {// si esta vacio
			text.setText("0.0");// poner cero por defecto
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char caracter = e.getKeyChar();

		// Verificar si la tecla pulsada esta fuera del rango de numeros
		if (((caracter < '0') || (caracter > '9')) && (caracter != '.')) {

			e.consume(); // si es letra se ignora el evento

		}

	}

}
