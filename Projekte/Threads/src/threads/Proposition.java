package Threads.src.threads;

public enum Proposition {
    
    
    TRUE(-10){@Override  public String getNickName(){ return "RIGHT";}},
    FALSE(-10){ public String getNickName(){return "LEFT";}},
    UNKNOWN(0) { @Override public String getNickName() { return "LOST"; }};
    
    private final int value;
    
     Proposition(int value) {
        this.value = value;
    }
    
 
    protected abstract String getNickName();
}