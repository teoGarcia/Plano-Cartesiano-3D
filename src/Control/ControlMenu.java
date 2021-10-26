package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaMenu;

public class ControlMenu implements ActionListener, MouseListener {

	
	private VistaMenu vm;
	private float tamaño = 10;
	
	
	
	public ControlMenu(VistaMenu vm) {
		this.vm = vm;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(vm.getBtnGrficar())){
			
			vm.setVisible(false);
			vm.getCv().getV3d().setVisible(true);
			vm.getCv().getV3d().FondoEscena();//setVisible(true);
		
		}else if(ev.getSource().equals(vm.getBtnEjemplos())){
			
			vm.setVisible(false);
			vm.getCv().getVme().setVisible(true);
			
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(vm.getLblCerrarSesion())){
			
			vm.setVisible(false);
			vm.getCv().getVis().setVisible(true);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vm.getLblCerrarSesion())){
			
			vm.getLblCerrarSesion().setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(vm.getLblCerrarSesion())){
			
			vm.getLblCerrarSesion().setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
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
