package Vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PnlConfig extends JPanel {
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JCheckBox checkBox;

	/**
	 * Create the panel.
	 */
	public PnlConfig() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Aplicaci\u00F3n", TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 12), null));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel label = new JLabel("Hacer que la ventana este siempre sobre cualquier otra:");
		label.setHorizontalTextPosition(SwingConstants.LEADING);
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(label);
		
		checkBox = new JCheckBox("Activar");
		checkBox.setSelected(true);
		checkBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(checkBox);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("Guardar cambios");
		btnNewButton.setIcon(new ImageIcon(PnlConfig.class.getResource("/Img/cambios.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(btnNewButton);
		
		lblNewLabel = new JLabel("Reiniciar para aplicar cambios");
		lblNewLabel.setVisible(false);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

	}

}
