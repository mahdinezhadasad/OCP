package Collections.src.set;


import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetPractice {
    
    public static void main(String[] args) {
        
        
        Character[] arr = { 'a', 'n', 'n', 'a' };
        boolean erg = isPalindrome(arr);
        System.out.println(erg); // true
    
    
    }

    static boolean isPalindrome(Character[] arr){
        
        Deque<Character>  deque = new ArrayDeque<>();
        
        for(Character c : arr){
            
            deque.add(c);
        }
        
        while(deque.size ()>1){
            
            Character c1 = deque.removeFirst ();
            Character c2 = deque.removeLast ();
            
            if(!c1.equals(c2)){
                return false;
                
            }
           
        }
        return true;
        
    }

        
    }