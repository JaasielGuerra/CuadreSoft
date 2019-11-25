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
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.DebugGraphics;
import javax.swing.JCheckBox;

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
	public JPanel PanelInferior;
	public JButton BtnGuardar;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	public JCheckBox CheckNota;
	

	public FormVistaPrincipal() {
		
		setTitle("CuadreSoft");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720,480);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel PanelSup = new JPanel();
		contentPane.add(PanelSup, BorderLayout.NORTH);
		PanelSup.setLayout(new BoxLayout(PanelSup, BoxLayout.X_AXIS));
		
		
		BtnCuadrar = new JButton("Cuadrar");
		BtnCuadrar.setFocusPainted(false);
		BtnCuadrar.setFont(new Font("Arial Black", Font.PLAIN, 14));
		BtnCuadrar.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Cuadrar.png")));
		PanelSup.add(BtnCuadrar);
		
		BtnHistorial = new JButton("Historial de cuadres");
		BtnHistorial.setFocusPainted(false);
		BtnHistorial.setFont(new Font("Arial Black", Font.PLAIN, 14));
		BtnHistorial.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Historial.png")));
		PanelSup.add(BtnHistorial);
		
		btnNewButton = new JButton("Configuracion");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 14));
		btnNewButton.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Configucaion.png")));
		PanelSup.add(btnNewButton);
		
		PanelInferior = new JPanel();
		contentPane.add(PanelInferior, BorderLayout.SOUTH);
		PanelInferior.setLayout(new GridLayout(1, 2, 5, 5));
		
		JPanel panel = new JPanel();
		PanelInferior.add(panel);
		
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		BtnAtras = new JButton("Atr\u00E1s");
		BtnAtras.setFocusPainted(false);
		BtnAtras.setFont(new Font("Arial Black", Font.PLAIN, 14));
		BtnAtras.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Atras.png")));
		BtnAtras.setHorizontalTextPosition(SwingConstants.RIGHT);
		panel.add(BtnAtras);
		
		JPanel panel_1 = new JPanel();
		PanelInferior.add(panel_1);
		
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		BtnSig = new JButton("Siguiente");
		BtnSig.setFocusPainted(false);
		BtnSig.setFont(new Font("Arial Black", Font.PLAIN, 14));
		BtnSig.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Siguiente.png")));
		BtnSig.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_1.add(BtnSig);
		
		BtnGuardar = new JButton("");
		BtnGuardar.setFocusPainted(false);
		BtnGuardar.setIcon(new ImageIcon(FormVistaPrincipal.class.getResource("/Img/Guardar.png")));
		panel_1.add(BtnGuardar);
		
		CheckNota = new JCheckBox("Nota");
		CheckNota.setFont(new Font("Arial Black", Font.BOLD, 14));
		panel_1.add(CheckNota);
		
		PanelCentral = new JPanel();
		
		PanelCentral.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPane.add(PanelCentral, BorderLayout.CENTER);
		PanelCentral.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("CuadreSoft");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 60));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PanelCentral.add(lblNewLabel, BorderLayout.CENTER);
	
	}

}
