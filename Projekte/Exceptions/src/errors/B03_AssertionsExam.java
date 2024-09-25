package errors;

public class B03_AssertionsExam {

	/*
	 * 1. Zuerst überprüfen, ob der Code kompiliert (s. B02)
	 * 
	 * 2. Wenn der Code kompiliert, überprüfen, ob die
	 *    Assertions beim Start aktiviert werden
	 */
	public static void main(String[] args) {

		/*
		 * Gegeben ist folgender Code:
		 */
		int x = 0;
		
		assert x == 0 : "moin";
		
		System.out.println("x = " + x);
		
		x = 1;
		
		assert x == 0;
		
		System.out.println("x = " + x);
		
		/*
		 * Und folgende Befehlszeile:
		 * 
		 * 	java -ea errors.B03_AssertionsExam
		 * 
		 * Was ist das Ergebnis?
		 * 
		 * A. Compilerfehler
		 * 
		 * B. x = 0
		 *    x = 1
		 *    
		 * C. x = 0
		 *    gefolgt von einer Exception
		 *    
		 * D. x = 0
		 *    gefolgt von einem Error
		 */
	}

}
