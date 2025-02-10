package Generics.src.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JellyBean {
    String flavor;
    
    public JellyBean(String flavor) {
        this.flavor = flavor;
    }
    
    
    
  
    
    @Override
    public String toString() {
        return "JellyBean{" +
                "flavor='" + flavor + '\'' +
                '}';
    }
    private static <T extends Collection<U> ,U> U add(T list, U element){
        list.add(element);
        
        return element;
        
    } 
    public static void main(String[] args) {
        
        List<String> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        add(list,"duck");
        add(list,"goose");
        add(list,"ffff");
        add(list1,1);
        add(list1,2);
        add(list1,3);
        
        System.out.println ( list1);
       
     
    }
}