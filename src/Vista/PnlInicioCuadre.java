package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JFormattedTextField;
import java.util.Date;
import javax.swing.UIManager;

public class PnlInicioCuadre extends JPanel {

	protected JDateChooser Fecha;
	protected JFormattedTextField InicioCaja;
	protected JFormattedTextField Ventas;
	protected JFormattedTextField Gastos;

	// Formato para los campos
	private NumberFormat decimalFormato;

	// formato para la fecha
	private Date date;

	/**
	 * Create the panel.
	 */
	public PnlInicioCuadre() {

		date = new Date();
		decimalFormato = NumberFormat.getNumberInstance(Locale.ENGLISH);
		decimalFormato.setMinimumFractionDigits(2);
		decimalFormato.setMaximumFractionDigits(2);

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
		panel_4.setFont(new Font("Arial Black", Font.PLAIN, 12));

		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Iniciales",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("Arial Black", Font.PLAIN, 12), new Color(0, 0, 0)));
		add(panel_4, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));

		Fecha = new JDateChooser();
		Fecha.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Fecha.setDateFormatString("dd/MM/yyyy");
		Fecha.setDate(date);

		JLabel lblNewLabel_1 = new JLabel("Inicio Caja");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 16));

		InicioCaja = new JFormattedTextField(decimalFormato);
		InicioCaja.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		InicioCaja.setText("0.00");

		Ventas = new JFormattedTextField(decimalFormato);
		Ventas.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Ventas.setText("0.00");

		Gastos = new JFormattedTextField(decimalFormato);
		Gastos.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Gastos.setText("0.00");

		JLabel lblNewLabel_2 = new JLabel("Ventas");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 16));

		JLabel lblNewLabel_3 = new JLabel("Gastos");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 16));
		panel_4.setLayout(new GridLayout(4, 2, 0, 5));
		panel_4.add(lblNewLabel);
		panel_4.add(Fecha);
		panel_4.add(lblNewLabel_1);
		panel_4.add(InicioCaja);
		panel_4.add(lblNewLabel_2);
		panel_4.add(Ventas);
		panel_4.add(lblNewLabel_3);
		panel_4.add(Gastos);

	}

}
