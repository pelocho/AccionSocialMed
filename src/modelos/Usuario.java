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
	private int numAreas = 0;
	private int numTipos = 0;
	private int numAsig = 0;
	private List<Actividad> participacion = new ArrayList<>();

	

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
			///////////////////////////////////////////////////////////////////////////////////////////
			numAreas = 0;
			numTipos = 0;
			numAsig = 0;
			
			List<String[]> val = miBD.select("SELECT Tipo FROM eef_primera_iteracion.usuario_tipo_preferencia WHERE Correo='"+correo+"';");
			for(String[] v : val) {
				tipoIntereses[numTipos] = Integer.parseInt(v[0]);
				numTipos++;
			}
			

			List<String[]> vals = miBD.select("SELECT Area FROM eef_primera_iteracion.usuario_area_preferencia WHERE Correo='"+correo+"';");
			for(String[] v : vals) {
				areaIntereses[numAreas] = Integer.parseInt(v[0]);
				numAreas++;
			}
			
			/*List<String[]> asignaturas = miBD.select("SELECT courseId FROM dumamockup.enrollments WHERE StudentId='"+dni+"';");
			for(String[] v : val) {
				asignaturasCursadas[numAsig] = Integer.parseInt(v[0]);
				numAsig++;
			}*/
			
			//////////////////////////////////////////////
			List<String[]> strs = miBD.select("SELECT * FROM eef_primera_iteracion.participacion WHERE correoUsuario='"+correo+"';");
			for(String[] str : strs) {
				participacion.add(new Actividad(Integer.parseInt(str[1])));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Error al cargar de la base de datos de eef en el constructor de usuario") ;
			e.printStackTrace();
		}

		
		

	}
	
	public boolean estaParticipando(Actividad a) throws Exception {
		
		MySQLBD miBD = new MySQLBD();
		miBD.readDataBase();
		int t = miBD.select("Select * from participacion where correoUsuario = '" + email + "' and idActividad = '" + a.getCodigo() + "' ;" ).size();

		return t != 0 ;
	}
	
	public boolean estaSolicitada(Actividad a) throws Exception {
		MySQLBD miBD = new MySQLBD();
		miBD.readDataBase();
		int t = miBD.select("Select * from solicitud where Solicitante = '" + email + "' and Actividad = '" + a.getCodigo() + "' ;" ).size();
		int x = miBD.select("Select * from solicitudesaps where Alumno = '" + email + "' and Actividad = '" + a.getCodigo() + "' ;" ).size();

		return t != 0 || x!= 0;
	}
	
	
	public int[] getAsignaturasCursadas() {
		return asignaturasCursadas;
	}

	public void setAsignaturasCursadas(int[] asignaturasCursadas) {
		this.asignaturasCursadas = asignaturasCursadas;
	}

	public int[] getTipoIntereses() {
		return tipoIntereses;
	}

	public void vaciarTipoIntereses() {
		tipoIntereses = new int[10];
		numTipos = 0;
	}

	public int[] getAreaIntereses() {
		return areaIntereses;
	}

	public void vaciarAreaIntereses() {
		this.areaIntereses  = new int[10];
		numAreas = 0;

	}
	
	public void anadirTipoIntereses(int g) {

		tipoIntereses[numTipos] = g;
		numTipos++;

	}
	
	public void anadirAreaInteres(int g) {
		areaIntereses[numAreas] = g;
		numAreas++;

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

	public String getAsignaturasCursadasToString() throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		int j = 0;
		String[] res = new String[getAsignaturasCursadas().length];
		for(int i : getAsignaturasCursadas()) {
			String[] asig = bd.select("SELECT name FROM dumamockup.courses WHERE id = "+i+";").get(0);
			res[j] = asig[0];
			j++;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < res.length-1; i++) {
			sb.append(res[i] + ", ");
		}

		if(res.length == 0) {
			sb.append("No está cursando ninguna actividad");
		}else {
			sb.append(res[res.length-1]);
		}
		
		return sb.toString();
	}

	
	
}

