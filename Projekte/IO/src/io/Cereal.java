package IO.src.io;

import java.io.*;

public class Cereal implements Serializable {
   
    private final String directionry;
    public Cereal(String directionry) {
        this.directionry=
                directionry;
    }
    
    public  File getDatabseFolder(String file){
        
        return new File(directionry + System.getProperty("path.separator") + file);
        
    }
    
    public void resetWorkingDirectory() throws Exception{
        File f1 = new File ("D:\\Udacity_Java_Entwikler\\ocp\\proofs");
        f1.mkdirs ();
        File f2 = new File ("/templates");
        f2.mkdirs ();
        
        new File(f2,"draft.doc").createNewFile ();
        
        f1.delete ();
        f2.delete ();
        
    }
    
    public static int getWidgetNumber(byte[] data) throws Exception {
        try (InputStream is = new ByteArrayInputStream (data)) {
            // Read first two bytes (into a dummy array, not used further)
            is.read (new byte[2]); // Reads bytes 1 and 2
            
            // Check if mark is supported
            if (!is.markSupported ()) return -1;
            
            // Mark the current position
            is.mark (5); // Mark at byte 3
            
            is.read (); is.read ();
            // Read one byte (3)
            int firstRead = is.read (); // Reads 3
            
            // Skip the next three bytes (4, 5, 6)
            is.skip (3);
            
            // Reset to the marked position (3)
            is.reset ();
            
            // Read again at the reset position (3)
            int resetRead = is.read (); // Reads 3 again
            return resetRead;
        }
        
    }
    public static void main(String[] args) throws Exception {
        // First example with {1, 2, 3, 4, 5, 6, 7}
        System.out.println("Result with first dataset: " + getWidgetNumber(new byte[]{1, 2, 3, 4, 5, 6, 7}));
        
        // Second example with another dataset
        System.out.println("Result with second dataset: " + getWidgetNumber(new byte[]{9, 8, 7, 6, 5, 4, 3, 2, 1}));
    }
} class WhaleSharkException extends Exception {
    public WhaleSharkException() {
        super("Friendly shark!");
    }
    
    public WhaleSharkException(String message) {
        super(new Exception(new WhaleSharkException()));
    }
    
    public WhaleSharkException(Exception cause) {}
}