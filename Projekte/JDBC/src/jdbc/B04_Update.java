package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B04_Update {

	public static void main(String[] args) {
		
		String sql = "UPDATE animals SET age=4 WHERE name='Rex'";

		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb;create=true");
				Statement stm = c.createStatement()) {
			
			int rowsFound = stm.executeUpdate(sql);
			
			System.out.println("Tabelle animals (evtl.) geändert");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
