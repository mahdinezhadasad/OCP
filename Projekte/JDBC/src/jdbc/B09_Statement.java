package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class B09_Statement {

	public static void main(String[] args) {
		JDBCUtils.rebuildTestTable();
		JDBCUtils.printTestTable();

		/*
		 * Statement. einfache Variante
		 */
		try( Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement() ) {
			
			String sql = "insert into kunden (id, name, kontostand) values (4, 'Ute', 3200)";
			stm.executeUpdate(sql);
			
			JDBCUtils.printTestTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		/*
		 * PreparedStatement.
		 * 
		 * SQL-Befehl mit PLatzhaltern vorbereiten.
		 */
		String sql = "insert into kunden (id, name, kontostand) values (?, ?, ?)";
		
		try( Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				PreparedStatement stm = c.prepareStatement(sql) ) {
			
			int parameterIndex = 1;
			
			// Werte für die Platzhalter festlegen
			stm.setInt(parameterIndex, 5); // id = 5
			stm.setString(parameterIndex+1, "Tobias"); // name = Tobias
			stm.setInt(parameterIndex+2, 412); // kontostand = 412
			// Sql-Befehl ausführen
			stm.execute(); 
			
			// Werte für die Platzhalter festlegen
			stm.setInt(parameterIndex, 6); // id = 6
			stm.setString(parameterIndex+1, "Jerald"); // name = Jerald
			stm.setInt(parameterIndex+2, 6789); // kontostand = 6789
			// Sql-Befehl ausführen
			stm.execute(); 
			
			JDBCUtils.printTestTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		/*
		 * weitere Statement-Art: CallableStatement zum Ausführen 
		 * der Prozeduren im DBMS
		 */
	}

}
