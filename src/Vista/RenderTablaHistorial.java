package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTablaHistorial extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// todo el codigo para personalizar la tabla

		// si una fila es seleccionada
		if (isSelected) {
			this.setBackground(new Color(187, 222, 251));
		} else {// si no esta seleccionada
			this.setBackground(Color.WHITE);
		}
		
		// modificando alto de filas
		table.setRowHeight(25);

		// modificando el encabezado
		table.getTableHeader().setFont(new Font("Arial Black", Font.PLAIN, 12));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(new Color(1, 87, 155));

		// modificando la letra de la tabla
		this.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		this.setForeground(Color.BLACK);

		// color de la cuadricula de la tabla
		table.setGridColor(new Color(96, 125, 139));
		
		//comprobando valor de la celda
		if(column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) > 0) {
			// si el valor de la celda es mayor o igual a cero
			this.setBackground(new Color(255,249,196));
			//this.setForeground(Color.WHITE);
		}else if(column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) == 0){
			this.setBackground(new Color(178,223,219));
			//this.setForeground(Color.WHITE);
		}else if(column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) < 0) {
			this.setBackground(new Color(255,205,210));
			//this.setForeground(Color.WHITE);
		}

		return this;
	}

}
