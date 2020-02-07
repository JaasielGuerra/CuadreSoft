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
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0};
		gridBagLayout.rowHeights = new int[] {0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0};
		setLayout(gridBagLayout);
		
				JPanel panel_4 = new JPanel();
				panel_4.setMinimumSize(new Dimension(350, 170));
				panel_4.setPreferredSize(new Dimension(350, 170));
				panel_4.setFont(new Font("Arial Black", Font.PLAIN, 12));
				
						panel_4.setBorder(new LineBorder(Color.LIGHT_GRAY));
						GridBagConstraints gbc_panel_4 = new GridBagConstraints();
						gbc_panel_4.anchor = GridBagConstraints.NORTHWEST;
						gbc_panel_4.gridx = 1;
						gbc_panel_4.gridy = 0;
						add(panel_4, gbc_panel_4);
						
								JLabel lblNewLabel = new JLabel("Fecha");
								lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
								
										Fecha = new JDateChooser();
										Fecha.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
										Fecha.setFont(new Font("Times New Roman", Font.PLAIN, 16));
										Fecha.setDateFormatString("yyyy-MM-dd");
										Fecha.setDate(date);
										
												JLabel lblNewLabel_1 = new JLabel("Inicio Caja");
												lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
												
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
																				lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 16));
																				
																						JLabel lblNewLabel_3 = new JLabel("Gastos");
																						lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 16));
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
