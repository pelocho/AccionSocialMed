import java.sql.*;

public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host = "localhost:3306";
	final private String user = "root";
	final private String passwd = "password";
	
	public void readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/gestor?user=" + user + "&password=" + passwd + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
			
			System.out.println("Connected");
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	private void close() {
		try {
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		
		}
	}
}
