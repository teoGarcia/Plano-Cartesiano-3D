package Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Node;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.JButton;

import Control.ControlEjemploPunto;
import Control.ControlVistas;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import java.awt.Toolkit;
import java.awt.SystemColor;

public class VistaEjemploPunto extends JFrame {

	private JPanel contentPane;
	private SimpleUniverse su;
	private JButton btnVerEjemplo;
	private JPanel panel;
	private ControlVistas cv;
	private JLabel lblSalir;
	private JLabel lblSiguiente;

	/**
	 * Create the frame.
	 */
	
	public VistaEjemploPunto(ControlVistas cv) {
		setResizable(false);
		this.setCv(cv);
		Contenido();
		// TODO Auto-generated constructor stub
	}
	
	public void Contenido() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaEjemploPunto.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");
		
		ControlEjemploPunto cep = new ControlEjemploPunto(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		
		
		JLabel lblPuntoEnEl = new JLabel("Punto en el espacio tridimensional");
		lblPuntoEnEl.setForeground(UIManager.getColor("Button.highlight"));
		lblPuntoEnEl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPuntoEnEl.setBounds(201, 27, 332, 32);
		contentPane.add(lblPuntoEnEl);
		
		JTextPane txtpnEfefe = new JTextPane();
		txtpnEfefe.setEditable(false);
		txtpnEfefe.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		txtpnEfefe.setText("En geometr\u00EDa, el punto es uno de los entes fundamentales junto con la recta y el plano. \r\nEl punto es una figura geom\u00E9trica sin dimensi\u00F3n, tampoco tiene longitud, \u00E1rea, volumen, ni otro \u00E1ngulo dimensional.\r\nDescribe una posici\u00F3n en el espacio, determinada por el eje X, Y, Z respecto de un sistema de coordenadas preestablecidas");
		txtpnEfefe.setBounds(20, 99, 694, 115);
		contentPane.add(txtpnEfefe);
		
		btnVerEjemplo = new JButton("Ver Ejemplo");
		btnVerEjemplo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnVerEjemplo.setBounds(551, 234, 151, 32);
		btnVerEjemplo.addActionListener(cep);
		contentPane.add(btnVerEjemplo);
		
		panel = new JPanel();
		panel.setBounds(0, 277, 734, 172);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add("Center",CrearUniverso());
		contentPane.add(panel).setVisible(false);
		
		lblSiguiente = new JLabel("Siguiente");
		lblSiguiente.setForeground(SystemColor.textHighlightText);
		lblSiguiente.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSiguiente.setIcon(new ImageIcon(VistaEjemploPunto.class.getResource("/Imagenes/Siguientee.png")));
		lblSiguiente.setBounds(578, 453, 146, 53);
		lblSiguiente.addMouseListener(cep);
		contentPane.add(lblSiguiente);
		
		lblSalir = new JLabel("Salir");
		lblSalir.setIcon(new ImageIcon(VistaEjemploPunto.class.getResource("/Imagenes/X.png")));
		lblSalir.setForeground(SystemColor.textHighlightText);
		lblSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSalir.setBounds(20, 460, 114, 42);
		lblSalir.addMouseListener(cep);
		contentPane.add(lblSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaEjemploPunto.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblFondo.setBounds(0, 0, 734, 512);
		contentPane.add(lblFondo);
		
		
	}


	public void CrearEscena(){
		
		BranchGroup Escena = new BranchGroup();
		PuntosEjemplo(Escena);
		Escena.compile();
		su.addBranchGraph(Escena);
	}
	
	
	public Component CrearUniverso(){
			
			GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();//Configuracion Grafica para el canvas
			Canvas3D c3d = new Canvas3D(config); // Setlayout y add vienen de la clase applet
	
			su = new SimpleUniverse(c3d); /*Universo simple clase de conveniencia por su rama predefinida de vista*/
			su.getViewingPlatform().setNominalViewingTransform();//Configurando la Vista 
			su.getViewer().getView().setFieldOfView(1.6); //alejar el campo de vision
			
			OrbitBehavior orbit = new OrbitBehavior(c3d, OrbitBehavior.REVERSE_ROTATE | OrbitBehavior.STOP_ZOOM);
			orbit.setSchedulingBounds(new BoundingSphere()); //Permite la rotacion en la vista por medio de orbita al SimpleUniverse
			su.getViewingPlatform().setViewPlatformBehavior(orbit);//orbita
			orbit.setMinRadius(1.5);
			
			return c3d;
			
		}
	
	
	
	public void PuntosEjemplo(BranchGroup Objeto){
		
		Sphere punto = new Sphere(0.07f);
		Appearance app = new Appearance();
		ColoringAttributes colorpuntos = new ColoringAttributes(1f,0f,0f, ColoringAttributes.SHADE_GOURAUD);
		app.setColoringAttributes(colorpuntos);
		punto.setAppearance(app);
		
		
		TransformGroup EsferaTranslationGroupX;
		Transform3D EsferaTranslation;
		TransformGroup tg = new TransformGroup();
		
		EsferaTranslation = new Transform3D();
		EsferaTranslation.setTranslation(new Vector3f(-0.4f, 0f,0f));
		EsferaTranslationGroupX = new TransformGroup(EsferaTranslation);
		EsferaTranslationGroupX.addChild(punto);
		
		tg.addChild(EsferaTranslationGroupX);
		
		Objeto.addChild(tg);
		
		
		
		
		Sphere punto1 = new Sphere(0.07f);
		Appearance app1 = new Appearance();
		ColoringAttributes colorpuntos1 = new ColoringAttributes(1f,0f,0f, ColoringAttributes.SHADE_GOURAUD);
		app1.setColoringAttributes(colorpuntos1);
		punto1.setAppearance(app1);
		
		
		
		
		
		TransformGroup EsferaTranslationGroupX1;
		Transform3D EsferaTranslation1;
		TransformGroup tg1 = new TransformGroup();
		
		
		EsferaTranslation1 = new Transform3D();
		EsferaTranslation1.setTranslation(new Vector3f(0.4f,0.0f,0.0f));
		EsferaTranslationGroupX1 = new TransformGroup(EsferaTranslation1);
		EsferaTranslationGroupX1.addChild(punto1);
		tg1.addChild(EsferaTranslationGroupX1);
		
		Objeto.addChild(tg1);
		
		
		TransformGroup textTranslationGroupX;
		Transform3D textTranslationX;
		TransformGroup objScaleX = new TransformGroup();
		
		Shape3D ObjetoTextoX = new Text2D("Punto A = (-2, 0, 0)", new Color3f(1.0f, 1.0f, 1.0f), "Arial", 18, Font.BOLD);
		Appearance appletra = ObjetoTextoX.getAppearance();
		appletra.setPolygonAttributes(DobleLetras());
		
		textTranslationX = new Transform3D();
		textTranslationX.setTranslation(new Vector3f(-0.8f,-0.2f,0));
		textTranslationGroupX = new TransformGroup(textTranslationX);
		textTranslationGroupX.addChild(ObjetoTextoX);
		
		objScaleX.addChild(textTranslationGroupX);
		
		Objeto.addChild(objScaleX);
		
		
		
		
		TransformGroup textTranslationGroupB;
		Transform3D textTranslationB;
		TransformGroup objScaleB = new TransformGroup();
		
		Shape3D ObjetoTextoB = new Text2D("Punto B = (2, 0, 0)", new Color3f(1.0f, 1.0f, 1.0f), "Arial", 18, Font.BOLD);
		Appearance appletraB = ObjetoTextoB.getAppearance();
		appletraB.setPolygonAttributes(DobleLetras());
		
		textTranslationB = new Transform3D();
		textTranslationB.setTranslation(new Vector3f(0.2f,-0.2f,0));
		textTranslationGroupB = new TransformGroup(textTranslationB);
		textTranslationGroupB.addChild(ObjetoTextoB);
		
		objScaleB.addChild(textTranslationGroupB);
		
		Objeto.addChild(objScaleB);
		
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
