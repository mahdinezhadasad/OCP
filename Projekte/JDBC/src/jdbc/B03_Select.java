package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B03_Select {

	public static void main(String[] args) {
		
		try(Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement();
					ResultSet res = stm.executeQuery("select * from animals");) {
			
			while( res.next() ) {

				int column = 1; // Achtung! JDBC-Nummerierung startet mit 1!
				String name = res.getString(column);
				
				// alternativ mit dem Spaltennamen als Argument:
//				String name = res.getString("name"); // auch ok
				
//				int age = res.getInt(2); // auch ok
				
				// alternativ mit dem Spaltennamen:
				int age = res.getInt("age");

				System.out.println("name: " + name + ", age: " + age);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
