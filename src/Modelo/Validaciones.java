package Modelo;

import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Vista.VistaCoordenadas;

public class Validaciones {
	
	private Pattern Decimales = Pattern.compile("[^- 0-9 .]");
	private Matcher validar;
	
	
	public Boolean ValidarFloat(String text){
		
		
		validar = Decimales.matcher(text);
		
		return validar.find();
			
	}
	
	public Boolean CamposVacios(int n){
		
		if(n <= 0){
			return false;
		}
		
		return true;
		
	}
	
	public Boolean Formato(String text){
		
		try{
			float v = Float.parseFloat(text);
			
			return true;
		}catch(Exception e){
			return false;
		}
	}
	

}
