package login;

import main.MySQLBD;
import java.util.*;

public class funcionesLogin {
	public Boolean comprobarUsuario(String user, String passwd) throws Exception {
		Boolean acceso = false;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		List<String[]> usuario = null;
		usuario = bd.selectForLogin("SELECT * FROM users WHERE userEmail='"+user+"' AND passwd='"+passwd+"'");
		
		if (usuario.size() == 1) {
			acceso = true;
		}
		return acceso;
	}
}
