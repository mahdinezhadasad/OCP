package Generics.src.generics;


    
    public class S {
        static class A implements AutoCloseable {
            public void close() throws Exception {
                throw new Exception("catch");
            } }
        
        private static void method() throws Exception {
            try (A a = new A()) {
                throw new Exception("try");
            } finally {
                throw new Exception("finally");
            } }
        
        public static void main(String[] args) {
            try {
                method();
            } catch(Exception e) {
                System.out.println(e.getMessage());
                System.out.println(e.getSuppressed()[0]);
            } } }

class Two {
    static class Good implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("Good");
        }
    }
    
    static class Bad implements AutoCloseable {
        public void close() throws Exception {
            System.out.println("Bad");
            throw new Exception("bad exception");
        }
    }
    
    public static void main(String[] args) {
        try (Good good = new Good(); Bad bad = new Bad()) {
            System.out.println("ssssssssssssssss");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
            
            // Printing suppressed exceptions
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed exception: " + suppressed);
            }
        }
    }
}