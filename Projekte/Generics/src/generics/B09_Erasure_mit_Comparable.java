package generics;

import java.util.Arrays;
import java.util.Collection;


class PersonV1 {
	public int compareTo(PersonV1 p2) { return 0; }
	public int compareTo(Object obj) { return 0; }
}


class PersonV2 implements Comparable<PersonV2> {
	/*
	 * Erasure:
	 *   Der Compiler löscht beim Übersetzen
	 *   die generischen Angaben. Die Klasse
	 *   ist dann so: class PersonV2 implements Comparable { ...
	 *   
	 *   Dabei muss der Compiler die compareTo auch ändern:
	 *   
	 *     public int compareTo(Object param) {
	 *     	   PersonV2 p2 = (PersonV2) obj; // generiert vom Compiler
	 *     	   //...
	 *         return 0;
	 *     }
	 */
	public int compareTo(PersonV2 p2) {
		return 0;
	}

	/*
	 * Diese Methode kompiliert nicht, da beim Erasure
	 * eine Methode compareTo(Object) bereits entsteht
	 */
//	public int compareTo(Object obj) {
//		return 0;
//	}
}

public class B09_Erasure_mit_Comparable {

	/*
	 * Das Bsp. ist nicht prüfungsrelevant
	 */
	public static void main(String[] args) {

		/*
		 * Warum gibt es ClassCastException 
		 */
		Object[] arr = {
			12, "22", -7	
		};
		
		try {
			Arrays.sort(arr);
		} catch (ClassCastException e) {
			System.out.println("1. ClassCastException");
		}
		
		/*
		 * Nachbilden der Arbeit der sort beim Vergleichen:
		 */
		Object element0 = arr[0];
		Comparable element1 = (Comparable)arr[1];

		try {
			int res = element1.compareTo(element0);
			
			// eventuell positionen tauschen ...
			
		} catch (ClassCastException e) {
			System.out.println("2. ClassCastException");
		}
		
		/*
		 * Ein weiteres Bsp. von Erasure:
		 * 
		 * Es ist nicht möglich eine Methode zu überladen,
		 * wenn die Varianten sich nur durch Parametrisierungen 
		 * unterscheiden.
		 * 
		 *  S. die Methoden m
		 */
		
	} // end of main
	
//	static void m(Collection<Number> c) {}
//	static void m(Collection<Integer> c) {} 
	
}
