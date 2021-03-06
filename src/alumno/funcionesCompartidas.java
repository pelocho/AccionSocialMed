package alumno;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;


import java.sql.Date;

import main.MySQLBD;
import modelos.Actividad;
import modelos.Usuario;

public class funcionesCompartidas {
	
	public static boolean evaluadaPorPDI(int id, String user) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		String[] valoracion = bd.select("SELECT valoracionPDI FROM participacion WHERE idActividad = '"+ id +"' AND correoUsuario = "
				+ " '"+user+"';").get(0);
		return Integer.parseInt(valoracion[0]) != -1;
	}
	
	public static boolean evaluadaPorUsuario(int id, String user) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		String[] valoracion = bd.select("SELECT valoracionAlumno FROM participacion WHERE idActividad = '"+ id +"' AND correoUsuario = "
				+ " '"+user+"';").get(0);
		return Integer.parseInt(valoracion[0]) != -1;
	}
	
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
		System.out.print(user + ", " + id);
		String query = "INSERT INTO solicitudesaps (Alumno,Actividad) VALUES ('" + user + "', '" + id + "');";
		ok = bd.insert(query);
		return ok;
	}
	
	public static String getTipoUsuario(int categoryId) {
		  if(categoryId == 1) {
		    return "Alumno";
		  }else if(categoryId == 2) {
		    return "PDI";
		  }else {
		    return "PAS";
		  }
		}
	
	public static List<Actividad> listaSolicitudesAlumno(String user) throws Exception{
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		List<Actividad> res = new ArrayList<>();
		List<String[]> list = bd.select("SELECT Actividad FROM solicitud WHERE Solicitante = '"+user+"';");

		for(String[] aa : list) {
			Actividad aux = new Actividad(Integer.parseInt(aa[0]));
			if(aux.getTipo()!= 6) res.add(aux);
		}
		list = bd.select("SELECT Actividad FROM solicitudesaps WHERE Alumno = '"+user+"';");
		for(String[] aa : list) {
			Actividad aux = new Actividad(Integer.parseInt(aa[0]));
			if(aux.getTipo()!= 6) res.add(aux);		}

		return res;
	}

	public static List<Actividad> listaActividadesAlumno(String user) throws Exception{
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		List<Actividad> res = new ArrayList<>();
		List<String[]> list = bd.select("SELECT idActividad FROM participacion WHERE correoUsuario = '"+user+"';");

		for(String[] aa : list) {
			Actividad aux = new Actividad(Integer.parseInt(aa[0]));
			res.add(aux);
		}

		return res;
	}
	
	public static void enviarMensaje(String remitente, String destinatario, String cuerpo) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.insert("INSERT INTO `eef_primera_iteracion`.`mensajes` (`remitente`, `destinatario`, `cuerpo`, `estado`) VALUES ('"+remitente+"', '"+destinatario+"', '"+cuerpo+"', '0');");
	}
	
	public static void eliminarMensaje(int id) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.delete("DELETE FROM eef_primera_iteracion.mensajes WHERE (id = '"+id+"');");
	}
	
	public static void mensajeLeido(int id) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.update("UPDATE eef_primera_iteracion.mensajes SET `estado` = '1' WHERE (id = '"+id+"');");		
	}
	
	public static boolean comprobarDestinatario(String destinatario) throws Exception{
		boolean acceso = false;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		List<String[]> usuario = null;
		
		usuario = bd.selectForLogin("SELECT * FROM eef_primera_iteracion.usuarios WHERE Correo ='"+destinatario+"';");
	
		if (usuario.size() == 1) {
			acceso = true;
		}else {
			usuario = bd.selectForLogin("SELECT * FROM eef_primera_iteracion.ong WHERE Correo ='"+destinatario+"';");
			if (usuario.size() == 1) {
				acceso = true;
			}
		}
		
		return acceso;
	}
	
	public static boolean esUsuario(String nombre) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		List<String[]> res = bd.select("SELECT * FROM eef_primera_iteracion.usuarios WHERE Correo ='"+nombre+"';");
		if(res.size() > 0) {
			return true;
		}else {
			return false;
		}
	}

	public static boolean esProfesor(int asignaturaAsociada, Usuario profesor) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		String[] res = bd.select("SELECT id FROM dumamockup.courses WHERE coordinator = '"+profesor.getDni()+"';").get(0);
		
		return Integer.parseInt(res[0]) == asignaturaAsociada;
	}
}
