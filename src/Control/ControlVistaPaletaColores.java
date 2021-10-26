package Control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vista.VistaPaletaColores;

public class ControlVistaPaletaColores implements MouseListener, ActionListener {
	
	private VistaPaletaColores vpc;

	public ControlVistaPaletaColores(VistaPaletaColores vpc) {
		
		this.vpc = vpc;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		if(ev.getSource().equals(vpc.getLblNegro())){
			
			vpc.getLblColorGeneral().setBackground(new Color (0,0,0));
			vpc.getLblNombreColor().setText("Negro");
			
			
		}else if(ev.getSource().equals(vpc.getLblRojo())){
			
			vpc.getLblColorGeneral().setBackground(new Color (255,0,0));
			vpc.getLblNombreColor().setText("Rojo");
			
		}else if(ev.getSource().equals(vpc.getLblVerde())){
			
			vpc.getLblColorGeneral().setBackground(new Color (0,255,0));
			vpc.getLblNombreColor().setText("Verde");
			
		}else if(ev.getSource().equals(vpc.getLblAzul())){
			
			vpc.getLblColorGeneral().setBackground(new Color (0,0,255));
			vpc.getLblNombreColor().setText("Azul");
			
		}else if(ev.getSource().equals(vpc.getLblAzulClaro())){
			
			vpc.getLblColorGeneral().setBackground(new Color (0,255,255));
			vpc.getLblNombreColor().setText("Turquesa");
			
		}else if(ev.getSource().equals(vpc.getLblPurpura())){
			
			vpc.getLblColorGeneral().setBackground(new Color (128,0,128));
			vpc.getLblNombreColor().setText("Púrpura");
			
		}else if(ev.getSource().equals(vpc.getLblAmarillo())){
			
			vpc.getLblColorGeneral().setBackground(new Color (255,255,0));
			vpc.getLblNombreColor().setText("Amarillo");
			
		}else if(ev.getSource().equals(vpc.getLblRosado())){
			
			vpc.getLblColorGeneral().setBackground(new Color (255,128,128));
			vpc.getLblNombreColor().setText("Rosado");
			
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vpc.getLblNegro())){
			
			vpc.getLblNegro().setBounds(149, 11, 30, 27);
			
			
		}else if(ev.getSource().equals(vpc.getLblRojo())){
			
			vpc.getLblRojo().setBounds(149, 55, 30, 27);
			
		}else if(ev.getSource().equals(vpc.getLblVerde())){
			
			vpc.getLblVerde().setBounds(211, 11, 30, 27);
			
		}else if(ev.getSource().equals(vpc.getLblAzul())){
			
			vpc.getLblAzul().setBounds(211, 55, 30, 27);
			
		}else if(ev.getSource().equals(vpc.getLblAzulClaro())){
			
			vpc.getLblAzulClaro().setBounds(269, 11, 30, 27);
			
		}else if(ev.getSource().equals(vpc.getLblPurpura())){
			
			vpc.getLblPurpura().setBounds(269, 55, 30, 27);
			
		}else if(ev.getSource().equals(vpc.getLblAmarillo())){
			
			vpc.getLblAmarillo().setBounds(321, 11, 30, 27);
			
		}else if(ev.getSource().equals(vpc.getLblRosado())){
			
			vpc.getLblRosado().setBounds(321, 55, 30, 27);
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(vpc.getLblNegro())){
			
			vpc.getLblNegro().setBounds(149, 11, 29, 26);
			
			
		}else if(ev.getSource().equals(vpc.getLblRojo())){
			
			vpc.getLblRojo().setBounds(149, 55, 29, 26);
			
		}else if(ev.getSource().equals(vpc.getLblVerde())){
			
			vpc.getLblVerde().setBounds(211, 11, 29, 26);
			
		}else if(ev.getSource().equals(vpc.getLblAzul())){
			
			vpc.getLblAzul().setBounds(211, 55, 29, 26);
			
		}else if(ev.getSource().equals(vpc.getLblAzulClaro())){
			
			vpc.getLblAzulClaro().setBounds(269, 11, 29, 26);
			
		}else if(ev.getSource().equals(vpc.getLblPurpura())){
			
			vpc.getLblPurpura().setBounds(269, 55, 29, 26);
			
		}else if(ev.getSource().equals(vpc.getLblAmarillo())){
			
			vpc.getLblAmarillo().setBounds(321, 11, 29, 26);
			
		}else if(ev.getSource().equals(vpc.getLblRosado())){
			
			vpc.getLblRosado().setBounds(321, 55, 29, 26);
			
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
		
		if(ev.getSource().equals(vpc.getBtnAceptar())){
			
			
		}else if(ev.getSource().equals(vpc.getBtnRegresar())){
			
			vpc.setVisible(false);
			
		}
		// TODO Auto-generated method stub
		
	}

}
