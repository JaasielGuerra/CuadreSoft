package Main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import Controlador.ControlInicio;

/*
 * Programa para cuadres al final del dia creado por Jaasiel Guerra
 * 
 */

public class Main {

	public static void main(String a[]) {

		// cambiar el look del programa

		try {
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel(new GraphiteLookAndFeel());
			ControlInicio in = new ControlInicio();
			//FrameCarga f = new FrameCarga();
			//f.setVisible(true);


		} catch ( UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, "Imposible modificar el tema visual: \n" + e.getMessage(), "Lookandfeel inválido.",
					JOptionPane.ERROR_MESSAGE);
		}

		// ControlPrincipal control = new ControlPrincipal();
		// control.setVisible(true);

		// ControlAsistente as = new ControlAsistente();
		// as.setVisible(true);

		// FrameCarga c = new FrameCarga();
		// c.setVisible(true);
	}

}
