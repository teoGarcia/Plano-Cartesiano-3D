package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaEjemploPunto;

public class ControlEjemploPunto implements ActionListener, MouseListener {
	
	private VistaEjemploPunto vep;

	public ControlEjemploPunto(VistaEjemploPunto vep) {
		this.vep = vep;
	}



	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(vep.getBtnVerEjemplo())){
			
			vep.CrearEscena();
			vep.getPanel().setVisible(true);
		}
		
	}
	
	
	
	
	
	
	



	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(vep.getLblSalir())){
			
			vep.setVisible(false);
			vep.getCv().getVme().setVisible(true);
		
		}else if(ev.getSource().equals(vep.getLblSiguiente())){
			
			vep.setVisible(false);
			vep.getCv().getVes().setVisible(true);
		}
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vep.getLblSalir())){
			
			vep.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		}else if(ev.getSource().equals(vep.getLblSiguiente())){
			
			vep.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		}
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(vep.getLblSalir())){
			
			vep.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
		}else if(ev.getSource().equals(vep.getLblSiguiente())){
			
			vep.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		}
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	

}
