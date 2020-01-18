package Controlador;
/*
 * COntrol para el ingreso de nota para cuadres
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Vista.DlgNota;

public class ControlNota extends DlgNota implements ActionListener, WindowListener {

	public ControlNota() {// constructor

		// eventos de la ventana
		this.addWindowListener(this);

		// eventos para los botones
		BtnAceptar.addActionListener(this);
		BtnCancelar.addActionListener(this);

		// iniciar el textArea por defecto
		this.textArea.setText("");

	}

	public String getTexto() {// devolver todo el texto del textArea
		return textArea.getText();
	}

	public void setTexto(String txt) {// insertar texto en el textArea
		textArea.setText(txt);
	}

	public void bloquearTextArea(boolean arg) {
		textArea.setEditable(!arg);
	}

	// MANEJO DE LOS EVENTOS

	@Override
	public void actionPerformed(ActionEvent e) {

		//////////// Boton aceptar////////////
		if (e.getSource().equals(BtnAceptar)) {
			this.setVisible(false);
		}

		////////// boton cancelar///////////
		if (e.getSource().equals(BtnCancelar)) {

			this.setVisible(false);

			this.textArea.setText("- Sin nota que mostrar -");
		}
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		setTexto("- Sin nota que mostrar -");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}
}
