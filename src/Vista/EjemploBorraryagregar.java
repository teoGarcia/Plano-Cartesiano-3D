package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.colorchooser.ColorChooserComponentFactory;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class EjemploBorraryagregar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploBorraryagregar frame = new EjemploBorraryagregar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	 private BranchGroup scene=new BranchGroup();
	 private BranchGroup content=new BranchGroup();;
	   
	 private JButton addBtn=new JButton("Add");
	 private JButton removeBtn=new JButton("Remove");
	private Sphere s;
	private Appearance app;
	private ColoringAttributes ColorEsfera;
	
	  
	public EjemploBorraryagregar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		    Canvas3D canvas3D = new Canvas3D(config);
		 
		    content.addChild(new ColorCube(0.4));
		    // Set the Capabilities that is need by adding and removing
		    // the Cube
		    scene.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
		    scene.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
		    scene.setCapability(BranchGroup.ALLOW_DETACH);
		    content.setCapability(BranchGroup.ALLOW_DETACH);
		     
		    // Compile the scene
		    scene.compile();
		 
		    SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
		 
		    simpleU.getViewingPlatform().setNominalViewingTransform();
		 
		    simpleU.addBranchGraph(scene);
		     
		    getContentPane().add(canvas3D,BorderLayout.CENTER);
		     
		    // Initialize GUI 
		    addBtn.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        scene.addChild(content);
		        addBtn.setEnabled(false);
		        removeBtn.setEnabled(true);
		      }
		       
		    });
		    removeBtn.setEnabled(false);
		    removeBtn.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent arg0) {
		        scene.removeChild(content);
		        removeBtn.setEnabled(false);
		        addBtn.setEnabled(true);
		      }
		       
		    });
		    JPanel panel=new JPanel();
		    panel.add(addBtn);
		    panel.add(removeBtn);
		    getContentPane().add(panel,BorderLayout.SOUTH);
		    
		    JButton btnPrueba = new JButton("prueba");
		    panel.add(btnPrueba);
		    btnPrueba.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0) {
				        PruebaDeAgregar();
				      }
				       
				    });
		    
		    JButton btnPunto = new JButton("punto");
		    panel.add(btnPunto);
		    btnPunto.addActionListener(new ActionListener(){
			      public void actionPerformed(ActionEvent arg0) {
				        Agregar();
				      }
				       
				    });
		    
		    
		    
		   JButton ColorBtn = new JButton("Cambiar Color");
		   panel.add(ColorBtn);
		   ColorBtn.addActionListener(new ActionListener() {
			   
			   
			   private Color color;

			public void actionPerformed(ActionEvent arg0) {

				   System.out.println("cambia color ");
				   ColorEsfera = new ColoringAttributes(1.0f, 0.0f, 0.0f, ColoringAttributes.SHADE_GOURAUD);
				   app.setColoringAttributes(ColorEsfera);
				  /* JColorChooser jcc = new JColorChooser();
				   color = jcc.showDialog(null, "Seleccione un Color", Color.gray);
				   ColorEsfera = new ColoringAttributes(1.0f,0f,0f, ColoringAttributes.SHADE_GOURAUD);
				   */
			}
		});
		  }
	

	    public void PruebaDeAgregar(){
	    	
	    	content=new BranchGroup();
	    	content.setCapability(BranchGroup.ALLOW_DETACH);
	    
	    	s = new Sphere(0.1f);
	    	app = new Appearance();
			ColorEsfera = new ColoringAttributes(2.6F,  0.6F,  0.6f, ColoringAttributes.SHADE_GOURAUD);
			app.setColoringAttributes(ColorEsfera);
			s.setAppearance(app);
			
			content.addChild(s);
			
			
	    }

	    
	    public void Agregar(){
			
			content.addChild(new Cone(0.5f,1f));
	    	
	    }
}
