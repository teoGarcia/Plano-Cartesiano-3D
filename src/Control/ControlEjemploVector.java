package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaEjemploVector;

public class ControlEjemploVector implements MouseListener, ActionListener {
	
	private VistaEjemploVector vev;

	public ControlEjemploVector(VistaEjemploVector vev) {
		this.vev = vev;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(vev.getLblSalir())){
			
			vev.getPanel().setVisible(false);
			vev.setVisible(false);
			vev.getCv().getVme().setVisible(true);
		
		}else if(ev.getSource().equals(vev.getLblSiguiente())){
			
			vev.getPanel().setVisible(false);
			vev.setVisible(false);
			vev.getCv().getVevp().setVisible(true);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vev.getLblSalir())){
			vev.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		}else if(ev.getSource().equals(vev.getLblSiguiente())){
			
			vev.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		}
			
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(vev.getLblSalir())){
			vev.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		}else if(ev.getSource().equals(vev.getLblSiguiente())){
			
			vev.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
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
		
		if(ev.getSource().equals(vev.getBtnVerEjemplo())){
			
			vev.getPanel().setVisible(true);
			
		}
		// TODO Auto-generated method stub
		
	}

}
