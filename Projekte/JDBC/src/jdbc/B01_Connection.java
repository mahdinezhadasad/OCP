package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class B01_Connection {

	public static void main(String[] args) {
		
		/*
		 * Derby ist nicht in der Prüfung.
		 * Hinweise zu Derby gibt es in der 'readme-derby.md' im Projektverzeichnis
		 */
		String url = "jdbc:derby:mydb;create=true";
		
		try(Connection c = DriverManager.getConnection(url)) {
			System.out.println("Die Verbindung steht.");
			//...
			System.out.println("Die Verbindung wird geschlossen.");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
