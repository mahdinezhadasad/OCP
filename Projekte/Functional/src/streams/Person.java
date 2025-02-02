package Functional.src.streams;



import org.w3c.dom.ls.LSOutput;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

class Person {
    
    String name;
    int age;
    double salary;
    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
class PartitioningAndMapping{
    
    public static void main(String[] args) {
        
        List<Person> people = List.of(
                
                new Person("Alice", 25, 6000),
                new Person("Bob", 30, 4800),
                new Person("Charlie", 35, 7500),
                new Person("David", 22, 3000),
                new Person("Eve", 40, 5200),
                new Person("Frank", 28, 4000)
        );
        
        Map<Boolean,List<String>> partioonedPeple = people.stream ()
                .collect(Collectors.partitioningBy (
                        p -> p.age>=18,
                        Collectors.mapping (p -> p.name, Collectors.toList ())
                ));
        
        System.out.println ("Adults:" + partioonedPeple.get (true));
        System.out.println ("Minors " + partioonedPeple.get (false));
        
        Map<Boolean,List<String>> salaryGroups = people.stream ()
                .collect(Collectors.partitioningBy (
                        
                        e -> e.salary >=5000,
                        Collectors.mapping (e -> e.name,Collectors.toList ())
                ));
        
        Map<Boolean,Double>  averageSalaries = people.stream ().collect (
                Collectors.partitioningBy (
                        
                        e -> e.salary>5000,
                        Collectors.averagingDouble ( e -> e.salary )
                )
        );
        Map<String,List<String>> ageGroups = people.stream ().collect (
                Collectors.groupingBy (
                        
                        e -> {
                            if(e.age <= 25) return "Young";
                            else if( e.age<=35) return "Mid";
                            else return "Senior";
                        },
                        Collectors.mapping (e -> e.name,Collectors.toList ())
                )
        );
        ageGroups.putIfAbsent ("Teen", new ArrayList<> (Arrays.asList ("Leo","Mia")));
        ageGroups.putIfAbsent ("Young", new ArrayList<> (Arrays.asList ("Mike","John")));
        
        System.out.println(ageGroups);
        System.out.println("Average Salary of High-income employees: " + averageSalaries.get(true));
        System.out.println("Average Salary of Low-income employees: " + averageSalaries.get(false));
        
        LongStream stream = LongStream.of (6,7);
        LongSummaryStatistics stats = stream.summaryStatistics ();
        System.out.println (stats.getAverage ());
        eatDessert (Optional.of ("Cupcake"));
        
        /*Stream<Character>  chars = Stream.generate(() -> 'a');
        chars.filter(c -> c < 'b')
                .sorted ()
                .findFirst ()
                .ifPresent (System.out::println);*/
        
        Stream<String> streeam = Stream.of ("Java","Spring");
        streeam.flatMap (s -> Stream.of ("Lang " + s, "Tech: " +s))
                .forEach (System.out::println);
    }
    
    public static void eatDessert(Optional<String> opt){
        
        System.out.println (opt.orElseGet (()->("No dessert today")));
    }
}