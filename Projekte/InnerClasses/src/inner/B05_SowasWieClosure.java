package inner;

import java.time.LocalTime;

abstract class Tier {
	
	static Tier getLieblingstier() {
		
		LocalTime time = LocalTime.now();
		
		// lokale Klasse
		class Hund extends Tier {
			
			public String toString() {
				// time = null; // cf
				return "Hund. Erstellt um " + time; // Zugriff auf die lokale
													// Variable der Methode
													// getLieblingstier
			}
			
		} // end of local class Hund
		
		// time = null; // an sich ok, aber dadurch ensteht
						// ein Compiilerfehler in der toString der Klasse Hund
		
		return new Hund();
	}
}

public class B05_SowasWieClosure {

	/*
	 * Closure: https://de.wikipedia.org/wiki/Closure_(Funktion)
	 * 
	 * Der Zugriff auf die lokale Variable der umschliessenden Methode
	 * in der Methode einer lokalen Klasse (oder einer lokalen anonymen 
	 * Klasse, oder in einer Lambda) funktioniert nur, wenn die Variable
	 * 'effectively final' bleibt
	 */
	public static void main(String[] args) throws Exception {
		
		Tier t1 = Tier.getLieblingstier();
		System.out.println("t1: " + t1.toString());
		
		Thread.sleep(1000);
		
		Tier t2 = Tier.getLieblingstier();
		System.out.println("t2: " + t2);
		
		System.out.println("t1: " + t1);

	}

}
