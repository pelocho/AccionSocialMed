package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Participacion {
	String correoUsuario, comentarioONG, comentarioPDI; 
	int idActividad, valoracionONG, valoracionPDI, valoracionAlumno;
	double numeroHoras;
	
	public List<Participacion> listaParticipaciones() throws Exception{
		List<Participacion> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		List<String[]> list = bd.select("SELECT correoUsuario, idActividad FROM eef_primera_iteracion.participacion WHERE correoUsuario = '"+correoUsuario+"' AND idActividad = "+idActividad+";");

		for(String[] sol : list) {
			Participacion aux = new Participacion(sol[0],Integer.parseInt(sol[1]));
			res.add(aux);
		}

		return res;
	}
	
	public Participacion(String correoUsuario, int idActividad) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		String[] participacion = bd.select("SELECT * FROM eef_primera_iteracion.participacion WHERE correoUsuario = '"+correoUsuario+"' AND idActividad = "+idActividad+";").get(0);
		this.correoUsuario = correoUsuario;
		this.idActividad = idActividad;
		this.valoracionONG = Integer.parseInt(participacion[2]);
		this.valoracionPDI = Integer.parseInt(participacion[3]);
		this.comentarioONG = participacion[4];
		this.comentarioPDI = participacion[5];
		this.numeroHoras = Double.parseDouble(participacion[6]);
		this.valoracionAlumno = Integer.parseInt(participacion[7]);
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE participacion SET correoUsuario = '" + correoUsuario + "' "
				+ "WHERE correoUsuario ='" + this.correoUsuario + " AND idActividad = "+this.idActividad+";");
		this.correoUsuario = correoUsuario;
	}

	public String getComentarioONG() {
		return comentarioONG;
	}

	public void setComentarioONG(String comentarioONG) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE participacion SET comentarioONG = '" + comentarioONG + "' "
				+ "WHERE correoUsuario ='" + this.correoUsuario + " AND idActividad = "+this.idActividad+";");
		this.comentarioONG = comentarioONG;
	}

	public String getComentarioPDI() {
		return comentarioPDI;
	}

	public void setComentarioPDI(String comentarioPDI) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE participacion SET comentarioPDI = '" + comentarioPDI + "' "
				+ "WHERE correoUsuario ='" + this.correoUsuario + " AND idActividad = "+this.idActividad+";");
		this.comentarioPDI = comentarioPDI;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE participacion SET idActividad = '" + idActividad + "' "
				+ "WHERE correoUsuario ='" + this.correoUsuario + " AND idActividad = "+this.idActividad+";");
		this.idActividad = idActividad;
	}

	public int getValoracionONG() {
		return valoracionONG;
	}

	public void setValoracionONG(int valoracionONG) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE participacion SET valoracionONG = '" + valoracionONG + "' "
				+ "WHERE correoUsuario ='" + this.correoUsuario + " AND idActividad = "+this.idActividad+";");
		this.valoracionONG = valoracionONG;
	}

	public int getValoracionPDI() {
		return valoracionPDI;
	}

	public void setValoracionPDI(int valoracionPDI) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE participacion SET valoracionPDI = '" + valoracionPDI + "' "
				+ "WHERE correoUsuario ='" + this.correoUsuario + " AND idActividad = "+this.idActividad+";");
		this.valoracionPDI = valoracionPDI;
	}

	public int getValoracionAlumno() {
		return valoracionAlumno;
	}

	public void setValoracionAlumno(int valoracionAlumno) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE participacion SET valoracionAlumno = '" + valoracionAlumno + "' "
				+ "WHERE correoUsuario ='" + this.correoUsuario + " AND idActividad = "+this.idActividad+";");
		this.valoracionAlumno = valoracionAlumno;
	}

	public double getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(double numeroHoras) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE participacion SET numeroHoras = '" + numeroHoras + "' "
				+ "WHERE correoUsuario ='" + this.correoUsuario + " AND idActividad = "+this.idActividad+";");
		this.numeroHoras = numeroHoras;
	}
	
	

}
