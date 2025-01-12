package IO.src.io;


import java.io.Closeable;
import java.io.IOException;

class Legs implements Closeable {
    
    public void close()  {}
}

class Storm{
    
    public static void main(String[] args) throws Exception {
        
        try(final AutoCloseable weatherTracker = new AutoCloseable () {
            @Override
            public void close()    {
            
            }
        }){
            System.out.println (weatherTracker.toString ());
        }
        catch (Exception e){
        
            
        }finally {
            System.out.println ("Storm closed");
        }
    }
}
 class Step {
  static{
      
      try(Legs leg = new Legs()){
          
          throw new IllegalArgumentException ();
      }catch (IllegalArgumentException e){
      
      }catch (Exception e){
      
      
      }
      finally {
          System.out.println ("final");
      }
  }
  
}
class SpellingException extends RuntimeException {}
class MissingMoneyExcepton extends Exception{}
class  MissingFoodException extends Exception{}
public class SpellChecker {
    
    public void doIHaveAProblem() throws MissingMoneyExcepton , MissingFoodException {
        
        System.out.println ("No problems");
    }
    
    class TideException extends Exception{}
    public static void main(String... participants) throws MissingMoneyExcepton , MissingFoodException {
       try{
           
           final SpellChecker spellChecker = new SpellChecker();
           spellChecker.doIHaveAProblem ();
       }catch (Exception e) {
           throw e;
       }
       
    }
    
    public void surf() throws RuntimeException{
        
        try{
            throw new TideException ();
        } catch (TideException | IllegalStateException e) {
        
        }
    }
}