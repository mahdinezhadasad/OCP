package wdh.methoden;

public class RichtigeUeberladeneMethodeFindenRegeln {

	/*
	 * Suche nach der richtigen überladenen Methode.
	 * 
	 * Argument ist primitiv.
	 * 
	 * 1. Argumenttyp und Parametertyp sind gleich
	 * 
	 * 2. Widening
	 * 			byte -> short -> int -> long -> float -> double
	 * 
	 * 3. Autoboxing 
	 * 			Wraper-Klassen-Parameter gesucht (oder Basistyp davon)
	 * 
	 * 4. Vorherige Schritte für Varargs-Methoden durchgehen 
	 */
	
	/*
	 * Suche nach der richtigen überladenen Methode.
	 * 
	 * Argument ist eine Referenz.
	 * 
	 * 1. Argumenttyp und Parametertyp sind gleich
	 *
	 * 2. Parameter ist Basistyp
	 * 
	 * 3. Autounboxing (und Widening wenn nötig) 
	 *    bei Wrapper-Klassen-Argumenten
	 * 
	 * X. Vorherige Schritte für Varargs-Methoden durchgehen 
	 */
	public static void main(String[] args) {

		Integer x = 12;
		m(x);
	}
	
//	static void m(String x) { System.out.println("String"); }
//	static void m(int x) { System.out.println("int"); }
//	static void m(Integer x) { System.out.println("Integer"); }
//	static void m(Number x) { System.out.println("Number"); }
	static void m(double x) { System.out.println("double"); }
//	static void m(byte x) { System.out.println("byte"); }
//	static void m(int... x) { System.out.println("int..."); }
	static void m(String... x) { System.out.println("String..."); }

}
