package Threads.src.threads;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class CountResouce extends ListResourceBundle {
    
    private int count = 0;
    
   
    
    @Override
    protected Object[][] getContents() {
       // return new Object[][] { { "count", count++ } };
     
        return new Object[][]{
                {"count", (Supplier<Integer>) () -> count++} // Supplier für dynamisches Verhalten
        };
    }
    
    
    public static void main(String[] args) {
        
    
    }
}