package Threads.src.concurrency;

import java.util.ArrayList;
import java.util.Objects;

public class Bussiness {
}
class Hotel extends Bussiness{}

class Inn extends Hotel{}

class Travel{
    
    ArrayList<Hotel> hotels = new ArrayList<Hotel>();
}

class Parent {
    int x = 10;
    
    Parent() {
        System.out.println("Parent constructor, x = " + x);
    }
}

class Child extends Parent {
    int y = 20;
    
    Child() {
        System.out.println("Child constructor, y = " + y);
    }
}