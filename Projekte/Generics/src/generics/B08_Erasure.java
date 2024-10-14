package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B08_Erasure {

	/*
	 * Exam:
	 * 
	 * 		Der Compiler wird (nach dem Überprüfen der Korrektheit)
	 * 		die generischen Angaben beim Übersetzen löschen (Erasure)
	 * 
	 * Nicht in der Prüfung:
	 * 
	 * 		Beim Erasure generiert der Compiler oft
	 * 		Sicherheitscode für Laufzeitkontrollen
	 */
	public static void main(String[] args) {
		
		List<Integer> list; // übersetzt: 32-Bit Referenz reservieren
		
		new ArrayList<Integer>(); // übersetzt: erzeuge ein neues Object
								  // vom Typ ArrayList

		list = new ArrayList<Integer>();
		
		System.out.println(list.getClass()); // class java.util.ArrayList
		
		/*
		 * Exam. Folgender Code generiert ClassCastException
		 */
		Object[] arr = {
			12,
			"22",
			-3
		};
		
		Arrays.sort(arr); // ClassCastException!
		
	}

}
