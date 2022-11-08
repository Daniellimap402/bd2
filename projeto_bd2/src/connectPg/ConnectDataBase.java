package connectPg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {

	static final String URL = "jdbc:postgresql://localhost:5432/postgres";
	static final String USER = "postgres";
	static final String PASS = "admin";

	public static Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");

		Connection connect = DriverManager.getConnection(URL, USER, PASS);

		if (connect != null) {
			System.out.println("Connection has been created successfully");
			return connect;
		}
		return null;
	}
}
