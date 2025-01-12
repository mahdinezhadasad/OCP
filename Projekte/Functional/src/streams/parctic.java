package Functional.src.streams;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class parctic {
    
    public static void main(String[] args) throws Exception {
        
        
       // bsp3();
        bsp1();
    
    }
    
    static void bsp3() throws Exception{
        
        
        ExecutorService  service = Executors.newCachedThreadPool ();
        
        Callable<Integer> t1 = () ->{
            
            System.out.println ("task 1");
            
            return 111;
        };
        
        Callable<Integer>  t2 = () ->{
            
            
            System.out.println ("task 2");
            return 222;
        };
        
        Collection<Callable<Integer>>  tasks = Arrays.asList(t1,t2);
        List<Future<Integer>> futures = service.invokeAll(tasks);
        
        
        for(Future<Integer> future : futures){
            
            System.out.println (future.isDone () +
                    " " + future.get ());
            
            
        }
        
        service.shutdown ();
    }
    
    
    static void bsp2() throws Exception{
        
        ExecutorService  service = Executors.newCachedThreadPool ();
        
        Callable<String> task = () -> {
            
            System.out.println ("task");
            return "mo";
        };
        
        Future<String> future = service.submit(task);
        
        String result = future.get ();
        
        System.out.println (result);
        service.shutdown ();
    }
    
    static void bsp1() throws Exception{
        
        ExecutorService  service = Executors.newCachedThreadPool ();
        service.execute (() -> System.out.println ("task 1"));
        service.execute (() -> System.out.println ("task 2"));
        
        try{
            
            
            service.awaitTermination (1, TimeUnit.DAYS);
            System.out.println ("main nach awaitTermination");
        }catch (InterruptedException e){
            
            e.printStackTrace ();
        }
        
    }
    
  
}