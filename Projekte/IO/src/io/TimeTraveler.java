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
    
    
    private static String formatMe(ZonedDateTime date) {
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime (FormatStyle.MEDIUM);
        return f.format (date);
        
    }
    
    public static void main(String[] twelve) {
        
    
        
    }
}