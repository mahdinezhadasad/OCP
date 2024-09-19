package wdh.strings;

import java.util.StringJoiner;

class Woche {
	/*
	 * Wenn der Compiler diese Klasse übersetzt, erzeugt
	 * der Compiler die Liste mit String-Literalen dieser Klasse:
	 * 
	 * 		"sa", "mo", "MO"
	 * 
	 * Wenn die JVM die Klasse laden wird, wird sie die Strings
	 * aus dieser Liste in den String-Pool übernehmen 
	 */
	
	static String besterTag = "sa"; // suche im String-Pool nach "sa"
	
	static String getText() {
		String s = "mo"; // suche im String-Pool nach "mo"
		String s2 = new String("mo"); 		// +1 String
		String s3 = "MO".toLowerCase();		// +1 String
		String s4 = "sa";
		return s + s2 + s3 + s4;
				// s + s2 -> Zwischenstring1 (momo)			// +1 String
				// Zwischenstring1 + s3 -> Zwischenstring2  // +1 String
				// Zwischenstring2 + s4 -> Ergebnisstring	// +1 String
	}
	
	static void m() { }
}

public class StringPool2 {

	public static void main(String[] args) {
		
		// Zeile A:   noch keine String-Objekte 
		
		Woche.m(); // Hier wird die Klasse Woche zum ersten Mal verwendet.
				   // Java lädt die Klasse Woche.
				   // String-Pool wird mit Strings "sa", "mo" und "MO" 
				   // vervollständigt.

		String m = Woche.getText(); // Zeile B. 5 neue String-Objekte erstellt
		System.out.println(m);
		/*
		 * 4 erzeugte String-Objekte stehen nach dem Aufruf dem GC
		 * zur Verfügung.
		 */

	}

}
