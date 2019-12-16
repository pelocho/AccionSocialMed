package pantallasCompartidas;

import main.MySQLBD;

public class funcionesEditarPerfil {
	public void editarAlumno( int telefono,  String user) throws Exception {
		String query;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		query = "UPDATE eef_primera_iteracion.usuarios SET Telefono= '"+ telefono + "' WHERE Correo='"+user+"' ; " ;
		bd.update(query);
		
	}
}
