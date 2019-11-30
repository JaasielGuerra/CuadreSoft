package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Checkbox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FrameAsistente extends JFrame {

	private JPanel contentPane;
	public javax.swing.ButtonGroup BtnGrupo;
	public JRadioButton RBtnCero;
	public JRadioButton RBtnTxt;
	public JButton BtnEscogerRuta;
	public JTextField TxtRuta;
	public JCheckBox CheckActivar;
	public JButton BtnFinalizar;
	public JPanel PnlRuta;

	/**
	 * Create the frame.
	 */
	public FrameAsistente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 5));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnHolaComoEstas = new JTextPane();
		txtpnHolaComoEstas.setEditable(false);
		txtpnHolaComoEstas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnHolaComoEstas.setText("Las siguientes opciones son para configurar el primer uso del aplicativo, por favor completelas y luego presione el bot\u00F3n finalizar.");
		panel.add(txtpnHolaComoEstas);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Cargar Datos", TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 12), null));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);
		
		RBtnCero = new JRadioButton("Comenzar desde cero");
		RBtnCero.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(RBtnCero);
		
		RBtnTxt = new JRadioButton("Tengo un archivo (TXT)");
		RBtnTxt.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(RBtnTxt);
		
		BtnGrupo = new javax.swing.ButtonGroup();
		BtnGrupo.add(RBtnCero);
		BtnGrupo.add(RBtnTxt);
		
		PnlRuta = new JPanel();
		PnlRuta.setEnabled(false);
		panel_2.add(PnlRuta);
		
		BtnEscogerRuta = new JButton("...");
		BtnEscogerRuta.setFont(new Font("Tahoma", Font.BOLD, 12));
		BtnEscogerRuta.setEnabled(false);
		BtnEscogerRuta.setFocusPainted(false);
		
		TxtRuta = new JTextField();
		TxtRuta.setEditable(false);
		TxtRuta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TxtRuta.setPreferredSize(new Dimension(20, 26));
		TxtRuta.setColumns(10);
		GroupLayout gl_PnlRuta = new GroupLayout(PnlRuta);
		gl_PnlRuta.setHorizontalGroup(
			gl_PnlRuta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlRuta.createSequentialGroup()
					.addGap(5)
					.addComponent(BtnEscogerRuta)
					.addGap(5)
					.addComponent(TxtRuta, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
		);
		gl_PnlRuta.setVerticalGroup(
			gl_PnlRuta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PnlRuta.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_PnlRuta.createParallelGroup(Alignment.LEADING)
						.addComponent(TxtRuta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(BtnEscogerRuta))
					.addGap(14))
		);
		PnlRuta.setLayout(gl_PnlRuta);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Aplicaci\u00F3n", TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 12), null));
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Hacer que la ventana este siempre sobre cualquier otra:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		panel_3.add(lblNewLabel);
		
		CheckActivar = new JCheckBox("Activar");
		CheckActivar.setFont(new Font("Tahoma", Font.BOLD, 12));
		CheckActivar.setSelected(true);
		panel_3.add(CheckActivar);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		BtnFinalizar = new JButton("Finalizar :)");
		BtnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BtnFinalizar.setFocusPainted(false);
		panel_4.add(BtnFinalizar);
	}

}
