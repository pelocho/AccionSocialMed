package modelos;

public class Usuario {
	private int id, categoryId;
	private String email, passwd, nombre, primerApellido, segundoApellido;
	
	public Usuario(int id, String email, String passwd, int categoria, String nombre, String apellido1, String apellido2) {
		this.id = id;
		this.email = email;
		this.passwd = passwd;
		this.categoryId = categoria;
		this.nombre = nombre;
		this.primerApellido = apellido1;
		this.segundoApellido = apellido2;
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
}
