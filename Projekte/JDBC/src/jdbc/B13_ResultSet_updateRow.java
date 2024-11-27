package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B13_ResultSet_updateRow {

	public static void main(String[] args) {
		JDBCUtils.rebuildTestTable();
		JDBCUtils.printTestTable();

		int resSetType = ResultSet.TYPE_FORWARD_ONLY;
		int resSetConcurrency = ResultSet.CONCUR_UPDATABLE;
		
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement(resSetType, resSetConcurrency);
					ResultSet res = stm.executeQuery("select * from kunden")) {
			
			/*
			 * Spezielles ResultSet (CONCUR_UPDATABLE)
			 * kommt aus dem speziellen Statement.
			 * 
			 * Dieses ResultSet kann Daten in der Tabelle ändern.
			 */
			
			/*
			 * Der Cursor muss auf eine Zeile zeigen
			 */
			res.next();
			
			/*
			 * Änderungen vorbereiten
			 */
			res.updateString("name", "PETER");
			res.updateInt("kontostand", 0);
			
			/*
			 * Änderungen in die Datenbank übertragen
			 */
			res.updateRow();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCUtils.printTestTable();
		
	}

}
