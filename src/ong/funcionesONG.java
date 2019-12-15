package ong;

import java.util.Date;
import java.util.ArrayList;
import main.MySQLBD;
import modelos.ONG;

import java.util.List;

public class funcionesONG {	
	public boolean subirActividad(String name, String lugar, String descripcion, String init_date, String end_date, int horas, String ong,int plazas) throws Exception {
		String query;
		MySQLBD bd = new MySQLBD();
		boolean res = false;
		bd.readDataBase();
		query = "INSERT INTO eef_primera_iteracion.actividades(Titulo, Horas, Fecha_Inicio, Fecha_Fin, Descripcion, ONG, Lugar, plazasDisponibles) VALUES('"+name+"', "+horas+", '"+init_date+"', '"+end_date+"', '"+descripcion+"', '"+ong+"', '"+lugar+"','"+plazas+"');";
		res = bd.insert(query);
		
		ONG o1 = new ONG(ong);
		String nombreONG = o1.getNombre();
		System.out.print(nombreONG);
		
		int idact;
		idact = Integer.parseInt(bd.select("SELECT Codigo FROM eef_primera_iteracion.actividades WHERE Titulo='"+name+"';").get(0)[0]);
		
		String query2 = "INSERT INTO eef_primera_iteracion.solicitud(Solicitante, CorreoSolicitante, Actividad, AprobadaPorGestor, RechazadaPorGestor) VALUES"
				+ "('"+nombreONG+"','"+ong+"','"+idact+"','"+0+"','"+0+"')";
		bd.insert(query2);
		
		return res;
	}
}
