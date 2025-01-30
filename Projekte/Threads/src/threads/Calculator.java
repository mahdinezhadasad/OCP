package Threads.src.threads;

interface AddNumbers{
    
    int add(int a, int b);
    static int subtract(int a, int b){ return a - b; }
    default int multiply(int a, int b){ return a * b; }
}

public class Calculator {
    
    protected void calculate(AddNumbers add, int a, int b){
        
        System.out.println (add.add(a,b));
    };
    
    public static void main(String[] args) {
        
        final Calculator calculator = new Calculator();
        calculator.calculate ((k,p) -> p+k+1,2,5);
    }
}