package Wdh.src.vererbung;


import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

class Prodduct {
    String pname;
    
    public Prodduct(String pname) {
        this.pname = pname;
    }
    

    

}

class Engine {
    int fuelLevel;
    
    Engine(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    
    public void start() {
        // Test different assertion options here:
        // Uncomment one assertion option at a time to test.
        
        // Option A
        // assert (fuelLevel > 0) : "Terminating...";
        
        // Option B
        // assert (fuelLevel > 0) : System.out.println("Impossible fuel");
        
        // Option C
        // if (fuelLevel <= 0) {
        //     System.exit(0);
        // }
        
        // Option D
        assert fuelLevel > 0 : "Impossible fuel";
        
        System.out.println("Started");
    }
    
    public void stop() {
        System.out.println("Stopped");
    }
}


class Resource implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("Close-");
    }
    
    public void open() {
        System.out.print("Open-");
    }
}
public class StrMan {
    public static void doStuff(String s) {
        try {
            if (s == null) {
                throw new NullPointerException();
            }
        } finally {
            System.out.println("-finally-");
        }
        System.out.println("-doStuff-");
    }
    public static Optional<String> getCountry(String loc) {
        Optional<String> couName = Optional.empty();
        if ("Paris".equals(loc)) {
            couName = Optional.of("France");
        } else if ("Mumbai".equals(loc)) {
            couName = Optional.of("India");
        }
        return couName;
    }
    public static void main(String[] args) {
        Stream<List<String>> strs = Stream.of(
                Arrays.asList("text1", "text2"),
                Arrays.asList("text2", "text3")
        );
        
        Stream<String> bs2 = strs
                .filter(b -> b.contains("text1"))
                .flatMap(rs -> rs.stream());
        
        bs2.forEach(b -> System.out.print(b));
        
    }
    }