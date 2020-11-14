package Help;
import java.sql.*;


public class DBConnection {
	
	Connection c = null;
	
	public DBConnection() {}
	
	public Connection connDb() {
		try {
			this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/dijitalmenu?user=root&password=1234");
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
