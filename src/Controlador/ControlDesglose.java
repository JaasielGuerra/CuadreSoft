package Controlador;

/*
 * Control para el panel del desglose de dinero
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import Vista.PnlDesglose;

public class ControlDesglose extends PnlDesglose implements FocusListener, KeyListener {

	// constantes
	private static final short CIEN = 100;
	private static final short CINCUENTA = 50;
	private static final short VEINTE = 20;
	private static final short DIEZ = 10;
	private static final short CINCO = 5;
	private static final short UNO = 1;
	private static final float CINCUENTACENTAVOS = 0.50f;
	private static final float VEINTICINCOCENTAVOS = 0.25f;
	private static final float DIEZCENTAVOS = 0.10f;
	private static final float CINCOCENTAVOS = 0.05f;

	public ControlDesglose() {

		// eventos del teclado
		Cien.addKeyListener(this);
		Cincuenta.addKeyListener(this);
		Veinte.addKeyListener(this);
		Diez.addKeyListener(this);
		Cinco.addKeyListener(this);
		Uno.addKeyListener(this);
		CincuentaCent.addKeyListener(this);
		VeinticincoCent.addKeyListener(this);
		DiezCent.addKeyListener(this);
		CincoCent.addKeyListener(this);

		// eventos focus
		Cien.addFocusListener(this);
		Cincuenta.addFocusListener(this);
		Veinte.addFocusListener(this);
		Diez.addFocusListener(this);
		Cinco.addFocusListener(this);
		Uno.addFocusListener(this);
		CincuentaCent.addFocusListener(this);
		VeinticincoCent.addFocusListener(this);
		DiezCent.addFocusListener(this);
		CincoCent.addFocusListener(this);

		// iniciar texto
		Cien.setText("0");
		Cincuenta.setText("0");
		Veinte.setText("0");
		Diez.setText("0");
		Cinco.setText("0");
		Uno.setText("0");
		CincuentaCent.setText("0");
		VeinticincoCent.setText("0");
		DiezCent.setText("0");
		CincoCent.setText("0");

	}

	public float getSumaTotal() {// devuelve la suma total del desglose de dinero;

		float sumaTotal = 0;

		// obtener el valor de los texfield
		int nCien = Integer.parseInt(Cien.getText());
		int nCincuenta = Integer.parseInt(Cincuenta.getText());
		int nVeinte = Integer.parseInt(Veinte.getText());
		int nDiez = Integer.parseInt(Diez.getText());
		int nCinco = Integer.parseInt(Cinco.getText());
		int nUno = Integer.parseInt(Uno.getText());
		int nCincuentaCent = Integer.parseInt(CincuentaCent.getText());
		int nVeinticincoCent = Integer.parseInt(VeinticincoCent.getText());
		int nDiezCent = Integer.parseInt(DiezCent.getText());
		int nCincoCent = Integer.parseInt(CincuentaCent.getText());
		
		// esta suma da como resultado el dinero real que hay en caja
		sumaTotal = (CIEN * nCien) + (CINCUENTA * nCincuenta) + (VEINTE * nVeinte) + (DIEZ * nDiez) + (CINCO * nCinco) + 
				(UNO * nUno) + (CINCUENTACENTAVOS * nCincuentaCent) + (VEINTICINCOCENTAVOS * nVeinticincoCent) +
				(DIEZCENTAVOS * nDiezCent) + (CINCOCENTAVOS * nCincoCent);

		return sumaTotal;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char caracter = e.getKeyChar();

		// Verificar si la tecla pulsada esta fuera del rango de numeros
		if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {

			e.consume(); // si es letra se ignora el evento

		}

	}

	@Override
	public void focusGained(FocusEvent e) {// cuando gana el foco

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Cien.selectAll();
				Cincuenta.selectAll();
				Veinte.selectAll();
				Diez.selectAll();
				Cinco.selectAll();
				Uno.selectAll();
				CincuentaCent.selectAll();
				VeinticincoCent.selectAll();
				DiezCent.selectAll();
				CincoCent.selectAll();

			}
		});

	}

	@Override
	public void focusLost(FocusEvent e) {// cuando pierde el foco

		JTextField text = (JTextField) e.getSource();// obtener el objeto que emite el evento

		if (text.getText().isEmpty()) {// si esta vacio
			text.setText("0");// poner cero por defecto
		}

	}

}
