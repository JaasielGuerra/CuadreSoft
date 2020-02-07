package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Color;

public class DlgNota extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JButton BtnCancelar;
	public JButton BtnAceptar;
	private JScrollPane scrollPane;
	public JTextArea textArea;

	/**
	 * Create the dialog.
	 */
	public DlgNota() {
		setTitle("Notas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgNota.class.getResource("/Img/icono.png")));
		setSize(450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				textArea = new JTextArea();
				textArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
				textArea.setLineWrap(true);
				scrollPane.setViewportView(textArea);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				BtnAceptar = new JButton("Aceptar");
				BtnAceptar.setBackground(new Color(129,199,132));
				BtnAceptar.setPreferredSize(new Dimension(80, 30));
				BtnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BtnAceptar.setFocusPainted(false);
				buttonPane.add(BtnAceptar);
				getRootPane().setDefaultButton(BtnAceptar);
			}
			{
				BtnCancelar = new JButton("Cancelar");
				BtnCancelar.setBackground(new Color(229,115,115));
				BtnCancelar.setPreferredSize(new Dimension(80, 30));
				BtnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				BtnCancelar.setFocusPainted(false);
				buttonPane.add(BtnCancelar);
			}
		}
	}

}
