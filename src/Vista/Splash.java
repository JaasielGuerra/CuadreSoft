package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Vista para el splash screen
 */

import com.sun.awt.AWTUtilities;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;

/**
 *
 * @author Rojeru San
 */
public class Splash extends javax.swing.JFrame {

	public Splash() {
		setMinimumSize(new Dimension(480, 324));
		setPreferredSize(new Dimension(480, 324));
		setSize(new Dimension(480, 324));
		setUndecorated(true);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		AWTUtilities.setWindowOpaque(this, false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Splash.class.getResource("/Img/barra-carga.gif")));
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Splash.class.getResource("/Img/splash.png")));
		panel.add(label, BorderLayout.CENTER);

	}
}
