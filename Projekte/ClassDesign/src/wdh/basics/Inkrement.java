package wdh.basics;

public class Inkrement {

	public static void main(String[] args) {
		
		int x = 0;
		
		/*
		 * Inkrement ist selbst das Statement:
		 *
		 * x wird einfach um 1 erhöht 
		 */
		x++;
		++x;
		
		System.out.println("1. x = " + x); // 2
		
		/*
		 * Inkrement kommt vor in einem Statement/Expression,
		 * wo die Variable an weiteren Operationen beteiligt wird.
		 * 
		 * Postinkrement:
		 * 
		 * 		x für die nächste Operation lesen
		 * 		x inkrementieren
		 * 		den davor gelesenen Wert weiter verwenden
		 * 
		 * Präinkrement:
		 * 
		 * 		x inkrementieren
		 * 		x für die nächste Operation lesen
		 * 		den gelesenen Wert weiter verwenden
		 * 
		 * 
		 */
		
		int y = x++;
		System.out.println("2. y = " + y); // 2
		System.out.println("2. x = " + x); // 3
		

	}

}
