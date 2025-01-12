package IO.src.io;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class TimeException extends Exception {}

class TimeMachine implements AutoCloseable {
    int v;
    
    public TimeMachine(int v) { this.v = v; }
    
    @Override
    public void close() throws TimeException { // Throws a general Exception
        System.out.print(v);
    }
}

public class TimeTraveler {
    
    
    public static void main(String[] twelve) {
        
        LocalDate xmas = LocalDate.of(2017,12,25);
        LocalDate  blackFriday = LocalDate.of(2017,11,24);
        long shoppnDaysLeft = blackFriday.until (xmas, ChronoUnit.DAYS);
        ChronoUnit.DAYS.between (blackFriday,xmas);
        System.out.println (shoppnDaysLeft);
        
        
    }
}