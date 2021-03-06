package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Solicitud {
	private int actividad;
	private String solicitante;
	private boolean aprobada;

	public static List<Solicitud> listaSolicitudes() throws Exception{
		List<Solicitud> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		List<String[]> list = bd.select("SELECT solicitante, Actividad FROM solicitud");

		for(String[] sol : list) {
			Solicitud aux = new Solicitud(sol[0],Integer.parseInt(sol[1]));
			res.add(aux);
		}

		return res;
	}

	public static List<Solicitud> listaSolicitudesNoAceptadas(String ong) throws Exception{
		List<Solicitud> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		List<String[]> list = bd.select("SELECT * FROM solicitud WHERE Aprobada = '"+0+"';");

		for(String[] sol : list) {
			Solicitud aux = new Solicitud(sol[0],Integer.parseInt(sol[1]));
			if(aux.getONG(aux.getActividad()).equals(ong)) {
				res.add(aux);
			}
		}

		return res;
	}
	
	private String getONG(int id) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		//String[] ong = bd.select("SELECT ONG FROM actividades WHERE Codigo = '"+id+"';").get(0);
		String[] ong = bd.select("SELECT ONG FROM actividades WHERE Codigo = '"+id+"';").get(0);
		return ong[0];		
	}

	public static List<String> listaSolicitudesAlumno(String user) throws Exception{
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		List<String> res = new ArrayList<>();
		List<String[]> list = bd.select("SELECT Actividad FROM solicitud WHERE Solicitante = '"+user+"';");

		for(String[] aa : list) {
			Actividad aux = new Actividad(Integer.parseInt(aa[0]));
			res.add(aux.getTitulo());
		}
		list = bd.select("SELECT Actividad FROM solicitudesaps WHERE Alumno = '"+user+"';");


		return res;
	}

	public Solicitud(String solicitante, int Actividad) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		String[] solicitud = bd.select("SELECT * FROM solicitud WHERE Solicitante = '" + solicitante + "' AND Actividad ='"+Actividad+"';").get(0);
		this.solicitante = solicitante;
		this.actividad = Actividad;
		this.aprobada = comprobarBool(Integer.parseInt(solicitud[2]));

	}

	private boolean comprobarBool(int num) {
		return num == 1;
	}

	public Solicitud(String solicitante, int actividad, boolean aprobada) throws Exception {
		this.solicitante = solicitante;
		this.actividad = actividad;
		this.aprobada = aprobada;

		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.insert("INSERT INTO `eef_primera_iteracion`.`solicitud` (`Solicitante`, `CorreoSolicitante`, `Actividad`, "
				+ "`Aprobada`) VALUES ('"+ this.solicitante + "', '" + this.actividad + "', '"
				+ transformarATinyInt(this.aprobada) + "');");
	}

	private int transformarATinyInt(boolean aprobado) {
		if(aprobado) {
			return 1;
		}else {
			return 2;
		}
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET solicitante = '" + solicitante + "' "
				+ "WHERE Solicitante ='"+ this.solicitante + "';");
		this.solicitante = solicitante;
	}

	public int getActividad() {
		return actividad;
	}

	public void setActividad(int actividad) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET actividad = '" + actividad + "' "
				+ "WHERE Solicitante ='"+ this.solicitante + "';");
		this.actividad = actividad;
	}

	public boolean isAprobada() {
		return aprobada;
	}

	public void setAprobada(boolean aprobada) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET aprobada = '" + transformarATinyInt(aprobada) + "' "
				+ "WHERE Solicitante ='"+ this.solicitante + "';");
		this.aprobada = aprobada;
	}
	
}
