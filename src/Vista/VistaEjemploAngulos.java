package Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.LineArray;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Control.ControlEjemploAngulo;
import Control.ControlVistas;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.universe.SimpleUniverse;

import java.awt.SystemColor;
import java.awt.Toolkit;

public class VistaEjemploAngulos extends JFrame {

	private JPanel contentPane;
	private SimpleUniverse su;
	private ControlVistas cv;
	private JButton btnVerEjemplo;
	private JPanel panel;
	private JLabel lblSalir;
	private JLabel lblSiguiente;

	public VistaEjemploAngulos(ControlVistas cv) {
		setResizable(false);
		this.setCv(cv);
		Contenido();
		// TODO Auto-generated constructor stub
	}




	/**
	 * Create the frame.
	 */
	public void Contenido() {
		
		ControlEjemploAngulo cea = new ControlEjemploAngulo(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaEjemploAngulos.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblAnguloEntreDos = new JLabel("Angulo entre dos Vectores");
		lblAnguloEntreDos.setForeground(SystemColor.textHighlightText);
		lblAnguloEntreDos.setBounds(237, 27, 259, 32);
		lblAnguloEntreDos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblAnguloEntreDos);
		
		JTextPane txtpnAngulo = new JTextPane();
		txtpnAngulo.setEditable(false);
		txtpnAngulo.setText("El ángulo que forman dos rectas en el espacio, viene dado por el ángulo que forman sus vectores de dirección. Su cálculo es sencillo a partir del producto escalar");
		txtpnAngulo.setBounds(20, 99, 694, 115);
		txtpnAngulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		contentPane.add(txtpnAngulo);
		
		btnVerEjemplo = new JButton("Ver Ejemplo");
		btnVerEjemplo.setBounds(551, 234, 151, 32);
		btnVerEjemplo.addActionListener(cea);
		btnVerEjemplo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(btnVerEjemplo);
		
		panel = new JPanel();
		panel.setBounds(0, 277, 734, 172);
		panel.setLayout(new BorderLayout(0,0));
		panel.add("Center", CrearUniverso());
		panel.setVisible(false);
		contentPane.add(panel);
		
		lblSalir = new JLabel("Salir");
		lblSalir.setForeground(SystemColor.textHighlightText);
		lblSalir.setIcon(new ImageIcon(VistaEjemploAngulos.class.getResource("/Imagenes/X.png")));
		lblSalir.setBounds(20, 460, 114, 42);
		lblSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSalir.addMouseListener(cea);
		contentPane.add(lblSalir);
		
		lblSiguiente = new JLabel("Siguiente");
		lblSiguiente.setForeground(SystemColor.textHighlightText);
		lblSiguiente.setIcon(new ImageIcon(VistaEjemploAngulos.class.getResource("/Imagenes/Siguientee.png")));
		lblSiguiente.setBounds(578, 453, 146, 53);
		lblSiguiente.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSiguiente.addMouseListener(cea);
		contentPane.add(lblSiguiente);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaEjemploAngulos.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblFondo.setBounds(0, 0, 734, 512);
		contentPane.add(lblFondo);
	}
	
	
	
	
	public Component CrearUniverso(){
		
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();//Configuracion Grafica para el canvas
		Canvas3D c3d = new Canvas3D(config);

		su = new SimpleUniverse(c3d); /*Universo simple clase de conveniencia por su rama predefinida de vista*/
		su.getViewingPlatform().setNominalViewingTransform();//Configurando la Vista 
		su.getViewer().getView().setFieldOfView(1.6); //alejar el campo de vision
		
		OrbitBehavior orbit = new OrbitBehavior(c3d, OrbitBehavior.REVERSE_ROTATE | OrbitBehavior.STOP_ZOOM);
		orbit.setSchedulingBounds(new BoundingSphere()); //Permite la rotacion en la vista por medio de orbita al SimpleUniverse
		su.getViewingPlatform().setViewPlatformBehavior(orbit);//orbita
		orbit.setMinRadius(1.5);
		
		Escena3D();
		
		return c3d;
		
	}
	
	public void Escena3D(){
		
		BranchGroup bg = new BranchGroup();
		
		Vectores(bg);
		
		bg.compile();
		
		su.addBranchGraph(bg);
		
	}
	
	
	public void Vectores(BranchGroup objVectores){
	
		
		LineArray linea = new LineArray(4, TriangleArray.COORDINATES|
                TriangleArray.COLOR_3);
		
		linea.setCoordinate(0, new Point3f(-0.4f, 0.0f, 0.0f));
		linea.setCoordinate(1, new Point3f(0.5f, 0.5f, 0.0f));
		
		linea.setCoordinate(2, new Point3f(-0.4f, 0.0f, 0.0f));
		linea.setCoordinate(3, new Point3f(0.5f, -0.5f, 0.0f));

		linea.setColor(0, new Color3f(1.0f, 0.0f, 0.0f)); // Rojo
		linea.setColor(1, new Color3f(1.0f, 0.0f, 0.0f));
		
		linea.setColor(2, new Color3f(0.0f, 1.0f, 0.0f)); // Verde
		linea.setColor(3, new Color3f(0.0f, 1.0f, 0.0f));
		 
		
		Shape3D forma = new Shape3D(linea);
		
		objVectores.addChild(forma);
		
		
		
		Transform3D coneTranslation = new Transform3D();
		TransformGroup coneTranslationGroup;
		TransformGroup objCono = new TransformGroup();
		
		
		Cone cone = new Cone(0.02f, 0.07f);
		Appearance app = new Appearance();
		//Color del cono
		ColoringAttributes ca = new ColoringAttributes((float) 1.0, (float) 0.0, (float) 0.0, ColoringAttributes.SHADE_GOURAUD);
		app.setColoringAttributes(ca);
		cone.setAppearance(app);
		coneTranslation.setTranslation(new Vector3f(0.48f, 0.49f, 0.0f));
		coneTranslation.setRotation(new AxisAngle4d(1.0,1.0,1.0,-1.38));
		coneTranslationGroup = new TransformGroup(coneTranslation);
		coneTranslationGroup.addChild(cone);
	    objCono.addChild(coneTranslationGroup);
		objVectores.addChild(objCono);
		
		
		Transform3D coneTranslation1 = new Transform3D();
		TransformGroup coneTranslationGroup1;
		TransformGroup objCono1 = new TransformGroup();
		
		
		Cone cone1 = new Cone(0.02f, 0.07f);
		Appearance app1 = new Appearance();
		//Color del cono
		ColoringAttributes ca1 = new ColoringAttributes((float) 0.0, (float) 1.0, (float) 0.0, ColoringAttributes.SHADE_GOURAUD);
		app1.setColoringAttributes(ca1);
		cone1.setAppearance(app1);
		coneTranslation1.setTranslation(new Vector3f(0.48f, -0.495f, 0.0f));
		coneTranslation1.setRotation(new AxisAngle4d(2.0,1.0,0.0,-3.0));
		coneTranslationGroup1 = new TransformGroup(coneTranslation1);
		coneTranslationGroup1.addChild(cone1);
	    objCono1.addChild(coneTranslationGroup1);
	    
	    
		objVectores.addChild(objCono1);
		
		
		
		TransformGroup textTranslationGroupZ;
		Transform3D textTranslationZ;
		TransformGroup objScaleZ = new TransformGroup();
		
		Shape3D textoZ = new Text2D("α = 45°",  new Color3f(1.0f, 0.0f, 1.0f), "Serif", 30, Font.BOLD);
		Appearance apptextoZ = textoZ.getAppearance();
		apptextoZ.setPolygonAttributes(DobleLetras());
		
		textTranslationZ = new Transform3D();
	    textTranslationZ.setTranslation(new Vector3f(-0.25f, -0.05f, 0.0f));
	    textTranslationGroupZ = new TransformGroup(textTranslationZ);
	    textTranslationGroupZ.addChild(textoZ);
	    objScaleZ.addChild(textTranslationGroupZ);
		objVectores.addChild(objScaleZ);
		
	}
	
	
	public PolygonAttributes DobleLetras(){
		
		Appearance app = new Appearance();
		
		PolygonAttributes pa = app.getPolygonAttributes();
	    if (pa == null)
	      pa = new PolygonAttributes();
	    pa.setCullFace(PolygonAttributes.CULL_NONE);
	    if (app.getPolygonAttributes() == null)
	      app.setPolygonAttributes(pa);
	    
	    return pa;
		
	}




	public JButton getBtnVerEjemplo() {
		return btnVerEjemplo;
	}




	public void setBtnVerEjemplo(JButton btnVerEjemplo) {
		this.btnVerEjemplo = btnVerEjemplo;
	}




	public JPanel getPanel() {
		return panel;
	}




	public void setPanel(JPanel panel) {
		this.panel = panel;
	}




	public JLabel getLblSalir() {
		return lblSalir;
	}




	public void setLblSalir(JLabel lblSalir) {
		this.lblSalir = lblSalir;
	}




	public JLabel getLblSiguiente() {
		return lblSiguiente;
	}




	public void setLblSiguiente(JLabel lblSiguiente) {
		this.lblSiguiente = lblSiguiente;
	}




	public ControlVistas getCv() {
		return cv;
	}




	public void setCv(ControlVistas cv) {
		this.cv = cv;
	}
}
