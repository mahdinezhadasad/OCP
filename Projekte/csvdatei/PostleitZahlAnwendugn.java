package csvdatei;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PostleitZahlAnwendugn {
    
    public static void main(String[] args) {
        
        Path filePath = Paths.get ("plz_ort(in).csv");
        
        List<location>  locations = new ArrayList<> ();
        
        try(Stream<String> lines = Files.lines(filePath)){
            
            lines.map (line -> line.split(",")).
                    filter (entry ->entry.length>3)
                    .map (entry -> new location (entry[1],entry[2],entry[3]))
                    .forEach (locations::add);
        }
        catch (IOException e){
            
            System.out.println ("Fehler beim Laden der Postleitzung von " + e.getMessage ());
            return;
        }
        
        Scanner scanner = new Scanner (System.in);
        while(true){
            
            System.out.println ("\nGebenSie eine fünfstellige Postleitzahl oder Ort ein (oder 'exist' zum Beenden :");
            String input = scanner.nextLine ().trim ();
            
            if(input.equalsIgnoreCase ("exit")){
                
                break;
            }
            
            if(input.matches ("\\d{5}")){
                
                String plz = input;
                List<location> result = locations.stream ()
                        .filter (ort->ort.plz.equals (plz))
                        .toList ();
                        
                if(result.isEmpty ()){
                    
                    System.out.println ("keine Orte gefunden für Plz" + plz);
                }
                else {
                    
                    System.out.println ("Gefudene Orte für plz " + plz +":");
                    result.forEach (System.out::println);
                    
                    
                }
               
                
            }else {
                
                String city = input;
                
                List<String> plzlist = locations.stream ()
                        .filter (ort->ort.ort.equalsIgnoreCase (city))
                        .map(ort-> ort.plz)
                        .distinct ()
                        .collect(Collectors.toList ());
                
                if(plzlist.isEmpty ()){
                    
                    System.out.println ("keine Postleitzahl gefunden für den Ort : "+ city);
                }
                else{
                    
                    System.out.println ("Gefunden Postleitzahlen für den Ort" + city +":");
                    
                    System.out.println (String.join(", ", plzlist));
                    
                }
            }
            
        }
        scanner.close();
        
    }
}

class location{
    
    String ort;
    String plz;
    String bundesland;
    
    public location(String ort, String plz, String bundesland) {
        this.ort = ort;
        this.plz = plz;
        this.bundesland = bundesland;
    }
    
    @Override
    public String toString() {
        return String.format ("Ort: %s, PLZ:%s Bundesland: %s", ort, plz, bundesland);
    }
    
    
}