package Control;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;




import Modelo.Usuarios;
import Vista.VistaInicioSesion;

public class ControlVistaSesion implements MouseListener, ActionListener, KeyListener {
	
	private VistaInicioSesion vis;
	private Usuarios usu = new Usuarios();
	
	public ControlVistaSesion(VistaInicioSesion vis) {
		this.vis = vis;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		if(ev.getSource().equals(vis.getLblHazOlvidado())){
			
			vis.getLblHazOlvidado().setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
			
			
		}else if(ev.getSource().equals(vis.getLblRegistrate())){
			
			vis.getLblRegistrate().setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		if(ev.getSource().equals(vis.getLblHazOlvidado())){
			
			
			vis.getLblHazOlvidado().setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
			
		}else if(ev.getSource().equals(vis.getLblRegistrate())){
			
			vis.getLblRegistrate().setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		
		if(ev.getSource().equals(vis.getLblRegistrate())){
			
			vis.getCv().getVis().setVisible(false);
			vis.getCv().getVru().setVisible(true);
			
		}
		
		else if(ev.getSource().equals(vis.getLblHazOlvidado())){
			
			vis.getCv().getVis().setVisible(false);
			vis.getCv().getVoc().setVisible(true);
			
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		
		
		if(ev.getSource().equals(vis.getBtnIngresar())){
				
			Ingresar();
		}
	}
	
	
	
	public void Ingresar(){
		
		if(CamposVacios()){
			
			try {
			
				String password = new String(vis.getPasswordField().getPassword());
				
				ResultSet rs =	usu.Login(vis.getTxtUsuario().getText(), password);
			
				if(rs.next()){
					
					JOptionPane.showMessageDialog(null, "Bienvenido  "+vis.getTxtUsuario().getText());
					vis.getTxtUsuario().setText("");
					vis.getPasswordField().setText("");
					vis.getCv().getVis().setVisible(false);
					vis.getCv().getVm().setVisible(true);
					vis.getCv().getVm().getLblCerrarSesion().setText(rs.getString("NombUsua")+" "+rs.getString("ApelUsua"));
					
				}else{
				
					JOptionPane.showMessageDialog(null, "Usuario o Clave Invalida");
					vis.getTxtUsuario().setText("");
					vis.getPasswordField().setText("");
				}

			}catch (SQLException ex) {
			
				JOptionPane.showMessageDialog(null, "Usuario"+ex.getMessage());
			}
		}
		
		
	}
	
	public Boolean CamposVacios(){
		
		if(vis.getTxtUsuario().getText().length()==0){
			JOptionPane.showMessageDialog(null, "Ingrese el Usuario");
			return false;
			
		}else if(vis.getPasswordField().getPassword().length==0){
			JOptionPane.showMessageDialog(null, "Ingrese la Clave");
			return false;
		}
		
		return true;
		
	}

	@Override
	public void keyPressed(KeyEvent ev) {
		
		if(ev.getKeyCode()== KeyEvent.VK_ENTER){
			
			Ingresar();
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
