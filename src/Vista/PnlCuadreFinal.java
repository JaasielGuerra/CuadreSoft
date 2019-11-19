package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PnlCuadreFinal extends JPanel {
	public JTable Tabla;

	/**
	 * Create the panel.
	 */
	public PnlCuadreFinal() {
		setLayout(new BorderLayout(0, 0));
		
		//DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
		//tcr.setHorizontalAlignment(SwingConstants.RIGHT);
		
		Tabla = new JTable();
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
				true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		Tabla.getColumnModel().getColumn(0).setPreferredWidth(140);
		Tabla.getColumnModel().getColumn(0).setMinWidth(140);
		Tabla.getColumnModel().getColumn(0).setMaxWidth(140);
		
		//table.setRowHeight(57);
		//table.getColumnModel().getColumn(0).setCellRenderer(tcr);

	}
}
