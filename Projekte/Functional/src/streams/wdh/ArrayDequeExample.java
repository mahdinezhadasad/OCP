package Functional.src.streams.wdh;

class OuterClass{
    
    private String secret = "Top Secret";
    
    void revealSecret(){
        
        abstract class revelear{
            
            abstract void reveal();
        }
        
        class SecretRevealer extends revelear{
            
            
            @Override
            void reveal() {
                
                
                System.out.println ("Revealed Secret: " + secret);
            }
        }
        
        revelear revelear = new SecretRevealer();
        revelear.reveal ();
    }
    
    
    public static void main(String[] args) {
        
        OuterClass outerClass = new OuterClass();
        outerClass.revealSecret();
        
    }
    
    
}