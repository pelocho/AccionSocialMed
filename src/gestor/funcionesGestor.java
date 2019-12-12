package gestor;

import main.MySQLBD;


public class funcionesGestor {

	public static void insertarONG(String correo, String contrasena) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		bd.insert(" INSERT INTO eef_primera_iteracion.ong (Correo, Contraseña) VALUES ('"+ correo + " ', '"+ contrasena +"');");	
		}
}
