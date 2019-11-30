package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.CConsultar;
import Modelo.CModificar;
import Modelo.Conexion;
import Modelo.ConstBaseDatos;
import Vista.PnlConfig;

/*
 * control para la configuracion del aplicativo
 */

public class ControlConfig extends PnlConfig implements ActionListener {

	public ControlConfig() {

		this.BtnGuardarCambios.addActionListener(this);
		initConfig();

	}

	// configuracion que esta guardada en la BD
	private void initConfig() {

		Conexion con = new Conexion(ConstBaseDatos.rutaBD);
		CConsultar consulta = new CConsultar(con.conectar(), "config");

		consulta.consultar("*");

		try {

			while (consulta.getResultadoConsulta().next()) {

				if (consulta.getResultadoConsulta().getString("llave").equals("visible_top"))
					checkActivar.setSelected(consulta.getResultadoConsulta().getString("valor").equals("si"));

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problemas al cargar la configucarion: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void guardarCambios() {// para guardar los cambios

		Conexion con = new Conexion(ConstBaseDatos.rutaBD);
		CModificar mod = new CModificar(con.conectar(), "config");

		mod.agregarValor("llave", "visible_top");
		mod.agregarValor("valor", checkActivar.isSelected() ? "si" : "no");// condicion ?

		if (mod.ejecutarSQL()) {

			LblMsj.setVisible(true);

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(BtnGuardarCambios)) {
			guardarCambios();
		}

	}

}
