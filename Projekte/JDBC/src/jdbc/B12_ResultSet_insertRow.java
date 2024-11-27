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

		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery("select * from kunden")) {
			
			/*
			 * Spezielles ResultSet hat eine spezielle Zeile: 'insert-row'
			 */
			
			/*
			 * Den Cursor zu der 'insert-row' bewegen
			 */
			res.moveToInsertRow();
			
			/*
			 * Daten für den neuen Eintrg in der 'insert-row' vorbereiten
			 */
			
			
			/*
			 * vorbereitete Daten in die Tabelle der Datenbank übertragen
			 */
			res.insertRow();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
