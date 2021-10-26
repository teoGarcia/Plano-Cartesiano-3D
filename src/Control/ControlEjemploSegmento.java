package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaEjemploSegmento;

public class ControlEjemploSegmento implements ActionListener, MouseListener {
	
	private VistaEjemploSegmento ves;

	public ControlEjemploSegmento(VistaEjemploSegmento ves) {
		this.ves = ves;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(ves.getBtnVerEjemplo())){
			
			ves.getPanel().setVisible(true);
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(ves.getLblSalir())){
			
			ves.getPanel().setVisible(false);
			ves.setVisible(false);
			ves.getCv().getVme().setVisible(true);
			
			
		}else if(ev.getSource().equals(ves.getLblSiguiente())){
			
			ves.getPanel().setVisible(false);
			ves.setVisible(false);
			ves.getCv().getVev().setVisible(true);
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(ves.getLblSalir())){
			
			ves.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
			
		}else if(ev.getSource().equals(ves.getLblSiguiente())){
			
			ves.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(ves.getLblSalir())){
			
			ves.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
			
		}else if(ev.getSource().equals(ves.getLblSiguiente())){
			
			ves.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
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
