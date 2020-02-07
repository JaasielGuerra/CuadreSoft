package Main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Controlador.ControlInicio;
/*import Controlador.ControlPrincipal;
import Vista.FrameCarga;*/

/*
 * Programa para cuadres al final del dia creado por Jaasiel Guerra
 * 
 */

public class Main {

	public static void main(String a[]) {

		// cambiar el look del programa

		try {
			// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
			ControlInicio in = new ControlInicio();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Imposible modificar el tema visual", "Lookandfeel inválido.",
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
