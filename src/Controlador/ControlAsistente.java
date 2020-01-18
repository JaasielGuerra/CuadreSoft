package Controlador;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javax.swing.filechooser.FileNameExtensionFilter;

import Modelo.CInsertar;
import Modelo.Conexion;
import Modelo.ConstBaseDatos;
import Vista.FrameAsistente;
import Vista.FrameCarga;

/*
 * Control para el asistente de configuracion
 */

public class ControlAsistente extends FrameAsistente implements ActionListener {

	// atributos
	private JFileChooser abrir;
	private String ruta;
	private FileReader f;
	private BufferedReader buffer;

	public ControlAsistente() {

		// instancias
		this.abrir = new JFileChooser();// cuadro de dialogo para abrir archivos
		this.ruta = null;

		// para solo escoger archivos
		this.abrir.setFileSelectionMode(JFileChooser.FILES_ONLY);

		abrir.setAcceptAllFileFilterUsed(false);// desactivar el filtro de aceptar cualquier archivo
		abrir.addChoosableFileFilter(new FileNameExtensionFilter("Sólo archivos de texto :)", "txt"));// establecer un
																										// filtro
		// activar escucha de eventos
		RBtnCero.addActionListener(this);
		RBtnTxt.addActionListener(this);
		BtnEscogerRuta.addActionListener(this);
		BtnFinalizar.addActionListener(this);

	}

	// valida el formulario del asistente de configuracion
	public boolean formValido() {
		boolean valido = false;

		if (RBtnTxt.isSelected() && TxtRuta.getText().length() > 0) {

			valido = true;

			this.dispose();

			llenarBD();// se llama el metodo para inicializar la base de datos

			ControlPrincipal c = new ControlPrincipal(CheckActivar.isSelected());// se instancia el control principal
			c.setVisible(true);
			
		} else if (RBtnCero.isSelected()) {

			valido = true;

			this.dispose();

			llenarBD();

			ControlPrincipal c = new ControlPrincipal(CheckActivar.isSelected());// se instancia el control principal
			c.setVisible(true);

		} else {

			valido = false;
			JOptionPane.showMessageDialog(this, "Por favor complete el formulario.", "Aplicativo",
					JOptionPane.WARNING_MESSAGE);

		}

		return valido;
	}

	private void abrirArchivo() {// para abrir cuadro de dialogo y abrir un archivo

		int seleccion = abrir.showOpenDialog(this);
		if (seleccion == JFileChooser.APPROVE_OPTION) {// si se selcciono el archivo y pulso abrir

			this.ruta = abrir.getSelectedFile().getAbsolutePath();// obtener la ruta del archivo
			this.TxtRuta.setText(ruta);
		}

	}

	// para llenar la base con los datos del archivo TXT
	private void llenarBD() {

		FrameCarga c = new FrameCarga();
		c.setVisible(true);

		// si se selcciono para llenar la base con datos del archivo
		if (RBtnTxt.isSelected()) {

			try {

				Conexion con = new Conexion(ConstBaseDatos.rutaBD);
				CInsertar in = new CInsertar(con.conectar(), "registro_cuadres");

				// cargar el archivo
				f = new FileReader(TxtRuta.getText());
				buffer = new BufferedReader(f);

				String linea = "";
				// DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");// para formatear la
				// fecha
				// Date fe = new Date("28/11/2019");
				FormatoFecha formato = new FormatoFecha();

				while ((linea = buffer.readLine()) != null) {

					StringTokenizer campo = new StringTokenizer(linea, " ");// dividir la linea

					for (int i = 0; i <= 7; i++) {

						if (i == 0)
							in.agregarValor("fecha", formato.formato(campo.nextToken()));
						if (i == 1)
							in.agregarValor("inicio_caja", campo.nextToken());
						if (i == 2)
							in.agregarValor("ventas", campo.nextToken());
						if (i == 3)
							in.agregarValor("gastos", campo.nextToken());
						if (i == 4)
							in.agregarValor("dinero_real", campo.nextToken());
						if (i == 5)
							in.agregarValor("sobra_falta", campo.nextToken());
						if (i == 6)
							in.agregarValor("cuadre_final", campo.nextToken());
						if (i == 7)
							in.agregarValor("nota", "- Sin nota que mostrar -");
					}

					in.ejecutarSQL();

				}

				in = new CInsertar(con.conectar(), "config");

				in.agregarValor("llave", "visible_top");
				in.agregarValor("valor", CheckActivar.isSelected() ? "si" : "no");// condicion ?

				in.ejecutarSQL();

				con.cerrar();// cerrar la conexion

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al cargar los datos:\n" + e.getMessage(), "Error IO",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (RBtnCero.isSelected()) {// si selecciona comenzar desde cero

			Conexion con = new Conexion(ConstBaseDatos.rutaBD);
			CInsertar in = new CInsertar(con.conectar(), "config");

			in.agregarValor("llave", "visible_top");
			in.agregarValor("valor", CheckActivar.isSelected() ? "si" : "no");// condicion ?

			in.ejecutarSQL();

			con.cerrar();// cerrar la conexion
		}

		c.dispose();

	}

	/////// eventos//////////

	@Override
	public void actionPerformed(ActionEvent e) {

		this.BtnEscogerRuta.setEnabled(RBtnTxt.isSelected());
		this.TxtRuta.setEnabled(RBtnTxt.isSelected());

		///////// Boton de abrir///////////////
		if (e.getSource().equals(BtnEscogerRuta)) {
			abrirArchivo();
		}

		////////// boton de finalizar////////////
		if (e.getSource().equals(BtnFinalizar)) {
			formValido();
		}

	}

}
