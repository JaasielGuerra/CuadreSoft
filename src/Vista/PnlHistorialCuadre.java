package Vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class PnlHistorialCuadre extends JPanel {
	public JTable Tabla;

	/**
	 * Create the panel.
	 */
	public PnlHistorialCuadre() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		Tabla = new JTable();
		Tabla.setDefaultRenderer(Object.class, new RenderTablaHistorial());
		Tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Fecha", "Inicio Caja", "Ventas", "Gastos", "Dinero real", "Diferencia", "Cuadre Final"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(Tabla);
					
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

	}

}
