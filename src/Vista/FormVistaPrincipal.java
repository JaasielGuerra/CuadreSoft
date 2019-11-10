package Vista;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/*
 * VIsta principal del programa
 */

public class FormVistaPrincipal extends JFrame {

	
	
	public JPanel contentPane;
	public JButton BtnAtras;
	public JButton BtnSig;
	public JButton BtnCuadrar;
	public JButton BtnHistorial;
	public JPanel PanelCentral;
	public JPanel PanelInf;
	public JButton BtnGuardar;


	public FormVistaPrincipal() {
		setTitle("CuadreSoft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720,480);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(5, 5));
		
		JPanel PanelSup = new JPanel();
		contentPane.add(PanelSup, BorderLayout.NORTH);
		PanelSup.setLayout(new BoxLayout(PanelSup, BoxLayout.X_AXIS));
		
		BtnCuadrar = new JButton("Cuadrar");
		BtnCuadrar.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Cuadrar.png")));
		PanelSup.add(BtnCuadrar);
		
		BtnHistorial = new JButton("Historial de cuadres");
		BtnHistorial.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Historial.png")));
		PanelSup.add(BtnHistorial);
		
		PanelInf = new JPanel();
		contentPane.add(PanelInf, BorderLayout.SOUTH);
		PanelInf.setLayout(new GridLayout(1, 2, 5, 5));
		
		JPanel panel = new JPanel();
		PanelInf.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		BtnAtras = new JButton("Atr\u00E1s");
		BtnAtras.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Atras.png")));
		BtnAtras.setHorizontalTextPosition(SwingConstants.RIGHT);
		panel.add(BtnAtras);
		
		JPanel panel_1 = new JPanel();
		PanelInf.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		BtnSig = new JButton("Siguiente");
		BtnSig.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Siguiente.png")));
		BtnSig.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_1.add(BtnSig);
		
		BtnGuardar = new JButton("");
		BtnGuardar.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Guardar.png")));
		panel_1.add(BtnGuardar);
		
		PanelCentral = new JPanel();
		PanelCentral.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPane.add(PanelCentral, BorderLayout.CENTER);
		PanelCentral.setLayout(new BorderLayout(0, 0));
	
	}

}
