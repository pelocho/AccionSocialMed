package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class ONG {
	private String correo, contrasena, nombre, tlfn, correo_contacto, web;
	private int[] actividades;

	public static List<ONG> listaONG() throws Exception{
		List<ONG> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT correo FROM ong");
		
		for(String[] sol : list) {
			ONG aux = new ONG(sol[0]);
			res.add(aux);
		}
		
		return res;		
	}
	
	public ONG(String correo) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		String[] ong = bd.select("SELECT * FROM ong WHERE Correo = " + correo + ";").get(0);
		this.correo = correo;
		contrasena = ong[1];
		nombre = ong[2];
		tlfn = ong[3];
		correo_contacto = ong[4]; 
		web = ong[5];
		
		List<String[]> listAux = bd.select("SELECT Codigo FROM eef_primera_iteracion.actividades WHERE ONG='"+this.correo+"';");
	    int i = 0;
		for(String[] act : listAux) {
			actividades[i] = Integer.parseInt(act[0]);
			i++;
		}
	}
	
	public ONG(String correo, String contrasena, String nombre, String tlfn, String correo_contacto, String web) throws Exception {
		this.correo = correo;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.tlfn = tlfn;
		this.correo_contacto = correo_contacto;
		this.web = web;
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.insert("INSERT INTO `eef_primera_iteracion`.`ong` (`Correo`, `Contraseña`, `Nombre`, `Telefono`, "
				+ "`Correo_Contacto`, `Web`) VALUES ('"+ this.correo + "', '" + this.contrasena + "', '" 
				+ this.nombre + "', '" + this.tlfn + "', '" + this.correo_contacto + "', '" + this.web + "'); ");
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE ong SET correo = '" + correo + "' "
				+ "WHERE correo ='"+ this.correo + "';");
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE ong SET contrasena = '" + contrasena + "' "
				+ "WHERE correo ='"+ this.correo + "';");
		this.contrasena = contrasena;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE ong SET nombre = '" + nombre + "' "
				+ "WHERE correo ='"+ this.correo + "';");
		this.nombre = nombre;
	}

	public String getTlfn() {
		return tlfn;
	}

	public void setTlfn(String tlfn) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE ong SET Telefono = '" + tlfn + "' "
				+ "WHERE correo ='"+ this.correo + "';");
		this.tlfn = tlfn;
	}

	public String getCorreo_contacto() {
		return correo_contacto;
	}

	public void setCorreo_contacto(String correo_contacto) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE ong SET Correo_Contacto = '" + correo_contacto + "' "
				+ "WHERE correo ='"+ this.correo + "';");
		this.correo_contacto = correo_contacto;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE ong SET web = '" + web + "' "
				+ "WHERE correo ='"+ this.correo + "';");
		this.web = web;
	}

	public int[] getActividades() {
		return actividades;
	}
}
