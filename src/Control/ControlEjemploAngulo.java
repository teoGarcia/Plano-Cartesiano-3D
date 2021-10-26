package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaEjemploAngulos;

public class ControlEjemploAngulo implements ActionListener, MouseListener {
	
	private VistaEjemploAngulos vea;

	public ControlEjemploAngulo(VistaEjemploAngulos vea) {
		this.vea = vea;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(vea.getBtnVerEjemplo())){
			
			vea.getPanel().setVisible(true);
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(vea.getLblSalir())){
			
			vea.setVisible(false);
			vea.getCv().getVme().setVisible(true);
			
		}else if(ev.getSource().equals(vea.getLblSiguiente())){
				
			vea.setVisible(false);
			
			//vea.getCv()
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vea.getLblSalir())){
			
			vea.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		}else if(ev.getSource().equals(vea.getLblSiguiente())){
			
			vea.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		}
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(vea.getLblSalir())){
			
			vea.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
		}else if(ev.getSource().equals(vea.getLblSiguiente())){
				
			vea.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
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
