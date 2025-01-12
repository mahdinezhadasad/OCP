package Functional.src.func;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Job {
    
    String name;
    Integer cost;
    Job(String name, Integer cost) {
        this.name = name;
        this.cost = cost;
    }
    String getName() {return name;}
    int getCost() {return cost;}
}
class TestClass {
    
    public static Optional<String> getCountry(String loc) {
        if ("Paris".equals(loc)) {
            return Optional.of("France");
        } else if ("Mumbai".equals(loc)) {
            return Optional.of("India");
        } else {
            return Optional.empty(); // Explicitly return Optional.empty() for clarity
        }
    }
    
    public static double applyDiscount(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0"); // Better error handling
        }
        return price * 0.50;
    }
    
    
    public static void main(String[] args) throws IOException {
        
        if (args.length == 0) {
            System.err.println("Usage: java Product <price>"); // Handle missing argument
            return; // Exit the program
        }
        
        try {
            double price = Double.parseDouble(args[0]);
         
            double newPrice = applyDiscount(price);
            System.out.println("New Price: " + newPrice);
        } catch (NumberFormatException e) {
            System.err.println("Invalid price format: " + args[0]); // Handle parsing errors
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage()); // Handle invalid price values
        }
        
        
        Stream<List<String>> strs = Stream.of(
                Arrays.asList("text1", "text2"),
                Arrays.asList("text2", "text3")
        );
        
        Stream<String> bs2 = strs
               // .filter(list -> list.contains("text1")) // Filter lists containing "text1"
                .flatMap(List::stream); // Flatten the remaining list into a Stream<String>
        
        bs2.forEach(System.out::print); // Print each string in the stream
        
        System.out.println();
        
        //More examples to understand flatMap
        Stream<List<String>> strs2 = Stream.of(
                Arrays.asList("text1", "text2"),
                Arrays.asList("text2", "text3"),
                Arrays.asList("text4")
        );
        Stream<String> bs3 = strs2.flatMap(List::stream);
        bs3.forEach(System.out::print);
        
        Stream<String[]> stringArrays = Stream.of(new String[]{"a","b"},new String[]{"c","d","e"});
        Stream<String> bs4 = stringArrays.flatMap(Arrays::stream);
        bs4.forEach(System.out::println);
        System.out.println();
        
        double d = 15;
        Locale locale = new Locale ("en", "US"); // Correct variable name
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale); // Use the Locale object
        
        System.out.println(formatter.format(d));
        
        
        
        // Demonstrate with other locales
        Locale germanLocale = new Locale("de", "DE");
        NumberFormat germanFormatter = NumberFormat.getCurrencyInstance(germanLocale);
        System.out.println("German: " + germanFormatter.format(d));
        
        Locale frenchLocale = new Locale("fr", "FR");
        NumberFormat frenchFormatter = NumberFormat.getCurrencyInstance(frenchLocale);
        System.out.println("French: " + frenchFormatter.format(d));
        
        double amount = 1500.50; // Example amount
        
        // Turkish Lira (TRY)
        Locale turkishLocale = new Locale("tr", "TR");
        NumberFormat turkishFormat = NumberFormat.getCurrencyInstance(turkishLocale);
        System.out.println("Turkish Lira: " + turkishFormat.format(amount));
        
        // Indian Rupee (INR)
        Locale indianLocale = new Locale("en", "IN"); // Or "hi", "IN" for Hindi
        NumberFormat indianFormat = NumberFormat.getCurrencyInstance(indianLocale);
        System.out.println("Indian Rupee: " + indianFormat.format(amount));
        
        // Using Currency class for more control (example for INR)
        Currency indianCurrency = Currency.getInstance(new Locale("en", "IN")); // Get Currency instance
        NumberFormat indianFormat2 = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        indianFormat2.setCurrency(indianCurrency); // Set the currency if needed (usually redundant)
        
        System.out.println("Indian Rupee (using Currency): " + indianFormat2.format(amount));
        
        //Example for locale that does not exist
        Locale nonExistentLocale = new Locale("xx", "XX");
        NumberFormat nonExistentFormat = NumberFormat.getCurrencyInstance(nonExistentLocale);
        System.out.println("Non Existent Locale: " + nonExistentFormat.format(amount));
        
        
    }

}
enum Course {
    JAVA(100),
    J2ME(200);
    private int cost;
    Course(int cost) {
        this.cost = cost;
    }
    int getCost() {return cost;}
}