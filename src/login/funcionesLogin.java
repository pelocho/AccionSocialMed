package login;

import main.MySQLBD;
import java.util.*;

public class funcionesLogin {
	public Boolean comprobarUsuario(String user, String passwd) throws Exception {
		Boolean acceso = false;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		List<String[]> usuario = null;
		usuario = bd.selectForLogin("SELECT * FROM dumamockup.users WHERE userEmail='"+user+"' AND passwd='"+passwd+"'");
	
		if (usuario.size() == 1) {
			acceso = true;
		}
		return acceso;
	}
	
	public Boolean comprobarUsuarioONG(String user, String passwd) throws Exception {
		Boolean acceso = false;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		List<String[]> usuario = null;
		usuario = bd.selectForLogin("SELECT * FROM eef_primera_iteracion.ong WHERE Correo='"+user+"' AND Contraseña='"+passwd+"'");
		System.out.print(usuario.size());
		if (usuario.size() == 1) {
			acceso = true;
			
		}
		return acceso;
	}
	
	public int tipoDeUsuario(String user, String passwd) throws Exception {
		int res = 0;
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		String [] usuario = bd.selectForLogin("SELECT * FROM dumamockup.users WHERE userEmail='"+user+"' AND passwd='"+passwd+"'").get(0);
		
		res = Integer.parseInt(usuario[3]);
		return res;
	}
	
	public void cargarBD(String user, String passwd) throws Exception {	
		boolean registrado = false;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> usuarioReg = null;
		usuarioReg = bd.select("SELECT * FROM eef_primera_iteracion.usuarios WHERE correo='"+user+"' AND contraseña='"+passwd+"'");
	
		if (usuarioReg.size() == 1) {
			registrado = true;
		}
		
		if(!registrado) {
			String[] usuario = null;
			usuario = bd.selectForLogin("SELECT * FROM dumamockup.users WHERE userEmail='"+user+"' AND passwd='"+passwd+"'").get(0);
			//bd.insert("INSERT INTO usuarios VALUES('" + usuario[1] + "', '" + usuario[0] + ", " + usuario[4] +
			//			", " + usuario[5] + ", " + usuario[6] + ", España, null, " + usuario[2] + ", 0, " + usuario[3] + ");");
			/*if(usuario[3].equals("4")) {
				bd.insert("INSERT INTO eef_primera_iteracion.ong(Correo, Contraseña, "+
						"Nombre, Telefono, Correo_Contacto, Web, Codigo, Actividades) "+
						"VALUES ('"+usuario[1]+"', '"+usuario[2]+"', '"+usuario[4]+"', "+
								"'123456789', '"+usuario[1]+"', 'web', "+usuario[0]+", 0);");
			}*///else//
				bd.insert("INSERT INTO eef_primera_iteracion.usuarios(Correo, DNI, "+
						"Nombre, Apellido1, Apellido2, Nacionalidad, Telefono, Contraseña, "+
						"Recordar_Contraseña, Rol) VALUES ('"+usuario[1]+"', '"+usuario[0]+"', '"+usuario[4]+"', "+
								"'"+usuario[5]+"', '"+usuario[6]+"', 'España', null, '"+usuario[2]+"', '0', '"+usuario[3]+"');");
			
			
			
		}
		
	}
}
