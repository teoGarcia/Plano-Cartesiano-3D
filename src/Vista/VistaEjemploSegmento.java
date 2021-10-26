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

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import Control.ControlEjemploSegmento;
import Control.ControlVistas;

import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Text2D;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class VistaEjemploSegmento extends JFrame {

	
	private JPanel panel;
	private SimpleUniverse su;
	private JButton btnVerEjemplo;
	private JLabel lblSalir;
	private JLabel lblSiguiente;
	private ControlVistas cv;

	public VistaEjemploSegmento(ControlVistas cv) {
		setResizable(false);
		this.setCv(cv);
		Contenido();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the frame.
	 */
	public void Contenido() {
		
		
		ControlEjemploSegmento ces = new ControlEjemploSegmento(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaEjemploSegmento.class.getResource("/Imagenes/IconoOriginal.png")));
		setTitle("SpaVecGenerator");
		setBounds(100, 100, 738, 540);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		JLabel lblSegmento = new JLabel("Segmento");
		lblSegmento.setForeground(SystemColor.textHighlightText);
		lblSegmento.setBounds(318, 27, 98, 32);
		lblSegmento.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		getContentPane().add(lblSegmento);
		
		JTextPane txtpnDefinicionsegmento = new JTextPane();
		txtpnDefinicionsegmento.setText("Un segmento, es un fragmento de recta que est\u00E1 comprendido entre dos puntos, llamados puntos extremos o finales.\r\nDesde la perspectiva de la geometr\u00EDa, una recta es producto de la uni\u00F3n de infinitos segmentos y puntos; el segmento, en cambio, s\u00F3lo es una porci\u00F3n de recta unida por un par de puntos.");
		txtpnDefinicionsegmento.setBounds(20, 99, 694, 115);
		txtpnDefinicionsegmento.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		getContentPane().add(txtpnDefinicionsegmento);
		
		btnVerEjemplo = new JButton("Ver ejemplo");
		btnVerEjemplo.setBounds(551, 234, 151, 32);
		btnVerEjemplo.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		btnVerEjemplo.addActionListener(ces);
		getContentPane().add(btnVerEjemplo);
		
		panel = new JPanel();
		panel.setBounds(0, 277, 734, 172);
		panel.setVisible(false);
		panel.setLayout(new BorderLayout(0,0));
		panel.add("Center", CrearUniverso());
		getContentPane().add(panel);
		
		lblSiguiente = new JLabel("Siguiente");
		lblSiguiente.setForeground(SystemColor.textHighlightText);
		lblSiguiente.setIcon(new ImageIcon(VistaEjemploSegmento.class.getResource("/Imagenes/Siguientee.png")));
		lblSiguiente.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSiguiente.setBounds(578, 453, 146, 53);
		lblSiguiente.addMouseListener(ces);
		getContentPane().add(lblSiguiente);
		
		lblSalir = new JLabel("Salir");
		lblSalir.setForeground(SystemColor.textHighlightText);
		lblSalir.setIcon(new ImageIcon(VistaEjemploSegmento.class.getResource("/Imagenes/X.png")));
		lblSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblSalir.setBounds(20, 460, 114, 42);
		lblSalir.addMouseListener(ces);
		getContentPane().add(lblSalir);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VistaEjemploSegmento.class.getResource("/Imagenes/FondoAzul.jpeg")));
		lblFondo.setBounds(0, 0, 734, 512);
		getContentPane().add(lblFondo);
		
		
		CrearEscena();
	}
	
	public void CrearEscena(){
		
		BranchGroup Escena = new BranchGroup();
		
		Segmento(Escena);
		
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
	
	public void Segmento(BranchGroup objeto){
		
		
		 LineArray linea = new LineArray(2, TriangleArray.COORDINATES|
                 TriangleArray.COLOR_3);
		 
		 
		linea.setCoordinate(0, new Point3f(-1.0f, 0.0f, 0.0f));
		linea.setCoordinate(1, new Point3f(1.0f, 0.0f, 0.0f));
		
		linea.setColor(0, new Color3f(1.0f, 0.0f, 0.0f));
		linea.setColor(1, new Color3f(1.0f, 0.0f, 0.0f));
		
		Shape3D shape = new Shape3D(linea);
		
		objeto.addChild(shape);
		
		
		TransformGroup EsferaTranslationGroupX1;
		Transform3D EsferaTranslation1;
		TransformGroup tg1 = new TransformGroup();
		
		Sphere puntoA = new Sphere(0.05f);
		Appearance appA = new Appearance();
		ColoringAttributes colorpuntos1 = new ColoringAttributes(1f,0f,0f, ColoringAttributes.SHADE_GOURAUD);
		appA.setColoringAttributes(colorpuntos1);
		puntoA.setAppearance(appA);
		
		
		EsferaTranslation1 = new Transform3D();
		EsferaTranslation1.setTranslation(new Vector3f(1.0f,0.0f,0.0f));
		EsferaTranslationGroupX1 = new TransformGroup(EsferaTranslation1);
		EsferaTranslationGroupX1.addChild(puntoA);
		tg1.addChild(EsferaTranslationGroupX1);
		
		objeto.addChild(tg1);
		
		
		TransformGroup EsferaTranslationGroupB;
		Transform3D EsferaTranslationB;
		TransformGroup tgB = new TransformGroup();
		
		
		Sphere puntoB = new Sphere(0.05f);
		Appearance appB = new Appearance();
		ColoringAttributes colorpuntosB = new ColoringAttributes(1f,0f,0f, ColoringAttributes.SHADE_GOURAUD);
		appB.setColoringAttributes(colorpuntosB);
		puntoB.setAppearance(appB);
		
		
		EsferaTranslationB = new Transform3D();
		EsferaTranslationB.setTranslation(new Vector3f(-1.0f,0.0f,0.0f));
		EsferaTranslationGroupB = new TransformGroup(EsferaTranslationB);
		EsferaTranslationGroupB.addChild(puntoB);
		tgB.addChild(EsferaTranslationGroupB);
		
		objeto.addChild(tgB);
		
		
		TransformGroup textTranslationGroupA;
		Transform3D textTranslationA;
		TransformGroup objScaleA = new TransformGroup();
		
		Shape3D ObjetoTextoA = new Text2D("B", new Color3f(1.0f, 1.0f, 1.0f), "Arial", 20, Font.BOLD);
		Appearance appletraA = ObjetoTextoA.getAppearance();
		appletraA.setPolygonAttributes(DobleLetras());
		
		textTranslationA = new Transform3D();
		textTranslationA.setTranslation(new Vector3f(1.0f,0.15f,0));
		textTranslationGroupA = new TransformGroup(textTranslationA);
		textTranslationGroupA.addChild(ObjetoTextoA);
		
		objScaleA.addChild(textTranslationGroupA);
		
		objeto.addChild(objScaleA);
		
		
		
		TransformGroup textTranslationGroupB;
		Transform3D textTranslationB;
		TransformGroup objScaleB = new TransformGroup();
		
		Shape3D ObjetoTextoB = new Text2D("A", new Color3f(1.0f, 1.0f, 1.0f), "Arial", 20, Font.BOLD);
		Appearance appletraB = ObjetoTextoB.getAppearance();
		appletraB.setPolygonAttributes(DobleLetras());
		
		textTranslationB = new Transform3D();
		textTranslationB.setTranslation(new Vector3f(-1.0f,0.15f,0));
		textTranslationGroupB = new TransformGroup(textTranslationB);
		textTranslationGroupB.addChild(ObjetoTextoB);
		
		objScaleB.addChild(textTranslationGroupB);
		
		objeto.addChild(objScaleB);
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
