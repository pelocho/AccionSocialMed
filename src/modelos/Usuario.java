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
}
