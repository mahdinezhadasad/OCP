package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B05_Delete {

	public static void main(String[] args) {
		
		String sql = "DELETE FROM animals WHERE name='Rex'"; 

		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement()) {
			
			int rowsDeleted = stm.executeUpdate(sql);
			
			System.out.println("Zeilen gelöscht: " + rowsDeleted);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
