package modelos;

import java.util.ArrayList;
import java.util.List;


import main.MySQLBD;

public class Usuario {
	private int id, categoryId, telefono;
	private String email, passwd, nombre, primerApellido, segundoApellido, nacionalidad, dni;
	private int[] asignaturasCursadas = new int [10] ;
	private int[] tipoIntereses = new int [10] ;
	private int [] areaIntereses = new int [10] ;
	private List<Actividad> participacion ;
	
	
	

	public int[] getAsignaturasCursadas() {
		return asignaturasCursadas;
	}

	public void setAsignaturasCursadas(int[] asignaturasCursadas) {
		this.asignaturasCursadas = asignaturasCursadas;
	}

	public int[] getTipoIntereses() {
		return tipoIntereses;
	}

	public void setTipoIntereses(int[] tipoIntereses) {
		this.tipoIntereses = tipoIntereses;
	}

	public int[] getAreaIntereses() {
		return areaIntereses;
	}

	public void setAreaIntereses(int[] areaIntereses) {
		this.areaIntereses = areaIntereses;
	}

	public Usuario(int id, String email, String passwd, int categoria, String nombre, String apellido1, String apellido2) {
		//Crea objeto y lo inserta en la base de datos
		//MySQLBD miBD = new MySQLBD();
		//miBD.insert("insert into dumamockup.users values ('"+ id + "', '"+ email + "', '" + passwd + "', '" + categoria + "', '" + nombre + "', '" +  apellido1 + "', '" + apellido2+ "'); ");
		this.id = id;
		this.email = email;
		this.passwd = passwd;
		this.categoryId = categoria;
		this.nombre = nombre;
		this.primerApellido = apellido1;
		this.segundoApellido = apellido2;
	}

	public Usuario(int id) { // Crear Objeto cargando de la base de datos
		MySQLBD miBD = new MySQLBD();
		Object[] tupla = miBD.select("SELECT * FROM dumamockup.users WHERE id='"+ id +"';").get(0);
		this.id = id ;
		this.email = (String)tupla[1];
		this.categoryId = (int) tupla[2];
		this.nombre = (String) tupla[3];
		this.primerApellido = (String) tupla[4];
		this.segundoApellido = (String) tupla[5];

	}
	
	public Usuario(String correo)  { // Crear Objeto cargando de la base de datos DE EEF LA NUESTRA, NO LA Mockup
		
		try {
			MySQLBD miBD = new MySQLBD();
			miBD.readDataBase();
			
			
			Object[] tupla = miBD.select("SELECT * FROM eef_primera_iteracion.usuarios WHERE Correo='"+correo+"';").get(0);
			this.email = correo ;
			this.dni = (String) tupla[1];
			this.nombre = (String) tupla[2];
			this.primerApellido = (String) tupla[3];
			this.segundoApellido = (String) tupla[4];
			this.nacionalidad = (String) tupla[5];
			//this.telefono = (int) tupla[6] ;
			this.passwd = (String) tupla[7] ;
			this.categoryId = Integer.parseInt((String)tupla[9]);
			
			//this.areaIntereses = 
			//this.tipoIntereses = 
			
			//this.asignaturasCursadas = 
			
			////////////////////////////////////
			
			List<String[]> strs = miBD.select("SELECT * FROM eef_primera_iteracion.participacion WHERE correoUsuario='"+correo+"';");
			for(String[] str : strs) {
				participacion.add(new Actividad(Integer.parseInt(str[1] ) ) );
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Error al cargar de la base de datos de eef en el consctructor de usuario") ;
			e.printStackTrace();
		}

		
		

	}
	
	public boolean estaParticipando(Actividad a) {
		return participacion.contains(a) ;
	}
	
	


	public String toString() {
		return id + " " + email + " " + passwd + " " + categoryId + " " + nombre + " " + primerApellido + " " + segundoApellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}


	public static List<Usuario> listaUsuarios(){
		// Metodo de clase que devuelve la lista con todos los usuarios
		List<Usuario> lista = new ArrayList<Usuario>();
		MySQLBD miBD = new MySQLBD();

		for(Object[] tupla: miBD.select("SELECT id FROM users;")){
			int id = (int)tupla[0];
			lista.add(new Usuario(id));
		}
		return lista;
	}
	
}

