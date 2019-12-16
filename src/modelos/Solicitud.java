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
		
		List<String[]> list = bd.select("SELECT solicitante FROM solicitud");
		
		for(String[] sol : list) {
			Solicitud aux = new Solicitud(sol[0]);
			res.add(aux);
		}
		
		return res;		
	}
	
	public static List<Solicitud> listaSolicitudesNoAceptadas() throws Exception{
		List<Solicitud> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT solicitante FROM solicitud WHERE Aceptada = '"+0+"';");
		
		for(String[] sol : list) {
			Solicitud aux = new Solicitud(sol[0]);
			res.add(aux);
		}
		
		return res;
	}	
	
	public Solicitud(String solicitante) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		String[] solicitud = bd.select("SELECT * FROM solicitud WHERE Solicitante = '" + solicitante + "';").get(0);
		this.solicitante = solicitante;
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
		if(aprobado == true) {
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
