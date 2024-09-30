package func;

public class B05_LambdaInterpretieren {

	public static void main(String[] args) {

		Runnable r1 = () -> {
			System.out.println("mo");
			System.out.println("di");
		};
		
		/*
		 * Lambda ist die Beschreibung der Realisierung
		 * der abstrakten Methode:
		 * 
		 *  1. es soll eine Klasse generiert werden,
		 *     die das funktionale Interface implementiert.
		 *     
		 *     - Der Name der Klasse soll auch generiert werden.
		 *     
		 *     - Welches Interface realisiert werden soll wird 
		 *       aus der Zuweisung erkannt.
		 *    
		 *  class Blabla implements Runnable {
		 *  
		 *  }
		 *  
		 *  2. es soll die abstrakte Methode so realisiert werden,
		 *     wie die Lambda beschreibt.
		 *     
		 *     - Die weiteren Infos (z.B. der Methodenname)
		 *       für die Methode werden aus dem Interface gelesen 
		 *     
		 *  class Blabla implements Runnable {
		 *  	public void run() {
		 *  		System.out.println("mo");
		 *  		System.out.println("di");
		 *  	}
		 *  }
		 *  
		 *  3. Es soll ein neues Objekt der generierten Klasse erzeugt 
		 *     werden:
		 *     
		 *  Runnable r1 = new Blabla();
		 *     
		 */
		
		System.out.println("main");

		r1.run();
		
	}

}
