package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import com.toedter.components.JSpinField;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PnlDesglose extends JPanel {
	
	public JTextField Cien;
	protected JTextField Cincuenta;
	protected JTextField Veinte;
	protected JTextField Diez;
	protected JTextField Cinco;
	protected JTextField Uno;
	protected JTextField CincuentaCent;
	protected JTextField VeinticincoCent;
	protected JTextField DiezCent;
	protected JTextField CincoCent;

	/**
	 * Create the panel.
	 */
	public PnlDesglose() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setHgap(50);
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(50);
		add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_2.getLayout();
		flowLayout_3.setVgap(10);
		add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setVgap(10);
		add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		add(panel_4, BorderLayout.CENTER);
		
		Uno = new JTextField();
		Uno.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		Uno.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Uno.setColumns(10);
		
		CincuentaCent = new JTextField();
		CincuentaCent.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		CincuentaCent.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CincuentaCent.setColumns(10);
		
		VeinticincoCent = new JTextField();
		VeinticincoCent.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		VeinticincoCent.setFont(new Font("Times New Roman", Font.BOLD, 16));
		VeinticincoCent.setColumns(10);
		
		DiezCent = new JTextField();
		DiezCent.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		DiezCent.setFont(new Font("Times New Roman", Font.BOLD, 16));
		DiezCent.setColumns(10);
		
		CincoCent = new JTextField();
		CincoCent.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		CincoCent.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CincoCent.setColumns(10);
		panel_4.setLayout(new GridLayout(10, 2, 15, 3));
		
		JLabel lblNewLabel = new JLabel("Q100.00 ->");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel);
		
		Cien = new JTextField();
		Cien.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		Cien.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Cien.setColumns(10);
		panel_4.add(Cien);
		
		JLabel lblNewLabel_1 = new JLabel("Q50.00 ->");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_1);
		
		Cincuenta = new JTextField();
		Cincuenta.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		Cincuenta.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Cincuenta.setColumns(10);
		panel_4.add(Cincuenta);
		
		JLabel lblNewLabel_2 = new JLabel("Q20.00 ->");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_2);
		
		Veinte = new JTextField();
		Veinte.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		Veinte.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Veinte.setColumns(10);
		panel_4.add(Veinte);
		
		JLabel lblNewLabel_3 = new JLabel("Q10.00 ->");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_3);
		
		Diez = new JTextField();
		Diez.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		Diez.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Diez.setColumns(10);
		panel_4.add(Diez);
		
		JLabel lblNewLabel_4 = new JLabel("Q5.00 ->");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_4);
		
		Cinco = new JTextField();
		Cinco.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		Cinco.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Cinco.setColumns(10);
		panel_4.add(Cinco);
		
		JLabel lblNewLabel_5 = new JLabel("Q1.00 ->");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_5);
		panel_4.add(Uno);
		
		JLabel lblNewLabel_6 = new JLabel("Q0.50 ->");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_6);
		panel_4.add(CincuentaCent);
		
		JLabel lblNewLabel_7 = new JLabel("Q0.25 ->");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_7);
		panel_4.add(VeinticincoCent);
		
		JLabel lblNewLabel_8 = new JLabel("Q0.10 ->");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_8);
		panel_4.add(DiezCent);
		
		JLabel lblNewLabel_9 = new JLabel("Q0.05 ->");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_4.add(lblNewLabel_9);
		panel_4.add(CincoCent);

	}
}
