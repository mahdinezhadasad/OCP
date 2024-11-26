package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B02_Insert {

	public static void main(String[] args) {
		
		String url = "jdbc:derby:mydb";
		
		try (Connection c = DriverManager.getConnection(url);
				Statement stm = c.createStatement();) {
			
			createTestTable(stm); // Tabelle zum Testen erzeugen
			
			String sql = "INSERT INTO animals (name, age) VALUES ('Tom', 5)";
			stm.executeUpdate(sql);
			
			System.out.println("Neue Zeile erzeugt");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	} // end of main

	/*
	 * SQL-Befehle zum Erzeugen einer Tabelle sind unwahrscheinlich in der Prüfung
	 */
	static void createTestTable(Statement stm) throws SQLException {
		try {
			String sql = "CREATE TABLE animals (name VARCHAR(255), age INT)";
			stm.executeUpdate(sql);
			System.out.println("Die Tabelle 'animals' wurde erzeugt");
			
		} catch (SQLException e) {
			if (e.getSQLState().equals("X0Y32")) {
				System.out.println("Die Tabelle 'animals' existiert bereits");
			} else {
				throw e;
			}
		}
	}
	
}
