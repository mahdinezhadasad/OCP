package Functional.src.streams.wdh;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@FunctionalInterface
interface FtoC{
    double convert(double x);
}
public class Pockets {
    public static void main(String[] args) {
        
    
   
    }
    
  


class Human {
    public Integer age;
    public String name;
    
    public Human(Integer age, String name) {
        this.age = age;
        this.name = name;
    }
    
    public Integer getAge() {
        return this.age;
    }
}

class Reading {
    int year, month, day;
    double value;
    
    Reading(int year, int month, int day, double value) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.value = value;
    }
}}