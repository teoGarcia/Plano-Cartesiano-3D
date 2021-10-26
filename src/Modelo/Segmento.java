package Modelo;

import java.math.*;

import javax.media.j3d.LineArray;
import javax.media.j3d.Node;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.TriangleArray;
import javax.vecmath.Color3f;
import javax.vecmath.Point3f;

public class Segmento {
	
	private Puntos p1;
	private Puntos p2;
	private double seg;
	private static int numero=1;
	private int n = numero;
	
	
	
		public Segmento(Puntos p1, Puntos p2){
			
			
			this.p1 = p1;
			this.p2 = p2;
			
			
			seg = Math.sqrt(Math.pow((p2.getX()-p1.getX()), 2)+Math.pow((p2.getY()-p1.getY()), 2)+Math.pow((p2.getZ()-p1.getZ()), 2)); 
			seg = Math.rint(seg*100)/100;
			
			numero++;
		}
		
		
		public Node ListarLinea(float tamaño){
			
			LineArray línea = new LineArray(2, TriangleArray.COORDINATES|
	                TriangleArray.COLOR_3);

			//lineas de ejes
			línea.setCoordinate(0, new Point3f( ((getP1().getX())/tamaño), ((getP1().getY())/tamaño), ((getP1().getZ())/tamaño)));// Eje X
			línea.setCoordinate(1, new Point3f( ((getP2().getX())/tamaño), ((getP2().getY())/tamaño), ((getP2().getZ())/tamaño)));
			
			línea.setColor(0, new Color3f(0.0f,0.0f,0.0f)); // Azul
			línea.setColor(1, new Color3f(0.0f, 0.0f, 0.0f)); 
			
			Shape3D forma = new Shape3D(línea);
			  
			Transform3D rotar = new Transform3D();
		    Transform3D temprotar = new Transform3D();
				
			temprotar.rotY(Math.PI/-4.0d);
	        rotar.mul(temprotar);
	        	
			TransformGroup objrotado = new TransformGroup(rotar);
			objrotado.addChild(forma);
				
			return objrotado;
			 
			
			
		}
		
		
		
		public String get() {
			//hola
			
			return "S"+n+"("+seg+")";
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


		public double getSeg() {
			return seg;
		}
		
	
		
	
}
