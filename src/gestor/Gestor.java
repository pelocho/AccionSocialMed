package gestor;   // Jorge

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Gestor {
	private int id;
	private String email;
	//categorie = 5
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	
	
	public Gestor(int id) {
	
		// Construye el objeto Provincia rellenando sus atributos de la tabla		
		MySQLBD miBD = new MySQLBD();
		Object[] tupla = miBD.select("SELECT * FROM users WHERE id='"+ id +"';").get(0);
		this.id = id ;
		this.email = (String)tupla[1];
		this.nombre = (String) tupla[3];
		this.primerApellido = (String) tupla[4];
		this.segundoApellido = (String) tupla[5];
		
	}
	
	/*public Gestor(String id, String provincia...){
		// Construye el objeto Provincia rellenando sus atributos de la tabla
		BD miBD = new BD(BD_SERVER,BD_NAME);
		miBD.Insert("INSERT INTO tProvincia VALUES("
				+ "'" + codigo + "','" + provincia + "');");
		this.codigo = codigo;
		this.nombre = provincia;
	}
*/

	public static List<Gestor> ListaProvincias(){
		// Método de clase que devuelve la lista con todas las Provincias
		List<Gestor> lista = new ArrayList<Gestor>();
		MySQLBD miBD = new MySQLBD();
		
		for(Object[] tupla: miBD.select("SELECT id FROM users;")){
			int id = (int)tupla[0];
			lista.add(new Gestor(id));
		}
		return lista;
	}

}
