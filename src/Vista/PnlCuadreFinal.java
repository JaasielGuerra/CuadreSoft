package Vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PnlCuadreFinal extends JPanel {
	public JTable Tabla;

	/**
	 * Create the panel.
	 */
	public PnlCuadreFinal() {
		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		
		//DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		//tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Tabla = new JTable();
		Tabla.setBorder(null);
		add(Tabla, BorderLayout.CENTER);
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
				{"Inicio Caja ->", null},
				{"Ventas del dia ->", null},
				{"Gastos ->", null},
				{"Dinero real ->", null},
				{"Dinero sobrante/faltante ->", null},
				{"Total sacar de caja ->", null},
			},
			new String[] {
				"Dato", "Cantidad"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
		Tabla.getColumnModel().getColumn(0).setMinWidth(200);
		Tabla.getColumnModel().getColumn(0).setMaxWidth(200);
		
		Tabla.setRowHeight(59);
		Tabla.setDefaultRenderer(Object.class, new RenderTablaResumen());
		//Tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);

	}
}
