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
import rojeru_san.componentes.RSDateChooser;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PnlHistorialCuadre extends JPanel {
	public JTable Tabla;
	public JComboBox Ordenar;
	public RSDateChooser Fecha;
	public JButton BtnBuscar;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	public JButton BtnEliminar;
	private JLabel lblFecha;
	public JPanel panFiltar;
	public JButton btnFiltrar;

	/**
	 * Create the panel.
	 */
	public PnlHistorialCuadre() {
		setPreferredSize(new Dimension(696, 332));
		
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
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		lblNewLabel = new JLabel("Orden:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		Ordenar = new JComboBox();
		Ordenar.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		Ordenar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Ordenar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Ordenar.setPreferredSize(new Dimension(200, 25));
		panel.add(Ordenar);
		
		horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setMinimumSize(new Dimension(50, 0));
		horizontalGlue.setPreferredSize(new Dimension(50, 0));
		panel.add(horizontalGlue);
		
		btnFiltrar = new JButton("Filtrar <<");
		btnFiltrar.setFocusPainted(false);
		btnFiltrar.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(btnFiltrar);
		
		panFiltar = new JPanel();
		FlowLayout fl_panFiltar = (FlowLayout) panFiltar.getLayout();
		fl_panFiltar.setVgap(0);
		fl_panFiltar.setHgap(0);
		panel.add(panFiltar);
		
		lblFecha = new JLabel("Fecha:");
		panFiltar.add(lblFecha);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		Fecha = new RSDateChooser();
		panFiltar.add(Fecha);
		Fecha.setFuente(new Font("Times New Roman", Font.BOLD, 14));
		Fecha.setColorForeground(Color.BLACK);
		Fecha.setColorButtonHover(Color.GRAY);
		Fecha.setColorBackground(Color.DARK_GRAY);
		Fecha.setFont(new Font("Dialog", Font.PLAIN, 14));
		Fecha.setFormatoFecha("yyyy-MM-dd");
		Fecha.setPreferredSize(new Dimension(150, 25));
		Fecha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		panFiltar.add(horizontalGlue_1);
		horizontalGlue_1.setMinimumSize(new Dimension(15, 0));
		horizontalGlue_1.setPreferredSize(new Dimension(15, 0));
		
		BtnBuscar = new JButton("Ir");
		panFiltar.add(BtnBuscar);
		BtnBuscar.setMargin(new Insets(0, 14, 0, 14));
		BtnBuscar.setIconTextGap(10);
		BtnBuscar.setFont(new Font("Dialog", Font.PLAIN, 14));
		BtnBuscar.setHorizontalTextPosition(SwingConstants.LEFT);
		BtnBuscar.setIcon(new ImageIcon(PnlHistorialCuadre.class.getResource("/Img/buscar.png")));
		BtnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BtnBuscar.setFocusPainted(false);
		
		panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		BtnEliminar = new JButton("Eliminar");
		BtnEliminar.setMinimumSize(new Dimension(100, 30));
		BtnEliminar.setPreferredSize(new Dimension(100, 30));
		BtnEliminar.setIcon(new ImageIcon(PnlHistorialCuadre.class.getResource("/Img/eliminar.png")));
		BtnEliminar.setFont(new Font("Dialog", Font.PLAIN, 12));
		BtnEliminar.setFocusPainted(false);
		panel_1.add(BtnEliminar);

	}
}
