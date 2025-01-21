package loc.res;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollSensitiveUpdatableExample {
    
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String  userName = "root";
        String  password = "password";
        
        try(Connection connection = DriverManager.getConnection (url,userName,password)){
            
            System.out.println ("Connected to database");
            
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            ResultSet  resultSet = statement.executeQuery ("SELECT id, name From Employee");
            
            if(resultSet.next ()){
                
                System.out.println("Original Name: " + resultSet.getString("name"));
                
                // Update the name
                resultSet.updateString("name", "UpdatedName");
                resultSet.updateRow(); // Apply the update
                System.out.println("Name updated!");
            }
            
            if (resultSet.last()) {
                System.out.println("Last Row ID: " + resultSet.getInt("id"));
            }
            
            System.out.println ("Checking for changes...");
            resultSet.beforeFirst ();
            
            while(resultSet.next ()){
                
                System.out.println ("ID: " + resultSet.getInt ("id") + ", Name : "  + resultSet.getString ("name"));
            }
            
            resultSet.close ();
            statement.close ();
        }catch (SQLException e){
            
            e.printStackTrace ();
        }
        
    }
}