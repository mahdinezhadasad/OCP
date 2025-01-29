package Threads.src.threads;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person {
    
    private String name;
    private LocalDate birthDate;
    
    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }
}

 class Test{
    
    public static void main(String[] args) {
        
        
        LocalDate date = LocalDate.of (1990,5,20);
        Person person = new Person("John Doe", date);
        
        System.out.println ("vorher: " + person.getBirthDate ());
        
        date = date.plusDays(1);
        System.out.println ("Nacher: " + person.getBirthDate ());
    }
}

class Student{
     
     private final List<String> subjects;
     
     public Student(List<String> subjects) {
         
         this.subjects = Collections.unmodifiableList (new ArrayList<> (subjects));
     }
     
     public List<String> getSubjects() {
         return subjects;
     }
}

class Test{
    public static void main(String[] args) {
        
        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("C++");
        
        Student  student = new Student(subjects);
        
        System.out.println ("Vorher: " + student.getSubjects ());
        
        List<String>  subectsFromGetter = student.getSubjects ();
        
        
        
    }
}