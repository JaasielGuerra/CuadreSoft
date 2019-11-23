package Main;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import Controlador.ControlPrincipal;

/*
 * Programa para cuadres al final del dia creado por Jaasiel Guerra
 * 
 */

public class Main {

	public static void main(String a[]) {

		/*
		 * // cambiar el look del programa try {
		 * UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch
		 * (Exception e) { JOptionPane.showMessageDialog(null,
		 * "Imposible modificar el tema visual", "Lookandfeel inválido.",
		 * JOptionPane.ERROR_MESSAGE); }
		 */

		ControlPrincipal control = new ControlPrincipal();
		control.setVisible(true);
	}

}
