package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.FormVistaPrincipal;
import Vista.PnlCuadreFinal;
import Vista.PnlDesglose;
import Vista.PnlHistorialCuadre;
import Vista.PnlInicioCuadre;

public class ControlPrincipal extends FormVistaPrincipal implements ActionListener{

	
	private CambiarPanel cambiar;
	private PnlInicioCuadre inicioCuadre;
	private PnlDesglose desglose;
	private PnlCuadreFinal cuadreFinal;
	private PnlHistorialCuadre historialCuadre;
	private int pnlSiguiente = 0;
	
	public ControlPrincipal() {
		
		this.cambiar = new CambiarPanel();
		this.inicioCuadre = new PnlInicioCuadre();
		this.desglose = new PnlDesglose();
		this.cuadreFinal = new PnlCuadreFinal();
		this.historialCuadre = new PnlHistorialCuadre();
		
		BtnCuadrar.addActionListener(this);
		BtnHistorial.addActionListener(this);
		BtnAtras.addActionListener(this);
		BtnSig.addActionListener(this);
		
		BtnAtras.setEnabled(false);
		PanelInf.setVisible(false);
		BtnGuardar.setVisible(false);
		
		//BtnCuadrar.doClick();//hacer clic a cuadrar
		
	}
	
	private void escogerPanel(int nPanel) {//para escoger los paneles
		
		switch(nPanel) {
		
		case 0:
			cambiar.cambiarPNL(PanelCentral, inicioCuadre);
			BtnAtras.setEnabled(false);
			BtnGuardar.setVisible(false);
			break;
		case 1:
			cambiar.cambiarPNL(PanelCentral, desglose);
			BtnAtras.setEnabled(true);
			BtnSig.setEnabled(true);
			BtnGuardar.setVisible(false);
			break;
		case 2:
			cambiar.cambiarPNL(PanelCentral, cuadreFinal);
			BtnSig.setEnabled(false);
			BtnGuardar.setVisible(true);
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		///////////boton cuadrar////////////////
		if(e.getSource().equals(BtnCuadrar)) {
			
			
			escogerPanel(pnlSiguiente);
			PanelInf.setVisible(true);
			
						
		}
		
		///////////boton historial////////////////		
		if(e.getSource().equals(BtnHistorial)) {
			
			PanelInf.setVisible(false);
			cambiar.cambiarPNL(PanelCentral, historialCuadre);
					
		}
		
		////////////////boton atras///////////////
		if(e.getSource().equals(BtnAtras)) {
			
			escogerPanel(--pnlSiguiente);
		}
		
		//////////boton siguiente
		if(e.getSource().equals(BtnSig)) {
			
			escogerPanel(++pnlSiguiente);
									
		}
	}
	
	
}
