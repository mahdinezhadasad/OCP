package IO.src.io;

public enum ExampleEnum {
    
    CONSTANT1{
        @Override
        public String getName(){
            return "constant1";
        }
    },
    CONSTANT2{
        @Override
        public String getName(){
            return "constant2";
        }
    }
    ;
    public abstract String getName();
    
    
    
    
}

class useEnumExample{
    
    public static void main(String[] args) {
        String value1 = ExampleEnum.CONSTANT1.getName ();
        String value2 = ExampleEnum.CONSTANT2.getName ();
        
        System.out.println ("Value 1: " + value1);
        System.out.println ("Value 2: " + value2);
        
        for(ExampleEnum constant : ExampleEnum.values ()){
            
            System.out.println (constant + " ->" + constant.getName ());
        }
    }
}