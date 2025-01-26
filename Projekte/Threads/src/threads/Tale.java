package Threads.src.threads;

public class Tale {
    
    class BearException extends  RuntimeException{}
    class WolfException extends  RuntimeException{}
    class  DragonException extends  RuntimeException{}
    
    public int tellStory(){
        
        try{}
        catch (BearException e){
            
            e = (BearException) new RuntimeException ();
            throw e;
        }catch (WolfException | DragonException e){
            
            throw new RuntimeException ();
            
        }
        
        return 0;
        
    }
    
    public static void main(String[] args) {
        new Tale ().tellStory ();
    }
}