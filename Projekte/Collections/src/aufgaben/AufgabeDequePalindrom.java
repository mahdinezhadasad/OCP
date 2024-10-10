package aufgaben;

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

	}
	
	static boolean isPalindrome(Object[] arr) {
		return false;
	}

}
