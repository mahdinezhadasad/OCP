package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class B15_ResultSetMetaData {

	public static void main(String[] args) throws SQLException {
		
		JDBCUtils.rebuildTestTable();
		
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery("select * from kunden")) {
			
			ResultSetMetaData rsmd = res.getMetaData();
			
			int column = 1;
			String tableName = rsmd.getTableName(column); 
			System.out.println("tableName: " + tableName); // KUNDEN
			
			int columnCount = rsmd.getColumnCount();
			System.out.println("columnCount: " + columnCount); // 3
			
			for(column = 1; column <= columnCount; column++) {
				String columnName = rsmd.getColumnName(column);
				System.out.println("  columnName: " + columnName);
			}
			
		}

	}

}
