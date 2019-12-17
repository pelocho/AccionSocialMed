package alumno;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


import java.sql.Date;

import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;

public class funcionesCompartidas {
	public static List<Actividad> listaOrdenada(Usuario us) throws Exception{
		List<Actividad> lista = Actividad.listaActividades();

		Map<Integer,List<Actividad>> prioridad = new TreeMap<Integer, List<Actividad > > ();  // 0 Voluntariado     1 APS     2 Invest     
		
		for(Actividad a : lista) {	// 1 estudiante 2 pdi 3 pas  (4 ong)   5 gestor
			if(a.getPlazasDisponibles() >0 && !us.estaParticipando(a) && !us.estaSolicitada(a) )  {
				if(a.getTipo() == 2) { // si es invest
					if(us.getCategoryId() == 2 ) { // cuenta solo pa los pdi
						introducir(prioridad, calcularCompatibilidad(us,a) , a ) ;
					}
				}else if(a.getTipo() == 1) { // si es APS
					if(us.getCategoryId() == 1) {	// cuenta solo pa los estudiantes
						introducir(prioridad, calcularCompatibilidad(us,a) , a ) ;
					}
				}else  if (a.getTipo() == 0 ){					// si es voluntariado cuenta para todos
					introducir(prioridad, calcularCompatibilidad(us,a) , a ) ;
				}
			}
			
		}
		
		List<Actividad> res = new ArrayList<> ();
		for(int p : prioridad.keySet()) {
			for(Actividad a : prioridad.get(p) ) {
				res.add(a);
			}
		}
		
		Collections.reverse(res);
		
		return res; 		
		
	}
		
	private static void introducir(Map<Integer, List<Actividad>> prioridad, int puntos, Actividad a) {
		
		List<Actividad> aux = prioridad.getOrDefault(puntos, new ArrayList<>());
		aux.add(a);
		prioridad.put(puntos, aux);
		
			
		
		
	}

	private static int calcularCompatibilidad(Usuario us, Actividad a) {
		int area = calcularComunes(us.getAreaIntereses(),a.getAreaActividad() );
		int tipo = calcularComunes(us.getTipoIntereses() , a.getTipoActividad() );
		int asignatura = 0;
		if(us.getCategoryId() == 1 && a.getTipo() == 1) {
			for (int i = 0; i < us.getAsignaturasCursadas().length ; i++) {
				if (us.getAsignaturasCursadas()[i] == a.getAsignaturaAsociada() ) asignatura = 5;
			}
		}
		System.out.println("Act " + a.getTitulo() + "     Puntos " + area + tipo + asignatura );

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
	
	public static boolean enviarSolicitud(String user,int id) throws Exception {
		boolean ok = false;
		String query;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		query = "INSERT INTO solicitud (Solicitante,Actividad) VALUES ('" + user + "', '" + id + "');";
		ok = bd.insert(query);
		
		return ok;
	}
	
	public static boolean enviarSolicitudAPDI(String user,int id) throws Exception{
		boolean ok = false;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		String query = "INSERT INTO solicitudesaps (Alumno,Actividad) VALUES ('" + user + "', '" + id + "');";
		bd.insert(query);
		return ok;
	}
}
