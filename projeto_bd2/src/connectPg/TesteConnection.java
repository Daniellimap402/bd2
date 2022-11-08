package connectPg;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConnection {

	public static void main(String[] args) {

		try {
			Connection con = ConnectDataBase.makeConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
