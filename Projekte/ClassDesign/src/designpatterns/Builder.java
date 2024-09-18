package designpatterns;

import java.util.Locale;

public class Builder {

	/*
	 * Builder: Klasse so gestalten, dass damit das Bilden
	 * neuer komplizierter Objekte bequemer gestaltet werden kann,
	 * als es mit vielen überladenen Konstruktoren möglich wäre
	 */
	public static void main(String[] args) {
		
		String s = new StringBuilder()
			.append(false)				// konstruieren
			.append("Java") 			// konstruieren
			.replace(0, 5, "Sprache") 	// konstruieren
			.insert(7, " ") 			// konstruieren
			.toString(); // bilden

		System.out.println("s = " + s);
		
		Locale loc = new Locale.Builder()
			.setRegion("DE")	// konstruieren
			.setLanguage("de")	// konstruieren
			.build(); 			// bilden
		
		System.out.println("loc = " + loc);
	}

}
