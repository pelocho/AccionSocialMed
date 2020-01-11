package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Mensaje {
	
	private Usuario remitente, destinatario;
	private String cuerpo;
	
	private int estado;  ///// 0 No Leido      1 Leido    
	
	
	
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
	
	public static List<Mensaje> listaMensajes() throws Exception {
		List<Mensaje> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT * FROM Mensaje");
		
		for(String[] sol : list) {
			Mensaje aux = new Mensaje(sol[0],sol[1],sol[2], Integer.parseInt(sol [3] ) );
			res.add(aux);
		}
		
		return res;
	}
	
	public static List<Mensaje> listaMensajesUsuario(Usuario us) throws Exception {
		List<Mensaje> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT * FROM Mensaje");
		
		for(String[] sol : list) {
			if(sol[2].equals(us.getEmail() ) ) {
				Mensaje aux = new Mensaje(sol[0],sol[1],sol[2] , Integer.parseInt(sol [3] ) );
				res.add(aux);
			}
			
		}
		
		return res;
	}
	
	

}
