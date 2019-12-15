package modelos;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Actividad {//voluntariado = 0, ApyS = 1, voluntariado = 2
	private int codigo, tipo, horas, asignaturaAsociada;
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
		this.tipo = Integer.parseInt(actividad[2]);
		this.horas = Integer.parseInt(actividad[3]);
		this.fecha_inicio = (Date) sdt.parse(actividad[4]);
		this.fecha_fin = (Date) sdt.parse(actividad [5]);
		this.descripcion = actividad[6];
		this.ong = actividad [7];
		this.lugar = actividad[8];
		this.asignaturaAsociada = Integer.parseInt(actividad[9]);
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
	
	public static List<Actividad> listaActividades() throws Exception{
		List<Actividad> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		List<String[]> list = bd.select("SELECT Codigo FROM eef_primera_iteracion.actividades");
		
		for(String[] sol : list) {
			Actividad aux = new Actividad(Integer.parseInt(sol[0]));
			res.add(aux);
		}
		
		
		return res;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET Codigo = '" + codigo + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.codigo = codigo;
	}
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET Tipo = '" + tipo + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.tipo = tipo;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET Horas = '" + horas + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.horas = horas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET Titulo = '" + titulo + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET Descripcion = '" + descripcion + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.descripcion = descripcion;
	}

	public String getOng() {
		return ong;
	}

	public void setOng(String ong) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET ONG = '" + ong + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.ong = ong;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET Lugar = '" + lugar + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.lugar = lugar;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET Fecha_Inicio = '" + fecha_inicio + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET Fecha_Fin = '" + fecha_fin + "' "
				+ "WHERE Codigo ='" + this.codigo + "';");
		this.fecha_fin = fecha_fin;
	}
	
	public int getAsignaturaAsociada() {
		return asignaturaAsociada;
	}

	public void setAsignaturaAsociada(int asignaturaAsociada) {
		MySQLBD bd = new MySQLBD();
		bd.update("UPDATE actividades SET AsignaturaAsociada = '" + asignaturaAsociada + "' "
				+ "WHERE Codigo ='"+ this.codigo + "';");
		this.asignaturaAsociada = asignaturaAsociada;
	}

	public int[] getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(int[] tipoActividad) {
		MySQLBD bd = new MySQLBD();
		bd.delete("DELETE FROM inter_act_tipoact WHERE Codigo ='"+ this.codigo + "';");
		for(int tipo : tipoActividad) {
			bd.insert("INSERT INTO `eef_primera_iteracion`.`inter_act_tipoact` (`idActividad`, `idTipoActividad`) VALUES ('" + this.codigo + "', '" + tipo + "');");
		}
		this.tipoActividad = tipoActividad;
	}

	public int[] getAreaActividad() {
		return areaActividad;
	}

	public void setAreaActividad(int[] areaActividad) {
		MySQLBD bd = new MySQLBD();
		bd.delete("DELETE FROM inter_act_areaact WHERE Codigo ='"+ this.codigo + "';");
		for(int tipo : areaActividad) {
			bd.insert("INSERT INTO `eef_primera_iteracion`.`inter_act_areaact` (`idActividad`, `idAreaActividad`) VALUES ('" + this.codigo + "', '" + tipo + "');");
		}
		this.areaActividad = areaActividad;
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
