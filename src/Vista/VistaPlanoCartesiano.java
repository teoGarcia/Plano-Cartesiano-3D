package Vista;

import java.awt.Font;
import java.awt.Rectangle;
import java.text.DecimalFormat;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.LineArray;
import javax.media.j3d.Node;
import javax.media.j3d.PointArray;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Matrix3d;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

import Control.ControlVistas;

import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.geometry.Text2D;

public class VistaPlanoCartesiano {
	
	int y=0;
	int x=0;
	int z=0;
	private ControlVistas cv;
	DecimalFormat df = new DecimalFormat("0.0");
	
	
	
	public VistaPlanoCartesiano(ControlVistas cv) {
		this.cv =cv;
	}
	

		public Node CrearEjes() {
		
		  LineArray línea = new LineArray(6, TriangleArray.COORDINATES|
		                                      TriangleArray.COLOR_3);
		  
		  //lineas de ejes
		  
		  línea.setCoordinate(1, new Point3f(0.0f, 1.0f, 0.0f));
		 
		  línea.setCoordinate(3, new Point3f( 1.0f, 0.0f, 0.0f));
		  
		  línea.setCoordinate(5, new Point3f( 0.0f, 0.0f, 1.0f));
		  
		
		  // color de ejes
		
		  línea.setColor(1, new Color3f(1.0f, 0.0f, 0.0f)); // Rojo
		 
		  línea.setColor(3, new Color3f(0.0f, 1.0f, 0.0f)); // Verde
		  
		  línea.setColor(5, new Color3f(0.0f, 0.0f, 1.0f)); // Azul
		  
		  Shape3D forma = new Shape3D(línea);
		  
		  return forma;
		  
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
		
	
		public void Texto2d(BranchGroup objeto){
			
			TransformGroup textTranslationGroupX;
			Transform3D textTranslationX;
			TransformGroup objScaleX = new TransformGroup();
			
		    
			Shape3D ObjetoTextoX = new Text2D("X", new Color3f(0.0f,  1.0f,  0.0f), "Arial", 16, Font.BOLD);
			Appearance app = ObjetoTextoX.getAppearance();
			app.setPolygonAttributes(DobleLetras());
			
			textTranslationX = new Transform3D();
		    textTranslationX.setTranslation(new Vector3f(0.80f, 0.0f, 0.80f));
		    textTranslationGroupX = new TransformGroup(textTranslationX);
		    textTranslationGroupX.addChild(ObjetoTextoX);
		    objScaleX.addChild(textTranslationGroupX);
			objeto.addChild(objScaleX);
			
			
			
			TransformGroup textTranslationGroupY;
			Transform3D textTranslationY;
			TransformGroup objScaleY = new TransformGroup();
			
		    
			Shape3D ObjetoTextoY = new Text2D("Y", new Color3f(1.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
			
			Appearance app1 = ObjetoTextoY.getAppearance();
			app1.setPolygonAttributes(DobleLetras());
			textTranslationY = new Transform3D();
		    textTranslationY.setTranslation(new Vector3f(-0.05f, 1.06f, 0.0f));
		    textTranslationGroupY = new TransformGroup(textTranslationY);
		    textTranslationGroupY.addChild(ObjetoTextoY);
		    objScaleY.addChild(textTranslationGroupY);
			
			objeto.addChild(objScaleY);
	
			
			
			TransformGroup textTranslationGroupZ;
			Transform3D textTranslationZ;
			TransformGroup objScaleZ = new TransformGroup();
			
		    
			Shape3D ObjetoTextoZ = new Text2D("Z", new Color3f(0.0f, 0.0f, 1.0f), "Serif", 16, Font.BOLD);
			Appearance app2 = ObjetoTextoY.getAppearance();
			app2.setPolygonAttributes(DobleLetras());
			
			textTranslationZ = new Transform3D();
		    textTranslationZ.setTranslation(new Vector3f(-0.80f, 0.0f, 0.80f));
		    textTranslationGroupZ = new TransformGroup(textTranslationZ);
		    textTranslationGroupZ.addChild(ObjetoTextoZ);
		    objScaleX.addChild(textTranslationGroupZ);
			
			objeto.addChild(objScaleZ);
			
		}
		
		
		
		public void VectorY(BranchGroup objeto, float Tamaño){
			
			float index = Tamaño/10;
			
			TransformGroup textTranslationGroup;
			Transform3D textTranslation;
			TransformGroup objScale = new TransformGroup();
			
		    
			Shape3D ObjetoTexto1 = new Text2D(""+df.format((index*1)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
			Appearance app = ObjetoTexto1.getAppearance();
			app.setPolygonAttributes(DobleLetras());
			
			textTranslation = new Transform3D();
		    textTranslation.setTranslation(new Vector3f(0.02f, 0.1f, 0.0f));
		    textTranslationGroup = new TransformGroup(textTranslation);
		    textTranslationGroup.addChild(ObjetoTexto1);
		    objScale.addChild(textTranslationGroup);
		    
		    objeto.addChild(objScale);
			
		    
		    
		    
		    TransformGroup textTranslationGroup2;
			Transform3D textTranslation2;
			TransformGroup objScale2 = new TransformGroup();
			
		    Shape3D ObjetoTexto2 = new Text2D(""+df.format((index*2)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
			
		    Appearance app1 = ObjetoTexto2.getAppearance();
			app1.setPolygonAttributes(DobleLetras());
		    
			textTranslation2 = new Transform3D();
		    textTranslation2.setTranslation(new Vector3f(0.02f, 0.2f, 0.0f));
		    textTranslationGroup2 = new TransformGroup(textTranslation2);
		    textTranslationGroup2.addChild(ObjetoTexto2);
		    objScale.addChild(textTranslationGroup2);
		    
		    objeto.addChild(objScale2);
		    
		    
		    
		    TransformGroup textTranslationGroup3;
			Transform3D textTranslation3;
			TransformGroup objScale3 = new TransformGroup();
			
		    Shape3D ObjetoTexto3 = new Text2D(""+df.format((index*3)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app2 = ObjetoTexto3.getAppearance();
			app2.setPolygonAttributes(DobleLetras());
			
			textTranslation3 = new Transform3D();
		    textTranslation3.setTranslation(new Vector3f(0.02f, 0.3f, 0.0f));
		    textTranslationGroup3 = new TransformGroup(textTranslation3);
		    textTranslationGroup3.addChild(ObjetoTexto3);
		    objScale.addChild(textTranslationGroup3);
		    
		    objeto.addChild(objScale3);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup4;
			Transform3D textTranslation4;
			TransformGroup objScale4 = new TransformGroup();
		
		    Shape3D ObjetoTexto4 = new Text2D(""+df.format((index*4)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app3 = ObjetoTexto4.getAppearance();
			app3.setPolygonAttributes(DobleLetras());
			
			textTranslation4 = new Transform3D();
		    textTranslation4.setTranslation(new Vector3f(0.02f, 0.4f, 0.0f));
		    textTranslationGroup4 = new TransformGroup(textTranslation4);
		    textTranslationGroup4.addChild(ObjetoTexto4);
		    objScale.addChild(textTranslationGroup4);
		    
		    objeto.addChild(objScale4);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup5;
			Transform3D textTranslation5;
			TransformGroup objScale5 = new TransformGroup();
			
		    Shape3D ObjetoTexto5 = new Text2D(""+df.format((index*5)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app4 = ObjetoTexto5.getAppearance();
			app4.setPolygonAttributes(DobleLetras());
			
			textTranslation5 = new Transform3D();
		    textTranslation5.setTranslation(new Vector3f(0.02f, 0.5f, 0.0f));
		    textTranslationGroup5 = new TransformGroup(textTranslation5);
		    textTranslationGroup5.addChild(ObjetoTexto5);
		    objScale.addChild(textTranslationGroup5);
		    
		    objeto.addChild(objScale5);
		    
		    
		
		    TransformGroup textTranslationGroup6;
			Transform3D textTranslation6;
			TransformGroup objScale6 = new TransformGroup();
			
		    Shape3D ObjetoTexto6 = new Text2D(""+df.format((index*6)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app5 = ObjetoTexto6.getAppearance();
			app5.setPolygonAttributes(DobleLetras());
			
			textTranslation6 = new Transform3D();
		    textTranslation6.setTranslation(new Vector3f(0.02f, 0.6f, 0.0f));
		    textTranslationGroup6 = new TransformGroup(textTranslation6);
		    textTranslationGroup6.addChild(ObjetoTexto6);
		    objScale.addChild(textTranslationGroup6);
		    
		    objeto.addChild(objScale6);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup7;
			Transform3D textTranslation7;
			TransformGroup objScale7 = new TransformGroup();
			
		    Shape3D ObjetoTexto7 = new Text2D(""+df.format((index*7)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app6 = ObjetoTexto7.getAppearance();
			app6.setPolygonAttributes(DobleLetras());
			
			textTranslation7 = new Transform3D();
		    textTranslation7.setTranslation(new Vector3f(0.02f, 0.7f, 0.0f));
		    textTranslationGroup7 = new TransformGroup(textTranslation7);
		    textTranslationGroup7.addChild(ObjetoTexto7);
		    objScale.addChild(textTranslationGroup7);
		    
		    objeto.addChild(objScale7);
		    
		    
		    
		    
		    
		    TransformGroup textTranslationGroup8;
			Transform3D textTranslation8;
			TransformGroup objScale8 = new TransformGroup();
			
		    Shape3D ObjetoTexto8 = new Text2D(""+df.format((index*8)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app7 = ObjetoTexto8.getAppearance();
			app7.setPolygonAttributes(DobleLetras());
			
			textTranslation8 = new Transform3D();
		    textTranslation8.setTranslation(new Vector3f(0.02f, 0.8f, 0.0f));
		    textTranslationGroup8 = new TransformGroup(textTranslation8);
		    textTranslationGroup8.addChild(ObjetoTexto8);
		    objScale.addChild(textTranslationGroup8);
		    
		    objeto.addChild(objScale8);
		    
		    
		    TransformGroup textTranslationGroup9;
			Transform3D textTranslation9;
			TransformGroup objScale9 = new TransformGroup();
			
		    Shape3D ObjetoTexto9 = new Text2D(""+df.format((index*9)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app8 = ObjetoTexto9.getAppearance();
			app8.setPolygonAttributes(DobleLetras());
			
			textTranslation9 = new Transform3D();
		    textTranslation9.setTranslation(new Vector3f(0.02f, 0.9f, 0.0f));
		    textTranslationGroup9 = new TransformGroup(textTranslation9);
		    textTranslationGroup9.addChild(ObjetoTexto9);
		    objScale.addChild(textTranslationGroup9);
		    
		    objeto.addChild(objScale9);
		    
		    
		    
		    TransformGroup textTranslationGroup10;
			Transform3D textTranslation10;
			TransformGroup objScale10 = new TransformGroup();
			
		    Shape3D ObjetoTexto10 = new Text2D(""+df.format((index*10)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app9 = ObjetoTexto10.getAppearance();
			app9.setPolygonAttributes(DobleLetras());
			
			textTranslation10 = new Transform3D();
		    textTranslation10.setTranslation(new Vector3f(0.02f, 1.0f, 0.0f));
		    textTranslationGroup10 = new TransformGroup(textTranslation10);
		    textTranslationGroup10.addChild(ObjetoTexto10);
		    objScale.addChild(textTranslationGroup10);
		    
		    objeto.addChild(objScale10);
		    
		}
		
		
		
		
		
		
		
		public void VectorX(BranchGroup objeto, float Tamaño){
	
			float index = Tamaño/10;
			
			TransformGroup textTranslationGroup;
			Transform3D textTranslation;
			TransformGroup objScale = new TransformGroup();
			
			Shape3D ObjetoTexto1 = new Text2D(""+df.format((index*1)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
			Appearance app = ObjetoTexto1.getAppearance();
			app.setPolygonAttributes(DobleLetras());
			
			textTranslation = new Transform3D();
		    textTranslation.setTranslation(new Vector3f(0.10f, 0.0f, 0.07f));
		    textTranslationGroup = new TransformGroup(textTranslation);
		    textTranslationGroup.addChild(ObjetoTexto1);
		    objScale.addChild(textTranslationGroup);
		    
		    objeto.addChild(objScale);
			
		    TransformGroup textTranslationGroup2;
			Transform3D textTranslation2;
			TransformGroup objScale2 = new TransformGroup();
			
		    Shape3D ObjetoTexto2 = new Text2D(""+df.format((index*2)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app1 = ObjetoTexto2.getAppearance();
			app1.setPolygonAttributes(DobleLetras());
			
			textTranslation2 = new Transform3D();
		    textTranslation2.setTranslation(new Vector3f(0.17f, 0.0f, 0.14f));
		    textTranslationGroup2 = new TransformGroup(textTranslation2);
		    textTranslationGroup2.addChild(ObjetoTexto2);
		    objScale.addChild(textTranslationGroup2);
		    
		    objeto.addChild(objScale2);
		    
		    
		    TransformGroup textTranslationGroup3;
			Transform3D textTranslation3;
			TransformGroup objScale3 = new TransformGroup();
			
		    Shape3D ObjetoTexto3 = new Text2D(""+df.format((index*3)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app2 = ObjetoTexto3.getAppearance();
			app2.setPolygonAttributes(DobleLetras());
			
			textTranslation3 = new Transform3D();
		    textTranslation3.setTranslation(new Vector3f(0.24f, 0.0f, 0.21f));
		    textTranslationGroup3 = new TransformGroup(textTranslation3);
		    textTranslationGroup3.addChild(ObjetoTexto3);
		    objScale.addChild(textTranslationGroup3);
		    
		    objeto.addChild(objScale3);
		    
		    TransformGroup textTranslationGroup4;
			Transform3D textTranslation4;
			TransformGroup objScale4 = new TransformGroup();
			
			
		    Shape3D ObjetoTexto4 = new Text2D(""+df.format((index*4)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app3 = ObjetoTexto4.getAppearance();
			app3.setPolygonAttributes(DobleLetras());
			
			textTranslation4 = new Transform3D();
		    textTranslation4.setTranslation(new Vector3f(0.30f, 0.0f, 0.28f));
		    textTranslationGroup4 = new TransformGroup(textTranslation4);
		    textTranslationGroup4.addChild(ObjetoTexto4);
		    objScale.addChild(textTranslationGroup4);
		    
		    objeto.addChild(objScale4);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup5;
			Transform3D textTranslation5;
			TransformGroup objScale5 = new TransformGroup();
			
		    Shape3D ObjetoTexto5 = new Text2D(""+df.format((index*5)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app4 = ObjetoTexto5.getAppearance();
			app4.setPolygonAttributes(DobleLetras());
			
			textTranslation5 = new Transform3D();
		    textTranslation5.setTranslation(new Vector3f(0.37f, 0.0f, 0.35f));
		    textTranslationGroup5 = new TransformGroup(textTranslation5);
		    textTranslationGroup5.addChild(ObjetoTexto5);
		    objScale.addChild(textTranslationGroup5);
		    
		    objeto.addChild(objScale5);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup6;
			Transform3D textTranslation6;
			TransformGroup objScale6 = new TransformGroup();
			
		    Shape3D ObjetoTexto6 = new Text2D(""+df.format((index*6)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app5 = ObjetoTexto6.getAppearance();
			app5.setPolygonAttributes(DobleLetras());
			
			textTranslation6 = new Transform3D();
		    textTranslation6.setTranslation(new Vector3f(0.44f, 0.0f, 0.42f));
		    textTranslationGroup6 = new TransformGroup(textTranslation6);
		    textTranslationGroup6.addChild(ObjetoTexto6);
		    objScale.addChild(textTranslationGroup6);
		    
		    objeto.addChild(objScale6);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup7;
			Transform3D textTranslation7;
			TransformGroup objScale7 = new TransformGroup();
			
		    Shape3D ObjetoTexto7 = new Text2D(""+df.format((index*7)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app6 = ObjetoTexto7.getAppearance();
			app6.setPolygonAttributes(DobleLetras());
			
			textTranslation7 = new Transform3D();
		    textTranslation7.setTranslation(new Vector3f(0.52f, 0.0f, 0.49f));
		    textTranslationGroup7 = new TransformGroup(textTranslation7);
		    textTranslationGroup7.addChild(ObjetoTexto7);
		    objScale.addChild(textTranslationGroup7);
		    
		    objeto.addChild(objScale7);
		    
		    
		    

		    TransformGroup textTranslationGroup8;
			Transform3D textTranslation8;
			TransformGroup objScale8 = new TransformGroup();
			
		    Shape3D ObjetoTexto8 = new Text2D(""+df.format((index*8)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app7 = ObjetoTexto8.getAppearance();
			app7.setPolygonAttributes(DobleLetras());
			
			textTranslation8 = new Transform3D();
		    textTranslation8.setTranslation(new Vector3f(0.60f, 0.0f, 0.56f));
		    textTranslationGroup8 = new TransformGroup(textTranslation8);
		    textTranslationGroup8.addChild(ObjetoTexto8);
		    objScale.addChild(textTranslationGroup8);
		    
		    objeto.addChild(objScale8);
		    

		    
		    TransformGroup textTranslationGroup9;
			Transform3D textTranslation9;
			TransformGroup objScale9 = new TransformGroup();
			
		    Shape3D ObjetoTexto9 = new Text2D(""+df.format((index*9)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app8 = ObjetoTexto9.getAppearance();
			app8.setPolygonAttributes(DobleLetras());
			
			textTranslation9 = new Transform3D();
		    textTranslation9.setTranslation(new Vector3f(0.67f, 0.0f, 0.63f));
		    textTranslationGroup9 = new TransformGroup(textTranslation9);
		    textTranslationGroup9.addChild(ObjetoTexto9);
		    objScale.addChild(textTranslationGroup9);
		    
		    objeto.addChild(objScale9);
		    
		    

		    TransformGroup textTranslationGroup10;
			Transform3D textTranslation10;
			TransformGroup objScale10 = new TransformGroup();
			
		    Shape3D ObjetoTexto10 = new Text2D(""+df.format((index*10)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app9 = ObjetoTexto10.getAppearance();
			app9.setPolygonAttributes(DobleLetras());
			
			textTranslation10 = new Transform3D();
		    textTranslation10.setTranslation(new Vector3f(0.74f, 0.0f, 0.70f));
		    textTranslationGroup10 = new TransformGroup(textTranslation10);
		    textTranslationGroup10.addChild(ObjetoTexto10);
		    objScale.addChild(textTranslationGroup10);
		    
		    objeto.addChild(objScale10);
		    
		    
		    
		    
		}
		

		public void VectorZ(BranchGroup objeto, float Tamaño){
			
			float index = Tamaño/10;
			
			
			
			TransformGroup textTranslationGroup;
			Transform3D textTranslation;
			TransformGroup objScale = new TransformGroup();
		
			
			
			Shape3D ObjetoTexto1 = new Text2D(""+df.format((index*1)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
			Appearance app = ObjetoTexto1.getAppearance();
			app.setPolygonAttributes(DobleLetras());
			
			textTranslation = new Transform3D();
		    textTranslation.setTranslation(new Vector3f(-0.10f, 0.0f, 0.07f));
		    textTranslationGroup = new TransformGroup(textTranslation);
		    textTranslationGroup.addChild(ObjetoTexto1);
		    objScale.addChild(textTranslationGroup);
		    
		    objeto.addChild(objScale);
			
		    
		    
		    
		    TransformGroup textTranslationGroup2;
			Transform3D textTranslation2;
			TransformGroup objScale2 = new TransformGroup();
			
		    Shape3D ObjetoTexto2 = new Text2D(""+df.format((index*2)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app1 = ObjetoTexto2.getAppearance();
			app1.setPolygonAttributes(DobleLetras());
			
			textTranslation2 = new Transform3D();
		    textTranslation2.setTranslation(new Vector3f(-0.17f, 0.0f, 0.14f));
		    textTranslationGroup2 = new TransformGroup(textTranslation2);
		    textTranslationGroup2.addChild(ObjetoTexto2);
		    objScale.addChild(textTranslationGroup2);
		    
		    objeto.addChild(objScale2);
		    
		    
		    
		    TransformGroup textTranslationGroup3;
			Transform3D textTranslation3;
			TransformGroup objScale3 = new TransformGroup();
			
		    Shape3D ObjetoTexto3 = new Text2D(""+df.format((index*3)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app2 = ObjetoTexto3.getAppearance();
			app2.setPolygonAttributes(DobleLetras());
			
			textTranslation3 = new Transform3D();
		    textTranslation3.setTranslation(new Vector3f(-0.24f, 0.0f, 0.21f));
		    textTranslationGroup3 = new TransformGroup(textTranslation3);
		    textTranslationGroup3.addChild(ObjetoTexto3);
		    objScale.addChild(textTranslationGroup3);
		    
		    objeto.addChild(objScale3);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup4;
			Transform3D textTranslation4;
			TransformGroup objScale4 = new TransformGroup();
			
			
		    Shape3D ObjetoTexto4 = new Text2D(""+df.format((index*4)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app3 = ObjetoTexto4.getAppearance();
			app3.setPolygonAttributes(DobleLetras());
			
			textTranslation4 = new Transform3D();
		    textTranslation4.setTranslation(new Vector3f(-0.34f, 0.0f, 0.28f));
		    textTranslationGroup4 = new TransformGroup(textTranslation4);
		    textTranslationGroup4.addChild(ObjetoTexto4);
		    objScale.addChild(textTranslationGroup4);
		    
		    objeto.addChild(objScale4);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup5;
			Transform3D textTranslation5;
			TransformGroup objScale5 = new TransformGroup();
			
		    Shape3D ObjetoTexto5 = new Text2D(""+df.format((index*5)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app4 = ObjetoTexto5.getAppearance();
			app4.setPolygonAttributes(DobleLetras());
			
			textTranslation5 = new Transform3D();
		    textTranslation5.setTranslation(new Vector3f(-0.38f, 0.0f, 0.35f));
		    textTranslationGroup5 = new TransformGroup(textTranslation5);
		    textTranslationGroup5.addChild(ObjetoTexto5);
		    objScale.addChild(textTranslationGroup5);
		    
		    objeto.addChild(objScale5);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup6;
			Transform3D textTranslation6;
			TransformGroup objScale6 = new TransformGroup();
			
		    Shape3D ObjetoTexto6 = new Text2D(""+df.format((index*6)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app5 = ObjetoTexto6.getAppearance();
			app5.setPolygonAttributes(DobleLetras());
			
			textTranslation6 = new Transform3D();
		    textTranslation6.setTranslation(new Vector3f(-0.45f, 0.0f, 0.42f));
		    textTranslationGroup6 = new TransformGroup(textTranslation6);
		    textTranslationGroup6.addChild(ObjetoTexto6);
		    objScale.addChild(textTranslationGroup6);
		    
		    objeto.addChild(objScale6);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup7;
			Transform3D textTranslation7;
			TransformGroup objScale7 = new TransformGroup();
			
		    Shape3D ObjetoTexto7 = new Text2D(""+df.format((index*7)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app6 = ObjetoTexto7.getAppearance();
			app6.setPolygonAttributes(DobleLetras());
			
			textTranslation7 = new Transform3D();
		    textTranslation7.setTranslation(new Vector3f(-0.51f, 0.0f, 0.49f));
		    textTranslationGroup7 = new TransformGroup(textTranslation7);
		    textTranslationGroup7.addChild(ObjetoTexto7);
		    objScale.addChild(textTranslationGroup7);
		    
		    objeto.addChild(objScale7);
		
		    
		    TransformGroup textTranslationGroup8;
			Transform3D textTranslation8;
			TransformGroup objScale8 = new TransformGroup();
			
		    Shape3D ObjetoTexto8 = new Text2D(""+(df.format(index*8)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app7 = ObjetoTexto8.getAppearance();
			app7.setPolygonAttributes(DobleLetras());
			
			textTranslation8 = new Transform3D();
		    textTranslation8.setTranslation(new Vector3f(-0.60f, 0.0f, 0.56f));
		    textTranslationGroup8 = new TransformGroup(textTranslation8);
		    textTranslationGroup8.addChild(ObjetoTexto8);
		    objScale.addChild(textTranslationGroup8);
		    
		    objeto.addChild(objScale8);
		    
		    
		    
		    
		    TransformGroup textTranslationGroup9;
			Transform3D textTranslation9;
			TransformGroup objScale9 = new TransformGroup();
			
		    Shape3D ObjetoTexto9 = new Text2D(""+df.format((index*9)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app8 = ObjetoTexto9.getAppearance();
			app8.setPolygonAttributes(DobleLetras());
			
			textTranslation9 = new Transform3D();
		    textTranslation9.setTranslation(new Vector3f(-0.66f, 0.0f, 0.63f));
		    textTranslationGroup9 = new TransformGroup(textTranslation9);
		    textTranslationGroup9.addChild(ObjetoTexto9);
		    objScale.addChild(textTranslationGroup9);
		    
		    objeto.addChild(objScale9);
		    
		    
		    TransformGroup textTranslationGroup10;
			Transform3D textTranslation10;
			TransformGroup objScale10 = new TransformGroup();
			
		    Shape3D ObjetoTexto10 = new Text2D(""+df.format((index*10)), new Color3f(0.0f, 0.0f, 0.0f), "Serif", 16, Font.BOLD);
		    Appearance app9 = ObjetoTexto10.getAppearance();
			app9.setPolygonAttributes(DobleLetras());
			
			textTranslation10 = new Transform3D();
		    textTranslation10.setTranslation(new Vector3f(-0.75f, 0.0f, 0.70f));
		    textTranslationGroup10 = new TransformGroup(textTranslation10);
		    textTranslationGroup10.addChild(ObjetoTexto10);
		    objScale.addChild(textTranslationGroup10);
		    
		    objeto.addChild(objScale10);
		    
		    
		}



	//Cono para la forma de flecha de los ejes


		public void ConoY(BranchGroup objetocono){
			
			//Cono Eje Y
			
			Transform3D coneTranslation = new Transform3D();
			TransformGroup coneTranslationGroup;
			TransformGroup objCono = new TransformGroup();
			
			
			Cone cone = new Cone(0.02f, 0.07f);
			Appearance app = new Appearance();
			//Color del cono
			ColoringAttributes ca = new ColoringAttributes((float) 1.0, (float) 0.0, (float) 0.0, ColoringAttributes.SHADE_GOURAUD);
			app.setColoringAttributes(ca);
			cone.setAppearance(app);
			coneTranslation.setTranslation(new Vector3f(0.0f, 1.03f, 0.0f));
			coneTranslationGroup = new TransformGroup(coneTranslation);
			coneTranslationGroup.addChild(cone);
		    objCono.addChild(coneTranslationGroup);
			objetocono.addChild(objCono);
	
			
			//Cono Eje X
			
			Transform3D coneTranslation1 = new Transform3D();
			TransformGroup coneTranslationGroup1;
			TransformGroup objCono1 = new TransformGroup();
			
			Cone cone1 = new Cone(0.02f, 0.07f);
			Appearance app1 = new Appearance();
			ColoringAttributes ca1 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app1.setColoringAttributes(ca1);
			cone1.setAppearance(app1);
			coneTranslation1.setTranslation(new Vector3f(1.03f, 0.0f, 0.0f));
			coneTranslation1.setRotation(new AxisAngle4d(1.0, 1.0, 1.0, -2.0));
			coneTranslationGroup1 = new TransformGroup(coneTranslation1);
			coneTranslationGroup1.addChild(cone1);
			objCono1.addChild(coneTranslationGroup1);
			objetocono.addChild((MoverEspacio(objCono1)));

			
			//Cono Eje Z
			
			Transform3D coneTranslation2 = new Transform3D();
			TransformGroup coneTranslationGroup2;
			TransformGroup objCono2 = new TransformGroup();
			
			
			Cone cone2 = new Cone(0.02f, 0.07f);
			Appearance app2 = new Appearance();
			ColoringAttributes ca2 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			app2.setColoringAttributes(ca2);
			cone2.setAppearance(app2);
			coneTranslation2.setTranslation(new Vector3f(0.0f, 0.0f, 1.03f));
			coneTranslation2.setRotation(new AxisAngle4d(1.0, 1.0, 1.0, 2.0));
			coneTranslationGroup2 = new TransformGroup(coneTranslation2);
			coneTranslationGroup2.addChild(cone2);
			objCono2.addChild(coneTranslationGroup2);
			objetocono.addChild((MoverEspacio(objCono2)));
			
			
			
			
		}
		
		
		public void EsferasPlano(BranchGroup ObjEsfera){
			
			//Esferas para el EJE X
			
			Transform3D EsferaTranslation = new Transform3D();
			TransformGroup EsferaTranslationGroup;
			TransformGroup objetoEsfera = new TransformGroup();
		
			Sphere esfera = new Sphere(0.01f);
			Appearance app = new Appearance();
			ColoringAttributes esf = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app.setColoringAttributes(esf);
			esfera.setAppearance(app);
			EsferaTranslation.setTranslation(new Vector3f(0.1f, 0f, 0.0f));
			EsferaTranslationGroup = new TransformGroup(EsferaTranslation);
			EsferaTranslationGroup.addChild(esfera);
			objetoEsfera.addChild(EsferaTranslationGroup);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera));
			
			

			Transform3D EsferaTranslation1 = new Transform3D();
			TransformGroup EsferaTranslationGroup1;
			TransformGroup objetoEsfera1 = new TransformGroup();
		
			Sphere esfera1 = new Sphere(0.01f);
			Appearance app1 = new Appearance();
			ColoringAttributes esf1 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app1.setColoringAttributes(esf1);
			esfera1.setAppearance(app1);
			EsferaTranslation1.setTranslation(new Vector3f(0.2f, 0f, 0.0f));
			EsferaTranslationGroup1 = new TransformGroup(EsferaTranslation1);
			EsferaTranslationGroup1.addChild(esfera1);
			objetoEsfera1.addChild(EsferaTranslationGroup1);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera1));
			
			
			
			Transform3D EsferaTranslation2 = new Transform3D();
			TransformGroup EsferaTranslationGroup2;
			TransformGroup objetoEsfera2 = new TransformGroup();
		
			Sphere esfera2 = new Sphere(0.01f);
			Appearance app2 = new Appearance();
			ColoringAttributes esf2 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app2.setColoringAttributes(esf2);
			esfera2.setAppearance(app2);
			EsferaTranslation2.setTranslation(new Vector3f(0.3f, 0f, 0.0f));
			EsferaTranslationGroup2 = new TransformGroup(EsferaTranslation2);
			EsferaTranslationGroup2.addChild(esfera2);
			objetoEsfera2.addChild(EsferaTranslationGroup2);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera2));
			
			
			
			Transform3D EsferaTranslation3 = new Transform3D();
			TransformGroup EsferaTranslationGroup3;
			TransformGroup objetoEsfera3 = new TransformGroup();
		
			Sphere esfera3 = new Sphere(0.01f);
			Appearance app3 = new Appearance();
			ColoringAttributes esf3 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app3.setColoringAttributes(esf3);
			esfera3.setAppearance(app3);
			EsferaTranslation3.setTranslation(new Vector3f(0.4f, 0f, 0.0f));
			EsferaTranslationGroup3 = new TransformGroup(EsferaTranslation3);
			EsferaTranslationGroup3.addChild(esfera3);
			objetoEsfera3.addChild(EsferaTranslationGroup3);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera3));
			
			
			
			Transform3D EsferaTranslation4 = new Transform3D();
			TransformGroup EsferaTranslationGroup4;
			TransformGroup objetoEsfera4 = new TransformGroup();
		
			Sphere esfera4 = new Sphere(0.01f);
			Appearance app4 = new Appearance();
			ColoringAttributes esf4 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app4.setColoringAttributes(esf4);
			esfera4.setAppearance(app4);
			EsferaTranslation4.setTranslation(new Vector3f(0.5f, 0f, 0.0f));
			EsferaTranslationGroup4 = new TransformGroup(EsferaTranslation4);
			EsferaTranslationGroup4.addChild(esfera4);
			objetoEsfera4.addChild(EsferaTranslationGroup4);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera4));
			
			
			
			Transform3D EsferaTranslation5 = new Transform3D();
			TransformGroup EsferaTranslationGroup5;
			TransformGroup objetoEsfera5 = new TransformGroup();
		
			Sphere esfera5 = new Sphere(0.01f);
			Appearance app5 = new Appearance();
			ColoringAttributes esf5 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app5.setColoringAttributes(esf5);
			esfera5.setAppearance(app5);
			EsferaTranslation5.setTranslation(new Vector3f(0.6f, 0f, 0.0f));
			EsferaTranslationGroup5 = new TransformGroup(EsferaTranslation5);
			EsferaTranslationGroup5.addChild(esfera5);
			objetoEsfera5.addChild(EsferaTranslationGroup5);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera5));
			
			
			
			Transform3D EsferaTranslation6 = new Transform3D();
			TransformGroup EsferaTranslationGroup6;
			TransformGroup objetoEsfera6 = new TransformGroup();
		
			Sphere esfera6 = new Sphere(0.01f);
			Appearance app6 = new Appearance();
			ColoringAttributes esf6 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app6.setColoringAttributes(esf6);
			esfera6.setAppearance(app6);
			EsferaTranslation6.setTranslation(new Vector3f(0.7f, 0f, 0.0f));
			EsferaTranslationGroup6 = new TransformGroup(EsferaTranslation6);
			EsferaTranslationGroup6.addChild(esfera6);
			objetoEsfera6.addChild(EsferaTranslationGroup6);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera6));
			
			
			
			Transform3D EsferaTranslation7 = new Transform3D();
			TransformGroup EsferaTranslationGroup7;
			TransformGroup objetoEsfera7= new TransformGroup();
		
			Sphere esfera7 = new Sphere(0.01f);
			Appearance app7 = new Appearance();
			ColoringAttributes esf7 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app7.setColoringAttributes(esf7);
			esfera7.setAppearance(app7);
			EsferaTranslation7.setTranslation(new Vector3f(0.8f, 0f, 0.0f));
			EsferaTranslationGroup7 = new TransformGroup(EsferaTranslation7);
			EsferaTranslationGroup7.addChild(esfera7);
			objetoEsfera7.addChild(EsferaTranslationGroup7);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera7));
			
			
			
			Transform3D EsferaTranslation8 = new Transform3D();
			TransformGroup EsferaTranslationGroup8;
			TransformGroup objetoEsfera8 = new TransformGroup();
		
			Sphere esfera8 = new Sphere(0.01f);
			Appearance app8 = new Appearance();
			ColoringAttributes esf8 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app8.setColoringAttributes(esf8);
			esfera8.setAppearance(app8);
			EsferaTranslation8.setTranslation(new Vector3f(0.9f, 0f, 0.0f));
			EsferaTranslationGroup8 = new TransformGroup(EsferaTranslation8);
			EsferaTranslationGroup8.addChild(esfera8);
			objetoEsfera8.addChild(EsferaTranslationGroup8);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera8));
			
			
			
			Transform3D EsferaTranslation9 = new Transform3D();
			TransformGroup EsferaTranslationGroup9;
			TransformGroup objetoEsfera9 = new TransformGroup();
		
			Sphere esfera9 = new Sphere(0.01f);
			Appearance app9 = new Appearance();
			ColoringAttributes esf9 = new ColoringAttributes( 0.0f,  1.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			app9.setColoringAttributes(esf9);
			esfera9.setAppearance(app9);
			EsferaTranslation9.setTranslation(new Vector3f(1.0f, 0f, 0.0f));
			EsferaTranslationGroup9 = new TransformGroup(EsferaTranslation9);
			EsferaTranslationGroup9.addChild(esfera9);
			objetoEsfera9.addChild(EsferaTranslationGroup9);
			ObjEsfera.addChild(MoverEspacio(objetoEsfera9));
			
			// Esferas para el eje Y
			
			Transform3D EsferaTranslationY = new Transform3D();
			TransformGroup EsferaTranslationGroupY;
			TransformGroup objetoEsferaY = new TransformGroup();
		
			Sphere esferaY = new Sphere(0.01f);
			Appearance appY = new Appearance();
			ColoringAttributes esfY = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY.setColoringAttributes(esfY);
			esferaY.setAppearance(appY);
			EsferaTranslationY.setTranslation(new Vector3f(0.0f, 0.1f, 0.0f));
			EsferaTranslationGroupY = new TransformGroup(EsferaTranslationY);
			EsferaTranslationGroupY.addChild(esferaY);
			objetoEsferaY.addChild(EsferaTranslationGroupY);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY));
			
			
			
			Transform3D EsferaTranslationY1 = new Transform3D();
			TransformGroup EsferaTranslationGroupY1;
			TransformGroup objetoEsferaY1 = new TransformGroup();
		
			Sphere esferaY1 = new Sphere(0.01f);
			Appearance appY1 = new Appearance();
			ColoringAttributes esfY1 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY1.setColoringAttributes(esfY1);
			esferaY1.setAppearance(appY1);
			EsferaTranslationY1.setTranslation(new Vector3f(0.0f, 0.2f, 0.0f));
			EsferaTranslationGroupY1 = new TransformGroup(EsferaTranslationY1);
			EsferaTranslationGroupY1.addChild(esferaY1);
			objetoEsferaY1.addChild(EsferaTranslationGroupY1);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY1));
			
			
			
			Transform3D EsferaTranslationY2 = new Transform3D();
			TransformGroup EsferaTranslationGroupY2;
			TransformGroup objetoEsferaY2 = new TransformGroup();
		
			Sphere esferaY2 = new Sphere(0.01f);
			Appearance appY2 = new Appearance();
			ColoringAttributes esfY2 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY2.setColoringAttributes(esfY2);
			esferaY2.setAppearance(appY2);
			EsferaTranslationY2.setTranslation(new Vector3f(0.0f, 0.3f, 0.0f));
			EsferaTranslationGroupY2 = new TransformGroup(EsferaTranslationY2);
			EsferaTranslationGroupY2.addChild(esferaY2);
			objetoEsferaY2.addChild(EsferaTranslationGroupY2);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY2));
			
			
			
			Transform3D EsferaTranslationY3 = new Transform3D();
			TransformGroup EsferaTranslationGroupY3;
			TransformGroup objetoEsferaY3 = new TransformGroup();
		
			Sphere esferaY3 = new Sphere(0.01f);
			Appearance appY3 = new Appearance();
			ColoringAttributes esfY3 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY3.setColoringAttributes(esfY3);
			esferaY3.setAppearance(appY3);
			EsferaTranslationY3.setTranslation(new Vector3f(0.0f, 0.4f, 0.0f));
			EsferaTranslationGroupY3 = new TransformGroup(EsferaTranslationY3);
			EsferaTranslationGroupY3.addChild(esferaY3);
			objetoEsferaY3.addChild(EsferaTranslationGroupY3);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY3));
			
			
			
			Transform3D EsferaTranslationY4 = new Transform3D();
			TransformGroup EsferaTranslationGroupY4;
			TransformGroup objetoEsferaY4 = new TransformGroup();
		
			Sphere esferaY4 = new Sphere(0.01f);
			Appearance appY4 = new Appearance();
			ColoringAttributes esfY4 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY4.setColoringAttributes(esfY4);
			esferaY4.setAppearance(appY4);
			EsferaTranslationY4.setTranslation(new Vector3f(0.0f, 0.5f, 0.0f));
			EsferaTranslationGroupY4 = new TransformGroup(EsferaTranslationY4);
			EsferaTranslationGroupY4.addChild(esferaY4);
			objetoEsferaY4.addChild(EsferaTranslationGroupY4);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY4));
			
			
			
			Transform3D EsferaTranslationY5 = new Transform3D();
			TransformGroup EsferaTranslationGroupY5;
			TransformGroup objetoEsferaY5 = new TransformGroup();
		
			Sphere esferaY5 = new Sphere(0.01f);
			Appearance appY5 = new Appearance();
			ColoringAttributes esfY5 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY5.setColoringAttributes(esfY5);
			esferaY5.setAppearance(appY5);
			EsferaTranslationY5.setTranslation(new Vector3f(0.0f, 0.6f, 0.0f));
			EsferaTranslationGroupY5 = new TransformGroup(EsferaTranslationY5);
			EsferaTranslationGroupY5.addChild(esferaY5);
			objetoEsferaY5.addChild(EsferaTranslationGroupY5);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY5));
			
			
			
			Transform3D EsferaTranslationY6 = new Transform3D();
			TransformGroup EsferaTranslationGroupY6;
			TransformGroup objetoEsferaY6 = new TransformGroup();
		
			Sphere esferaY6 = new Sphere(0.01f);
			Appearance appY6 = new Appearance();
			ColoringAttributes esfY6 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY6.setColoringAttributes(esfY6);
			esferaY6.setAppearance(appY6);
			EsferaTranslationY6.setTranslation(new Vector3f(0.0f, 0.7f, 0.0f));
			EsferaTranslationGroupY6 = new TransformGroup(EsferaTranslationY6);
			EsferaTranslationGroupY6.addChild(esferaY6);
			objetoEsferaY6.addChild(EsferaTranslationGroupY6);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY6));
			
			
			
			Transform3D EsferaTranslationY7 = new Transform3D();
			TransformGroup EsferaTranslationGroupY7;
			TransformGroup objetoEsferaY7 = new TransformGroup();
		
			Sphere esferaY7 = new Sphere(0.01f);
			Appearance appY7 = new Appearance();
			ColoringAttributes esfY7 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY7.setColoringAttributes(esfY7);
			esferaY7.setAppearance(appY7);
			EsferaTranslationY7.setTranslation(new Vector3f(0.0f, 0.8f, 0.0f));
			EsferaTranslationGroupY7 = new TransformGroup(EsferaTranslationY7);
			EsferaTranslationGroupY7.addChild(esferaY7);
			objetoEsferaY7.addChild(EsferaTranslationGroupY7);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY7));
			
			
			
			Transform3D EsferaTranslationY8 = new Transform3D();
			TransformGroup EsferaTranslationGroupY8;
			TransformGroup objetoEsferaY8 = new TransformGroup();
		
			Sphere esferaY8 = new Sphere(0.01f);
			Appearance appY8 = new Appearance();
			ColoringAttributes esfY8 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY8.setColoringAttributes(esfY8);
			esferaY8.setAppearance(appY8);
			EsferaTranslationY8.setTranslation(new Vector3f(0.0f, 0.9f, 0.0f));
			EsferaTranslationGroupY8 = new TransformGroup(EsferaTranslationY8);
			EsferaTranslationGroupY8.addChild(esferaY8);
			objetoEsferaY8.addChild(EsferaTranslationGroupY8);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY8));
			
			
			
			Transform3D EsferaTranslationY9 = new Transform3D();
			TransformGroup EsferaTranslationGroupY9;
			TransformGroup objetoEsferaY9 = new TransformGroup();
		
			Sphere esferaY9 = new Sphere(0.01f);
			Appearance appY9 = new Appearance();
			ColoringAttributes esfY9 = new ColoringAttributes( 1.0f,  0.0f,  0.0f, ColoringAttributes.SHADE_GOURAUD);
			appY9.setColoringAttributes(esfY9);
			esferaY9.setAppearance(appY9);
			EsferaTranslationY9.setTranslation(new Vector3f(0.0f, 1.0f, 0.0f));
			EsferaTranslationGroupY9 = new TransformGroup(EsferaTranslationY9);
			EsferaTranslationGroupY9.addChild(esferaY9);
			objetoEsferaY9.addChild(EsferaTranslationGroupY9);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaY9));
			
	
			//Esferas para el Eje Z
			
			Transform3D EsferaTranslationZ = new Transform3D();
			TransformGroup EsferaTranslationGroupZ;
			TransformGroup objetoEsferaZ = new TransformGroup();
		
			Sphere esferaZ = new Sphere(0.01f);
			Appearance appZ = new Appearance();
			ColoringAttributes esfZ = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ.setColoringAttributes(esfZ);
			esferaZ.setAppearance(appZ);
			EsferaTranslationZ.setTranslation(new Vector3f(0.0f, 0.0f, 0.1f));
			EsferaTranslationGroupZ = new TransformGroup(EsferaTranslationZ);
			EsferaTranslationGroupZ.addChild(esferaZ);
			objetoEsferaZ.addChild(EsferaTranslationGroupZ);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ));
			
			
			
			Transform3D EsferaTranslationZ1 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ1;
			TransformGroup objetoEsferaZ1 = new TransformGroup();
		
			Sphere esferaZ1 = new Sphere(0.01f);
			Appearance appZ1 = new Appearance();
			ColoringAttributes esfZ1 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ1.setColoringAttributes(esfZ1);
			esferaZ1.setAppearance(appZ1);
			EsferaTranslationZ1.setTranslation(new Vector3f(0.0f, 0.0f, 0.2f));
			EsferaTranslationGroupZ1 = new TransformGroup(EsferaTranslationZ1);
			EsferaTranslationGroupZ1.addChild(esferaZ1);
			objetoEsferaZ1.addChild(EsferaTranslationGroupZ1);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ1));
			
			
			
			Transform3D EsferaTranslationZ2 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ2;
			TransformGroup objetoEsferaZ2 = new TransformGroup();
		
			Sphere esferaZ2 = new Sphere(0.01f);
			Appearance appZ2 = new Appearance();
			ColoringAttributes esfZ2 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ2.setColoringAttributes(esfZ2);
			esferaZ2.setAppearance(appZ2);
			EsferaTranslationZ2.setTranslation(new Vector3f(0.0f, 0.0f, 0.3f));
			EsferaTranslationGroupZ2 = new TransformGroup(EsferaTranslationZ2);
			EsferaTranslationGroupZ2.addChild(esferaZ2);
			objetoEsferaZ2.addChild(EsferaTranslationGroupZ2);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ2));
			
			
			
			Transform3D EsferaTranslationZ3 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ3;
			TransformGroup objetoEsferaZ3 = new TransformGroup();
		
			Sphere esferaZ3 = new Sphere(0.01f);
			Appearance appZ3 = new Appearance();
			ColoringAttributes esfZ3 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ3.setColoringAttributes(esfZ3);
			esferaZ3.setAppearance(appZ3);
			EsferaTranslationZ3.setTranslation(new Vector3f(0.0f, 0.0f, 0.4f));
			EsferaTranslationGroupZ3 = new TransformGroup(EsferaTranslationZ3);
			EsferaTranslationGroupZ3.addChild(esferaZ3);
			objetoEsferaZ3.addChild(EsferaTranslationGroupZ3);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ3));
			
			
			
			Transform3D EsferaTranslationZ4 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ4;
			TransformGroup objetoEsferaZ4 = new TransformGroup();
		
			Sphere esferaZ4 = new Sphere(0.01f);
			Appearance appZ4 = new Appearance();
			ColoringAttributes esfZ4 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ4.setColoringAttributes(esfZ4);
			esferaZ4.setAppearance(appZ4);
			EsferaTranslationZ4.setTranslation(new Vector3f(0.0f, 0.0f, 0.5f));
			EsferaTranslationGroupZ4 = new TransformGroup(EsferaTranslationZ4);
			EsferaTranslationGroupZ4.addChild(esferaZ4);
			objetoEsferaZ4.addChild(EsferaTranslationGroupZ4);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ4));
			
			
			
			Transform3D EsferaTranslationZ5 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ5;
			TransformGroup objetoEsferaZ5 = new TransformGroup();
		
			Sphere esferaZ5 = new Sphere(0.01f);
			Appearance appZ5 = new Appearance();
			ColoringAttributes esfZ5 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ5.setColoringAttributes(esfZ5);
			esferaZ5.setAppearance(appZ5);
			EsferaTranslationZ5.setTranslation(new Vector3f(0.0f, 0.0f, 0.6f));
			EsferaTranslationGroupZ5 = new TransformGroup(EsferaTranslationZ5);
			EsferaTranslationGroupZ5.addChild(esferaZ5);
			objetoEsferaZ5.addChild(EsferaTranslationGroupZ5);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ5));
			
			
			
			Transform3D EsferaTranslationZ6 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ6;
			TransformGroup objetoEsferaZ6 = new TransformGroup();
		
			Sphere esferaZ6 = new Sphere(0.01f);
			Appearance appZ6 = new Appearance();
			ColoringAttributes esfZ6 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ6.setColoringAttributes(esfZ6);
			esferaZ6.setAppearance(appZ6);
			EsferaTranslationZ6.setTranslation(new Vector3f(0.0f, 0.0f, 0.7f));
			EsferaTranslationGroupZ6 = new TransformGroup(EsferaTranslationZ6);
			EsferaTranslationGroupZ6.addChild(esferaZ6);
			objetoEsferaZ6.addChild(EsferaTranslationGroupZ6);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ6));
			
			
			
			Transform3D EsferaTranslationZ7 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ7;
			TransformGroup objetoEsferaZ7 = new TransformGroup();

			Sphere esferaZ7 = new Sphere(0.01f);
			Appearance appZ7 = new Appearance();
			ColoringAttributes esfZ7 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ7.setColoringAttributes(esfZ7);
			esferaZ7.setAppearance(appZ7);
			EsferaTranslationZ7.setTranslation(new Vector3f(0.0f, 0.0f, 0.8f));
			EsferaTranslationGroupZ7 = new TransformGroup(EsferaTranslationZ7);
			EsferaTranslationGroupZ7.addChild(esferaZ7);
			objetoEsferaZ7.addChild(EsferaTranslationGroupZ7);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ7));
			
			
			
			Transform3D EsferaTranslationZ8 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ8;
			TransformGroup objetoEsferaZ8 = new TransformGroup();
		
			Sphere esferaZ8 = new Sphere(0.01f);
			Appearance appZ8 = new Appearance();
			ColoringAttributes esfZ8 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ8.setColoringAttributes(esfZ8);
			esferaZ8.setAppearance(appZ8);
			EsferaTranslationZ8.setTranslation(new Vector3f(0.0f, 0.0f, 0.9f));
			EsferaTranslationGroupZ8 = new TransformGroup(EsferaTranslationZ8);
			EsferaTranslationGroupZ8.addChild(esferaZ8);
			objetoEsferaZ8.addChild(EsferaTranslationGroupZ8);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ8));
			
			
			
			Transform3D EsferaTranslationZ9 = new Transform3D();
			TransformGroup EsferaTranslationGroupZ9;
			TransformGroup objetoEsferaZ9 = new TransformGroup();
			
			Sphere esferaZ9 = new Sphere(0.01f);
			Appearance appZ9 = new Appearance();
			ColoringAttributes esfZ9 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			appZ9.setColoringAttributes(esfZ9);
			esferaZ9.setAppearance(appZ9);
			EsferaTranslationZ9.setTranslation(new Vector3f(0.0f, 0.0f, 1.0f));
			EsferaTranslationGroupZ9 = new TransformGroup(EsferaTranslationZ9);
			EsferaTranslationGroupZ9.addChild(esferaZ9);
			objetoEsferaZ9.addChild(EsferaTranslationGroupZ9);
			ObjEsfera.addChild(MoverEspacio(objetoEsferaZ9));
		}
	

		public TransformGroup MoverEspacio(Node nodo){
		
			
			Transform3D rotar = new Transform3D();
			Transform3D temprotar = new Transform3D();
			
			temprotar.rotY(Math.PI/-4.0f);
            rotar.mul(temprotar);
			TransformGroup objrotado = new TransformGroup(rotar);
			objrotado.addChild(nodo);
			return objrotado;
			
		}
		
}
