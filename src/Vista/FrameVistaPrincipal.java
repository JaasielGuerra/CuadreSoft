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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JSplitPane;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.event.KeyEvent;

/*
 * VIsta principal del programa
 */

public class FrameVistaPrincipal extends JFrame {

	
	
	public JPanel contentPane;
	public JButton BtnAtras;
	public JButton BtnSig;
	public JButton BtnCuadrar;
	public JButton BtnHistorial;
	public JPanel PanelCentral;
	public JPanel PanelInferior;
	public JButton BtnGuardar;
	private JLabel lblNewLabel;
	public JCheckBox CheckNota;
	public JButton BtnConfig;
	private JSeparator separator;
	private JSeparator separator_1;
	public JPanel PanelSup;
	

	public FrameVistaPrincipal() {
		setMinimumSize(new Dimension(720, 480));
		setPreferredSize(new Dimension(720, 480));
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameVistaPrincipal.class.getResource("/Img/icono.png")));
		
		setTitle("CuadreSoft 1.0.3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720,480);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		PanelSup = new JPanel();
		PanelSup.setBackground(Color.white);
		//PanelSup.setBackground(new Color(232,232,232));
		contentPane.add(PanelSup, BorderLayout.NORTH);
		PanelSup.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		BtnCuadrar = new JButton("Cuadrar");
		BtnCuadrar.setMnemonic(KeyEvent.VK_F1);
		BtnCuadrar.setRolloverEnabled(false);
		BtnCuadrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnCuadrar.setContentAreaFilled(false);
		BtnCuadrar.setPreferredSize(new Dimension(150, 30));
		BtnCuadrar.setMinimumSize(new Dimension(150, 30));
		BtnCuadrar.setBorder(null);
		BtnCuadrar.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/cuadre.png")));
		BtnCuadrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BtnCuadrar.setFocusPainted(false);
		BtnCuadrar.setFont(new Font("Dialog", Font.PLAIN, 14));
		PanelSup.add(BtnCuadrar);
		
		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(2, 30));
		separator.setOrientation(SwingConstants.VERTICAL);
		PanelSup.add(separator);
		
		BtnHistorial = new JButton("Reporter\u00EDa");
		BtnHistorial.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnHistorial.setContentAreaFilled(false);
		BtnHistorial.setMinimumSize(new Dimension(150, 30));
		BtnHistorial.setPreferredSize(new Dimension(150, 30));
		BtnHistorial.setBorder(null);
		BtnHistorial.setFocusPainted(false);
		BtnHistorial.setFont(new Font("Dialog", Font.PLAIN, 14));
		BtnHistorial.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/Historial.png")));
		PanelSup.add(BtnHistorial);
		
		separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(2, 30));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		PanelSup.add(separator_1);
		
		BtnConfig = new JButton("Configuraci\u00F3n");
		BtnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnConfig.setContentAreaFilled(false);
		BtnConfig.setPreferredSize(new Dimension(150, 30));
		BtnConfig.setMinimumSize(new Dimension(150, 30));
		BtnConfig.setBorder(null);
		BtnConfig.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/ajuste.png")));
		BtnConfig.setFocusPainted(false);
		BtnConfig.setFont(new Font("Dialog", Font.PLAIN, 14));
		PanelSup.add(BtnConfig);
		
		PanelInferior = new JPanel();
		contentPane.add(PanelInferior, BorderLayout.SOUTH);
		PanelInferior.setLayout(new GridLayout(1, 2, 5, 5));
		
		JPanel panel = new JPanel();
		PanelInferior.add(panel);
		
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		BtnAtras = new JButton("Atr\u00E1s");
		BtnAtras.setMinimumSize(new Dimension(150, 35));
		BtnAtras.setPreferredSize(new Dimension(150, 35));
		BtnAtras.setFocusPainted(false);
		BtnAtras.setFont(new Font("Dialog", Font.PLAIN, 12));
		BtnAtras.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/Atras.png")));
		BtnAtras.setHorizontalTextPosition(SwingConstants.RIGHT);
		panel.add(BtnAtras);
		
		JPanel panel_1 = new JPanel();
		PanelInferior.add(panel_1);
		
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		BtnSig = new JButton("Siguiente");
		BtnSig.setMinimumSize(new Dimension(150, 35));
		BtnSig.setPreferredSize(new Dimension(150, 35));
		BtnSig.setFocusPainted(false);
		BtnSig.setFont(new Font("Dialog", Font.PLAIN, 12));
		BtnSig.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/sigueinte.png")));
		BtnSig.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_1.add(BtnSig);
		
		BtnGuardar = new JButton("");
		BtnGuardar.setMinimumSize(new Dimension(35, 35));
		BtnGuardar.setPreferredSize(new Dimension(35, 35));
		BtnGuardar.setFocusPainted(false);
		BtnGuardar.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/Guardar.png")));
		panel_1.add(BtnGuardar);
		
		CheckNota = new JCheckBox("NOTA");
		CheckNota.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(CheckNota);
		
		PanelCentral = new JPanel();
		
		PanelCentral.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPane.add(PanelCentral, BorderLayout.CENTER);
		PanelCentral.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/logo.png")));
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PanelCentral.add(lblNewLabel, BorderLayout.CENTER);
	
	}

}
