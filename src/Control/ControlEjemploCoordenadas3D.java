package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaEjemploCoordenadas3D;

public class ControlEjemploCoordenadas3D implements ActionListener, MouseListener {
	
	private VistaEjemploCoordenadas3D vec3D;

	public ControlEjemploCoordenadas3D(VistaEjemploCoordenadas3D vec3D) {
		
		this.vec3D = vec3D;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(vec3D.getBtnVerEjemplo())){
			
			vec3D.getPanel().setVisible(true);
			
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(vec3D.getLblSalir())){
			
			vec3D.getPanel().setVisible(false);
			vec3D.setVisible(false);
			vec3D.getCv().getVme().setVisible(true);
			
			
		}else if(ev.getSource().equals(vec3D.getLblSiguiente())){
			
			vec3D.getPanel().setVisible(false);
			vec3D.setVisible(false);
			vec3D.getCv().getVep().setVisible(true);
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vec3D.getLblSalir())){
			
			vec3D.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			
		}else if(ev.getSource().equals(vec3D.getLblSiguiente())){
			
			vec3D.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		// TODO Auto-generated method stub
		if(ev.getSource().equals(vec3D.getLblSalir())){
			
			vec3D.getLblSalir().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
			
		}else if(ev.getSource().equals(vec3D.getLblSiguiente())){
			
			vec3D.getLblSiguiente().setFont(new Font("Comic Sans MS", Font.BOLD, 15));
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
