package Control;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.LineArray;
import javax.media.j3d.Node;
import javax.media.j3d.PointArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.vecmath.Point3d;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.geometry.Sphere;

import Modelo.Angulo;
import Modelo.Segmento;
import Modelo.Validaciones;
import Modelo.Vector;
import Vista.VistaCoordenadas;
import Vista.Vista3D;
import Modelo.Puntos;

public class ControlCoordenadas extends Validaciones implements ActionListener, KeyListener, MouseListener {
	
	private VistaCoordenadas vc;
	private int px1 =0, py1 =0, pz1 =0, gx1 =0, gy1 =0, gz1 =0;
	private float tamaño = 1;
	private float aux = 1;
	private boolean v = true;
	
	public ControlCoordenadas(VistaCoordenadas vc) {
		this.vc = vc;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vc.getBtnAadir())){
			
					if(CamposVacios(vc.getTxtX1().getText().length()) && CamposVacios(vc.getTxtY1().getText().length()) && CamposVacios(vc.getTxtZ1().getText().length())){
							
						if(Formato(vc.getTxtX1().getText()) && Formato(vc.getTxtY1().getText()) && Formato(vc.getTxtZ1().getText())){
							
							Tamaño();
							
							
							vc.getCv().getV3d().getLsPuntos().add(new Puntos(Float.parseFloat(vc.getTxtX1().getText()), Float.parseFloat(vc.getTxtY1().getText()), Float.parseFloat(vc.getTxtZ1().getText())));
							vc.getListaPuntos().add(vc.getCv().getV3d().getLsPuntos().get(vc.getCv().getV3d().getLsPuntos().size()-1).get());
							
							
							vc.getCv().getV3d().AgregarNodos(vc.getCv().getV3d().getLsPuntos().get(vc.getCv().getV3d().getLsPuntos().size()-1).getPunto(tamaño));
							vc.getCv().getV3d().AddTree(vc.getCv().getV3d().getLsPuntos().get(vc.getCv().getV3d().getLsPuntos().size()-1).get(), 0);
						
							vc.BorrarCampos();
							
							px1=0; 
							py1=0; 
							pz1=0;
							gx1=0; 
							gy1=0; 
							gz1=0;
							
						}else{
							JOptionPane.showMessageDialog(null, "Debe Ingresar los Valores Validos \n Ejem Valido: -1.0\n Ejem Invalido: -.0");
						}
					}else{
						JOptionPane.showMessageDialog(null, "Debe Ingresar los Valores de X,Y,Z para agregar un punto");
					}
			
					
					//float segmento = px1;
			
		}else if(e.getSource().equals(vc.getBtnGenerarGrfica())){
			
			if(vc.getListaPuntos().countItems() > 0){
				
				if(v){
				
					v = true;
					
					vc.setVisible(false);
					vc.getCv().getV3d().setVisible(true);
					
				}
				
				
			}else{
				JOptionPane.showMessageDialog(null, "Debe ingresar al menos un punto");
			}
			
		}else if(e.getSource().equals(vc.getBtnRegresar())){
			
			vc.setVisible(false);
			vc.getCv().getV3d().setVisible(true);
			
		}
		
	}

	int Num ;
	double x, y, z;
	
	public ControlCoordenadas(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;	
	}
	
	
	
	

	@Override
	public void keyPressed(KeyEvent ev) {
		// TODO Auto-generated method stub
		
		
		if(ev.getSource().equals(vc.getTxtX1())){
			
			if(ev.getKeyCode() == 8 && vc.getTxtX1().getText().length() > 0){
				px1 = 0;
				gx1 = 0;
				
			}
			
		}else if(ev.getSource().equals(vc.getTxtY1())){
			
			if(ev.getKeyCode() == 8 && vc.getTxtY1().getText().length() > 0){
				py1=0;
				gy1=0;
				
			}
			
		}else if(ev.getSource().equals(vc.getTxtZ1())){
			
			if(ev.getKeyCode() == 8 && vc.getTxtZ1().getText().length()>0){
				pz1=0;
				gz1=0;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent ev) {
		
		
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent ev) {
		
		if(ev.getSource().equals(vc.getTxtX1())){
			
			
			if(!(ev.getKeyChar() == '.' && vc.getTxtX1().getText().length() == 0)){
			
				if(ev.getKeyChar() == '.'){
					px1++;
					
				}
				
				if(px1 <= 1){
					
					if(ValidarFloat(""+ev.getKeyChar())){
						ev.consume();
					}
				}else{
					
					Mensage(true);
					vc.getTxtX1().setText("");
					ev.consume();
					px1 = 0;
				}
				
			 }else{
				 ev.consume();
				 px1 = 0;
			 }
			
			if(!(ev.getKeyChar() == '-' && vc.getTxtX1().getText().length() > 0)){
				
				if(ev.getKeyChar() == '-'){
					gx1++;
					
				}
				
				if(gx1 <= 1){
					if(ValidarFloat(""+ev.getKeyChar())){
						ev.consume();
					}
				}else{
					
					Mensage(false);
					vc.getTxtX1().setText("");
					ev.consume();
					gx1 = 0;
				}
				
			}else{
				 ev.consume();
				 gx1 = 0;
			}
			
			
			
			
		  }else if(ev.getSource().equals(vc.getTxtY1())){
			  
			  if(!(ev.getKeyChar() == '.' && vc.getTxtY1().getText().length() == 0)){
				  
				  if(ev.getKeyChar() == '.'){
					  py1 ++;
					  
				  }
				  
				  if(py1 <= 1){
					  
					  if(ValidarFloat(""+ev.getKeyChar())){			
						  ev.consume();
						 
					  }
						 
					  }else{
						 
						  Mensage(true);
						  vc.getTxtY1().setText("");
						  ev.consume();
						  py1 =0;
					  }
					  
					  
				  }else{
					  
					  ev.consume();
					  py1 =0;
				  }
				  
			  if(!(ev.getKeyChar() == '-' && vc.getTxtY1().getText().length() > 0)){
					
					if(ev.getKeyChar() == '-'){
						gy1++;
						
					}
					
					if(gy1 <= 1){
						if(ValidarFloat(""+ev.getKeyChar())){
							ev.consume();
						}
					}else{
						
						Mensage(false);
						vc.getTxtX1().setText("");
						ev.consume();
						gy1 = 0;
					}
					
				}else{
					 ev.consume();
					 gy1 = 0;
				 }
			  
		  }else if(ev.getSource().equals(vc.getTxtZ1())){
			  
			  if(!(ev.getKeyChar() == '.' && vc.getTxtZ1().getText().length() == 0)){
				  
				  if(ev.getKeyChar() == '.'){
					  pz1 ++;
					  
				  }
				  if(pz1 <=1){
					  
					  if(ValidarFloat(""+ev.getKeyChar())){
						  ev.consume();
						  
					  }
					  
				  }else{
					  Mensage(true);
					  vc.getTxtZ1().setText("");
					  ev.consume();
					  pz1=0;
				  }
				  
			  }else{
				  ev.consume();
				  pz1=0;
				  
			  }
			  
			  
			  if(!(ev.getKeyChar() == '-' && vc.getTxtZ1().getText().length() > 0)){
					
					if(ev.getKeyChar() == '-'){
						gz1++;
						
					}
					
					if(gz1 <= 1){
						if(ValidarFloat(""+ev.getKeyChar())){
							ev.consume();
						}
					}else{
						
						Mensage(false);
						vc.getTxtX1().setText("");
						ev.consume();
						gz1 = 0;
					}
					
				}else{
					 ev.consume();
					 gz1 = 0;
				 }
			  
		  }
	}
	
	private void Mensage(boolean v){
		
		if(v){
			JOptionPane.showMessageDialog(null, "Solo se puede introducir un punto");
		}else{
			JOptionPane.showMessageDialog(null, "Solo se puede introducir un simbolo de menos y es al comienzo");
		}
	}

	

	@Override
	public void mouseClicked(MouseEvent ev) {
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		/*if(ev.getSource().equals(vc.getLblBorrarPuntos())){
			
			vc.getLblBorrarPuntos().setIcon(new javax.swing.ImageIcon(VistaCoordenadas.class.getResource("/Imagenes/Borrar.png")));
			
		}*/
		
	}

	@Override
	public void mouseExited(MouseEvent ev) {
		
		/*if(ev.getSource().equals(vc.getLblBorrarPuntos())){
					
				vc.getLblBorrarPuntos().setIcon(new javax.swing.ImageIcon(VistaCoordenadas.class.getResource("/Imagenes/BorrarX.png")));
		
		}*/
	
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		
	/*if(ev.getSource().equals(vc.getLblBorrarPuntos())){
			
				if(vc.getListaPuntos().getSelectedIndexes().length > -1){
					
					int[] index = vc.getListaPuntos().getSelectedIndexes();
					
					
					for(int x=index.length; x>0; x--){
						
						vc.getListaPuntos().remove(index[x-1]);
						vc.getCv().getV3d().getLsPuntos().remove(index[x-1]);
						
					}
					
				}else{
					
					JOptionPane.showMessageDialog(null, "Debe seleccionar un punto");
				}
			
			
			
		}*/
	
	}
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	public void Tamaño() {
		
		
		if(Float.parseFloat(vc.getTxtX1().getText()) > tamaño){
			
			tamaño = Float.parseFloat(vc.getTxtX1().getText());
			
		}
		
		if(Float.parseFloat(vc.getTxtY1().getText()) > tamaño){
			
			tamaño = Float.parseFloat(vc.getTxtY1().getText());
		
		}
		
		if(Float.parseFloat(vc.getTxtZ1().getText()) > tamaño){
			
			tamaño = Float.parseFloat(vc.getTxtZ1().getText());
		
		}
		
		if(tamaño > aux){
			
			aux = tamaño;
			
			vc.getCv().getV3d().RecrearEsena(tamaño);
			
		}
	
	}

	public float getAux() {
		return aux;
	}

	public void setAux(float aux) {
		this.aux = aux;
		
		
	}public VistaCoordenadas getVc() {
		return vc;
	}

	public void setVc(VistaCoordenadas vc) {
		this.vc = vc;
	}

	public float getTamaño() {
		return tamaño;
	}

	public void setTamaño(float tamaño) {
		this.tamaño = tamaño;
	}
	
	

}
