package ong;

import java.util.List;

//import javafx.css.Size;
import main.MySQLBD;
import modelos.Actividad;

public class ongListaActividades{

	MySQLBD bd = new MySQLBD();
	
	public List<String[]> listaActividades(String ong ) throws Exception {
		
		bd.readDataBase();
		List<String[]> actividades = null;
		actividades = bd.select("SELECT * FROM actividades WHERE ong ='" + ong+ "'");
		
		return actividades;
	}
	
	public String name (String ong, int i) throws Exception {
		String name = null;
		
		bd.readDataBase();
		name = listaActividades(ong).get(i)[1];
		
		//	name = bd.select("SELECT Titulo FROM actividades WHERE ong ='" + ong+ "' LIMIT 1 OFFSET "+i+" ").toString();
		
		return name;
	}
	public String lugar (String ong, int i) throws Exception {
		String lugar = null;
		
		bd.readDataBase();
		lugar = listaActividades(ong).get(i)[7];
		
			//lugar = bd.select("SELECT Lugar FROM actividades WHERE ong ='" + ong+ "' LIMIT 1 OFFSET "+i+" ").toString();
		
		return lugar;
	}
	public int horas (String ong, int i) throws Exception {
		int horas = 0;
		
		bd.readDataBase();
		horas = Integer.parseInt(listaActividades(ong).get(i)[2]);
			
		return horas;
	}
	
	public String desc (String ong, int i) throws Exception {
		String desc = null;
		
		bd.readDataBase();
		desc = listaActividades(ong).get(i)[5];
			//desc = bd.select("SELECT Descripcion FROM actividades WHERE ong ='" + ong+ "' LIMIT 1 OFFSET "+i+" ").toString();
		
		return desc;
	}
	
}
