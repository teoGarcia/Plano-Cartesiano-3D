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

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.universe.SimpleUniverse;

import Control.ControlEjemploVector;
import Control.ControlVistas;

import java.awt.SystemColor;
import java.awt.Toolkit;

public class VistaEjemploVector extends JFrame {

	private JPanel contentPane;
	private JLabel lblSalir;
	private JLabel lblSiguiente;
	private JPanel panel;
	private SimpleUniverse su;
	private JButton btnVerEjemplo;
	private ControlVistas cv;

	public VistaEjemploVector(ControlVistas cv) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaEjemploVector.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");
		this.setCv(cv);
		Contenido();
		// TODO Auto-generated constructor stub
	}


	/**
	 * Create the frame.
	 */
	public void Contenido() {
		
		ControlEjemploVector cev = new ControlEjemploVector(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVectoresEnEl = new JLabel("Vectores en el espacio tridimensional");
		lblVectoresEnEl.setForeground(SystemColor.textHighlightText);
		lblVectoresEnEl.setBounds(183, 27, 367, 32);
		lblVectoresEnEl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		contentPane.add(lblVectoresEnEl);
		
		JTextPane txtpnVectores = new JTextPane();
		txtpnVectores.setEditable(false);
		txtpnVectores.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtpnVectores.setText("En f\u00EDsica, un vector se utiliza para describir magnitudes tales como velocidades, aceleraciones o fuerzas. Un vector libre, puede ser caracterizado por un segmento orientado en el espacio y contiene: Un origen; que da el comienzo al vector cuando sea necesario, una direcci\u00F3n; coincidente con la de la recta que la contiene cualquier otra recta paralela, un sentido; Que viene determinado por la punta de flecha localizada en el extremo del vector.");
		txtpnVectores.setBounds(20, 99, 694, 115);
		contentPane.add(txtpnVectores);
		
		btnVerEjemplo = new JButton("Ver Ejemplo");
		btnVerEjemplo.setBounds(551, 234, 151, 32);
		btnVerEjemplo.addActionListener(cev);
		btnVerEjemplo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		contentPane.add(btnVerEjemplo);
		
		panel = new JPanel();
		panel.setBounds(0, 277, 734, 172);
		panel.setVisible(false);
		panel.setLayout(new BorderLayout(0,0));
		panel.add("Center", CrearUniverso());
		contentPane.add(panel);
		
		lblSalir = new JLabel("Salir");
		lblSalir.setForeground(SystemColor.textHighlightText);
		lblSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSalir.setIcon(new ImageIcon(VistaEjemploVector.class.getResource("/Imagenes/X.png")));
		lblSalir.setBounds(20, 460, 114, 42);
		lblSalir.addMouseListener(cev);
		contentPane.add(lblSalir);
		
		lblSiguiente = new JLabel("Siguiente");
		lblSiguiente.setForeground(SystemColor.textHighlightText);
		lblSiguiente.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSiguiente.setIcon(new ImageIcon(VistaEjemploVector.class.getResource("/Imagenes/Siguientee.png")));
		lblSiguiente.setBounds(578, 453, 146, 53);
		lblSiguiente.addMouseListener(cev);
		contentPane.add(lblSiguiente);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaEjemploVector.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblFondo.setBounds(0, 0, 734, 512);
		contentPane.add(lblFondo);
		
		Escena3D();
		
	}
	
	
	public void Escena3D(){
		
		BranchGroup Escena = new BranchGroup();
		
		Vector(Escena);
		Escena.compile();
		su.addBranchGraph(Escena);
		
	}
	
	
	public Component CrearUniverso(){
		
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();//Configuracion Grafica para el canvas
		Canvas3D c3d = new Canvas3D(config); // Setlayout y add vienen de la clase applet

		su = new SimpleUniverse(c3d); /*Universo simple clase de conveniencia por su rama predefinida de vista*/
		su.getViewingPlatform().setNominalViewingTransform();//Configurando la Vista 
		su.getViewer().getView().setFieldOfView(1.2); //alejar el campo de vision
		
		OrbitBehavior orbit = new OrbitBehavior(c3d, OrbitBehavior.REVERSE_ROTATE | OrbitBehavior.STOP_ZOOM);
		orbit.setSchedulingBounds(new BoundingSphere()); //Permite la rotacion en la vista por medio de orbita al SimpleUniverse
		su.getViewingPlatform().setViewPlatformBehavior(orbit);//orbita
		orbit.setMinRadius(1.5);
		
		return c3d;
		
	}
	
	
	public void Vector(BranchGroup objeto){
		
		LineArray linea = new LineArray(2, TriangleArray.COORDINATES|
                TriangleArray.COLOR_3);
		 
		 
		linea.setCoordinate(0, new Point3f(-1.0f, 0.0f, 0.0f));
		linea.setCoordinate(1, new Point3f(1.0f, 0.0f, 0.0f));
	
		linea.setColor(0, new Color3f(1.0f, 1.0f, 1.0f));
		linea.setColor(1, new Color3f(1.0f, 1.0f, 1.0f));
		
		Shape3D s3 = new Shape3D(linea);
		
		objeto.addChild(s3);
		
		
		TransformGroup ConeTranslationGroup;
		Transform3D ConeTranslation = new Transform3D();
		TransformGroup objCono = new TransformGroup();
		
		Cone co = new Cone(0.02f, 0.07f);
		Appearance app = new Appearance();
		ColoringAttributes ca = new ColoringAttributes((float) 1.0, (float) 0.0, (float) 0.0, ColoringAttributes.SHADE_GOURAUD);
		app.setColoringAttributes(ca);
		co.setAppearance(app);
		ConeTranslation.setTranslation(new Vector3f(1.0f, 0.0f, 0.0f));
		ConeTranslation.setRotation(new AxisAngle4d(1.0,1.0,1.0,-2.0));
		ConeTranslationGroup = new TransformGroup(ConeTranslation);
		ConeTranslationGroup.addChild(co);
	    objCono.addChild(ConeTranslationGroup);
		objeto.addChild(objCono);
		
		
		
		TransformGroup PuntoTranslationGroup;
		Transform3D PuntoTranslation = new Transform3D();
		TransformGroup objPunto = new TransformGroup();
		
		Sphere PuntoDeOrigen = new Sphere(0.02f);
		
		Appearance appPunto = new Appearance();
		ColoringAttributes colorPunto = new ColoringAttributes((float) 1.0, (float) 0.0, (float) 0.0, ColoringAttributes.SHADE_GOURAUD);
		appPunto.setColoringAttributes(colorPunto);
		PuntoDeOrigen.setAppearance(appPunto);
		PuntoTranslation.setTranslation(new Vector3f(-1.0f, 0.0f, 0.0f));
		PuntoTranslationGroup = new TransformGroup(PuntoTranslation);
		PuntoTranslationGroup.addChild(PuntoDeOrigen);
		objPunto.addChild(PuntoTranslationGroup);
		
		objeto.addChild(objPunto);
		
		
		
		TransformGroup textTranslationGroupX;
		Transform3D textTranslationX;
		TransformGroup objScaleX = new TransformGroup();
		
		Shape3D textoX = new Text2D("Punto de Origen",  new Color3f(1.0f, 1.0f, 1.0f), "Serif", 18, Font.BOLD);
		Appearance apptextoX = textoX.getAppearance();
		apptextoX.setPolygonAttributes(DobleLetras());
		
		textTranslationX = new Transform3D();
	    textTranslationX.setTranslation(new Vector3f(-1.2f, 0.04f, 0.0f));
	    textTranslationGroupX = new TransformGroup(textTranslationX);
	    textTranslationGroupX.addChild(textoX);
	    objScaleX.addChild(textTranslationGroupX);
		objeto.addChild(objScaleX);
		
		
		TransformGroup textTranslationGroup;
		Transform3D textTranslation;
		TransformGroup objScale = new TransformGroup();
		
		Shape3D texto = new Text2D("Sentido",  new Color3f(1.0f, 1.0f, 1.0f), "Serif", 18, Font.BOLD);
		Appearance apptexto = texto.getAppearance();
		apptexto.setPolygonAttributes(DobleLetras());
		
		textTranslation = new Transform3D();
	    textTranslation.setTranslation(new Vector3f(0.9f, 0.04f, 0.0f));
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

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JButton getBtnVerEjemplo() {
		return btnVerEjemplo;
	}

	public void setBtnVerEjemplo(JButton btnVerEjemplo) {
		this.btnVerEjemplo = btnVerEjemplo;
	}


	public ControlVistas getCv() {
		return cv;
	}


	public void setCv(ControlVistas cv) {
		this.cv = cv;
	}
}
