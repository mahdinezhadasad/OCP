package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B08_Connection_nochmal {

	/*
	 * Achtung! Exam!
	 * 
	 * Wenn die Connection geschlossen ist, kann sie nicht mehr 
	 * verwendet werden.
	 *  
	 * Wenn die Connection geschlossen ist, können damit erstellte
	 * Objekte (Statement, ResultSet...) nicht mehr verwendet werden 
	 */
	
	static Connection connection;
	
	static Connection getConnection() throws SQLException {
		
		String url = "jdbc:derby:mydb"; // Exam: bekannt ist, dass die Url korrekt ist
		
		try (Connection c = DriverManager.getConnection(url)) {
			connection = c;
		} // Achtung! Connection wird geschlossen!
		
		return connection; // Referenz zeigt auf die geschlossene Connection
	}
	
	public static void main(String[] args) {
		JDBCUtils.rebuildTestTable();
			
		try {
			Connection c = getConnection();
			Statement stm = c.createStatement(); // Exception! 
			ResultSet res = stm.executeQuery("select * from kunden");
			
			res.next();
			System.out.println(res.getString("name"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
