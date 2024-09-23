package exceptions;

import java.io.IOException;

class FahrenException extends Exception {}
class BremsenException extends FahrenException {}

class Auto {
	void fahren() throws FahrenException {}
}

class VW extends Auto {
	void fahren() { } 
}

class Audi extends Auto {
	void fahren() throws FahrenException { } // ok, dieselbe FahrenException deklariert 
}

class Mercedes extends Auto {
	void fahren() throws BremsenException { } // ok, BremsenException IS-A FahrenException 
}

class Mazda extends Auto {
	void fahren() throws RuntimeException { } // ok, unchecked 
}

class Opel extends Auto {
//	void fahren() throws IOException { } // cf, Geschwisterklassen-checked 
}

class Fiat extends Auto {
//	void fahren() throws Exception { } // cf, Basisklassen-checked 
}


public class B07_Checked_Exceptions_beim_Ueberschreiben {

	/*
	 * Regeln beim Überschreiben/Implementieren:
	 * 
	 * 1. Sichtbarkeit nicht verschärfen
	 * 2. Rückgabetyp nicht ändern
	 * 3. keine zusätzlichen checked Exceptions deklarieren:
	 * 		- keine Geschwisterklassen-checked-Exceptions
	 * 		- keine Basisklassen-checked-Exceptions
	 */
	public static void main(String[] args) {
		
		

	}

}
