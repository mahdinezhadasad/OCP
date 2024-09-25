package inner;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

class Buch { // Buch ist Toplevel-Klasse
	
	private String titel = "Harry P.";
	
	protected class Seite { // Seite ist innere (inner, nested) Klasse
		void testAccess() {
			System.out.println(titel);
		}
	} // end of class Seite
	
} // end of class Buch

public class B01_WozuInnereKlassen {

	/*
	 * Mögliche Vorteile der inneren Klassen
	 * 
	 * -  Konflikte bei gleichen Klassennamen gibt es nicht,
	 *    wenn im selben Package die gleichnamigen Klassen die 
	 *    inneren Klassen sind
	 *     
	 * -  starke logische Verbindung mit dem äußeren Typ
	 * 
	 * -  Anzahl der Toplevel-Typen reduzieren
	 * 
	 * -  innere Klassen können beliebige Sichtbarkeiten bekommen
	 * 
	 * -  innere Klasse kann private Elemente der äußeren Klasse sehen 
	 * 
	 * -  innere Klasse, die nicht statisch ist, hat den Zugriff
	 *    auf ein Objekt der äußeren Klasse 
	 *    
	 * -  ...
	 */
	public static void main(String[] args) {

		Buch.Seite s1;
		
		Locale.Builder b1;
		
		Map.Entry e1;
		
		// Bsp. aus der Standardbibliothek: 
		// Die innere Klasse, die zum Erzeugen einer Liste
		// in der Arrays.asList verwendet wird.
		
	}

}
