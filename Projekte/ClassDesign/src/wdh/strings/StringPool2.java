package wdh.strings;

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
		String s2 = new String("mo");
		String s3 = "MO".toLowerCase();
		String s4 = "sa";
		return s + s2 + s3 + s4;
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

		
	}

}
