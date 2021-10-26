package Modelo;

import java.text.DecimalFormat;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.LineArray;
import javax.media.j3d.Node;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.Cone;

public class Vector {
	
	private Puntos p1;
	private Puntos p2;
	private static int numero=1;
	private int n = numero;
	private double VectorResultX, VectorResultY, VectorResultZ;
	
	DecimalFormat df = new DecimalFormat("0.0");
		
		
		public Vector (Puntos p1, Puntos p2){
			
			this.p1 = p1;
			this.p2 = p2;
			
			numero++;
			
			VectorResultX = (getP2().getX()-getP1().getX()) ;
			VectorResultY = (getP2().getY()-getP1().getY()) ;
			VectorResultZ = (getP2().getZ()-getP1().getZ()) ;
			
			
		}
		
		
		
		
		public Node CrearVector(float tamaño){
			
			LineArray línea = new LineArray(2, TriangleArray.COORDINATES|
	                TriangleArray.COLOR_3);

			//lineas de Vector
			línea.setCoordinate(0, new Point3f( ((getP1().getX())/tamaño), ((getP1().getY())/tamaño), ((getP1().getZ())/tamaño)));
			línea.setCoordinate(1, new Point3f( ((getP2().getX())/tamaño), ((getP2().getY())/tamaño), ((getP2().getZ())/tamaño)));
			
			línea.setColor(0, new Color3f(0.0f,0.0f,1.0f)); // Azul
			línea.setColor(1, new Color3f(0.0f, 0.0f, 1.0f)); 
			
			Shape3D forma = new Shape3D(línea);
			  
			Transform3D rotar = new Transform3D();
		    Transform3D temprotar = new Transform3D();
				
			temprotar.rotY(Math.PI/-4.0d);
	        rotar.mul(temprotar);
	        	
			TransformGroup objrotado = new TransformGroup(rotar);
			objrotado.addChild(forma);
				
			return objrotado;
			
			
		}
		
		public Node CrearCono(float tamaño){
			
			Transform3D coneTranslation;
			Transform3D coneTranslationX;
			Transform3D coneTranslationY;
			Transform3D coneTranslationZ;
			TransformGroup coneTranslationGroup1;
			TransformGroup objCono1 = new TransformGroup();
			
			Cone cone1 = new Cone(0.02f, 0.07f);
			Appearance app1 = new Appearance();
			ColoringAttributes ca1 = new ColoringAttributes( 0.0f,  0.0f,  1.0f, ColoringAttributes.SHADE_GOURAUD);
			app1.setColoringAttributes(ca1);
			cone1.setAppearance(app1);
			coneTranslationX = new Transform3D();
			coneTranslationX.rotX(Math.PI/0.62);
			coneTranslationY = new Transform3D(coneTranslationX);
			coneTranslationY.rotY(Math.PI/2.08);
			coneTranslationZ = new Transform3D();
			coneTranslationZ.rotZ(Math.PI/-1.24);
			coneTranslation = new Transform3D(coneTranslationZ);
			coneTranslation.setTranslation(new Vector3f((getP2().getX())/tamaño, ((getP2().getY()))/tamaño, ((getP2().getZ()))/tamaño));
			coneTranslationGroup1 = new TransformGroup(coneTranslation);
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
			
			return "V"+n+"("+df.format(VectorResultX)+";"+df.format(VectorResultY)+";"+df.format(VectorResultZ)+")";
		}
	


		public Puntos getP1() {
			return p1;
		}




		public void setP1(Puntos p1) {
			this.p1 = p1;
		}




		public Puntos getP2() {
			return p2;
		}




		public void setP2(Puntos p2) {
			this.p2 = p2;
		}




		public double getVectorResultX() {
			return VectorResultX;
		}




		public void setVectorResultX(double vectorResultX) {
			VectorResultX = vectorResultX;
		}




		public double getVectorResultY() {
			return VectorResultY;
		}




		public void setVectorResultY(double vectorResultY) {
			VectorResultY = vectorResultY;
		}




		public double getVectorResultZ() {
			return VectorResultZ;
		}




		public void setVectorResultZ(double vectorResultZ) {
			VectorResultZ = vectorResultZ;
		}
		
		
	
}
