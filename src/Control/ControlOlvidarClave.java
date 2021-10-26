package Control;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Usuarios;
import Vista.VistaOlvidarContraseña;

public class ControlOlvidarClave implements ActionListener {
	
	private VistaOlvidarContraseña voc;
	private Usuarios user = new Usuarios();

	public ControlOlvidarClave(VistaOlvidarContraseña voc) {
		this.voc = voc;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(voc.getBtnRegresar())){
			
			
			voc.getCv().getVoc().setVisible(false);
			voc.getCv().getVis().setVisible(true);
			
			
		}else if(ev.getSource().equals(voc.getBtnGenerarClave())){
			
			ResultSet rs = user.RecuperarClave(voc.getTxtUsuario().getText(), ""+(voc.getComboPregunta().getSelectedIndex()+1), voc.getTxtRespuesta().getText());
			
			try {
				if(rs.next()){
					
					voc.getTxtRecuperarClave().setText(rs.getString("ClavUsua"));
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Los datos del usuario no son correctos");
					
				}
			} catch (HeadlessException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				
				e.printStackTrace();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				
				e.printStackTrace();
			}
			
		}
		
		// TODO Auto-generated method stub
		
	}

}
