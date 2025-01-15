package IO.src.io;

public class LocalInnerClassExample {
    
    public void demonstrate() {
        // Final variable
        final String finalVar = "I am final";
        
        // Effectively final variable (not declared final, but never reassigned)
        String effectivelyFinalVar = "I am effectively final";
        
        // This would cause an error if uncommented:
        // effectivelyFinalVar = "Reassigned"; // Now it is no longer effectively final
        
        // Local inner class
        class InnerClass {
            public void printVariables() {
                System.out.println(finalVar); // Accessing final variable
                System.out.println(effectivelyFinalVar); // Accessing effectively final variable
            }
        }
        
        // Instantiating the local inner class and calling its method
        InnerClass inner = new InnerClass();
        inner.printVariables();
    }
    
    public static void main(String[] args) {
        LocalInnerClassExample example = new LocalInnerClassExample();
        example.demonstrate();
    }
}