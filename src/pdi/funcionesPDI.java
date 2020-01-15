package pdi;

import java.util.List;

import main.MySQLBD;
import modelos.Actividad;

public class funcionesPDI {
	
	public static boolean soyElCoordinador(String user, Actividad act) throws Exception {
		boolean res = false;
		int asig = act.getAsignaturaAsociada();
		
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		
		String id ;
		List<String[]> l =  bd.select("SELECT id FROM dumamockup.users WHERE userEmail='"+user+ "' ; " ) ;
		if(l.size() == 1) {
			id = l.get(0)[0];

			
			List<String[]> l2 =  bd.select("SELECT coordinator FROM dumamockup.courses WHERE id='"+asig+ "' ; " ) ;
			if(l2.size() == 1) {
				String coordinator = l2.get(0)[0];

				res = id.equals(coordinator);
			}
		}
		return res;
	}
}
