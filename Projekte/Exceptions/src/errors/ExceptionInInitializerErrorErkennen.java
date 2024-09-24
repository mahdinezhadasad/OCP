package errors;


class Blume {
	static {
		System.out.println(5/0); // ArithmeticException
	}
}

public class ExceptionInInitializerErrorErkennen {

	public static void main(String[] args) {
		/*
		 * ExceptionInInitializerError wirft die JVM,
		 * wenn sie beim Laden der Klasse im ClassLoader
		 * eine Exception abfängt
		 * 
		 * Achtung!
		 * ExceptionInInitializerError ist Error (keine Exception)
		 */
		
		try {
			new Blume();
		} catch (Error e) {
			System.out.println("Error abgefangen: " + e); // ExceptionInInitializerError
		} catch (Exception e) {
			System.out.println("diese Ausgabe gibt es nicht");
		}

	}

}
