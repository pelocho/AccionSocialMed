package pantallasCompartidas;

import main.MySQLBD;

public class funcionesEditarPerfil {
	public Boolean editarAlumno(String password, int telefono, String lugar, String user) throws Exception {
		Boolean ok = false;
		if (password != null && telefono != 0 && lugar != null) {
			String query;
			MySQLBD bd = new MySQLBD();
			boolean res = false;
			bd.readDataBase();
			query = "UPDATE eef_primera_iteracion.usuarios SET Telefono="+telefono+", Contraseña='"+password+"' WHERE Correo='"+user+"';";
			ok = bd.update(query);
		}
		return ok;
	}
}
