package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Mensaje {
	
	private String cuerpo,remitente,destinatario;
	
	private int estado, id;  ///// 0 No Leido      1 Leido    
	
	
	
	public Mensaje(String rem, String dest, String cu, int est) throws Exception {
		remitente = rem;
		destinatario = dest;
		cuerpo = cu;
		estado = est;
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.insert("INSERT INTO `eef_primera_iteracion`.`mensajes` (`remitente`, `destinatario`, `cuerpo`, "  
				+ "`estado`) VALUES ('"+ remitente + "', '" + destinatario + "', '"
				+ cuerpo + "', '" + estado + "');")  ;
	}
	
	
	public Mensaje (int id) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		String[] msg = bd.select("SELECT * FROM Mensajes WHERE id = '" + id + "';").get(0);
		this.id = Integer.parseInt(msg[0]);
		remitente = msg[1];
		destinatario = msg[2];
		cuerpo = msg[3];
		estado = Integer.parseInt(msg[4]);

	}
	
	public static List<Mensaje> listaMensajes() throws Exception {
		List<Mensaje> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT * FROM Mensajes");
		
		for(String[] sol : list) {
			Mensaje aux = new Mensaje(Integer.parseInt(sol[0]));
			res.add(aux);
		}
		
		return res;
	}
	
	public static List<Mensaje> listaMensajesUsuario(String us) throws Exception {
		List<Mensaje> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT * FROM Mensajes");
		
		for(String[] sol : list) {
			if(sol[2].equals(us) ) {
				Mensaje aux = new Mensaje(Integer.parseInt(sol[0]));
				res.add(aux);
			}
		}		
		return res;
	}
	
	public String getRemitente() {
		return remitente;
	}


	public void setRemitente(String remitente) {
		
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE mensajes SET remitente = '" + remitente + "' "
				+ "WHERE id ='"+ id + "';");
		this.remitente = remitente;
	}


	public String getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(String destinatario) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE mensajes SET destinatario = '" + destinatario + "' "
				+ "WHERE id ='"+ id + "';");
		this.destinatario = destinatario;
	}


	public String getCuerpo() {
		return cuerpo;
	}


	public void setCuerpo(String c) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE mensajes SET cuerpo = '" + c + "' "
				+ "WHERE id ='"+ id + "';");
		
		this.cuerpo = c;
	}


	public int getEstado() {
		return estado;
	}
	
	public String getEstadotoString() {
		if(estado == 0) {
			return "No leído";
		}else {
			return "Leído";
		}
	}

	public void setEstado(int estado) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE mensajes SET estado = '" + estado + "' "
				+ "WHERE id ='"+ id + "';");
		this.estado = estado;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
}
