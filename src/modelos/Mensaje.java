package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Mensaje {
	
	private Usuario remitente, destinatario;
	private String cuerpo;
	
	private int estado, id;  ///// 0 No Leido      1 Leido    
	
	
	
	public Mensaje(String rem, String dest, String cu, int est) throws Exception {
		remitente = new Usuario (rem );
		destinatario = new Usuario(dest);
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
		remitente = new Usuario(msg[1]);
		destinatario = new Usuario(msg[2]);
		cuerpo = msg[3];
		estado = Integer.parseInt(msg [4] );

	}
	
	public static List<Mensaje> listaMensajes() throws Exception {
		List<Mensaje> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT * FROM Mensajes");
		
		for(String[] sol : list) {
			//Mensaje aux = new Mensaje(sol[1],sol[2],sol[3], Integer.parseInt(sol[4]));
			Mensaje aux = new Mensaje(Integer.parseInt(sol[0]));
			res.add(aux);
		}
		
		return res;
	}
	
	public static List<Mensaje> listaMensajesUsuario(Usuario us) throws Exception {
		List<Mensaje> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT * FROM Mensajes");
		
		for(String[] sol : list) {
			if(sol[2].equals(us.getEmail() ) ) {
				//Mensaje aux = new Mensaje(sol[1],sol[2],sol[3], Integer.parseInt(sol[4]) );
				Mensaje aux = new Mensaje(Integer.parseInt(sol[0]));
				res.add(aux);
			}
		}		
		return res;
	}
	
	public Usuario getRemitente() {
		return remitente;
	}


	public void setRemitente(Usuario remitente) {
		
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE mensajes SET remitente = '" + remitente + "' "
				+ "WHERE cuerpo ='"+ cuerpo + "';");
		this.remitente = remitente;
	}


	public Usuario getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(Usuario destinatario) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE mensajes SET destinatario = '" + destinatario + "' "
				+ "WHERE cuerpo ='"+ cuerpo + "';");
		this.destinatario = destinatario;
	}


	public String getCuerpo() {
		return cuerpo;
	}


	public void setCuerpo(String c) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE mensajes SET cuerpo = '" + c + "' "
				+ "WHERE cuerpo ='"+ cuerpo + "';");
		
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
				+ "WHERE cuerpo ='"+ cuerpo + "';");
		this.estado = estado;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
}
