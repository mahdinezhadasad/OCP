package inner;

public class B04_lokaleKlassen {

	/*
	 * lokale Klasse:
	 * 	
	 * 		- wird in einer Methode definiert
	 * 		- ist ab der Stelle der Definition
	 * 		  bis zum Ende der Methode gültig 
	 */
	public static void main(String[] args) {
		// Game g1 = new Game(); // cf: unbekannte Klasse

	}
	
	
	static void myMethod() {
		
		// Game g1 = new Game(); // cf: unbekannte Klasse
		
		class Game {
			
		} // gültig ab hier bis zum Ende der Methode
		
		Game g2 = new Game();
	}

}
