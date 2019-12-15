package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Solicitud {
	private int idSolicitud, actividad;
	private String solicitante, correoSolicitante;
	private boolean aprobadaPorGestor, rechazadaPorGestor;
	
	public static List<Solicitud> listaSolicitudes() throws Exception{
		List<Solicitud> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT idSolicitud FROM solicitud");
		
		for(String[] sol : list) {
			Solicitud aux = new Solicitud(Integer.parseInt(sol[0]));
			res.add(aux);
		}
		
		return res;		
	}
	
	public static List<Solicitud> listaSolicitudesOng(String ong) throws Exception{
		List<Solicitud> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT idSolicitud FROM solicitud WHERE '"+ong+"';");
		
		for(String[] sol : list) {
			Solicitud aux = new Solicitud(Integer.parseInt(sol[0]));
			res.add(aux);
		}
		
		return res;		
	}
	
	public Solicitud(int idSolicitud) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		String[] solicitud = bd.select("SELECT * FROM solicitud WHERE idSolicitud = " + idSolicitud + ";").get(0);
		this.idSolicitud = idSolicitud;
		solicitante = solicitud[1];
		correoSolicitante = solicitud[2];
		actividad = Integer.parseInt(solicitud[3]);
		aprobadaPorGestor = comprobarBool(Integer.parseInt(solicitud[4])); 
		rechazadaPorGestor = comprobarBool(Integer.parseInt(solicitud[5]));
		
	}

	private boolean comprobarBool(int num) {
		if (num == 1){
			return true;
		}else{
			return false;
		}
	}
	
	public Solicitud(int idSolicitud, String solicitante, String correoSolicitante, int actividad,
						boolean aprobadaPorGestor, boolean rechazadaPorGestor) throws Exception {
		this.idSolicitud = idSolicitud;
		this.solicitante = solicitante;
		this.correoSolicitante = correoSolicitante;
		this.actividad = actividad;
		this.aprobadaPorGestor = aprobadaPorGestor; 
		this.rechazadaPorGestor = rechazadaPorGestor;

		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.insert("INSERT INTO `eef_primera_iteracion`.`solicitud` (`idSolicitud`, `Solicitante`, `CorreoSolicitante`, "
				+ "`Actividad`, `AprobadaPorGestor`, `RechazadaPorGestor`) VALUES ('"+ 
				this.idSolicitud + "', '" + this.solicitante + "', '" + this.correoSolicitante + "', '" + this.actividad +
				"', '" + transformarATinyInt(this.aprobadaPorGestor) + "', '" + transformarATinyInt(this.rechazadaPorGestor) +
				"');");
	}

	private int transformarATinyInt(boolean aprobado) {
		if(aprobado == true) {
			return 1;
		}else {
			return 2;
		}
	}

	public int getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET idSolicitud = '" + idSolicitud + "' "
				+ "WHERE idSolicitud ='"+ this.idSolicitud + "';");
		this.idSolicitud = idSolicitud;

	}

	public int getActividad() {
		return actividad;
	}

	public void setActividad(int actividad) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET actividad = '" + actividad + "' "
				+ "WHERE idSolicitud ='"+ this.idSolicitud + "';");
		this.actividad = actividad;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET solicitante = '" + solicitante + "' "
				+ "WHERE idSolicitud ='"+ this.idSolicitud + "';");
		this.solicitante = solicitante;
	}

	public String getCorreoSolicitante() {
		return correoSolicitante;
	}

	public void setCorreoSolicitante(String correoSolicitante) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET correoSolicitante = '" + correoSolicitante + "' "
				+ "WHERE idSolicitud ='"+ this.idSolicitud + "';");
		this.correoSolicitante = correoSolicitante;
	}

	public boolean isAprobadaPorGestor() {
		return aprobadaPorGestor;
	}

	public void setAprobadaPorGestor(boolean aprobadaPorPDI) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET aprobadaPorGestor = '" + transformarATinyInt(aprobadaPorGestor) + "' "
				+ "WHERE idSolicitud ='"+ this.idSolicitud + "';");
		this.aprobadaPorGestor = aprobadaPorPDI;
	}


	public boolean isRechazadaPorGestor() {
		return rechazadaPorGestor;
	}

	public void setRechazadaPorGestor(boolean rechazadaPorGestor) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE solicitud SET aprobadaPorGestor = '" + transformarATinyInt(rechazadaPorGestor) + "' "
				+ "WHERE idSolicitud ='"+ this.idSolicitud + "';");
		this.rechazadaPorGestor = rechazadaPorGestor;
	}
}
