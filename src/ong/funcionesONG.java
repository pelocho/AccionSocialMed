package ong;

import java.util.Date;
import java.util.ArrayList;
import main.MySQLBD;
import java.util.List;

public class funcionesONG {
	public Boolean subirActividad(String name, String lugar, String descripcion, String init_date, String end_date, int horas, ArrayList<String> tipo, ArrayList<String> area, String ong) throws Exception {
		Boolean ok = false;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		String tipos = null;
		ArrayList<String> type = tipo;
		StringBuilder sbtipo = new StringBuilder();
		for (String s : type) {
			sbtipo.append(s);
		}
		tipos = sbtipo.toString();
		String areas = null;
		StringBuilder sbarea = new StringBuilder();
		ArrayList<String> areaa = area;
		for (String s : areaa) {
			sbarea.append(s);
		}
		areas = sbarea.toString();
		String query;
		query = "INSERT INTO eef_primera_iteracion.actividades(Titulo, Horas, Fecha_Inicio, Fecha_Fin, Descripcion, Area_Actividad, Tipo_Actividad, ONG, Lugar) VALUES('"+name+"', "+horas+", '"+init_date+"', '"+end_date+"', '"+descripcion+"', '"+areas+"', '"+tipos+"', '"+ong+"', '"+lugar+"');";
		ok = bd.insert(query);
		return ok;
	}
}
