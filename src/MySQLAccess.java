import java.sql.*;

public class MySQLAccess {
	private Connection connect = null;
	
	final private String host = "localhost:3306";
	final private String user = "root";
	final private String passwd = "password";
	
	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/gestor?user=" + user + "&password=" + passwd + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			
			System.out.println("Connected");
			
		} catch (ClassNotFoundException ex) {
			System.err.println("No se ga podido encontrar el driver");
			System.exit(1);
		} catch (SQLException e) {
			System.err.println("Hubo un error al iniciar la base de datos");
			System.exit(1);
		}
	}
	
	private void close() {
		try {
			connect.close();
		} catch (SQLException e) {
			System.err.println("Error al cerrar la base de datos");
		}
	}
}
