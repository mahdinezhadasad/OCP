package wdh.konstruktoren;

class Auto {
	int baujahr;
	
	/*
	 * default-Konstruktor:
	 * 
	 * Auto() {
	 *    super();
	 *    this.baujahr = 0;
	 * }
	 */
	
}

class VW extends Auto {
	String modell;
	
	/*
	 * default-Konstruktor:
	 * 
	 * VW() {
	 *    super();
	 *    this.modell = null;
	 * }
	 */
}

class Mazda extends Auto {
	int preis;
	Mazda() {
		this(2000);
	}
	Mazda(int preis) {
		// super(); // generiert
		this.preis = preis;
	}
}




public class B02_ObjekteMitKonstruktorenInitialisieren {

	public static void main(String[] args) {
		new VW();
		new Mazda(33333);
		new Mazda();
	}

}
