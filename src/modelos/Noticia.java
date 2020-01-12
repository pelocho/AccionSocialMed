package modelos;

import java.util.ArrayList;
import java.util.List;
import main.MySQLBD;

public class Noticia {
	private String titulo, cuerpo;
	
	public Noticia(String titulo, String cuerpo) throws Exception {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.insert("INSERT INTO `eef_primera_iteracion`.`noticias` (`titulo`, `cuerpo`) VALUES('"+ this.titulo+ "', '"+this.cuerpo+"');");
	}
	
	public Noticia (String titulo) throws Exception{
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		String[] noticia = bd.select("SELECT * FROM noticias WHERE titulo = '"+titulo+"';").get(0);
		titulo = noticia[1];
		cuerpo = noticia[2];
	}
	
	public static List<Noticia> listaNoticias() throws Exception {
		List<Noticia> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT * FROM noticias");
		
		for(String[] notice : list) {
			Noticia aux = new Noticia(notice[1], notice[2]);
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
