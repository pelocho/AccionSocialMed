package alumno;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import java.sql.Date;

import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;

public class funcionesAlumno {
	
	public List<Actividad> listaOrdenada(Usuario us){
		List<Actividad> lista = Actividad.listaActividades();
		List<Actividad> res = new ArrayList<> ();

		Map<Integer,Actividad> prioridad = new TreeMap<Integer, Actividad>();  // 0 Voluntariado     1 APS     2 Invest     
		
		for(Actividad a : lista) {									// 1 estudiante 2 pdi 3 pas  4 ong   5 gestor
			if(a.tipo == 2) {
				if(us.getCategoryId() == 2 ) {
					prioridad.put(calcularCompatibilidad(al.interesTipo, a.interesTipo);
				}
			}else if(a.tipo == 1) {
				if(us.getCategoryId() == 1) {
					prioridad.put(calcularCompatibilidad(al.interesTipo, a.interesTipo);
				}
			}else {
				prioridad.put(calcularCompatibilidad(al.interesTipo, a.interesTipo);
			}
			
		}
		
		return (List<Actividad>) prioridad.values();	
		
	}
		
	
	
	private int calcularCompatibilidad(int[] a, int[] b) {
		int res = 0;
		for(int i = 0; i < a.length ; i++) {
			for(int j = 0; j < b.length; j++) {
				if(a[i] == b[j]) res++;
			}
		}
		return res;
	}
		
		
		
	
		 
	

}
