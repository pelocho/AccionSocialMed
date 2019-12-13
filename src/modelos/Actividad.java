package modelos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import main.MySQLBD;

public class Actividad {
		private int codigo, horas;
	private String titulo,descripcion,ong,lugar;
	private Date fecha_inicio,fecha_fin;
	private int[] tipoActividad;
	private int[] areaActividad;
	private static SimpleDateFormat sdt;
	
	
	public Actividad(int codigo) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		String[] actividad = bd.select("SELECT * FROM eef_primera_iteracion.actividades WHERE codigo = '"+codigo+"';").get(0);
		this.codigo = codigo;
		this.titulo = actividad[1];
		this.horas = Integer.parseInt(actividad[2]);
		this.fecha_inicio = (Date) sdt.parse(actividad[3]);
		this.fecha_fin = (Date) sdt.parse(actividad [4]);
		this.descripcion = actividad[5];
		this.ong = actividad [6];
		this.lugar = actividad[7];
		List<String[]> listAux = bd.select("SELECT idTipoActividad FROM eef_primera_iteracion.inter_act_tipoact WHERE idActividad='"+this.codigo+"'");
	    int i = 0;
		for(String[] act : listAux) {
			tipoActividad[i] = Integer.parseInt(act[0]);
			i++;
		}
		List<String[]> listAux1 = bd.select("SELECT idAreaActividad FROM eef_primera_iteracion.inter_act_areaact WHERE idActividad='"+this.codigo+"'");
	    i = 0;
		for(String[] act : listAux1) {
			areaActividad[i] = Integer.parseInt(act[0]);
			i++;
		}
		
		//this.tipoactividad = bd.select("SELECT idTipoActividad FROM eef_primera_iteracion.inter_act_tipoact WHERE idActividad='"+this.codigo+"'").get(i);
		
	}
	
	/*public Actividad (int codigo, String titulo, int horas, Date fecha_inicio, Date fecha_fin, String descripcion, String ong, String lugar) throws Exception {
		this.codigo = codigo;
		this.titulo = titulo;
		this.horas = horas;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.descripcion = descripcion;
		this.ong = ong;
		this.lugar = lugar;
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		bd.insert("INSERT INTO eef_primera_iteracion.actividades (Codigo,Titulo,Horas,Fecha_Inicio,Fecha_Fin,Descripcion,ONG,Lugar) VALUES "
				+ "( '"+this.codigo+"','"+this.titulo+"','"+this.horas+"','"+this.fecha_inicio+"','"+this.fecha_fin+"',"
				+ "'"+this.descripcion+"','"+this.ong+"','"+this.lugar+"')");
		
	}*/
}
