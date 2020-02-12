package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
//import com.sun.awt.AWTUtilities;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrameCarga extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public FrameCarga() {
		setAlwaysOnTop(true);
		setResizable(false);
		setType(Type.NORMAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameCarga.class.getResource("/Img/icono.png")));
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(460, 134);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		//AWTUtilities.setWindowOpaque(this, false);
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Inicializando datos, por favor espere...");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1, BorderLayout.CENTER);
	}

}
