package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B10_ResultSet {

	public static void main(String[] args) throws SQLException {
		JDBCUtils.rebuildTestTable();
		
		/*
		 * Standard-ResultSet kommt aus dem Standard-Statement
		 */
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery("select * from kunden")) {
			
			res.next();
			res.previous(); // Exception! 
		} catch (SQLException e) {
			System.out.println("1. Fehler! ResultSet ist vom Typ FORWARD_ONLY");
		} 
		
		/*
		 * Spezielles ResultSet kommt aus dem speziellen Statement
		 */
		int type = ResultSet.TYPE_SCROLL_INSENSITIVE;
		int concurrency = ResultSet.CONCUR_READ_ONLY;
		
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement(type, concurrency);
					ResultSet res = stm.executeQuery("select * from kunden")) {
			
			res.next();
			res.previous(); 
			System.out.println("2. Rückwärts den Curser bewegt");
		} 
		
		/*
		 * Achtung!
		 * Der Cursor steht zuerst VOR der 1. Zeile!!!
		 */
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery("select * from kunden")) {
			
			res.getString("name"); // Exception!
		} catch (SQLException e) {
			System.out.println("3. Fehler! Cursor zeigt auf keine Zeile");
		}

		/*
		 * Achtung!
		 * 
		 * Ein Statement kann nur ein ResultSet auf einmal unterstützen!
		 * Wenn ein neues ResultSet erstellt wird, wird das vorherige 
		 * ResultSet automatisch geschlossen!!!
		 */
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement();) {
			
			ResultSet res1 = stm.executeQuery("select * from kunden");
			
			res1.next();
			System.out.println("4. " + res1.getString("name")); // Peter

			ResultSet res2 = 
			stm.executeQuery("select * from kunden"); // neues ResultSet erzeugt,
												      // altes ResultSet wird dabei 
													  // automatisch geschlossen
			
			res1.getString("name"); // Exception! "ResultSet not open."
		}
	}

}
