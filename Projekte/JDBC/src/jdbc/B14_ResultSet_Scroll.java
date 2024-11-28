package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B14_ResultSet_Scroll {

	public static void main(String[] args) {
		
		JDBCUtils.rebuildTestTable();

		/*
		 * Standard-Typ von einem ResultSet ist TYPE_FOWARD_ONLY
		 * 
		 * Damit der Cursor auch rückwärts bewegt werden kann,
		 * muss das ResultSet den Typ TYPE_SCROLL_INSENSITIVE 
		 * oder TYPE_SCROLL_SENSITIVE haben.
		 */
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb");
				Statement stm = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY )) {
			
			stm.executeUpdate("INSERT INTO kunden (id, name, kontostand) VALUES (4, 'Tom', 12345)");
			stm.executeUpdate("INSERT INTO kunden (id, name, kontostand) VALUES (5, 'Jerry', 50000)");
			
			JDBCUtils.printTestTable();
			System.out.println();
			
			try (ResultSet res = stm.executeQuery("select * from kunden")) {
				/*
				 *   ->  
				 *     |  1| Peter|        2000|
				 *     |  2|  Paul|         111|
				 *     |  3|  Mary|        7500|
				 *     |  4|   Tom|       12345|
				 *     |  5| Jerry|       50000|
				 *     
				 */
				
				/*
				 *  boolean next() throws SQLException
				 */
				boolean result = res.next();
				
				/*
				 *     
				 *   ->|  1| Peter|        2000|
				 *     |  2|  Paul|         111|
				 *     |  3|  Mary|        7500|
				 *     |  4|   Tom|       12345|
				 *     |  5| Jerry|       50000|
				 *     
				 */
				System.out.println("1. " + res.getString("name")); // Peter
				System.out.println("2. " + result); // true
				
				res.next();
				res.next();
				/*
				 *     
				 *     |  1| Peter|        2000|
				 *     |  2|  Paul|         111|
				 *   ->|  3|  Mary|        7500|
				 *     |  4|   Tom|       12345|
				 *     |  5| Jerry|       50000|
				 *     
				 */
				System.out.println("3. " + res.getString("name")); // Mary
				
				res.next();
				res.next();
				result = res.next();
				/*
				 *     
				 *     |  1| Peter|        2000|
				 *     |  2|  Paul|         111|
				 *     |  3|  Mary|        7500|
				 *     |  4|   Tom|       12345|
				 *     |  5| Jerry|       50000|
				 *   ->
				 */
				System.out.println("4. " + result); // false
				
				/*
				 * boolean previous() throws SQLException
				 */
				result = res.previous(); // true
				
				/*
				 *     
				 *     |  1| Peter|        2000|
				 *     |  2|  Paul|         111|
				 *     |  3|  Mary|        7500|
				 *     |  4|   Tom|       12345|
				 *   ->|  5| Jerry|       50000|
				 *  
				 */
				System.out.println("5. " + res.getString("name")); // Jerry
				System.out.println("6. " + result); // true
				
				/*
				 * boolean isBeforeFirst() throws SQLException
				 * boolean isAfterLast() throws SQLException
				 * 
				 * void afterLast() throws SQLException
				 * void beforeFirst() throws SQLException
				 */
				result = res.isBeforeFirst();
				System.out.println("7. " + result); // false
				System.out.println("8. " + res.isAfterLast()); // false
				
				res.afterLast();
				/*
				 *     |  1| Peter|        2000|
				 *     |  2|  Paul|         111|
				 *     |  3|  Mary|        7500|
				 *     |  4|   Tom|       12345|
				 *     |  5| Jerry|       50000|
				 *   ->   
				 */
				
				res.beforeFirst();
				/*
				 *   ->   
				 *     |  1| Peter|        2000|
				 *     |  2|  Paul|         111|
				 *     |  3|  Mary|        7500|
				 *     |  4|   Tom|       12345|
				 *     |  5| Jerry|       50000|
				 *  
				 */
				
				/*
				 * boolean absolute( int row ) throws SQLException
				 */
				int rowNr = 4;
				res.absolute(rowNr); 

				/*
				 *                                Negative Rückwärtsnummerierung                                 
				 *     |  1| Peter|        2000| -5
				 *     |  2|  Paul|         111| -4
				 *     |  3|  Mary|        7500| -3
				 *   ->|  4|   Tom|       12345| -2
				 *     |  5| Jerry|       50000| -1
				 *  
				 */
				System.out.println("9. " + res.getString("name")); // Tom
				
				res.absolute(-4);
				/*
				 *                                Negative Rückwärtsnummerierung                                 
				 *     |  1| Peter|        2000| -5
				 *   ->|  2|  Paul|         111| -4
				 *     |  3|  Mary|        7500| -3
				 *     |  4|   Tom|       12345| -2
				 *     |  5| Jerry|       50000| -1
				 *  
				 */
				System.out.println("10. " + res.getString("name")); // Paul
				
				/*
				 * 
				 */
				int delta = 3; // forwärts
				res.relative(delta);
				/*
				 *                                                                
				 *     |  1| Peter|        2000| 
				 *     |  2|  Paul|         111| 
				 *     |  3|  Mary|        7500| 
				 *     |  4|   Tom|       12345| 
				 *   ->|  5| Jerry|       50000| 
				 *  
				 */
				System.out.println("11. " + res.getString("name")); // Jerry

				res.relative(-2); // rückwärts
				/*
				 *                                                                
				 *     |  1| Peter|        2000| 
				 *     |  2|  Paul|         111| 
				 *   ->|  3|  Mary|        7500| 
				 *     |  4|   Tom|       12345| 
				 *     |  5| Jerry|       50000| 
				 *  
				 */
				System.out.println("12. " + res.getString("name")); // Mary
				
				
			} // ResultSet schliessen
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
