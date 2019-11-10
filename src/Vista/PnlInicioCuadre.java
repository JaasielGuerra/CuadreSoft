package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;
import java.awt.FlowLayout;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import com.toedter.components.JLocaleChooser;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class PnlInicioCuadre extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnlInicioCuadre() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
		flowLayout_2.setHgap(55);
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_1.getLayout();
		flowLayout_3.setHgap(55);
		add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(45);
		add(panel_2, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setVgap(45);
		add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_4.setBorder(new TitledBorder(null, "Datos Iniciales", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(4, 2, 5, 15));
		
		JLabel lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		panel_4.add(dateChooser);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio Caja");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_1);
		
		JSpinField spinField = new JSpinField();
		panel_4.add(spinField);
		
		JLabel lblNewLabel_2 = new JLabel("Ventas");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_2);
		
		JSpinField spinField_1 = new JSpinField();
		panel_4.add(spinField_1);
		
		JLabel lblNewLabel_3 = new JLabel("Gastos");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_3);
		
		JSpinField spinField_2 = new JSpinField();
		panel_4.add(spinField_2);

	}

}
