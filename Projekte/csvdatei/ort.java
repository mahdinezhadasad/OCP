package csvdatei;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ort {
    
    String ort;
    
    String plz;
    
    String bundesland;
    
    public ort(String ort, String plz, String bundesland) {
        this.ort = ort;
        this.plz = plz;
        this.bundesland = bundesland;
    }
    
    
    @Override
    public String toString() {
        return String.format ("Ort: %s , PLZ:%s, Bundesland: %s", ort, plz, bundesland);
    }
    
    
    public static class PostleitzahlAuswertung {
        
        public static void main(String[] args) throws IOException {
            
            Path filePath = Paths.get ("plz_ort(in).csv");
            
          
            List<ort> ortList = new ArrayList<> ();
            
            try (Stream<String> lines = Files.lines (filePath)) {
                
                lines.map (line -> line.split (","))
                        .filter (entry -> entry.length > 3)
                        .map (entry -> new ort (entry[1].trim (), entry[2].trim (), entry[3].trim ()))
                        .forEach (ortList::add);
            } catch (IOException e) {
                
                e.printStackTrace ();
            }
            
            System.out.println("\nOrt-Objekt mit der größten Postleitzahl:");
            ortList.stream ()
                    .sorted (Comparator.comparing (ort-> ort.plz))
                    .forEach (System.out::println);
            
            String bundeslanderList = ortList.stream ()
                    .map(ort -> ort.bundesland)
                    .distinct ()
                    .collect(Collectors.joining(", "));
            
            System.out.println (bundeslanderList);
            
            
            ortList.stream ()
                    .collect (Collectors.groupingBy (ort-> ort.ort,Collectors.counting ()))
                    .entrySet ().stream ()
                    .max(Map.Entry.comparingByValue ())
                    .ifPresent (enty-> System.out.println ("ort :" + enty.getKey ()+ "Anzahl :" + enty.getValue ()));
            
            Map<String,Long> bundeslandGroup = ortList.stream ()
                    .collect (Collectors.groupingBy (ort-> ort.bundesland,Collectors.counting ()));
                     bundeslandGroup.forEach ((bundesland,count)-> System.out.println (bundesland + ": " + count ));
        }
    }
}