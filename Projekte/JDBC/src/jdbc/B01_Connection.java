package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class B01_Connection {

	public static void main(String[] args) {
		
		String url = "jdbc:derby:mydb;create=true";
		
		try {
			Connection c = DriverManager.getConnection(url);
			System.out.println("Die Verbindung steht.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
