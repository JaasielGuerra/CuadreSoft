package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.awt.AWTUtilities;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Font;

public class FrameCarga extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameCarga() {
		
		setBackground(Color.WHITE);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 50);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		AWTUtilities.setWindowOpaque(this, false);
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Inicializando datos, por favor espere...");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, BorderLayout.CENTER);
	}

}
