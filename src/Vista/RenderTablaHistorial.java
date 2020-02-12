package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTablaHistorial extends DefaultTableCellRenderer {

	private JButton boton;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// todo el codigo para personalizar la tabla

		// modificando el encabezado
		table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 14));
		// table.getTableHeader().setForeground(new Color(255,255,255));
		// table.getTableHeader().setBackground(new Color(1, 87, 155));

		// color de fila segun par o impar
		if (row % 2 == 0) {
			this.setBackground(new Color(238, 238, 238));
		} else {
			this.setBackground(Color.white);
		}

		// si una fila es seleccionada
		if (isSelected) {
			this.setBackground(new Color(189,189,189));
		}
		// modificando alto de filas
		table.setRowHeight(25);

		// modificando la letra de la tabla
		this.setFont(new Font("Dialog", Font.PLAIN, 12));
		this.setForeground(Color.BLACK);

		// color de la cuadricula de la tabla
		table.setGridColor(new Color(238, 238, 238));

		// comprobando valor de la celda
		if (column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) > 0) {
			// si el valor de la celda es mayor a cero
			this.setBackground(new Color(255, 238, 88));
			// this.setForeground(Color.WHITE);
		} else if (column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) == 0) {
			this.setBackground(new Color(102, 187, 106));
			// this.setForeground(Color.WHITE);
		} else if (column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) < 0) {
			this.setBackground(new Color(239, 83, 80));
			// this.setForeground(Color.WHITE);
		}

		this.setHorizontalAlignment(SwingConstants.CENTER);

		if (column == 7) {// la ultima columna

			boton = new JButton(new ImageIcon(PnlHistorialCuadre.class.getResource("/Img/nota.png")));
			boton.setFont(new Font("Dialog", Font.PLAIN, 12));
			// boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			return boton;

		}

		return this;
	}

}
