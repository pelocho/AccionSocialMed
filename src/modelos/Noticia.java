package modelos;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import main.MySQLBD;

public class Noticia {
	private String titulo, cuerpo, imagen;
	
	public Noticia(String titulo, String cuerpo, String imagen) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.imagen = imagen;
	}
	
	public static Boolean guardarNoticia(String titulo, String cuerpo, String imagen) throws Exception{
		MySQLBD bd = new MySQLBD();
		Boolean ok = bd.insert_image(titulo, cuerpo, imagen);
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
		
		List<String[]> list = bd.selectImage();
		
		for(String[] notice : list) {
			Noticia aux = new Noticia(notice[0], notice[1], notice[2]);
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
	
	public String getImagen() {
		return imagen;
	}
}
