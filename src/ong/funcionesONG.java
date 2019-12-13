package ong;

import java.util.Date;
import java.util.ArrayList;
import main.MySQLBD;
import java.util.List;

public class funcionesONG {	
	public boolean subirActividad(String name, String lugar, String descripcion, String init_date, String end_date, int horas, String ong) throws Exception {
		String query;
		MySQLBD bd = new MySQLBD();
		boolean res = false;
		bd.readDataBase();
		query = "INSERT INTO eef_primera_iteracion.actividades(Titulo, Horas, Fecha_Inicio, Fecha_Fin, Descripcion, ONG, Lugar) VALUES('"+name+"', "+horas+", '"+init_date+"', '"+end_date+"', '"+descripcion+"', '"+ong+"', '"+lugar+"');";
		res = bd.insert(query);
		return res;
	}
}
