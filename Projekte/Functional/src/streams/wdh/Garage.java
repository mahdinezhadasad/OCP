package Functional.src.streams.wdh;


abstract class Shape {
    // Constructor for Shape
    Shape() {
        System.out.println("Shape");
    }
    
    // Abstract area method
    protected void area() {
        System.out.println("Shape");
    }
}

class Square extends Shape {
    int side;
    
    // Constructor for Square
    Square(int side) {
        super(); // Call the parent class constructor
        this.side = side;
    }
    
    // Overridden area method
    public void area() {
        System.out.println("Square");
    }
}

class Rectangle extends Square {
    int len, br;
    
    // Constructor for Rectangle
    Rectangle(int x, int y) {
        super(x); // Call the constructor of the Square class
        len = x;
        br = y;
    }
    
    // Overridden area method
    public void area() {
        System.out.println("Rectangle");
    }
}