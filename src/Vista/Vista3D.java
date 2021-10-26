package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Node;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Control.ControlCoordenadas;
import Control.ControlVista3D;
import Control.ControlVistas;
import Modelo.Angulo;
import Modelo.Puntos;
import Modelo.RestarVectores;
import Modelo.Segmento;
import Modelo.SumarVectores;
import Modelo.Vector;

import com.sun.j3d.loaders.Scene;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTree;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.UIManager;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

public class Vista3D extends JFrame {
	
	private Panel panel1;
	private VistaPlanoCartesiano plano;
	
	private Segmento seg;
	private Vector vec;

	private JMenuBar barramenu; 
	private Canvas3D c3d;
	private SimpleUniverse su;
	private ControlVista3D c3D;
	private ControlVistas cv;
	private JMenuItem mntmAgregarPunto;
	private JTree tree;
	private ArrayList<Vector> LsVector = new ArrayList<Vector>();
	private ArrayList<Segmento> LsSegmento = new ArrayList<Segmento>();
	private ArrayList<Angulo> LsAngulo = new ArrayList<Angulo>();
	private ArrayList<Puntos> LsPuntos = new ArrayList<Puntos>();
	private ArrayList<SumarVectores> LsSumarVectores = new ArrayList<SumarVectores>();
	private ArrayList<RestarVectores> LsRestarVectores = new ArrayList<RestarVectores>();
	private BranchGroup bg = new BranchGroup();
	private BranchGroup scene = new BranchGroup();
	private JMenuItem mntmSalir;
	private JMenuItem mntmAbrir;
	private DefaultMutableTreeNode TreePuntos = new DefaultMutableTreeNode("Puntos");
	private DefaultMutableTreeNode TreeSegmentos = new DefaultMutableTreeNode("Segmentos");
	private DefaultMutableTreeNode TreeVectores = new DefaultMutableTreeNode("Vectores");
	private DefaultMutableTreeNode TreeAngulos = new DefaultMutableTreeNode("Angulos");
	
	private JMenuItem mntmCrearSegmento;
	private JMenuItem mntmCrearVector;
	private JMenuItem mntmSumarVector;
	private JMenuItem mntmRestarVectores;
	private JMenuItem mntmCambiarColor;
	private JMenuItem mntmCrearAngulo;
	private JMenuItem mntmBorrar;
	private JMenuItem mntmTutorial;
	private JMenuItem mntmManual;
	
	public Vista3D(ControlVistas cv) {
		setResizable(false);
		getContentPane().setBackground(new Color(176, 224, 230));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vista3D.class.getResource("/Imagenes/IconoOriginal.png")));
		this.cv = cv;
		plano = cv.getVpc(); 
		Contenido(); 
	}
	

	
	public void Contenido(){
	
		Fondo();
		
		c3D = new ControlVista3D(this);
		
		getContentPane().setLayout(null);
		
		setTitle("SpaVecGenerator");
		setBounds(100, 100, 1040, 570);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		
		//Menu de Letras
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 255, 240));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.addActionListener(c3D);
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mnArchivo.add(mntmGuardarComo);
		
		mntmSalir = new JMenuItem("Salir 'X'");
		mntmSalir.addActionListener(c3D);
		mnArchivo.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmTutorial = new JMenuItem("Tutorial");
		mntmTutorial.addActionListener(c3D);
		mnAyuda.add(mntmTutorial);
		
		mntmManual = new JMenuItem("Manual");
		mntmManual.addActionListener(c3D);
		mnAyuda.add(mntmManual);
		
		setJMenuBar(menuBar);
		//add("Center", CrearUniverso());   
		
		JLabel lblVistad = new JLabel("Vista 3D");
		lblVistad.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblVistad.setBounds(367, 11, 92, 31);
		getContentPane().add(lblVistad);
		
		JLabel lblVistaAlgebraica = new JLabel("Vista Algebraica");
		lblVistaAlgebraica.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		lblVistaAlgebraica.setBounds(854, 11, 143, 31);
		getContentPane().add(lblVistaAlgebraica);
		
		
		JPanel panelUniverse = new JPanel();
		panelUniverse.setBounds(0, 48, 819, 469);
		panelUniverse.setBackground(new Color(240, 255, 240));
		panelUniverse.setLayout(new BorderLayout(0, 0));
		panelUniverse.add("Center", CrearUniverso());
		getContentPane().add(panelUniverse);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(c3d, popupMenu);
		
		mntmAgregarPunto = new JMenuItem("Agregar Punto");
		mntmAgregarPunto.addActionListener(c3D);
		popupMenu.add(mntmAgregarPunto);
		
		tree = new JTree();
		tree.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DefaultTreeCellRenderer render= (DefaultTreeCellRenderer)tree.getCellRenderer();
		render.setOpenIcon(new ImageIcon("/Imagenes/guardado.png"));
		
		//PopupMenu para hacer Segmentos, vectores y angulos
		
		popupMenu = new JPopupMenu();
		Popup(tree, popupMenu);
		
		mntmCrearSegmento = new JMenuItem("Crear Segmento");
		popupMenu.add(mntmCrearSegmento);
		mntmCrearSegmento.setVisible(false);
		mntmCrearSegmento.addActionListener(c3D);
		
		mntmCrearVector = new JMenuItem("Crear Vector");
		popupMenu.add(mntmCrearVector);
		mntmCrearVector.setVisible(false);
		mntmCrearVector.addActionListener(c3D);
		
		mntmSumarVector = new JMenuItem("Sumar Vectores");
		popupMenu.add(mntmSumarVector);
		mntmSumarVector.setVisible(false);
		mntmSumarVector.addActionListener(c3D);
		
		mntmRestarVectores = new JMenuItem("Restar Vectores");
		popupMenu.add(mntmRestarVectores);
		mntmRestarVectores.setVisible(false);
		mntmRestarVectores.addActionListener(c3D);
		
		mntmCambiarColor = new JMenuItem("Cambiar Color");
		popupMenu.add(mntmCambiarColor);
		mntmCambiarColor.setVisible(false);
		mntmCambiarColor.addActionListener(c3D);
		
		mntmCrearAngulo = new JMenuItem("Crear Angulo");
		popupMenu.add(mntmCrearAngulo);
		mntmCrearAngulo.setVisible(false);
		mntmCrearAngulo.addActionListener(c3D);
		
		mntmBorrar = new JMenuItem("Borrar");
		popupMenu.add(mntmBorrar);
		mntmBorrar.setVisible(false);
		mntmBorrar.addActionListener(c3D);
		
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("SpaVecGenerator") {
				{
					add(TreePuntos);
					add(TreeSegmentos);
					add(TreeVectores);
					add(TreeAngulos);
					
				}
			}
		));
		
		tree.addTreeExpansionListener(c3D);
		tree.addMouseListener(c3D);
	
		getContentPane().add(tree);
		
		tree.setBounds(820, 48, 204, 469);
		
	}
		
	public Component CrearUniverso(){
			
			GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();//Configuracion Grafica para el canvas
			c3d = new Canvas3D(config); // Setlayout y add vienen de la clase applet

			su = new SimpleUniverse(c3d); /*Universo simple clase de conveniencia por su rama predefinida de vista*/
			su.getViewingPlatform().setNominalViewingTransform();//Configurando la Vista 
			su.getViewer().getView().setFieldOfView(1.6); //alejar el campo de vision
			
			OrbitBehavior orbit = new OrbitBehavior(c3d, OrbitBehavior.REVERSE_ROTATE | OrbitBehavior.STOP_ZOOM);
			orbit.setSchedulingBounds(new BoundingSphere()); //Permite la rotacion en la vista por medio de orbita al SimpleUniverse
			su.getViewingPlatform().setViewPlatformBehavior(orbit);//orbita
			orbit.setMinRadius(1.5);
			
			bg.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
			bg.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
			bg.setCapability(BranchGroup.ALLOW_DETACH);
			bg.addChild(Fondo());
			bg.compile();
			
			su.addBranchGraph(bg);
			
			createSceneGraph(1);
			
			return c3d;
			
		}
		
		public Node Fondo(){
			Background Fondo3D = new Background(new Color3f(Color.WHITE)); 
		    Fondo3D.setApplicationBounds(new BoundingSphere(new Point3d(0f,0f,0f), 10000)); 
		    
		    return Fondo3D;
		}
		
		
		
		public void FondoEscena(){
			
			BranchGroup Fondoescena = new BranchGroup();
			Fondoescena.addChild(Fondo());
			Fondoescena.compile();
			su.addBranchGraph(Fondoescena);
			
		}
		

		public void createSceneGraph(float tamaño) {
			
			//Rama de Contenido
			scene = new BranchGroup(); //nodo principal desde el cual, todo lo que depende de este empieza a ser renderizado
			scene.setCapability(BranchGroup.ALLOW_CHILDREN_READ); //grupo de instrucciones para
			scene.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE); //agregar la capacidad de crear
			scene.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND); //modificar en posicion, tamaño, rotacion, etc
			scene.setCapability(BranchGroup.ALLOW_DETACH); //y destruir objetos en tiempo real
			
			scene.addChild(MoverEspacio(plano.CrearEjes()));
			
			plano.Texto2d(scene);
			
			plano.VectorX(scene, tamaño);
			
			plano.VectorY(scene, tamaño);
			
			plano.VectorZ(scene, tamaño);
			
			plano.ConoY(scene);
			
			plano.EsferasPlano(scene);
			
			
			// prueba
			/*Transform3D coneTranslation1 = new Transform3D();
			TransformGroup coneTranslationGroup1;
			TransformGroup objCono1 = new TransformGroup();
			
			Cone cone1 = new Cone(0.02f, 0.07f);
			Appearance app1 = new Appearance();
			ColoringAttributes ca1 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			app1.setColoringAttributes(ca1);
			cone1.setAppearance(app1);

			Transform3D coneTranslation2 = new Transform3D();
			Transform3D coneTranslation3;
			TransformGroup coneTranslationGroup2;
			TransformGroup objCono2 = new TransformGroup();
			
			//coneTranslation2.setRotation(new AxisAngle4d(0.0, 0.0, 0.0, 0.0));
			coneTranslation2.rotX(1.7);
			//coneTranslation2.rotY(1.7);
			//coneTranslation2.rotZ(-1.7);
			coneTranslation3 = new Transform3D(coneTranslation2);
			coneTranslation3.rotZ(-1);
			coneTranslationGroup2 = new TransformGroup(coneTranslation3);
			coneTranslationGroup2.addChild(cone1);
			objCono2.addChild(coneTranslationGroup2);
			
			Transform3D rotar = new Transform3D();
			Transform3D temprotar = new Transform3D();
			
			temprotar.rotY(Math.PI/-4.0f);
            rotar.mul(temprotar);
			TransformGroup objrotado = new TransformGroup(rotar);
			objrotado.addChild(objCono2);
			
			scene.addChild(objrotado);*/
			
			bg.addChild(scene);  //  Mostrando
			
		}
		
		public void RecrearEsena(float tamaño) {
		
			bg.removeChild(scene);  //  remueve la esena
			
			//Rama de Contenido
			scene = new BranchGroup(); //nodo principal desde el cual, todo lo que depende de este empieza a ser renderizado
			scene.setCapability(BranchGroup.ALLOW_CHILDREN_READ); //grupo de instrucciones para
			scene.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE); //agregar la capacidad de crear
			scene.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND); //modificar en posicion, tamaño, rotacion, etc
			scene.setCapability(BranchGroup.ALLOW_DETACH); //y destruir objetos en tiempo real
			
			scene.addChild(MoverEspacio(plano.CrearEjes()));
			
			plano.Texto2d(scene);
			
			plano.VectorX(scene, tamaño);
			
			plano.VectorY(scene, tamaño);
			
			plano.VectorZ(scene, tamaño);
			
			plano.ConoY(scene);
			
			plano.EsferasPlano(scene);
			
			for(int x=0; x<LsPuntos.size(); x++){
				
				scene.addChild(LsPuntos.get(x).getPunto(tamaño));
				
			}
			
			for(int x=0; x<LsSegmento.size(); x++){
				
				scene.addChild(LsSegmento.get(x).ListarLinea(tamaño));
				
			}
			
			for(int x=0; x<LsVector.size(); x++){
				
				scene.addChild(LsVector.get(x).CrearVector(tamaño));
				scene.addChild(LsVector.get(x).CrearCono(tamaño));
				
			}
			
			for(int x=0; x<LsAngulo.size(); x++){
				
				scene.addChild(LsAngulo.get(x).CrearAngulo());
				
				
				
			}
			
			for(int x=0; x<LsSumarVectores.size(); x++){
				
				scene.addChild(LsSumarVectores.get(x).SumarVectores(tamaño));
				
				
				
			}for(int x=0; x<LsRestarVectores.size(); x++){
				
				scene.addChild(LsRestarVectores.get(x).RestarVectores(tamaño));
				
				
				
			}
			
			bg.addChild(scene);  //  Mostrando
			
		}
		
		public void AgregarNodos(Node n){
			
			bg.removeChild(scene);
			scene.addChild(n);
			bg.addChild(scene);
		
		}

		
		public TransformGroup MoverEspacio(Node nodo){
		
			Transform3D rotar = new Transform3D();
			Transform3D temprotar = new Transform3D();
			
			temprotar.rotY(Math.PI/-4.0d);
            rotar.mul(temprotar);
        	
			TransformGroup objrotado = new TransformGroup(rotar);
			objrotado.addChild(nodo);
			
			return objrotado;
		}
		
		
		private static void addPopup(Component component, final JPopupMenu popup) {
			component.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}
				public void mouseReleased(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}
				private void showMenu(MouseEvent e) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			});
		}
		

		// agregar al tree
		
		public void AddTree(String desc, int Style){
			
			switch(Style){
			
				case 0:
						TreePuntos.add(new DefaultMutableTreeNode(desc));
						tree.updateUI();
						tree.expandRow(1);
					break;
					
				case 1:
						TreeSegmentos.add(new DefaultMutableTreeNode(desc));
						tree.updateUI();
						if(LsSegmento.size() == 1){
							
							tree.expandRow((2+LsPuntos.size()));
							
						}
					break;
									
				case 2:
						TreeVectores.add(new DefaultMutableTreeNode(desc));
						tree.updateUI();
						if(LsVector.size() == 1){
							
							tree.expandRow((3+LsPuntos.size()+LsSegmento.size()));
							
						}
					break;
				
				case 3:
						TreeAngulos.add(new DefaultMutableTreeNode(desc));
						tree.updateUI();
						if(LsAngulo.size() == 1){
							
							tree.expandRow((4+LsPuntos.size()+LsSegmento.size()+LsVector.size()));
							
						}
					break;
			
			}
			
		}
		
		
		
		
		
		
		private static void Popup(Component component, final JPopupMenu popup) {
			component.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					
					
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
		
				}
				public void mouseReleased(MouseEvent e) {
					
					if (e.isPopupTrigger()) {
							showMenu(e);
					}

				}
				private void showMenu(MouseEvent e) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			});
		}


		public JMenuBar getBarramenu() {
			return barramenu;
		}



		public void setBarramenu(JMenuBar barramenu) {
			this.barramenu = barramenu;
		}


		public Canvas3D getC3d() {
			return c3d;
		}



		public void setC3d(Canvas3D c3d) {
			this.c3d = c3d;
		}

		public SimpleUniverse getSu() {
			return su;
		}

		public void setSu(SimpleUniverse su) {
			this.su = su;
		}

		public ControlVistas getCv() {
			return cv;
		}

		public void setCv(ControlVistas cv) {
			this.cv = cv;
		}


		public JMenuItem getMntmAgregarPunto() {
			return mntmAgregarPunto;
		}
	
		public void setMntmAgregarPunto(JMenuItem mntmAgregarPunto) {
			this.mntmAgregarPunto = mntmAgregarPunto;
		}



		public JMenuItem getMntmSalir() {
			return mntmSalir;
		}



		public void setMntmSalir(JMenuItem mntmSalir) {
			this.mntmSalir = mntmSalir;
		}



		public JMenuItem getMntmAbrir() {
			return mntmAbrir;
		}



		public void setMntmAbrir(JMenuItem mntmAbrir) {
			this.mntmAbrir = mntmAbrir;
		}



		public BranchGroup getScene() {
			return scene;
		}



		public void setScene(BranchGroup scene) {
			this.scene = scene;
		}



		public VistaPlanoCartesiano getPlano() {
			return plano;
		}



		public void setPlano(VistaPlanoCartesiano plano) {
			this.plano = plano;
		}



		public ArrayList<Vector> getLsVector() {
			return LsVector;
		}



		public void setLsVector(ArrayList<Vector> lsVector) {
			LsVector = lsVector;
		}



		public ArrayList<Segmento> getLsSegmento() {
			return LsSegmento;
		}



		public void setLsSegmento(ArrayList<Segmento> lsSegmento) {
			LsSegmento = lsSegmento;
		}



		public ArrayList<Angulo> getLsAngulo() {
			return LsAngulo;
		}



		public void setLsAngulo(ArrayList<Angulo> lsAngulo) {
			LsAngulo = lsAngulo;
		}



		public ArrayList<Puntos> getLsPuntos() {
			return LsPuntos;
		}



		public void setLsPuntos(ArrayList<Puntos> lsPuntos) {
			LsPuntos = lsPuntos;
		}





		public JTree getTree() {
			return tree;
		}



		public void setTree(JTree tree) {
			this.tree = tree;
		}


		public ArrayList<SumarVectores> getLsSumarVectores() {
			return LsSumarVectores;
		}



		public void setLsSumarVectores(ArrayList<SumarVectores> lsSumarVectores) {
			LsSumarVectores = lsSumarVectores;
		}
		
		
		public void OpcionesDeBorrado(int index){
			
			if(index>1 && index<=LsPuntos.size()+1){
				
				LsPuntos.remove(index-2);
				TreePuntos.remove(index-2);
				cv.getVc().getListaPuntos().remove(index-2);
				tree.updateUI();
				RecrearEsena(cv.getVc().getCc().getTamaño());
				
			}else if(index > (LsPuntos.size()+2) && index <= (LsPuntos.size()+2+LsSegmento.size())){
				
				LsSegmento.remove(index-LsPuntos.size()-3);
				TreeSegmentos.remove(index-LsPuntos.size()-3);
				tree.updateUI();
				RecrearEsena(cv.getVc().getCc().getTamaño());
				
			}else if(index >(LsPuntos.size()+3+LsSegmento.size()) && index <= (LsPuntos.size()+3+LsSegmento.size()+LsVector.size())){
			
				LsVector.remove(index-LsPuntos.size()-LsSegmento.size()-4);
				TreeVectores.remove(index-LsPuntos.size()-LsSegmento.size()-4);
				tree.updateUI();
				RecrearEsena(cv.getVc().getCc().getTamaño());
				
			}else if(index >(LsPuntos.size()+4+LsSegmento.size()+LsVector.size()) && index <= (LsPuntos.size()+4+LsSegmento.size()+LsVector.size()+LsAngulo.size())){
				
				LsAngulo.remove(index-LsPuntos.size()-LsSegmento.size()-LsVector.size()-5);
				TreeAngulos.remove(index-LsPuntos.size()-LsSegmento.size()-LsVector.size()-5);
				tree.updateUI();
				RecrearEsena(cv.getVc().getCc().getTamaño());
				
			}else{
				
				mntmCrearSegmento.setVisible(false);
				mntmCrearVector.setVisible(false);
				mntmSumarVector.setVisible(false);
				mntmRestarVectores.setVisible(false);
				mntmCambiarColor.setVisible(false);
				mntmCrearAngulo.setVisible(false);
				mntmBorrar.setVisible(false);
			
			}
			
			
		}
		
		
		public void OpcionesDeMenu(int index){
			
			if(index>1 && index<=LsPuntos.size()+1){	//1
				
				mntmCrearSegmento.setVisible(true);
				mntmCrearVector.setVisible(true);
				mntmSumarVector.setVisible(false);
				mntmRestarVectores.setVisible(false);
				mntmCambiarColor.setVisible(false);
				mntmCrearAngulo.setVisible(false);
				mntmBorrar.setVisible(true);
				
				
				
	/*2*/		}else if(index > (LsPuntos.size()+2) && index <= (LsPuntos.size()+2+LsSegmento.size())){
				
				mntmCrearSegmento.setVisible(false);
				mntmCrearVector.setVisible(false);
				mntmSumarVector.setVisible(false);
				mntmRestarVectores.setVisible(false);
				mntmCambiarColor.setVisible(false);
				mntmCrearAngulo.setVisible(true);
				mntmBorrar.setVisible(true);
				
	/*3*/		}else if(index >(LsPuntos.size()+3+LsSegmento.size()) && index <= (LsPuntos.size()+3+LsSegmento.size()+LsVector.size()+LsSumarVectores.size()+LsRestarVectores.size())){
			
				
				// +LsSumarVectores.size()+1+LsRestarVectores.size()+1    +LsSumarVectores.size()+LsRestarVectores.size()
				mntmCrearSegmento.setVisible(false);
				mntmCrearVector.setVisible(false);
				mntmSumarVector.setVisible(true);
				mntmRestarVectores.setVisible(true);
				mntmCambiarColor.setVisible(true);
				mntmCrearAngulo.setVisible(true);
				mntmBorrar.setVisible(true);
				
	/*4*/			}else if(index >(LsPuntos.size()+4+LsSegmento.size()+LsVector.size()) && index <= (LsPuntos.size()+4+LsSegmento.size()+LsVector.size()+LsAngulo.size())){
				
				mntmCrearSegmento.setVisible(false);
				mntmCrearVector.setVisible(false);
				mntmSumarVector.setVisible(false);
				mntmRestarVectores.setVisible(false);
				mntmCambiarColor.setVisible(false);
				mntmCrearAngulo.setVisible(false);
				mntmBorrar.setVisible(true);
				
	/*5*/		}else{
				mntmCrearSegmento.setVisible(false);
				mntmCrearVector.setVisible(false);
				mntmSumarVector.setVisible(false);
				mntmRestarVectores.setVisible(false);
				mntmCambiarColor.setVisible(false);
				mntmCrearAngulo.setVisible(false);
				mntmBorrar.setVisible(false);
			}
		
			
		}



		public JMenuItem getMntmCrearSegmento() {
			return mntmCrearSegmento;
		}



		public void setMntmCrearSegmento(JMenuItem mntmCrearSegmento) {
			this.mntmCrearSegmento = mntmCrearSegmento;
		}



		public JMenuItem getMntmCrearVector() {
			return mntmCrearVector;
		}



		public void setMntmCrearVector(JMenuItem mntmCrearVector) {
			this.mntmCrearVector = mntmCrearVector;
		}



		public JMenuItem getMntmSumarVector() {
			return mntmSumarVector;
		}



		public void setMntmSumarVector(JMenuItem mntmSumarVector) {
			this.mntmSumarVector = mntmSumarVector;
		}



		public JMenuItem getMntmRestarVectores() {
			return mntmRestarVectores;
		}



		public void setMntmRestarVectores(JMenuItem mntmRestarVectores) {
			this.mntmRestarVectores = mntmRestarVectores;
		}



		public JMenuItem getMntmCambiarColor() {
			return mntmCambiarColor;
		}



		public void setMntmCambiarColor(JMenuItem mntmCambiarColor) {
			this.mntmCambiarColor = mntmCambiarColor;
		}



		public JMenuItem getMntmCrearAngulo() {
			return mntmCrearAngulo;
		}



		public void setMntmCrearAngulo(JMenuItem mntmCrearAngulo) {
			this.mntmCrearAngulo = mntmCrearAngulo;
		}



		public JMenuItem getMntmBorrar() {
			return mntmBorrar;
		}



		public void setMntmBorrar(JMenuItem mntmBorrar) {
			this.mntmBorrar = mntmBorrar;
		}



		public ArrayList<RestarVectores> getLsRestarVectores() {
			return LsRestarVectores;
		}



		public void setLsRestarVectores(ArrayList<RestarVectores> lsRestarVectores) {
			LsRestarVectores = lsRestarVectores;
		}



		public JMenuItem getMntmTutorial() {
			return mntmTutorial;
		}



		public void setMntmTutorial(JMenuItem mntmTutorial) {
			this.mntmTutorial = mntmTutorial;
		}



		public JMenuItem getMntmManual() {
			return mntmManual;
		}



		public void setMntmManual(JMenuItem mntmManual) {
			this.mntmManual = mntmManual;
		}
		
}
