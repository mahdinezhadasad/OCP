package exceptions;

public class B08_Rethrow {

	/*
	 * Rethrow: eine Exception abfangen und aus dem catch-Block weiter werfen
	 */
	public static void main(String[] args) {
		myMethod(); // ArithmeticException
	}
	
	static void myMethod() {
		try {
			System.out.println(5/0);
			
		} catch (ArithmeticException e) {
			// hier protokollieren...
			
			throw e; // rethrow
		}
	}

}
