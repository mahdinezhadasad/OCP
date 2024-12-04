package vererbung;

public class Konstruktoren {
	
	class C1 {
		// generiert:
		// C1() {
		//   super();
		// }
	}
	
	
	class C2 extends C1 {
		// generiert:
		// C2() {
		//   super();
		// }
	}

	/*
	 * Der Compiler garantiert (vervollständigt auch):
	 * 
	 * 1. Eine Klasse hat mindestens einen Konstruktor
	 * 
	 * 2. Erste Anweisung im Konstruktor ist Aufruf eines anderen Konstruktors
	 * 
	 * 3. Alle Attribute werden nach dem super-Konstruktor-Aufruf initialisiert
	 */
	public static void main(String[] args) {


	}

}
