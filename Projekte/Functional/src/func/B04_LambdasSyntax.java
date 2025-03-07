package func;

public class B04_LambdasSyntax {

	interface I1 {
		void m();
	}
	interface I2 {
		void m(int x);
	}
	interface I3 {
		void m(int x, String y);
	}
	interface I4 {
		int m();
	}
	
	public static void main(String[] args) {
		
		/*
		 *  Liste der Parameter. 
		 * 
		 *  Vollständige (ausführliche) Notation 
		 *  (wie in einer normalen Java-Methode)
		 */
		
		I1 v1 = () -> {};
		I2 v2 = (int a) -> {};
		I3 v3 = (int param1, String param2) -> {};

		/*
		 *  Liste der Parameter. 
		 * 
		 *  Kompakte Notation:
		 *  	- ohne Parameter-Typen
		 *  	- ohne der runden Klammer 
		 *  		- nur bei genau einem Parameter
		 *  		- Typ-Angabe muss auch weg
		 */
		// I1 v10 =  -> {}; // cf
		
		I2 v20 = (a) -> {};
		I2 v21 = a -> {};
		// I2 v22 = int a -> {}; // cf
		
		I3 v30 = (param1, param2) -> {};
		// I3 v31 = (int param1, param2) -> {};		// cf
		// I3 v32 = (param1, String param2) -> {};	// cf
		
		/*
		 *  Methoden-Rumpf (Körper)
		 * 
		 *  Vollständige (ausführliche) Notation 
		 *  (wie in einer normalen Java-Methode)
		 */
		
		I1 v100 = () -> {};
		
		I1 v101 = () -> {
			System.out.println("line 1");
			System.out.println("line 2");
		};
		
		I4 v4 = () -> {
			return 42;
		};
		
		/*
		 *  Methoden-Rumpf (Körper)
		 * 
		 *  Kompakte Notation:
		 *  	Ohne der geschweiften Klammer
		 *  		- wenn es genau eine Anweisung gibt
		 *  		- Semikolon nach der Anweisung sollte auch weg
		 *  		- return muss auch weg (bei nicht-void-Methoden) 
		 */
		
		I1 v50 = () -> {};  // ausführlich, keine Anweisungen
		// I1 v51 = () -> ; // cf: kompakt, keine Anweisungen
		
		I1 v52 = () -> System.out.println("mo");
		
		I4 v6 = () -> 42;
		// I4 v61 = () -> return 42; // cf
		
//		doStuff( () -> { return 42 } ); // cf: ausführlich, Semikolon fehlt
		doStuff( () -> { return 42; } ); 
//		doStuff( () -> 42; ); // cf: kompakt, Semikolon nicht entfernt 
		doStuff( () -> 42 );  
		
	} // end of main

	static void doStuff(I4 param) {}
	
}
