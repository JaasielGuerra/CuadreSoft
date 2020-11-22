package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import rojeru_san.componentes.RSDateChooser;

public class PnlHistorialCuadre extends JPanel {
	public JTable Tabla;
	public JComboBox Ordenar;
	public RSDateChooser fechaFin;
	public JButton BtnBuscar;
	private Component horizontalGlue_1;
	private JPanel panel_1;
	public JButton BtnEliminar;
	private JLabel lblFecha;
	public JPanel panFiltar;
	public JButton btnFiltrar;
	public JButton btnImprimir;
	private JLabel label;
	public JLabel label_1;
	public RSDateChooser fechaInicio;
	private Component horizontalGlue;
	private Component horizontalGlue_2;

	/**
	 * Create the panel.
	 */
	public PnlHistorialCuadre() {

		setPreferredSize(new Dimension(696, 332));

		JScrollPane scrollPane = new JScrollPane();

		Tabla = new JTable();
		Tabla.setDefaultRenderer(Object.class, new RenderTablaHistorial());
		setLayout(new BorderLayout(0, 0));
		Tabla.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null }, },
				new String[] { "Fecha", "Inicio Caja", "Ventas", "Gastos", "Dinero real", "Diferencia", "Cuadre Final",
						"Nota" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false };

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

		Ordenar = new JComboBox();
		Ordenar.setBorder(new LineBorder(Color.DARK_GRAY, 2));
		Ordenar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Ordenar.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Ordenar.setPreferredSize(new Dimension(200, 25));
		panel.add(Ordenar);

		btnFiltrar = new JButton("<<");
		btnFiltrar.setFocusPainted(false);
		btnFiltrar.setFont(new Font("Dialog", Font.PLAIN, 14));
		panel.add(btnFiltrar);

		panFiltar = new JPanel();
		FlowLayout fl_panFiltar = (FlowLayout) panFiltar.getLayout();
		fl_panFiltar.setVgap(0);
		fl_panFiltar.setHgap(0);
		panel.add(panFiltar);
		
		fechaInicio = new RSDateChooser();
		fechaInicio.setPreferredSize(new Dimension(150, 25));
		fechaInicio.setPlaceholder("");
		fechaInicio.setFuente(new Font("Times New Roman", Font.BOLD, 14));
		fechaInicio.setFormatoFecha("yyyy-MM-dd");
		fechaInicio.setFont(new Font("Dialog", Font.PLAIN, 14));
		fechaInicio.setColorForeground(Color.BLACK);
		fechaInicio.setColorButtonHover(Color.GRAY);
		fechaInicio.setColorBackground(Color.DARK_GRAY);
		panFiltar.add(fechaInicio);
		
		horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setPreferredSize(new Dimension(15, 0));
		horizontalGlue.setMinimumSize(new Dimension(15, 0));
		panFiltar.add(horizontalGlue);

		lblFecha = new JLabel("A");
		panFiltar.add(lblFecha);
		lblFecha.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalGlue_2.setPreferredSize(new Dimension(15, 0));
		horizontalGlue_2.setMinimumSize(new Dimension(15, 0));
		panFiltar.add(horizontalGlue_2);

		fechaFin = new RSDateChooser();
		fechaFin.setPlaceholder("");
		panFiltar.add(fechaFin);
		fechaFin.setFuente(new Font("Times New Roman", Font.BOLD, 14));
		fechaFin.setColorForeground(Color.BLACK);
		fechaFin.setColorButtonHover(Color.GRAY);
		fechaFin.setColorBackground(Color.DARK_GRAY);
		fechaFin.setFont(new Font("Dialog", Font.PLAIN, 14));
		fechaFin.setFormatoFecha("yyyy-MM-dd");
		fechaFin.setPreferredSize(new Dimension(150, 25));
		fechaFin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		horizontalGlue_1 = Box.createHorizontalGlue();
		panFiltar.add(horizontalGlue_1);
		horizontalGlue_1.setMinimumSize(new Dimension(15, 0));
		horizontalGlue_1.setPreferredSize(new Dimension(15, 0));

		BtnBuscar = new JButton("");
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

		

		btnImprimir = new JButton("Imprimir");
		btnImprimir.setIcon(new ImageIcon(PnlHistorialCuadre.class.getResource("/Img/imprimir.png")));
		btnImprimir.setPreferredSize(new Dimension(100, 30));
		btnImprimir.setMinimumSize(new Dimension(100, 30));
		btnImprimir.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnImprimir.setFocusPainted(false);
		panel_1.add(btnImprimir);

		BtnEliminar = new JButton("Eliminar");
		BtnEliminar.setMinimumSize(new Dimension(100, 30));
		BtnEliminar.setPreferredSize(new Dimension(100, 30));
		BtnEliminar.setIcon(new ImageIcon(PnlHistorialCuadre.class.getResource("/Img/eliminar.png")));
		BtnEliminar.setFont(new Font("Dialog", Font.PLAIN, 12));
		BtnEliminar.setFocusPainted(false);
		panel_1.add(BtnEliminar);

	}

}
