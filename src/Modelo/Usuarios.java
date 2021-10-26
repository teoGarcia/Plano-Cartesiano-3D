package Modelo;

import java.sql.ResultSet;

public class Usuarios extends BD {
	
	
		public int GuardarUsuario(String Usuario, String Clave, String Nombre, String Apellido, String Pregunta, String Respuesta){
			
			Conectar();
			
			return setInformacion("INSERT INTO `proyectoiii`.`usuarios`"
					+"(`Usua`, `ClavUsua`, `NombUsua`, `ApelUsua`, `PregSegu`, `RespSegu`) VALUES "
					+"('"+Usuario+"', '"+Clave+"', '"+Nombre+"', '"+Apellido+"', '"+Pregunta+"', '"+Respuesta+"');");
			
		}
		
		public ResultSet Login(String Usuario, String Clave){
			
			Conectar();
			return  getInformacion("SELECT * FROM `usuarios` WHERE `Usua` LIKE '"+Usuario+"' AND `ClavUsua` LIKE '"+Clave+"'");
			
		}
		
		public ResultSet RecuperarClave(String Usuario, String Pregunta, String Respuesta){
			
			Conectar();
			
			return getInformacion("SELECT * FROM `usuarios` WHERE `Usua` LIKE '"+Usuario+"' AND `PregSegu` = "+Pregunta+" AND `RespSegu` LIKE '"+Respuesta+"'");
			
		}
		
	
	
}
