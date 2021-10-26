package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaMenuEjemplos;

public class ControlMenuEjemplos implements ActionListener, MouseListener {
	
	private VistaMenuEjemplos vme;

	public ControlMenuEjemplos(VistaMenuEjemplos vme) {
		this.vme = vme;
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(vme.getBtnPunto())){
			
			vme.setVisible(false);
			vme.getCv().getVep().setVisible(true);
		
			
		}else if(ev.getSource().equals(vme.getBtnCoordenadas3D())){
			
			vme.setVisible(false);
			vme.getCv().getVec3D().setVisible(true);
			
		}else if(ev.getSource().equals(vme.getBtnSegmento())){
			
			vme.setVisible(false);
			vme.getCv().getVes().setVisible(true);
		
		}else if(ev.getSource().equals(vme.getBtnVector())){
			
			vme.setVisible(false);
			vme.getCv().getVev().setVisible(true);
			
		}else if(ev.getSource().equals(vme.getBtnVectorDePosicion())){
			
			vme.setVisible(false);
			vme.getCv().getVevp().setVisible(true);
			
		}else if(ev.getSource().equals(vme.getBtnSumaDeVectores())){
			
			vme.setVisible(false);
			vme.getCv().getVesv().setVisible(true);
		
		}else if(ev.getSource().equals(vme.getBtnAngulos())){
			
			vme.setVisible(false);
			vme.getCv().getVea().setVisible(true);
			
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent ev) {
		
		
		if(ev.getSource().equals(vme.getLblSalir())){
			
			vme.setVisible(false);
			vme.getCv().getVm().setVisible(true);
			
		}
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent ev) {
		// TODO Auto-generated method stub
		
		if(ev.getSource().equals(vme.getLblSalir())){
			
			vme.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		}
		
	}
	


	@Override
	public void mouseExited(MouseEvent ev) {
		// TODO Auto-generated method stub
		
		if(ev.getSource().equals(vme.getLblSalir())){
			
			vme.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
		}
		
	}



	@Override
	public void mousePressed(MouseEvent ev) {
		
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
