package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class SolicitudApS {
	private int actividad;
	private String alumno;
	private boolean aprobada;
	
	public static List<SolicitudApS> listaSolicitudesAlumnos() throws Exception{
		List<SolicitudApS> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT alumno FROM solicitudesaps");
		
		for(String[] sol : list) {
			SolicitudApS aux = new SolicitudApS(sol[0]);
			res.add(aux);
		}
		
		return res;		
	}
	
	public static List<SolicitudApS> listaSolicitudesNoAceptadas() throws Exception{
		List<SolicitudApS> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT alumno FROM solicitudesaps WHERE Aceptada = '"+0+"';");
		
		for(String[] sol : list) {
			SolicitudApS aux = new SolicitudApS(sol[0]);
			res.add(aux);
		}
		
		return res;
	}	
	
	public SolicitudApS(String alumno) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		String[] solicitud = bd.select("SELECT * FROM solicitudesaps WHERE alumno = '" + alumno + "';").get(0);
		this.alumno = alumno;
		this.actividad = Integer.parseInt(solicitud[1]);
		this.aprobada = comprobarBool(Integer.parseInt(solicitud[2]));
		
	}

	private boolean comprobarBool(int num) {
		if (num == 1){
			return true;
		}else{
			return false;
		}
	}
	
	public SolicitudApS(String alumno, int actividad, boolean aprobada) throws Exception {
		this.alumno = alumno;
		this.actividad = actividad;
		this.aprobada = aprobada;

		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.insert("INSERT INTO `eef_primera_iteracion`.`solicitudesaps` (`Alumno`, `Actividad`, `Aprobada`) VALUES "
				+ "('"+ this.alumno + "', '" + this.actividad + "', '" + transformarATinyInt(this.aprobada) + "');");
	}

	private int transformarATinyInt(boolean aprobado) {
		if(aprobado == true) {
			return 1;
		}else {
			return 2;
		}
	}

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitudesaps SET alumno = '" + alumno + "' "
				+ "WHERE alumno ='"+ this.alumno + "';");
		this.alumno = alumno;
	}

	public int getActividad() {
		return actividad;
	}

	public void setActividad(int actividad) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitudesaps SET actividad = '" + actividad + "' "
				+ "WHERE alumno ='"+ this.alumno + "';");
		this.actividad = actividad;
	}

	public boolean isAprobada() {
		return aprobada;
	}

	public void setAprobada(boolean aprobada) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitudesaps SET aprobada = '" + transformarATinyInt(aprobada) + "' "
				+ "WHERE alumno ='"+ this.alumno + "';");
		this.aprobada = aprobada;
	}
}
