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
		
		
		/*
		 * Exam. Wenn die Operatoren verwendet werden,
		 * überlegen Sie, ob es diese Operatoren für Referenzen gibt.
		 */
		
		Integer x = 12;
		Double y = 12.0;
		float z = 12f;
		
		System.out.println( x > z ); // x.intValue() > z
		System.out.println( x < y ); // x.intValue() < y.doubleValue()
		System.out.println( x == z ); // x.intValue() == z 
									  // (Vergleich der primitiven Werte 
									  // int und float)
		
		System.out.println( x == x ); // Referenzenvergleich
		System.out.println( x != x ); // Referenzenvergleich
//		System.out.println( x == y ); // cf! Integer und Double sind Geschwisterklassen

		/*
		 * Exam
		 */
		Integer ref = null;
		int value = ref; // Autounboxing: ref.intValue() verursacht NullPointerException
		
		
	}

}
