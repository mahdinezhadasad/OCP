package wdh.wrapper;

public class KonstantenPools {

	/*
	 * Autoboxing: der vom Compiler generierter Aufruf der
	 * statischen Methode valueOf, dort, wo eine Referenz
	 * benötigt wird, aber ein primitiver Wert steht.
	 * 
	 *  Für Byte, Short, Integer, Long haben eigene Konstanten-Pools.
	 *  
	 *   Z.B. für die Klasse Integer:
	 *   
	 *   Wenn die Integer.valueOf(int) aufgerufen wird,
	 *   liefert sie die Integer-Referenz aus dem Integer-Pool,
	 *   wenn der übergebene primitiver Wert aus dem Bereich [-128..127] ist. 
	 *   Ansonsten erzeugt die Methode ein neues Integer-Objekt.
	 *   
	 *   Integer-Pool ist ein Array mit Integer für die Werte [-128..127]
	 */
	public static void main(String[] args) {
	
		Integer x1 = 12; // Integer.valueOf(12)
		Integer x2 = 12; // Integer.valueOf(12)

		System.out.println("x1 == x2: " + (x1==x2)); // true
		
		Integer x3 = Integer.valueOf(12); // manuelles Boxing
		
		System.out.println("x1 == x3: " + (x1==x3)); // true
		
		Integer y1 = 1200; // Integer.valueOf(1200)
		Integer y2 = 1200; // Integer.valueOf(1200)
		
		System.out.println("y1 == y2: " + (y1==y2)); // false
		
	}

}
