package modelos;

import java.sql.Date;

public class Actividad {
	private String titulo, descripcion, objetivos, area_actividad, tipo_actividad, ong, lugar;
	private int codigo, horas;
	private Date fecha_inicio, fecha_fin;
	
	public Actividad(String titulo, String descripcion, String objetivos, String area_actividad, String tipo_actividad, String ong, String lugar, int codigo, int horas, Date fecha_inicio, Date fecha_fin) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.objetivos = objetivos;
		this.area_actividad = area_actividad;
		this.tipo_actividad = tipo_actividad;
		this.ong = ong;
		this.lugar = lugar;
		this.codigo = codigo;
		this.horas = horas;
		this.fecha_fin = fecha_fin;
		this.fecha_inicio = fecha_inicio;
	}
}
