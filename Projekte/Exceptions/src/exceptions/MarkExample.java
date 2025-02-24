package Exceptions.src.exceptions;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class MarkExample {
    public static void main(String[] args) throws IOException {
      /*  InputStream stream = new BufferedInputStream (new ByteArrayInputStream (new byte[]{1, 2, 3, 4, 5}));
        
        System.out.println("Mark supported? " + stream.markSupported()); // true
        
        // Read the first byte
        System.out.println("Reading: " + stream.read()); // 1
        
        // Mark position after first byte
        stream.mark(5); // Mark at position of '2'
        
        // Read next two bytes
        System.out.println("Reading: " + stream.read()); // 2
        System.out.println("Reading: " + stream.read()); // 3
        
        // Reset back to marked position
        stream.reset();
        
        // Read again (should be '2')
        System.out.println("Reading after reset: " + stream.read()); // 2
        
        stream.close();
        
        InputStream byteArrayStream = new ByteArrayInputStream(new byte[]{1, 2, 3});
        InputStream bufferedStream = new BufferedInputStream(new FileInputStream ("test.txt"));
        InputStream fileStream = new FileInputStream("test.txt");
        
        System.out.println("ByteArrayInputStream supports mark: " + byteArrayStream.markSupported()); // true
        System.out.println("BufferedInputStream supports mark: " + bufferedStream.markSupported()); // true
        System.out.println("FileInputStream supports mark: " + fileStream.markSupported()); // false
        
        // Close streams
        byteArrayStream.close();
        bufferedStream.close();
        fileStream.close();*/
        
        // Create test.txt if it does not exist
        File file = new File("test.txt");
        if (!file.exists()) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Hello, this is a test file."); // Sample content
            }
        }
        
        // Input streams
        InputStream byteArrayStream = new ByteArrayInputStream(new byte[]{1, 2, 3});
        InputStream bufferedStream = new BufferedInputStream(new FileInputStream("test.txt"));
        InputStream fileStream = new FileInputStream("test.txt");
        
        // Checking markSupported()
        System.out.println("ByteArrayInputStream supports mark: " + byteArrayStream.markSupported()); // true
        System.out.println("BufferedInputStream supports mark: " + bufferedStream.markSupported()); // true
        System.out.println("FileInputStream supports mark: " + fileStream.markSupported()); // false
        
        // Close streams
        byteArrayStream.close();
        bufferedStream.close();
        fileStream.close();
    }
}