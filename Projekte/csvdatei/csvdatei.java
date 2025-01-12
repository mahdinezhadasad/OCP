package csvdatei;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class csvdatei {
    
    public static void main(String[] args) {
        
        
        Path filePath = Paths.get ("plz_ort(in).csv");
        
        List<String[]> data = new ArrayList<>();
        
        // Step 2: Read the CSV file using Files.lines and store data
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(line -> data.add(line.split (",")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println ("print allll .........");
        
 
        
        data.stream ()
                .filter(entry -> entry.length > 2 && entry[2].trim().equals("8066"))
                .forEach (entry -> System.out.println (String.join (", " ,entry)+"99999999999999"));
        
        data.stream ()
                .filter (entry -> entry.length>2 && entry[2].trim().equals("8066"))
                .forEach (entry -> System.out.println (String.join (", " ,entry[1],entry[2],entry[3])));
        
        data.stream ()
                .filter (entry -> entry.length>2 && entry[2].trim().equals("8066"))
                .forEach (entry-> System.out.println (entry[1].trim ()));
    }
    

    
 
}