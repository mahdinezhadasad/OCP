package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B11_Statement_execute {

	public static void main(String[] args) {

		JDBCUtils.rebuildTestTable();
		JDBCUtils.printTestTable();
		
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement()) {
			
			/*
			 *  ResultSet executeQuery(String sql) throws SQLException
			 */
			try (ResultSet res = stm.executeQuery("select * from kunden")) {
				res.next();
				System.out.println("1. name: " + res.getString(2)); // Peter
			}
			
			/*
			 * int executeUpdate(String sql) throws SQLException
			 */
			int zeilen = stm.executeUpdate("update kunden set kontostand=0 where kontostand > 1000");
			System.out.println("\n2. Zeilen, die für die where-Klausel passen: " + zeilen);
			
			JDBCUtils.printTestTable();
			
			/*
			 * 
			 * boolean execute(String sql) throws SQLException
			 * 
			 * 
			 * true if the first result is a ResultSet object; 
			 * false if it is an update count or there are no results
			 */
			
			 /* 
			  * - kann select-Befehl ausführen
			  */
			stm.execute("select * from kunden"); // erzeugt ein neues ResultSet
			System.out.println("\n3. ResultSet erzeugt");
			
			ResultSet res = stm.getResultSet();
			res.next();
			System.out.println("4. name: " + res.getString(2)); // Peter
			
			 /* 
			  * - kann andere Befehle auch ausführen
			  */
			stm.execute("update kunden set kontostand=555 where kontostand = 0");
			JDBCUtils.printTestTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
