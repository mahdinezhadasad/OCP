package Threads.src.threads;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

final class FallenException extends Exception{}

final class HikinGear implements AutoCloseable {
    @Override
    public void close() throws Exception {
        
        throw new FallenException();
        
    }
}


public class Cliff {
    
    public final void climb() throws Exception{
        
        try(HikinGear gear = new HikinGear()){
            
            throw new RuntimeException ("RuntimeException from climb()");
        }
    }
    
    public static void main(String[] args) {
      /*  try{
            
            new Cliff ().climb ();
        } catch (Throwable e) {
            System.out.println ("Primary Exception: " + e);
            for(Throwable suppressed : e.getSuppressed()){
                
                System.out.println ("Suppressed: " + suppressed);
            }
        }*/
        
        /*LocalDate hatDay = LocalDate.of (20147, Month.JANUARY,15);
        DateTimeFormatter f = DateTimeFormatter.ISO_DATE;
        System.out.println (f.format(hatDay));
        System.out.println (hatDay.format (f));*/
       /* LocalDate montyPythonDay = LocalDate.of(2017, Month.MAY, 10);
        LocalDate aprilFools = LocalDate.of(2018, Month.APRIL, 1);
        Duration duration = Duration.ofDays(1);
        LocalDate result = montyPythonDay.minus(duration);
        System.out.println(result + " " + aprilFools.isBefore(result));*/
        
/*        LocalDate date = LocalDate.of(2023, Month.JANUARY, 25);
        int year = date.getYear();
        LocalDate polarBearDay = LocalDate.of(2017, 2, 27);
        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        System.out.println(polarBearDay.format(formatter));
        
        LocalTime startTime = LocalTime.of (9,0);
        LocalTime endTime = LocalTime.of (17,30);
        
        long hoursBetween = ChronoUnit.HOURS.between (startTime, endTime);
        System.out.println ("Studen dazischen:" + hoursBetween);*/
        
        LocalDate montyPythonDay = LocalDate.of(2017,Month.MAY,10);
        LocalTime time = LocalTime.of (5,40);
        LocalDateTime dateTime = LocalDateTime.of(montyPythonDay, time);
        Duration duration = Duration.ofDays (1);
        LocalDateTime result = dateTime.minus (duration);
        System.out.println (result);
    }
    
    
    public boolean isItMyBirthday(LocalDateTime dateTime){
        
        LocalDate now = LocalDate.now ();
        return now.getMonth () == dateTime.getMonth ()
                && now.getDayOfMonth () == dateTime.getDayOfMonth ();
    }
}