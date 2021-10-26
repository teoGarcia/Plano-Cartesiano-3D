package Control;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Usuarios;
import Vista.VistaRegistrarUsuario;

public class ControlRegistrarUsuario implements ActionListener {

	
	private Usuarios usu = new Usuarios();
	
	private VistaRegistrarUsuario vru;

	
	
	public ControlRegistrarUsuario(VistaRegistrarUsuario vru) {
		this.vru = vru;
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(vru.getBtnGuardar())){
			
				if(LLenarCampos()){
				
					String Clave= new String(vru.getPssw_Clave().getPassword());
					String ConfirClave= new String(vru.getPssw_ConfirClave().getPassword());
					
					if(Clave.equals(ConfirClave)){
					
						String password = new String(vru.getPssw_Clave().getPassword());
						int a = usu.GuardarUsuario(vru.getTxtUsuario().getText(), Clave,  vru.getTxtNombre().getText(), vru.getTextFieldApellido().getText(), ""+(vru.getComboPregunta().getSelectedIndex()+1), vru.getTxtRespuesta().getText());
							

								
							if(a>0){
								
								vru.BorrarCampos();
								JOptionPane.showMessageDialog(null, "Se ha registrado Correctamente");
								vru.getCv().getVru().setVisible(false);
								vru.getCv().getVis().setVisible(true);
								
							}
							
							
						}else {
							
							JOptionPane.showMessageDialog(null, "Las Claves no coinciden");
							
						}
					
					}
	
		
		}else if(ev.getSource().equals(vru.getBtnRegresar())){
			
			vru.getCv().getVru().setVisible(false);
			vru.getCv().getVis().setVisible(true);
			}
	
	}

	

	public boolean LLenarCampos(){
		
		if(vru.getTxtUsuario().getText().length()==0){
			
			JOptionPane.showMessageDialog(null, "Ingrese el usuario");
			
			return false;
		}
		
		
		else if(vru.getPssw_Clave().getPassword().length==0){
			
			JOptionPane.showMessageDialog(null, "Ingrese la clave");
			return false;
			
			
		}else if(vru.getPssw_ConfirClave().getPassword().length ==0){
			
			JOptionPane.showMessageDialog(null, "Confirme la clave");
			return false;
			
		}else if(vru.getTxtNombre().getText().length()==0){
			
			JOptionPane.showMessageDialog(null, "Ingrese el Nombre");
			return false;
			
		}else if(vru.getTextFieldApellido().getText().length()==0){
			
			JOptionPane.showMessageDialog(null, "Ingrese el apellido");
			return false;
	
		}else if(vru.getTxtRespuesta().getText().length()==0){
			
			JOptionPane.showMessageDialog(null, "Ingrese la respuesta");
			return false;
		}
		
		return true;
	}




}
