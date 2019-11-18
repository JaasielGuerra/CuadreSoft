package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import Vista.FormVistaPrincipal;
import Vista.PnlCuadreFinal;
import Vista.PnlDesglose;
import Vista.PnlHistorialCuadre;
import Vista.PnlInicioCuadre;

public class ControlPrincipal extends FormVistaPrincipal implements ActionListener {

	private CambiarPanel cambiar;
	private ControlInicioCuadre CtrlInicioCuadre;
	private ControlDesglose CtrlDesglose;
	private ControlCuadreFinal CtrlCuadreFinal;
	private ControlHistorial CtrlHistorialCuadre;
	private int pnlSiguiente = 0;

	public ControlPrincipal() {

		this.cambiar = new CambiarPanel();
		this.CtrlInicioCuadre = new ControlInicioCuadre();
		this.CtrlDesglose = new ControlDesglose();
		this.CtrlCuadreFinal = new ControlCuadreFinal();
		this.CtrlHistorialCuadre = new ControlHistorial();

		BtnCuadrar.addActionListener(this);
		BtnHistorial.addActionListener(this);
		BtnAtras.addActionListener(this);
		BtnSig.addActionListener(this);

		BtnAtras.setEnabled(false);
		PanelInf.setVisible(false);
		BtnGuardar.setVisible(false);

		// BtnCuadrar.doClick();//hacer clic a cuadrar

	}

	private void escogerPanel(int nPanel) {// para escoger los paneles

		switch (nPanel) {

		case 0:
			cambiar.cambiarPNL(PanelCentral, CtrlInicioCuadre);
			BtnAtras.setEnabled(false);
			BtnGuardar.setVisible(false);
			break;
		case 1:
			cambiar.cambiarPNL(PanelCentral, CtrlDesglose);
			BtnAtras.setEnabled(true);
			BtnSig.setEnabled(true);
			BtnGuardar.setVisible(false);
			break;
		case 2:
			cambiar.cambiarPNL(PanelCentral, CtrlCuadreFinal);
			BtnSig.setEnabled(false);
			BtnGuardar.setVisible(true);
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/////////// boton cuadrar////////////////
		if (e.getSource().equals(BtnCuadrar)) {

			escogerPanel(pnlSiguiente);
			PanelInf.setVisible(true);

		}

		/////////// boton historial////////////////
		if (e.getSource().equals(BtnHistorial)) {

			PanelInf.setVisible(false);
			cambiar.cambiarPNL(PanelCentral, CtrlHistorialCuadre);

		}

		//////////////// boton atras///////////////
		if (e.getSource().equals(BtnAtras)) {

			escogerPanel(--pnlSiguiente);
		}

		////////// boton siguiente
		if (e.getSource().equals(BtnSig)) {

			escogerPanel(++pnlSiguiente);

		}
	}

}
