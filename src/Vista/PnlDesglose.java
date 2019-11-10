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

public class PnlDesglose extends JPanel {

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
		panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(10, 2, 80, 2));
		
		JLabel lblNewLabel = new JLabel("Q100.00 ->");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel);
		
		JSpinField spinField = new JSpinField();
		panel_4.add(spinField);
		
		JLabel lblNewLabel_1 = new JLabel("Q50.00 ->");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_1);
		
		JSpinField spinField_1 = new JSpinField();
		panel_4.add(spinField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Q20.00 ->");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_2);
		
		JSpinField spinField_2 = new JSpinField();
		panel_4.add(spinField_2);
		
		JLabel lblNewLabel_3 = new JLabel("Q10.00 ->");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_3);
		
		JSpinField spinField_3 = new JSpinField();
		panel_4.add(spinField_3);
		
		JLabel lblNewLabel_4 = new JLabel("Q5.00 ->");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_4);
		
		JSpinField spinField_4 = new JSpinField();
		panel_4.add(spinField_4);
		
		JLabel lblNewLabel_5 = new JLabel("Q1.00 ->");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_5);
		
		JSpinField spinField_5 = new JSpinField();
		panel_4.add(spinField_5);
		
		JLabel lblNewLabel_6 = new JLabel("Q0.50 ->");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_6);
		
		JSpinField spinField_6 = new JSpinField();
		panel_4.add(spinField_6);
		
		JLabel lblNewLabel_7 = new JLabel("Q0.25 ->");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_7);
		
		JSpinField spinField_7 = new JSpinField();
		panel_4.add(spinField_7);
		
		JLabel lblNewLabel_8 = new JLabel("Q0.10 ->");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_8);
		
		JSpinField spinField_8 = new JSpinField();
		panel_4.add(spinField_8);
		
		JLabel lblNewLabel_9 = new JLabel("Q0.05 ->");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_9);
		
		JSpinField spinField_9 = new JSpinField();
		panel_4.add(spinField_9);

	}

}
