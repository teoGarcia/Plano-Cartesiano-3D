package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaEjemploVectorDePosicion;

public class ControlEjemploVectorDePosicion implements ActionListener, MouseListener {
	
	private VistaEjemploVectorDePosicion vevp;

	public ControlEjemploVectorDePosicion(VistaEjemploVectorDePosicion vevp) {
		this.vevp = vevp;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(vevp.getBtnVerEjemplo())){
			
			vevp.getPanel().setVisible(true);
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(vevp.getLblSalir())){
			
			vevp.getPanel().setVisible(false);
			vevp.setVisible(false);
			vevp.getCv().getVme().setVisible(true);
			
			
		}else if(ev.getSource().equals(vevp.getLblSiguiente())){
			
			vevp.getPanel().setVisible(false);
			vevp.setVisible(false);
			vevp.getCv().getVesv().setVisible(true);
			
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vevp.getLblSalir())){
			
			vevp.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
			
		}else if(ev.getSource().equals(vevp.getLblSiguiente())){
			
			vevp.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(vevp.getLblSalir())){
			
			vevp.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
			
		}else if(ev.getSource().equals(vevp.getLblSiguiente())){
			
			vevp.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
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
