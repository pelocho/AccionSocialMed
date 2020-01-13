package modelos;

import java.util.ArrayList;
import java.util.List;
import main.MySQLBD;

public class Noticia {
	private String titulo, cuerpo;
	
	public Noticia(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
	}
	
	public static Boolean guardarNoticia(String titulo, String cuerpo) throws Exception{
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		Boolean ok = bd.insert("INSERT INTO `eef_primera_iteracion`.`noticias` (`titulo`, `cuerpo`) VALUES('"+ titulo+ "', '"+cuerpo+"');");
		return ok;
	}
	
	public static Boolean borrarNoticia (String titulo) throws Exception{
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		Boolean ok = bd.delete("DELETE FROM noticias WHERE titulo = '"+titulo+"';");
		return ok;
	}
	
	public static List<Noticia> listaNoticias() throws Exception {
		List<Noticia> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT * FROM noticias");
		
		for(String[] notice : list) {
			Noticia aux = new Noticia(notice[0], notice[1]);
			res.add(aux);
		}
		
		return res;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getCuerpo() {
		return cuerpo;
	}
}
