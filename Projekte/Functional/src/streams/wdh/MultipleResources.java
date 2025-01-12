package Functional.src.streams.wdh;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

class Lamb implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("l");
    }
}

class Goat implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("g");
    }
}

public class MultipleResources {
    public static void main(String[] args) throws Exception {
        
        Map<ToDos,String>  m = new HashMap<ToDos,String> ();
        ToDos t1 = new ToDos("Monday");
        ToDos t2 = new ToDos("Tuesday");
        ToDos t3 = new ToDos("Monday");
        
        m.put(t1, "doLaundry");
        m.put(t2, "payBills");
        m.put(t3, "ee");
        System.out.println (m.size ());
      
        
    }
    
    public void run() throws Exception {
        try (Lamb l = new Lamb();
             Goat g = new Goat()) {
            System.out.print("t");
            System.out.print("2");
        } finally {
            System.out.print("f");
        }
    }
}

class ToDos{
    
      String day;
      
      ToDos(String day) {
          this.day = day;
      }
      
      public boolean equals(Object o){
          
          return ((ToDos)  o).day.equals (this.day);
      }
        public int hashCode(){
          return 9;
}
    
        }