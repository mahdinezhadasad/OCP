package wdh.konstruktoren;

class C1 {
	/*
	 * Die Klasse hat den default-Konstruktor:
	 * 
	 * C1() {
	 *    super();
	 * }
	 */
}

class C2 {
	/*
	 * Die Klasse hat KEINEN default-Konstruktor,
	 * da sie den expliziten Konstruktor hat
	 */
	C2() {
		// super(); // generiert
	}
}

public class B01_Regeln {

	/*
	 * 1. Jede Klasse hat mindestens einen Konstruktor
	 * 
	 * 2. Wenn eine Klasse keinen expliziten Konstruktor hat,
	 *    wird der default-Konstruktor generiert:
	 *    	- Sichtbarkeit wie die der Klasse
	 *      - Keine Parameter
	 *      - Alle Regeln aus dem Punkt 3
	 *    
	 * 3. Alle Konstruktoren (auch der default-Konstruktor)
	 *    werden BEI BEDARF vervollständigt, so dass:
	 *    
	 *    - die erste Anweisung ist der Aufruf eines anderen 
	 *      Konstruktors mit dem Schlüßelwort this oder super. 
	 *      Wenn der Compiler die Anweisung generiert,
	 *      dann nur als 'super()'
	 *    
	 */
	public static void main(String[] args) {


	}

}
