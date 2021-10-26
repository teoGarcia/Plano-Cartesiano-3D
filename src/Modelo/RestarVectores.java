package Modelo;

import java.text.DecimalFormat;

import javax.media.j3d.Appearance;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.LineArray;
import javax.media.j3d.Node;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.Cone;

public class RestarVectores {
	
	private static int numero =1;
	
	private double RestarVectorX;
	private double RestarVectorY;
	private double RestarVectorZ;
	private int n = numero;
	
	DecimalFormat df = new DecimalFormat("0.0");
	private Vector v1;
	private Vector v2;
	
	
	
		public RestarVectores(Vector v1, Vector v2){
		
			this.v1 = v1;
			this.v2 = v2;
			
			numero ++;
			
			RestarVectorX = (v1.getVectorResultX() - v2.getVectorResultX());
			
			RestarVectorY = (v1.getVectorResultY() - v2.getVectorResultY());
			
			RestarVectorZ = (v1.getVectorResultZ() - v2.getVectorResultZ());
			
		}
	

		public Node RestarVectores(float tamaño){
			
			LineArray línea = new LineArray(2, TriangleArray.COORDINATES|
		            TriangleArray.COLOR_3);
		
			línea.setCoordinate(0, new Point3f(0f,0f,0f));
			línea.setCoordinate(1, new Point3f(((float) RestarVectorX/tamaño) ,((float) RestarVectorY/tamaño), ((float) RestarVectorZ/tamaño)));
			
			línea.setColor(0, new Color3f(1.0f,0.0f,1.0f)); 
			línea.setColor(1, new Color3f(1.0f, 0.0f, 1.0f)); 
			
			Shape3D forma = new Shape3D(línea);
			  
			Transform3D rotar = new Transform3D();
		    Transform3D temprotar = new Transform3D();
				
			temprotar.rotY(Math.PI/-4.0d);
		    rotar.mul(temprotar);
		    	
			TransformGroup objrotado = new TransformGroup(rotar);
			objrotado.addChild(forma);
				
			return objrotado;
			
			
		}
		
		
		public Node ConoRestarVectores(){
			
			Transform3D coneTranslation1 = new Transform3D();
			TransformGroup coneTranslationGroup1;
			TransformGroup objCono1 = new TransformGroup();
			
			Cone cone1 = new Cone(0.02f, 0.07f);
			Appearance app1 = new Appearance();
			ColoringAttributes ca1 = new ColoringAttributes( 1.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			app1.setColoringAttributes(ca1);
			cone1.setAppearance(app1);
			coneTranslation1.setTranslation(new Vector3f((float)RestarVectorX,(float)RestarVectorY,(float)RestarVectorZ));
			coneTranslation1.setRotation(new AxisAngle4d(1.0, 1.0, 1.0, -2.0));
			coneTranslationGroup1 = new TransformGroup(coneTranslation1);
			coneTranslationGroup1.addChild(cone1);
			objCono1.addChild(coneTranslationGroup1);
			
			

			Transform3D rotar = new Transform3D();
		    Transform3D temprotar = new Transform3D();
				
			temprotar.rotY(Math.PI/-4.0d);
	        rotar.mul(temprotar);
	        	
			TransformGroup objrotado = new TransformGroup(rotar);
			objrotado.addChild(objCono1);
			
			
			
			return objrotado;
			
		}
		
		
		
		
	public String get() {
			
		return "RV"+n+"="+""+df.format(RestarVectorX)+","+df.format(RestarVectorY)+","+df.format(RestarVectorZ);
	}

}
