package Control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.media.j3d.Node;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.TreePath;

import com.sun.j3d.utils.applet.MainFrame;

import Modelo.Angulo;
import Modelo.Puntos;
import Modelo.RestarVectores;
import Modelo.Segmento;
import Modelo.SumarVectores;
import Modelo.Vector;
import Vista.Vista3D;
import Vista.VistaCoordenadas;


public class ControlVista3D implements ActionListener, MouseListener, TreeExpansionListener {
	
	private Vista3D V3D;
	private Segmento seg;
	private Color color;

	public ControlVista3D(Vista3D V3D) {
		this.V3D = V3D;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		
		if(ev.getSource().equals(V3D.getMntmAgregarPunto())){
			
			V3D.setVisible(false);
			V3D.getCv().getVc().setVisible(true);
		
		}else if(ev.getSource().equals(V3D.getMntmSalir())){
			
			V3D.setVisible(false);
			V3D.getCv().getVm().setVisible(true);
			
		}else if(ev.getSource().equals(V3D.getMntmTutorial())){
			

			String direccion = "https://www.youtube.com/watch?v=foXhmoILrAU";
			
			Runtime aplicacion = Runtime.getRuntime(); 
	        try{aplicacion.exec("\"C:\\Program Files\\Internet Explorer\\IEXPLORE.EXE\" " + direccion); }
	        
	        catch(Exception e){
	        	
	        	JOptionPane.showMessageDialog(null, "No Posee Navegador Internet Explorer");
	        }
	        
	        
		}else if(ev.getSource().equals(V3D.getMntmCrearSegmento())){
			
			if(V3D.getTree().getSelectionRows().length==2){
				
			int[] a = V3D.getTree().getSelectionRows();
			
			V3D.getLsSegmento().add(new Segmento(V3D.getLsPuntos().get(getIndexPuntos(a[0])), V3D.getLsPuntos().get(getIndexPuntos(a[1]))));
			V3D.AgregarNodos(V3D.getLsSegmento().get(V3D.getLsSegmento().size()-1).ListarLinea(V3D.getCv().getVc().getCc().getTamaño()));
			V3D.AddTree(V3D.getLsSegmento().get(V3D.getLsSegmento().size()-1).get(), 1);
			
			
			}else{
				
			JOptionPane.showMessageDialog(null,"Debe seleccionar 2 Puntos");
				
			}
			
			
		}else if(ev.getSource().equals(V3D.getMntmCrearVector())){
			
			if(V3D.getTree().getSelectionRows().length==2){
				
				int[] a = V3D.getTree().getSelectionRows();
				
				V3D.getLsVector().add(new Vector(V3D.getLsPuntos().get(getIndexPuntos(a[0])), V3D.getLsPuntos().get(getIndexPuntos(a[1]))));
				V3D.AgregarNodos(V3D.getLsVector().get(V3D.getLsVector().size()-1).CrearVector(V3D.getCv().getVc().getCc().getTamaño()));
				V3D.AgregarNodos(V3D.getLsVector().get(V3D.getLsVector().size()-1).CrearCono(V3D.getCv().getVc().getCc().getTamaño()));
				V3D.AddTree(V3D.getLsVector().get(V3D.getLsVector().size()-1).get(), 2);
			}else{
				
			JOptionPane.showMessageDialog(null,"Debe seleccionar 2 Puntos");
				
			}
			
			
		}else if(ev.getSource().equals(V3D.getMntmCrearAngulo())){
			
			if(V3D.getTree().getSelectionRows().length==2){
			
			V3D.getLsAngulo().add(new Angulo(V3D.getLsVector().get(getIndexVector(V3D.getTree().getMinSelectionRow())), V3D.getLsVector().get(getIndexVector(V3D.getTree().getMaxSelectionRow()))));
			V3D.AgregarNodos(V3D.getLsAngulo().get(V3D.getLsAngulo().size()-1).CrearAngulo()/*(V3D.getCv().getVc().getCc().getTamaño())*/);
			V3D.AddTree(V3D.getLsAngulo().get(V3D.getLsAngulo().size()-1).get(), 3);
			
			}else{
				
			JOptionPane.showMessageDialog(null,"Debe seleccionar 2 Vectores o Segmentos");
				
			}
		
		}else if(ev.getSource().equals(V3D.getMntmSumarVector())){
			
			if(V3D.getTree().getSelectionRows().length==2){
			
			V3D.getLsSumarVectores().add(new SumarVectores(V3D.getLsVector().get(getIndexVector(V3D.getTree().getMinSelectionRow())), V3D.getLsVector().get(getIndexVector(V3D.getTree().getMaxSelectionRow()))));
			V3D.AgregarNodos(V3D.getLsSumarVectores().get(V3D.getLsSumarVectores().size()-1).SumarVectores(V3D.getCv().getVc().getCc().getTamaño()));
			V3D.AddTree(V3D.getLsSumarVectores().get(V3D.getLsSumarVectores().size()-1).get(), 2);
			
			}else{
				
			JOptionPane.showMessageDialog(null,"Debe seleccionar 2 Vectores");
				
			}
			
		}else if(ev.getSource().equals(V3D.getMntmRestarVectores())){
			
			if(V3D.getTree().getSelectionRows().length==2){
			
			V3D.getLsRestarVectores().add(new RestarVectores(V3D.getLsVector().get(getIndexVector(V3D.getTree().getMinSelectionRow())), V3D.getLsVector().get(getIndexVector(V3D.getTree().getMaxSelectionRow()))));
			V3D.AgregarNodos(V3D.getLsRestarVectores().get(V3D.getLsRestarVectores().size()-1).RestarVectores(V3D.getCv().getVc().getCc().getTamaño()));
			V3D.AddTree(V3D.getLsRestarVectores().get(V3D.getLsRestarVectores().size()-1).get(), 2);
			
			}else{
				
				JOptionPane.showMessageDialog(null,"Debe seleccionar 2 Vectores");
					
			}
		}else if(ev.getSource().equals(V3D.getMntmCambiarColor())){
			
			
			V3D.getCv().getVpcolores().setVisible(true);
			
			
		}else if(ev.getSource().equals(V3D.getMntmBorrar())){
				
			if(V3D.getTree().getSelectionRows().length==1){
			
				if(V3D.getTree().getSelectionCount() > 0){
				
				V3D.OpcionesDeBorrado(V3D.getTree().getSelectionRows()[0]);
			
				}else{
				
				V3D.OpcionesDeBorrado(0);
				
				}
			}else{
				
				JOptionPane.showMessageDialog(null,"Debe seleccionar 1 elemento para se borrado");
				
			}
		}
		
		
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		//System.out.println(arg0.getPoint());
		
		
	}

	@Override
	public void mouseEntered(MouseEvent ev) {
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		
		if(ev.getButton() == 3){
		
		if(ev.getSource().equals(V3D.getTree())){
			
			
			if(V3D.getTree().getSelectionCount() > 0){
				
				
				V3D.OpcionesDeMenu(V3D.getTree().getSelectionRows()[0]);
				
			}else{
				
				V3D.OpcionesDeMenu(0);
				
			}
						
		}
		}
	
		
	}
	
	


	@Override
	public void mouseReleased(MouseEvent arg0) {	
		
	}

	public Segmento getSeg() {
		return seg;
	}

	public void setSeg(Segmento seg) {
		this.seg = seg;
	}
	
	
	public int getIndexPuntos(int index){
	
		return index-2;
		
	}
	
	public int getIndexSegemnto(int index){
		
		return index-3-(V3D.getLsPuntos().size());
		
	}
	
	public int getIndexVector(int index){
		
		return index-4-(V3D.getLsPuntos().size())-(V3D.getLsSegmento().size());
		
	}
	
	public int getIndexAngulo(int index){
		
		return index-5-(V3D.getLsPuntos().size())-(V3D.getLsSegmento().size())-(V3D.getLsVector().size());
		
		
	}

	@Override
	public void treeCollapsed(TreeExpansionEvent ev) {
		
		V3D.getTree().expandPath(ev.getPath());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void treeExpanded(TreeExpansionEvent ev) {
	
		
		// TODO Auto-generated method stub
		
	}
}
