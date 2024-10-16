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

class C3 {
	C3() {
		super();
	}
}

class C4 {
	C4(int x) {
		// super(); // generiert
	}
}

class C5 {
	C5() {
		// super(); // generiert
	}
	
	C5(int x) {
		this();
	}
}

class C6 {
	int x;
	String y;
	boolean z;
	
	C6() {
		// super(); 		// generiert
		// this.x = 0;		// generiert
		// this.y = null;	// generiert
		// this.z = false;	// generiert
	}
	
	C6(int x) {
		this();
	}
	
	C6(String y) {
		// super(); 		// generiert
		// this.x = 0;		// generiert
		// this.y = null;	// generiert
		// this.z = false;	// generiert
		System.out.println("C6(String). this.y = " + this.y);
	}
}


class C7 {
	int x = 42;
	
	C7(int x) {
		// super(); // generiert
		this.x = x;
		System.out.println("C7(int). this.x = " + this.x);
	}
	
	C7() {
		// super();
		// this.x = 42;
		System.out.println("C7(). this.x = " + this.x);
	}
}

public class B01_Regeln {

	/*
	 * 1. Jede Klasse hat mindestens einen Konstruktor
	 * 
	 * 2. Wenn eine Klasse keinen expliziten Konstruktor hat,
	 *    wird der default-Konstruktor generiert:
	 *    	- Sichtbarkeit wie die der Klasse
	 *      - Keine Parameter (norargs)
	 *      - Alle Regeln aus den Punkten 3 und 4
	 *    
	 * 3. Alle Konstruktoren (auch der default-Konstruktor)
	 *    werden BEI BEDARF vervollständigt, so dass:
	 *    
	 *    - die erste Anweisung ist der Aufruf eines anderen 
	 *      Konstruktors mit dem Schlüßelwort this oder super. 
	 *      Wenn der Compiler die Anweisung generiert,
	 *      dann nur als 'super()'
	 *      
	 *    - Wenn der Konstruktor einen super-Aufruf hat,
	 *      werden alle Attribute vor dem 1. Lesen 
	 *      initialisiert
	 *    
	 * 4. Wenn die Klasse Init-Blöcke hat, werden sie in
	 *    alle Konstruktoren, die einen super-Aufruf haben,
	 *    intelligent direkt nach dem super-Aufruf integriert
	 */
	public static void main(String[] args) {
		new C6("moin"); // y = null
		new C7(111); // x = 111
		new C7();
	}

}
