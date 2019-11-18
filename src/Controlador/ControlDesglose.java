package Controlador;

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
