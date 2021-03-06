package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * para personalizar un JTable
 */

public class RenderTablaResumen extends DefaultTableCellRenderer {
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		/////////////todo el codigo para personalizar la tabla/////////////
		
		
		
		if(isSelected) {
			this.setBackground(new Color(189,189,189));
		}else {
			this.setBackground(Color.WHITE);
		}
		
		if(column == 0) {// modificar la primera columna
			this.setBackground(new Color(33,33,33));
			this.setFont(new Font("Dialog", Font.BOLD,14));
			this.setForeground(Color.white);
			this.setHorizontalAlignment(SwingConstants.RIGHT);
			table.getColumnModel().getColumn(0).setCellRenderer(this);
		}
		
		if(column == 1) {// modificar columna dos
			this.setFont(new Font("Times New Roman", Font.BOLD,20));
			this.setForeground(Color.BLACK);
			this.setHorizontalAlignment(SwingConstants.CENTER);
			table.getColumnModel().getColumn(1).setCellRenderer(this);
		}
		
		// color de la cuadricula de la tabla
		table.setGridColor(new Color(97,97,97));
		

		return this;
	}
}