package Threads.src.threads;

public class WhaleSharkException extends Exception{
    
    public WhaleSharkException(){
        super("Friendly Shark");
    }
    
    public WhaleSharkException(String message){
        super(new Exception (new WhaleSharkException ()));
    }
    
    public WhaleSharkException(Exception cause){}
}