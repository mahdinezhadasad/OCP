package Threads.src.threads;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class LoggingSystem {
    
    private static LinkedBlockingQueue<String>  logQueue = new LinkedBlockingQueue<> (10);
    private static volatile boolean isRunning = true;
    
    
    public static void main(String[] args) {
        
        // Eine Liste von Zahlen
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Serialer Stream
        Optional<Integer> serialResult = numbers.stream()
                .findAny();
        System.out.println("Serialer Stream - findAny: " + serialResult.orElse(-1));
        
        // Paralleler Stream
        Optional<Integer> parallelResult = numbers.parallelStream()
                .findAny();
        System.out.println("Paralleler Stream - findAny: " + parallelResult.orElse(-1));
        
        
        
        Thread loggerThread  = new Thread( () -> {
            
            try{
                
                while(isRunning || !logQueue.isEmpty()){
                    
                    String logMessage = logQueue.poll();
                    
                    if(logMessage != null){
                        
                        writeLogToFile(logMessage);
                    }
                }
                
            }catch (Exception e){
                
                e.printStackTrace();
                
            }
              });
        loggerThread.start ();
        
        Thread appThread1 = new Thread( () -> generateLogs("AppThread-1"));
        Thread appThread2 = new Thread (() ->  generateLogs("AppThread-2"));
        Thread  appThread3 = new Thread (() -> generateLogs("AppThread-3"));
        
        appThread1.start ();
        appThread2.start ();
        appThread3.start ();
        
        try{
            
            appThread1.join ();
            appThread2.join ();
            appThread3.join ();
        }catch (InterruptedException e){
            
            Thread.currentThread().interrupt ();
        }
        
        System.out.println ("Logging system has shut down ");
        
    }
    
    private static void generateLogs(String threadName){
        
        
        for(int i = 0; i <=5; i++){
            
            
            String logMessage = threadName + " - Log Message: " + i;
            try{
                
                logQueue.put (logMessage);
                System.out.println ("Generated log message: " + logMessage);
            }catch (Exception e){
                
                Thread.currentThread().interrupt ();
            }
            
        }
        
    
    }
    
    // Method to simulate writing a log to a file
    private static void writeLogToFile(String logMessage) {
        System.out.println("Logging: " + logMessage);
        // Simulating a delay to write to a file
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}