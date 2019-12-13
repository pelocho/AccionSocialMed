package gestor;

import main.MySQLBD;


public class funcionesGestor {

	public static boolean insertarONG(String correo, String contrasena) throws Exception {
		boolean res = false;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		res = bd.insert("INSERT INTO eef_primera_iteracion.ong (Correo, Contraseña) VALUES ('"+ correo + "', '"+ contrasena +"');");
		
		return res;
		}
}
