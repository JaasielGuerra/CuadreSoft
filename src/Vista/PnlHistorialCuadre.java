package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;

public class PnlHistorialCuadre extends JPanel {
	public JTable Tabla;
	public JComboBox Ordenar;
	public JDateChooser Fecha;
	public JButton BtnBuscar;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	public JButton BtnEliminar;
	private JLabel lblFecha;

	/**
	 * Create the panel.
	 */
	public PnlHistorialCuadre() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		Tabla = new JTable();
		Tabla.setDefaultRenderer(Object.class, new RenderTablaHistorial());
		setLayout(new BorderLayout(0, 0));
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Fecha", "Inicio Caja", "Ventas", "Gastos", "Dinero real", "Diferencia", "Cuadre Final", "Nota"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Tabla.getColumnModel().getColumn(7).setPreferredWidth(25);
		Tabla.getColumnModel().getColumn(7).setMinWidth(25);
		scrollPane.setViewportView(Tabla);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		lblNewLabel = new JLabel("Orden:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		Ordenar = new JComboBox();
		Ordenar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Ordenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Ordenar.setPreferredSize(new Dimension(200, 25));
		panel.add(Ordenar);
		
		horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setPreferredSize(new Dimension(15, 0));
		panel.add(horizontalGlue);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblFecha);
		
		Fecha = new JDateChooser();
		Fecha.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Fecha.setDateFormatString("yyyy-MM-dd");
		Fecha.setPreferredSize(new Dimension(150, 25));
		BorderLayout bl_Fecha = (BorderLayout) Fecha.getLayout();
		Fecha.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(Fecha);
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalGlue_1.setPreferredSize(new Dimension(15, 0));
		panel.add(horizontalGlue_1);
		
		BtnBuscar = new JButton("Ir");
		BtnBuscar.setMargin(new Insets(0, 14, 0, 14));
		BtnBuscar.setIconTextGap(10);
		BtnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		BtnBuscar.setHorizontalTextPosition(SwingConstants.LEFT);
		BtnBuscar.setIcon(new ImageIcon(PnlHistorialCuadre.class.getResource("/Img/buscar.png")));
		BtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBuscar.setFocusPainted(false);
		panel.add(BtnBuscar);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
		
		BtnEliminar = new JButton("Eliminar");
		BtnEliminar.setIcon(new ImageIcon(PnlHistorialCuadre.class.getResource("/Img/eliminar.png")));
		BtnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BtnEliminar.setFocusPainted(false);
		panel_1.add(BtnEliminar);

	}
}
