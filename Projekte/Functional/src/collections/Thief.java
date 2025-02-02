package Functional.src.collections;

class Combinatio{
    
    private int[]  combo = {17,24,36};
    int[]  getCombo()  {return combo;}
    void printCombo(){
        
        for(int x : combo){
            System.out.println (x + "");
        }
    }
}


public class Thief {
    
    public static void main(String[] args){
        
        Combinatio c = new Combinatio();
        c.printCombo();
        System.out.println ("*****************************************");
        int[] myArray = c.getCombo();
        myArray[0] = 18;
        
        c.printCombo();
    }
}