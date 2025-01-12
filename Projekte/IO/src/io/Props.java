package IO.src.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class Props {
     
     public static void main(String[] args) {
         
         // Step 1: Create the first Properties object and add key-value pairs
         Properties props = new Properties();
         props.setProperty("k1", "v1");
         props.setProperty("k2", "v2");
         
         // Display the initial properties
         System.out.println("Initial Properties:");
         props.list(System.out);
         
         // Step 2: Store the properties into the file
         try (FileOutputStream fos = new FileOutputStream("myProps.properties")) {
             props.store(fos, "test");
         } catch (IOException e) {
             System.out.println("Error saving props to file: " + e.getMessage());
         }
         
         // Step 3: Create a second Properties object and add a new key-value pair
         Properties p2 = new Properties();
         p2.setProperty("a1", "a2");
         
         // Step 4: Load the properties from the file into the second Properties object
         try (FileInputStream in = new FileInputStream("myProps.properties")) {
             p2.load(in);
         } catch (IOException e) {
             System.out.println("Error loading props from file: " + e.getMessage());
         }
         
         // Display the merged properties
         System.out.println("Merged Properties:");
         p2.list(System.out);
         
         // Step 5: Store the updated properties back into the file
         try (FileOutputStream fos = new FileOutputStream("myProps.properties")) {
             p2.store(fos, "Updated properties");
         } catch (IOException e) {
             System.out.println("Error saving merged props to file: " + e.getMessage());
         }
     }
     
}