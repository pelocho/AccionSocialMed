package modelos;

import java.util.ArrayList;
import java.util.List;

import main.MySQLBD;

public class Courses {
	private int id, coordinator;
	private String name;
	
	public static List<Courses> listaCourses() throws Exception{
		List<Courses> res = new ArrayList<>();
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();

		List<String[]> list = bd.select("SELECT id FROM dumamockup.courses");

		for(String[] sol : list) {
			Courses aux = new Courses(Integer.parseInt(sol[0]));
			res.add(aux);
		}

		return res;
	}
	
	public Courses(int id) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		String[] course = bd.select("SELECT * FROM dumamockup.courses WHERE id = '"+id+"';").get(0);
		
		this.id = id;
		name = course[1];
		coordinator = Integer.parseInt(course[2]);
	}
	
	public Courses(int id, String name, int coordinator) throws Exception {
		this.id = id;
		this.name = name;
		this.coordinator = coordinator;
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.insert("INSERT INTO `dumamockup`.`courses` (`id`, `name`, `coordinator`) VALUES ('"+ this.id + "', '" + this.name + "', '" 
				+ this.coordinator + "'); ");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.update("UPDATE Courses SET id = '" + id + "' "
				+ "WHERE id ='" + this.id + "';");
		this.id = id;
	}

	public int getCoordinator() {
		return coordinator;
	}

	public void setCoordinator(int coordinator) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.update("UPDATE Courses SET coordinator = '" + coordinator + "' "
				+ "WHERE id ='" + this.coordinator + "';");
		this.coordinator = coordinator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		MySQLBD bd = new MySQLBD();
		bd.readDataBase();
		bd.update("UPDATE Courses SET name = '" + name + "' "
				+ "WHERE id ='" + this.id + "';");
		this.name = name;
	}
}
