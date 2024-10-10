package aufgaben;

import java.util.ArrayDeque;
import java.util.Deque;

public class AufgabeDequePalindrom {

	public static void main(String[] args) {
		Character[] arr = { 'a', 'n', 'n', 'a' };
	    boolean erg = isPalindrome(arr);
	    System.out.println(erg); // true
	      
	    arr = new Character[] { 'r', 'o', 't', 'o', 'r' };
	    erg = isPalindrome(arr);
	    System.out.println(erg); // true

	    arr = new Character[] { 'm', 'o', 't', 'o', 'r' };
	    erg = isPalindrome(arr);
	    System.out.println(erg); // false
	    
	    arr = new Character[] { 'ü', 'o', 't', 'o', 'ü' };
	    erg = isPalindrome(arr);
	    System.out.println(erg); // true
	}
	
	static boolean isPalindrome(Character[] arr) {
		
		Deque<Character> deque = new ArrayDeque<Character>();
		
		for(Character ch : arr) {
			deque.add(ch);
		}
		
		while( deque.size() > 1 ) {
			Character c1 = deque.removeFirst();
			Character c2 = deque.removeLast();
			
			if(!c1.equals(c2)) {
				return false;
			}
		}
		
		return true;
	}

}
