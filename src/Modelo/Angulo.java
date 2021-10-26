package Modelo;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.media.j3d.Appearance;
import javax.media.j3d.Node;
import javax.media.j3d.PolygonAttributes;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.Text2D;

public class Angulo {
	
	private static int numero =1;
	private int n = numero;
	double ResultadoAngulo;
	private Vector v1;
	private Vector v2;
	private double ResultFinalAngulo1;
	private double ResultFinalAngulo2;
	
	DecimalFormat df = new DecimalFormat("0.0");
	
	
	public Angulo (Vector v1, Vector v2){
		
		
		this.v1 = v1;
		this.v2 = v2;
		
		numero++;
		
		double Vector1X = (v1.getP2().getX() - v1.getP1().getX());
		double Vector1Y = (v1.getP2().getY() - v1.getP1().getY());
		double Vector1Z = (v1.getP2().getZ() - v1.getP1().getZ());
		
		double Vector2X = (v2.getP2().getX() - v2.getP1().getX());
		double Vector2Y = (v2.getP2().getY() - v2.getP1().getY());
		double Vector2Z = (v2.getP2().getZ() - v2.getP1().getZ());
		
		double ResultMultipVectores = ((Vector1X*Vector2X) + (Vector1Y*Vector2Y) + (Vector1Z*Vector2Z));

		double ResultModuloVector1 = Math.sqrt(Math.pow(Vector1X, 2)+ Math.pow(Vector1Y,2)+ Math.pow(Vector1Z, 2));
		
		double ResultModuloVector2 = Math.sqrt(Math.pow(Vector2X, 2)+ Math.pow(Vector2Y,2)+ Math.pow(Vector2Z, 2));
		
		double PreAngulo = (ResultMultipVectores / (ResultModuloVector1*ResultModuloVector2));
		
		ResultFinalAngulo1 = Math.acos(PreAngulo);
		
		ResultFinalAngulo2 = Math.toDegrees(ResultFinalAngulo1);
		
		
	}

	
	public Node CrearAngulo(/*float tamaño*/){
		
		TransformGroup objScaleAngulo = new TransformGroup();
		
		Shape3D TextAngulo = new Text2D("α", new Color3f(0.5f,  1.0f,  0.5f), "Arial", 25, Font.BOLD);
		
		Appearance app = TextAngulo.getAppearance();
		app.setPolygonAttributes(VerDobleLetras());
		
		Transform3D textTranslationAngulo = new Transform3D();
	    textTranslationAngulo.setTranslation(new Vector3f(0.0f, 0.0f, 0.0f));
	    TransformGroup textTranslationGroupAngulo = new TransformGroup(textTranslationAngulo);
	    textTranslationGroupAngulo.addChild(TextAngulo);
	    objScaleAngulo.addChild(textTranslationGroupAngulo);

		return objScaleAngulo;
	}
	
	
	
	
	public PolygonAttributes VerDobleLetras(){
		
		Appearance app = new Appearance();
		
		PolygonAttributes pa = app.getPolygonAttributes();
	    if (pa == null)
	      pa = new PolygonAttributes();
	    pa.setCullFace(PolygonAttributes.CULL_NONE);
	    if (app.getPolygonAttributes() == null)
	      app.setPolygonAttributes(pa);
	    
	    return pa;
		
	}
	
	
	
	public String get() {
		
		return "α"+n+"="+""+df.format(ResultFinalAngulo2)+"°";
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public Vector getV1() {
		return v1;
	}


	public void setV1(Vector v1) {
		this.v1 = v1;
	}


	public Vector getV2() {
		return v2;
	}


	public void setV2(Vector v2) {
		this.v2 = v2;
	}
	
	
}