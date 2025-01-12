package Functional.src.streams.wdh;

class ExampleSuppressedException {
    public static void main(String[] args) {
        try {
            methodA();
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
    
    static void methodA() throws Exception {
        try (AutoCloseable resource = new AutoCloseable() {
            @Override
            public void close() throws Exception {
                throw new Exception("Exception in close()");
            }
        }) {
            throw new Exception("Primary Exception");
        }
    }
}