package Modelo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;


public class BD {

	
	
	private Connection conexion = null;
	private Statement consulta = null;
	private ResultSet rs = null;
	
	
	
	public void Conectar(){
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
		
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/proyectoiii", "root", "");
		
			
			
		
		}catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "INFORMACION DEL SISTEMA ERROR(02): al cargar la base de datos");
			e.printStackTrace();
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(null, "INFORMACION DEL SISTEMA ERROR(02): al cargar el driver");
		}
	
	}
	
	
	public void Desconectar(){
		
		try{
			
			conexion.close();
	
		}catch (SQLException e){
			
			JOptionPane.showMessageDialog (null, "INFORMACION DEL SISTEMA", "ERROR (1): Al desconectar de la base de datos",0);
			
			
		}
		
	}
	
	public ResultSet getInformacion (String instruccion){
		
		Conectar();
		
		try{
			consulta = conexion.createStatement();
			rs = consulta.executeQuery(instruccion);
			
		}catch(SQLException e){
			
			JOptionPane.showMessageDialog(null, "INFORMACION DEL SISTEMA Error (01): Al Realizar la consulta en la base de datos");
			
		}
		return rs;
	}
	
	
	public int setInformacion(String instruccion){
		
		Conectar();
		
		int validar = 0;
		
		try{
			
			if(conexion == null){
				System.out.println("conexion null");
			}

		consulta = conexion.createStatement();
		validar = consulta.executeUpdate(instruccion);
		return validar;
		
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "INFORMACION DEL SISTEMA Error (02): Al Realizar la consulta en la base de datos");
		JOptionPane.showMessageDialog(null, "INFORMACION DEL SISTEMA");
		e.printStackTrace();
			return validar;
	
	}
	}


	public Connection getConexion() {
		return conexion;
	}


	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
}
