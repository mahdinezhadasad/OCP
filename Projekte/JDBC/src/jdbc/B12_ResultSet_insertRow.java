package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B12_ResultSet_insertRow {

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
			 * Spezielles ResultSet hat eine spezielle Zeile: 'insert-row'
			 */
			
			/*
			 * Den Cursor zu der 'insert-row' bewegen
			 */
			res.moveToInsertRow();
			
			/*
			 * Daten für den neuen Eintrg in der 'insert-row' vorbereiten
			 */
			res.updateInt(1, 4); 				// Spalte 1 (id)
			res.updateString("name", "Jerry");  
			res.updateInt("kontostand", 12345);
			
			/*
			 * vorbereitete Daten in die Tabelle der Datenbank übertragen
			 */
			res.insertRow();
			
			/*
			 * Optional. Den Cursor zu seiner ursprünglichen Position bewegen 
			 */
			res.moveToCurrentRow();
			
			/*
			 * wieder normal mit dem ResultSet arbeiten...
			 */
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JDBCUtils.printTestTable();
	}

}
