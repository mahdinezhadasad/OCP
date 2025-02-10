package Generics.src.generics;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class AppointmentTreeMapExample {
    
    public static void main(String[] args) {
        
        TreeMap<LocalDateTime,String>  appointments = new TreeMap<>();
        appointments.put(LocalDateTime.of(2024,6,15,10,30),"ArzTermin");
        appointments.put(LocalDateTime.of(2024,6,15,10,30),"Meeting mit kunde");
        appointments.put(LocalDateTime.of(2024,6,15,10,30),"Fittnesstudio");
        
        System.out.println ("Termine nach Datum sortiert: ");
        
        for(Map.Entry<LocalDateTime,String> entry : appointments.entrySet()){
            
            System.out.println (entry.getKey () + " - " + entry.getValue());
        }
        
        System.out.println ("\n Nächstegelegener Termin nach 13.06.2024");
        
        System.out.println (LocalDateTime.of (2024,6,13,0,0));
        
        
    }
}