package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PnlHistorialCuadre extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PnlHistorialCuadre() {
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		add(table, BorderLayout.CENTER);

	}

}
