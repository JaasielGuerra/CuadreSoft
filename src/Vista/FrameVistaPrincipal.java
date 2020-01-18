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
	

	public FrameVistaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameVistaPrincipal.class.getResource("/Img/icono.png")));
		
		setTitle("CuadreSoft 1.0.2");
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
		PanelSup.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		
		
		BtnCuadrar = new JButton("CUADRAR");
		BtnCuadrar.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/cuadre.png")));
		BtnCuadrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BtnCuadrar.setFocusPainted(false);
		BtnCuadrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PanelSup.add(BtnCuadrar);
		
		BtnHistorial = new JButton("HISTORIAL DE CUADRES");
		BtnHistorial.setFocusPainted(false);
		BtnHistorial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BtnHistorial.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/historial.png")));
		PanelSup.add(BtnHistorial);
		
		BtnConfig = new JButton("CONFIGURACION");
		BtnConfig.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/ajuste.png")));
		BtnConfig.setFocusPainted(false);
		BtnConfig.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PanelSup.add(BtnConfig);
		
		PanelInferior = new JPanel();
		contentPane.add(PanelInferior, BorderLayout.SOUTH);
		PanelInferior.setLayout(new GridLayout(1, 2, 5, 5));
		
		JPanel panel = new JPanel();
		PanelInferior.add(panel);
		
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		BtnAtras = new JButton("Atr\u00E1s");
		BtnAtras.setFocusPainted(false);
		BtnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BtnAtras.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/atras.png")));
		BtnAtras.setHorizontalTextPosition(SwingConstants.RIGHT);
		panel.add(BtnAtras);
		
		JPanel panel_1 = new JPanel();
		PanelInferior.add(panel_1);
		
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		BtnSig = new JButton("Siguiente");
		BtnSig.setFocusPainted(false);
		BtnSig.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BtnSig.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/sigueinte.png")));
		BtnSig.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_1.add(BtnSig);
		
		BtnGuardar = new JButton("");
		BtnGuardar.setFocusPainted(false);
		BtnGuardar.setIcon(new ImageIcon(FrameVistaPrincipal.class.getResource("/Img/guardar.png")));
		panel_1.add(BtnGuardar);
		
		CheckNota = new JCheckBox("NOTA");
		CheckNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
