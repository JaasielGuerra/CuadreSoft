package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.Cursor;

public class RenderTablaHistorial extends DefaultTableCellRenderer {
	
	
	private JButton boton;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		// todo el codigo para personalizar la tabla

		// modificando el encabezado
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
		//table.getTableHeader().setForeground(new Color(255,255,255));
		//table.getTableHeader().setBackground(new Color(1, 87, 155));
		
		// si una fila es seleccionada
		if (isSelected) {
			this.setBackground(new Color(187, 222, 251));
		} else {// si no esta seleccionada
			this.setBackground(Color.WHITE);
		}

		// modificando alto de filas
		table.setRowHeight(25);

		// modificando la letra de la tabla
		this.setFont(new Font("Tahoma", Font.PLAIN, 12));
		this.setForeground(Color.BLACK);

		// color de la cuadricula de la tabla
		table.setGridColor(new Color(96, 125, 139));

		// comprobando valor de la celda
		if (column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) > 0) {
			// si el valor de la celda es mayor o igual a cero
			this.setBackground(new Color(255, 249, 196));
			// this.setForeground(Color.WHITE);
		} else if (column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) == 0) {
			this.setBackground(new Color(178, 223, 219));
			// this.setForeground(Color.WHITE);
		} else if (column == 5 && Float.parseFloat(table.getValueAt(row, 5).toString()) < 0) {
			this.setBackground(new Color(255, 205, 210));
			// this.setForeground(Color.WHITE);
		}

		this.setHorizontalAlignment(SwingConstants.CENTER);

		if(column == 7) {// la ultima columna
			
				
			boton = new JButton(new ImageIcon(PnlHistorialCuadre.class.getResource("/Img/Nota.png")));
			boton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			//boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			return boton;
			
		}
		
		return this;
	}

}
