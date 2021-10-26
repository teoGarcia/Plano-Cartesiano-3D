package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaEjemploSumaVectores;

public class ControlEjemploSumaVectores implements MouseListener, ActionListener {
	
	
	private VistaEjemploSumaVectores vesv;

	public ControlEjemploSumaVectores(VistaEjemploSumaVectores vesv) {
		this.vesv = vesv;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(vesv.getLblSalir())){
			
			
			vesv.getPanel().setVisible(false);
			vesv.setVisible(false);
			vesv.getCv().getVme().setVisible(true);
			
		}else if(ev.getSource().equals(vesv.getLblSiguiente())){
			
			vesv.getPanel().setVisible(false);
			vesv.setVisible(false);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vesv.getLblSalir())){
			
			vesv.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		}else if(ev.getSource().equals(vesv.getLblSiguiente())){
			
			vesv.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(vesv.getLblSalir())){
			
			vesv.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
		}else if(ev.getSource().equals(vesv.getLblSiguiente())){
			
			vesv.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			vesv.getCv().getVea().setVisible(true);
			
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

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		
		if(ev.getSource().equals(vesv.getBtnVerEjemplo())){
			
			vesv.getPanel().setVisible(true);
		}
			
			
		
		// TODO Auto-generated method stub
		
	}

}
