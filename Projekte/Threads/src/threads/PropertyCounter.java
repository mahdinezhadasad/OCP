package Threads.src.threads;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class PropertyCounter extends ListResourceBundle {
    
    private int counter = 0;
    
    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"count",new PropertyCounter ()}};
    }
    
    public int getCount() {
        return counter++;
    }
    
    public static void main(String[] args) {
        
        ResourceBundle rb = ResourceBundle.getBundle ("Threads.src.threads.PropertyCounter");
        PropertyCounter counter = (PropertyCounter) rb.getObject ("count");
        System.out.println ( counter.getCount () + " " + counter.getCount () );
    }
}