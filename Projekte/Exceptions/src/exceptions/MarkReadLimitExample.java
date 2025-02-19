package Exceptions.src.exceptions;

import java.io.ByteArrayInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkReadLimitExample {
    
    public static void main(String[] args) throws IOException {
        
        byte[]  date = "Zeile1\nZeile2\nZeile3\n".getBytes();
        InputStream inputStream  = new ByteArrayInputStream (date);
        
        
        
        System.out.println ((char) inputStream.read ());
        
        inputStream.mark (7);
        
        for(int i =0; i <6; i++){
            
            System.out.println ((char) inputStream.read ());
        }
        
        System.out.println ();
        
        inputStream.read ();
        
        if(inputStream.markSupported()){
            
            try{ inputStream.reset ();
                System.out.println ("Reset funktonier noch");
            }
            catch (IOException e){
                
                System.out.println ("Reset funktionier Nicht Mehr");
            }
        }
        inputStream.close ();
    }
}