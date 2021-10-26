package Modelo;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.Node;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

import com.sun.j3d.utils.geometry.Sphere;

public class Puntos{
	
	private static int numero=1;
	private int n = numero;
	private float x;
	private float y;
	private float z;
	private TransformGroup objetoEsfera;
	
	
	public Puntos(float x, float y, float z){
		
		
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		numero++;
			
	}
	
	public void Apariencia(Sphere sphere){
		
		Appearance app = new Appearance();
		ColoringAttributes ColorEsfera = new ColoringAttributes(0.0f, 0.0f ,0.0f, ColoringAttributes.SHADE_GOURAUD);
		app.setColoringAttributes(ColorEsfera);
		sphere.setAppearance(app);
		
	}
	
	public Node getPunto(float tamaño){
		
		float x1 = x / tamaño;
		float y2 = y / tamaño;
		float z3 = z / tamaño;
		
		Transform3D EsferaTranslation = new Transform3D();
		TransformGroup EsferaTranslationGroup;
		TransformGroup objetoEsfera = new TransformGroup();
		
		EsferaTranslation.setTranslation(new Vector3f(x1, y2, z3));
		EsferaTranslationGroup = new TransformGroup(EsferaTranslation);
		Sphere sphere = new Sphere(0.01f);
		Apariencia(sphere);
		EsferaTranslationGroup.addChild(sphere);
		objetoEsfera.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		objetoEsfera.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objetoEsfera.addChild(EsferaTranslationGroup);
		
		Transform3D rotar = new Transform3D();
		Transform3D temprotar = new Transform3D();
		
		temprotar.rotY(Math.PI/-4.0d);
        rotar.mul(temprotar);
    	
		TransformGroup objrotado = new TransformGroup(rotar);
		objrotado.addChild(objetoEsfera);
		
		return objrotado;
		
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	public String get() {
	
		return "P"+n+"("+x+","+y+","+z+")";
		
	}

	public static int getNumero() {
		return numero;
	}

	public static void setNumero(int puntos) {
		Puntos.numero = puntos;
	}
	

}
