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
import java.awt.Dimension;

public class PnlConfig extends JPanel {
	public JLabel LblMsj;
	public JCheckBox checkActivar;
	public JButton BtnGuardarCambios;

	/**
	 * Create the panel.
	 */
	public PnlConfig() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Aplicaci\u00F3n", TitledBorder.LEFT, TitledBorder.TOP, new Font("Dialog", Font.PLAIN, 12), null));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel label = new JLabel("Hacer que la ventana este siempre sobre cualquier otra:");
		label.setHorizontalTextPosition(SwingConstants.LEADING);
		label.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel.add(label);
		
		checkActivar = new JCheckBox("Activar");
		checkActivar.setSelected(true);
		checkActivar.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(checkActivar);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(0);
		add(panel_1, BorderLayout.SOUTH);
		
		BtnGuardarCambios = new JButton("Guardar cambios");
		BtnGuardarCambios.setMinimumSize(new Dimension(150, 30));
		BtnGuardarCambios.setPreferredSize(new Dimension(150, 30));
		BtnGuardarCambios.setIcon(new ImageIcon(PnlConfig.class.getResource("/Img/cambios.png")));
		BtnGuardarCambios.setFocusPainted(false);
		BtnGuardarCambios.setFont(new Font("Dialog", Font.PLAIN, 12));
		panel_1.add(BtnGuardarCambios);
		
		LblMsj = new JLabel("REINICIAR PARA APLICAR LOS CAMBIOS");
		LblMsj.setIcon(new ImageIcon(PnlConfig.class.getResource("/Img/alerta.png")));
		LblMsj.setVisible(false);
		LblMsj.setHorizontalAlignment(SwingConstants.CENTER);
		add(LblMsj, BorderLayout.CENTER);
		LblMsj.setForeground(new Color(255, 165, 0));
		LblMsj.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));

	}

}
