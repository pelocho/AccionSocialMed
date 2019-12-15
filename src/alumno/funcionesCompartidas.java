package alumno;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import java.sql.Date;

import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;

public class funcionesCompartidas {
	public static List<Actividad> listaOrdenada(Usuario us) throws Exception{
		List<Actividad> lista = Actividad.listaActividades();

		Map<Integer,Actividad> prioridad = new TreeMap<Integer, Actividad>();  // 0 Voluntariado     1 APS     2 Invest     
		
		for(Actividad a : lista) {									// 1 estudiante 2 pdi 3 pas  4 ong   5 gestor
			if(a.getTipo() == 2) { // si es invest
				if(us.getCategoryId() == 2 ) { // cuenta solo pa los pdi
					prioridad.put(calcularCompatibilidad(us,a),a);
				}
			}else if(a.getTipo() == 1) { // si es APS
				if(us.getCategoryId() == 1) {	// cuenta solo pa los estudiantes
					prioridad.put(calcularCompatibilidad(us,a),a);
				}
			}else {					// si es voluntariado cuenta para todos
				prioridad.put(calcularCompatibilidad(us,a),a);
			}
		}
		List <Actividad> res = new ArrayList(prioridad.values() );
		
		return res;
		
		
	}
		
	private static int calcularCompatibilidad(Usuario us, Actividad a) {
		int area = calcularComunes(us.getAreaIntereses(),a.getAreaActividad() );
		int tipo = calcularComunes(us.getTipoIntereses() , a.getTipoActividad() );
		int asignatura = 0;
		if(us.getCategoryId() == 1 ) {
			for (int i = 0; i < us.getAsignaturasCursadas().length ; i++) {
				if (us.getAsignaturasCursadas()[i] == a.getAsignaturaAsociada() ) asignatura = 5;
			}
		}
		return area + tipo + asignatura;
	}
	
	private static int calcularComunes(int[] a , int[]b) {
		int res = 0;
		if(a != null && b != null && a.length != 0 && b.length != 0 ) {
			for(int i = 0; i < a.length ; i++) {
				for(int j = 0; j < b.length; j++) {
					if(a[i] == b[j]) res++;
				}
			}
		}
		return res;
	}
}
