package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	
	private static Connection getConnection() throws SQLException {
		String url = "jdbc:derby:mydb;create=true";
		return DriverManager.getConnection(url);
	}
	
	/**
	 * Erzeugt in der Datenbank 'mydb' die Tabelle 'kunden':<br/><br/>
	 * 
	 * <table>
	 * <tr>
	 *   <th>id</th><th>name</th><th>kontostand</th>
	 * </tr>
	 * 
	 * <tr>
	 *   <td>1</td><td>Peter</td><td>2000</td>
	 * </tr>
	 * 
	 * <tr>
	 *   <td>2</td><td>Paul</td><td>111</td>
	 * </tr>
	 * 
	 * <tr>
	 *   <td>3</td><td>Mary</td><td>7500</td>
	 * </tr>
	 * </table>
	 */
	public static void rebuildTestTable() {
		try (Connection c = getConnection();
				Statement stm = c.createStatement()) {
			
			// alte Tabelle löschen
			String sql;
			sql = "DROP TABLE kunden";
			try {
				stm.executeUpdate(sql);
//				System.out.println("*** Alte Tabelle 'kunden' gelöscht");
				
			} catch (SQLException e) {
				if("42Y55".equals(e.getSQLState())) {
//					System.out.println("*** Tabelle 'kunden' existiert nicht");
				} else {
					throw e;
				}
			}
			
			// Tabelle erneut erzeugen
			sql = "CREATE TABLE kunden (id INT, name VARCHAR(255), kontostand INT)";
			stm.executeUpdate(sql);

			// todo: besser wäre mit PreparedStatement die Datensätze zu speichern
			sql = getSqlInsertIntoTestTable(1, "Peter", 2000);
			stm.executeUpdate(sql);
			sql = getSqlInsertIntoTestTable(2, "Paul", 111);
			stm.executeUpdate(sql);
			sql = getSqlInsertIntoTestTable(3, "Mary", 7500);
			stm.executeUpdate(sql);
			
			System.out.println("*** Neue Tabelle 'kunden' erzeugt");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static String getSqlInsertIntoTestTable(int id, String name, int kontostand) {
		return "INSERT INTO kunden (id, name, kontostand) VALUES (" + 
				id + ", '" + name + "', " + kontostand + ")";
	}
	
	public static void printTestTable() {
		
		try (Connection c = getConnection();
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery("select * from kunden")) {
			
			String fmt = "|%3s|%6s|%12s|%n";
			
			System.out.println("\n*** Tabelle 'kunden':");
			System.out.format(fmt, "id", "name", "kontostand");
			
			while(res.next()) {
				
				int id = res.getInt("id");
				String name = res.getString("name");
				int kontostand = res.getInt("kontostand");
				
				System.out.format(fmt, id, name, kontostand);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		rebuildTestTable();
		printTestTable();
	}

}
