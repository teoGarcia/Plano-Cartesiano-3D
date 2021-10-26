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

import java.awt.SystemColor;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Control.ControlEjemploSumaVectores;
import Control.ControlVistas;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.Toolkit;

public class VistaEjemploSumaVectores extends JFrame {

	private JPanel contentPane;
	private SimpleUniverse su;
	private JButton btnVerEjemplo;
	private JPanel panel;
	private JLabel lblSalir;
	private JLabel lblSiguiente;
	private ControlVistas cv;

	public VistaEjemploSumaVectores(ControlVistas cv) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaEjemploSumaVectores.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");
		this.cv = cv;
		Contenido();
		// TODO Auto-generated constructor stub
	}


	/**
	 * Create the frame.
	 */
	public void Contenido() {
		
		ControlEjemploSumaVectores cesv = new ControlEjemploSumaVectores(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 540);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSumaDeVectores = new JLabel("Suma de Vectores");
		lblSumaDeVectores.setBounds(275, 27, 183, 32);
		lblSumaDeVectores.setForeground(SystemColor.textHighlightText);
		lblSumaDeVectores.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblSumaDeVectores);
		
		JTextPane txtpnSumavectores = new JTextPane();
		txtpnSumavectores.setEditable(false);
		txtpnSumavectores.setBounds(20, 99, 694, 115);
		txtpnSumavectores.setText("En f\u00EDsica para sumar vectores existe el M\u00E9todo gr\u00E1fico que consiste en una interpretaci\u00F3n geom\u00E9trica de la suma de vectores. Algunas de las variantes del m\u00E9todo gr\u00E1fico son: El m\u00E9todo del paralelogramo y el m\u00E9todo del pol\u00EDgono");
		txtpnSumavectores.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		contentPane.add(txtpnSumavectores);
		
		btnVerEjemplo = new JButton("Ver Ejemplo");
		btnVerEjemplo.setBounds(551, 234, 151, 32);
		btnVerEjemplo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnVerEjemplo.addActionListener(cesv);
		contentPane.add(btnVerEjemplo);
		
		panel = new JPanel();
		panel.setBounds(0, 277, 734, 172);
		panel.setLayout(new BorderLayout(0,0));
		panel.add("Center", CrearUniverso());
		panel.setVisible(false);
		contentPane.add(panel);
		
		lblSalir = new JLabel("Salir");
		lblSalir.setBounds(20, 460, 114, 42);
		lblSalir.setForeground(SystemColor.textHighlightText);
		lblSalir.setIcon(new ImageIcon(VistaEjemploSumaVectores.class.getResource("/Imagenes/X.png")));
		lblSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSalir.addMouseListener(cesv);
		contentPane.add(lblSalir);
		
		lblSiguiente = new JLabel("Siguiente");
		lblSiguiente.setBounds(578, 453, 146, 53);
		lblSiguiente.setForeground(SystemColor.textHighlightText);
		lblSiguiente.setIcon(new ImageIcon(VistaEjemploSumaVectores.class.getResource("/Imagenes/Siguientee.png")));
		lblSiguiente.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSiguiente.addMouseListener(cesv);
		contentPane.add(lblSiguiente);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaEjemploSumaVectores.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblFondo.setBounds(0, 0, 734, 512);
		contentPane.add(lblFondo);
	
		
		Escena3D();
	}
	
	
	public Component CrearUniverso(){
		
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();//Configuracion Grafica para el canvas
		Canvas3D c3d = new Canvas3D(config);

		su = new SimpleUniverse(c3d); /*Universo simple clase de conveniencia por su rama predefinida de vista*/
		su.getViewingPlatform().setNominalViewingTransform();//Configurando la Vista 
		su.getViewer().getView().setFieldOfView(1.2); //alejar el campo de vision
		
		OrbitBehavior orbit = new OrbitBehavior(c3d, OrbitBehavior.REVERSE_ROTATE | OrbitBehavior.STOP_ZOOM);
		orbit.setSchedulingBounds(new BoundingSphere()); //Permite la rotacion en la vista por medio de orbita al SimpleUniverse
		su.getViewingPlatform().setViewPlatformBehavior(orbit);//orbita
		orbit.setMinRadius(1.5);
		
		return c3d;
		
	}
	
	
	public void Escena3D(){
		
		BranchGroup bg = new BranchGroup();
		
		Ejes(bg);
		bg.compile();
		
		su.addBranchGraph(bg);
		
	}
	
	public void Ejes(BranchGroup objeto){
		
		LineArray linea = new LineArray(6, TriangleArray.COORDINATES|
                TriangleArray.COLOR_3);
		
		linea.setCoordinate(0, new Point3f(-1.0f, 0.0f, 0.0f));
		linea.setCoordinate(1, new Point3f(0.0f, 0.2f, 0.0f));
		linea.setCoordinate(2, new Point3f(0.0f, 0.2f, 0.0f));
		linea.setCoordinate(3, new Point3f(0.5f, 0.0f, 0.0f));
		linea.setCoordinate(4, new Point3f(-1.0f, 0.0f, 0.0f));
		linea.setCoordinate(5, new Point3f(0.5f, 0.0f, 0.0f));
		
		
		linea.setColor(0, new Color3f(1.0f, 0.0f, 0.0f)); // Rojo
		linea.setColor(1, new Color3f(1.0f, 0.0f, 0.0f));
		
		linea.setColor(2, new Color3f(0.0f, 1.0f, 1.0f)); // Verde
		linea.setColor(3, new Color3f(0.0f, 1.0f, 1.0f));
		
		linea.setColor(4, new Color3f(0.0f, 0.0f, 1.0f)); // azul
		linea.setColor(5, new Color3f(0.0f, 0.0f, 1.0f));
		
		Shape3D s3 = new Shape3D(linea);
		
		objeto.addChild(s3);
		
		
		
		Transform3D coneTranslationX = new Transform3D();
		TransformGroup coneTranslationGroupX;
		TransformGroup objConoX = new TransformGroup();
		
		
		Cone coneX = new Cone(0.02f, 0.07f);
		Appearance appX = new Appearance();
		//Color del cono
		ColoringAttributes caX = new ColoringAttributes((float) 1.0, (float) 0.0, (float) 0.0, ColoringAttributes.SHADE_GOURAUD);
		appX.setColoringAttributes(caX);
		coneX.setAppearance(appX);
		coneTranslationX.setTranslation(new Vector3f(0.0f, 0.197f, 0.0f));
		coneTranslationX.setRotation(new AxisAngle4d(1.0,1.0,1.0,-2.0));
		coneTranslationGroupX = new TransformGroup(coneTranslationX);
		coneTranslationGroupX.addChild(coneX);
	    objConoX.addChild(coneTranslationGroupX);
	    
		objeto.addChild(objConoX);
		
		
		
		Transform3D coneTranslationZ = new Transform3D();
		TransformGroup coneTranslationGroupZ;
		TransformGroup objConoZ = new TransformGroup();
		
		
		Cone coneZ = new Cone(0.02f, 0.07f);
		Appearance appZ = new Appearance();
		//Color del cono
		ColoringAttributes caZ = new ColoringAttributes((float) 0.0, (float) 1.0, (float) 0.0, ColoringAttributes.SHADE_GOURAUD);
		appZ.setColoringAttributes(caZ);
		coneZ.setAppearance(appZ);
		coneTranslationZ.setTranslation(new Vector3f(0.46f, 0.02f, 0.f));
		coneTranslationZ.setRotation(new AxisAngle4d(0.0,0.0,1.0,-2.0));
		coneTranslationGroupZ = new TransformGroup(coneTranslationZ);
		coneTranslationGroupZ.addChild(coneZ);
	    objConoZ.addChild(coneTranslationGroupZ);
		objeto.addChild(objConoZ);
		
		
		Transform3D coneTranslation = new Transform3D();
		TransformGroup coneTranslationGroup;
		TransformGroup objCono= new TransformGroup();
		
		
		Cone cone = new Cone(0.02f, 0.07f);
		Appearance app = new Appearance();
		//Color del cono
		ColoringAttributes ca = new ColoringAttributes((float) 0.0, (float) 0.0, (float) 1.0, ColoringAttributes.SHADE_GOURAUD);
		app.setColoringAttributes(ca);
		cone.setAppearance(app);
		coneTranslation.setTranslation(new Vector3f(0.46f, 0.0f, 0.f));
		coneTranslation.setRotation(new AxisAngle4d(1.0,1.0,1.0,-2.0));
		coneTranslationGroup = new TransformGroup(coneTranslation);
		coneTranslationGroup.addChild(cone);
	    objCono.addChild(coneTranslationGroup);
	    
		objeto.addChild(objCono);
		
		
		
		TransformGroup textTranslationGroupX;
		Transform3D textTranslationX;
		TransformGroup objScaleX = new TransformGroup();
		
		Shape3D textoX = new Text2D("Vector A",  new Color3f(1.0f, 1.0f, 1.0f), "Serif", 18, Font.BOLD);
		Appearance apptextoX = textoX.getAppearance();
		apptextoX.setPolygonAttributes(DobleLetras());
		
		textTranslationX = new Transform3D();
	    textTranslationX.setTranslation(new Vector3f(-0.8f, 0.14f, 0.0f));
	    textTranslationGroupX = new TransformGroup(textTranslationX);
	    textTranslationGroupX.addChild(textoX);
	    objScaleX.addChild(textTranslationGroupX);
		objeto.addChild(objScaleX);
		
		TransformGroup textTranslationGroupY;
		Transform3D textTranslationY;
		TransformGroup objScaleY = new TransformGroup();
		
		Shape3D textoY = new Text2D("Vector B",  new Color3f(1.0f, 1.0f, 1.0f), "Serif", 18, Font.BOLD);
		Appearance apptextoY = textoY.getAppearance();
		apptextoY.setPolygonAttributes(DobleLetras());
		
		textTranslationY = new Transform3D();
	    textTranslationY.setTranslation(new Vector3f(0.2f, 0.14f, 0.0f));
	    textTranslationGroupY = new TransformGroup(textTranslationY);
	    textTranslationGroupY.addChild(textoY);
	    objScaleY.addChild(textTranslationGroupY);
		objeto.addChild(objScaleY);
		
		
		
		TransformGroup textTranslationGroupZ;
		Transform3D textTranslationZ;
		TransformGroup objScaleZ = new TransformGroup();
		
		Shape3D textoZ = new Text2D("Vector C",  new Color3f(1.0f, 1.0f, 1.0f), "Serif", 18, Font.BOLD);
		Appearance apptextoZ = textoZ.getAppearance();
		apptextoZ.setPolygonAttributes(DobleLetras());
		
		textTranslationZ = new Transform3D();
	    textTranslationZ.setTranslation(new Vector3f(-0.3f, -0.08f, 0.0f));
	    textTranslationGroupZ = new TransformGroup(textTranslationZ);
	    textTranslationGroupZ.addChild(textoZ);
	    objScaleZ.addChild(textTranslationGroupZ);
		objeto.addChild(objScaleZ);
		
		
		
		TransformGroup textTranslationGroup;
		Transform3D textTranslation;
		TransformGroup objScale = new TransformGroup();
		
		Shape3D texto = new Text2D("A+B = C",  new Color3f(1.0f, 1.0f, 1.0f), "Serif", 18, Font.BOLD);
		Appearance apptexto = texto.getAppearance();
		apptexto.setPolygonAttributes(DobleLetras());
		
		textTranslation = new Transform3D();
	    textTranslation.setTranslation(new Vector3f(0.7f, 0.0f, 0.0f));
	    textTranslationGroup = new TransformGroup(textTranslation);
	    textTranslationGroup.addChild(texto);
	    objScale.addChild(textTranslationGroup);
		objeto.addChild(objScale);
		
		
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
