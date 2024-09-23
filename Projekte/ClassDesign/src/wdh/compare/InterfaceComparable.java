package wdh.compare;

import java.util.Arrays;

public class InterfaceComparable {

	public static void main(String[] args) {

		/*
		 * Wenn eine Klasse Comparable realisiert,
		 * wird dir compareTo-Methode den für
		 * die Klasse 'natürlichen' Vergleich implementieren.
		 */
		Comparable<String> c1 = "mo";
		
		int result = c1.compareTo("di");

		if(result < 0) {
			System.out.println("mo ist kleiner als di");
		} else if (result > 0) {
			System.out.println("mo ist grösser als di"); // Ausgabe
		} else {
			System.out.println("mi ist gleich di");
		}
		
		/*
		 * Die Standard-Sortierung verwendent den 'natürlichen' Vergleich
		 */
		
		String[] arr = {
			"mo", "di", "mi", "do"
		};
		
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr)); // [di, do, mi, mo]
		
	}

}
