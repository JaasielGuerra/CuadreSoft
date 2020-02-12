package Controlador;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;

import Vista.Splash;

public class ControladorSplash extends Splash implements Runnable {

	private Thread tiempo;

	// constructor
	public ControladorSplash() {
		tiempo = new Thread(this);
		tiempo.start();
	}

	@Override
	public void run() {

		try {

			// cambiar el look del programa
			UIManager.setLookAndFeel(new GraphiteLookAndFeel());

			ControlInicio control = new ControlInicio();

			if (control.getTodoListo()) {
				this.dispose();
			}

		} catch (UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, "Imposible modificar el tema visual: \n" + e.getMessage(),
					"Lookandfeel inválido.", JOptionPane.ERROR_MESSAGE);
		}

	}

}
