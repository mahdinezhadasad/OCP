package Functional.src.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        
        System.out.println("Average Salary of High-income employees: " + averageSalaries.get(true));
        System.out.println("Average Salary of Low-income employees: " + averageSalaries.get(false));
    }
}