package IO.src.io;


import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class PropertyCounter extends ListResourceBundle {
    private int count = 0; // Instance variable to keep track of count
    
    @Override
    protected Object[][] getContents() {
        // Provide "count" as a key and return the current instance of PropertyCounter
        return new Object[][] { { "count", this } };
    }
    
    public int getCount() {
        return count++; // Increment count and return the previous value
    }
    
    public static void main(String[] args) {
        // Load the resource bundle
        ResourceBundle rb = ResourceBundle.getBundle("IO.src.io.counter.PropertyCounter");
        
        // Fetch the PropertyCounter object from the bundle
        PropertyCounter obj = (PropertyCounter) rb.getObject("count");
        
        // Call getCount() twice and print the values
        System.out.println(obj.getCount() + " " + obj.getCount()); // Expected output: 0 1
    }
}