package alumno;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import java.sql.Date;

import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;

public class funcionesAlumno {
	
	public List<Actividad> listaOrdenada(Usuario al){
		List<Actividad> lista = Actividad.listaActividades();
		Pair<Actividad,Integer> prioridad;
		
		for(Actividad a : lista) {
			prioridad.add(a,calcularCompatibilidad(al.interesTipo);
			
		}
		
		
		
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
