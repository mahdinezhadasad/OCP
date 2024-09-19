package wdh.wrapper;

public class AutoboxingAutounboxing {

	public static void main(String[] args) {
		/*
		 * Autoboxing: der vom Compiler generierter Aufruf der
		 * statischen Methode valueOf, dort, wo eine Referenz
		 * benötigt wird, aber ein primitiver Wert steht.
		 */

		Boolean v0 = Boolean.valueOf(true); // manuelles Boxing, nicht empfohlen
		Boolean v1 = true; // Autoboxing, kompakt und schön :)
		
		/*
		 * Autounboxing: der vom Compiler generierter Aufruf
		 * der Instanzmethode xxxValue(), dort, wo ein primitiver
		 * Wert benötigt wird, aber eine Wrapper-Klassen-Referenz steht.
		 */
		
		boolean v3 = v1.booleanValue(); // manuelles Unboxen, nicht empfohlen
		boolean v4 = v1; // Autounboxing
		
	}

}
