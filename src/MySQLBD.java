import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLBD {
	private Connection connection = null;
	
	final private String host = "localhost:3306";
	final private String user = "root";
	final private String passwd = "password";
	
	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://" + host + "/gestor?user=" + user + "&password=" + passwd + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			
			System.out.println("Connected");
			
		} catch (ClassNotFoundException ex) {
			System.err.println("No se ga podido encontrar el driver");
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Hubo un error al iniciar la base de datos");
			System.exit(1);
		}
	}
	
	public void execute(String statement) {
		try {
			Statement stm = connection.createStatement();
			stm.execute(statement);
		} catch (SQLException e) {
			System.err.println("Error al ejecutar la sentencia: " + e.getMessage());
		}
	}
	
	public void insert(String statement) {
		execute(statement);
	}
	
	public void delete(String statement) {
		execute(statement);
	}
	
	public void update(String statement) {
		execute(statement);
	}
	
	public List<String[]> select(String query) {
		ArrayList<String[]> list = new ArrayList<>();
		
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmt = rs.getMetaData();
			
			while (rs.next()) {
				String [] sm = new String[rsmt.getColumnCount()];
				
				for(int i = 0; i < sm.length; i++) {
					sm[i] = rs.getString(i+1);
				}
				
				list.add(sm);
			}
		} catch (SQLException e) {
			System.out.println("Error al ejecutar sentencia: " + query + "\nError: " + e.getMessage());
		}
		
		return list;
	}
	
	public String selectEscalar(String query) {
		String result = null;
		
		try {
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmt = rs.getMetaData();
			
			if (rsmt.getColumnCount() > 0 && rs.next())
				result = rs.getString(1);
		} catch (SQLException e) {
			System.out.println("Error al ejecutar la sentencia : " + query + "\nError : " + e.getMessage());
		}
		
		return result;
	}
	
	public void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar la base de datos");
		}
	}
}
