package exceptions;

public class B05_Multicatch_Regeln {

	public static void main(String[] args) {

		/*
		 * Achtung! Nur Geschwisterklassen-Exceptions in einem Multicatch!
		 */
		
//		try {
//			
//		} catch (RuntimeException | Exception e) {  // cf
//			
//		}

		try {
			
		} catch (ArithmeticException | NullPointerException | IllegalArgumentException e) {
			
		}
		
		
		/*
		 * Achtung! Nur eine Variable in einem Multicatch!
		 */
		
		try {
		} catch(NullPointerException | ArithmeticException e) {
		}
		
//		try {
//		} catch(NullPointerException e1 | ArithmeticException e2) { // cf
//		}
		
//		try {
//		} catch(NullPointerException e | ArithmeticException e) { // cf
//		}
		
		
		/*
		 * Achtung! Die Multicatch-Variable muss 'effectively final' bleiben
		 * 
		 */
		try {
			
		} catch (Exception e) {
			e = null; // ok, normale Blockvariable 
		}
		
		try {
			
		} catch (ArithmeticException | NullPointerException e) {
			// e = null; // cf: muss 'effectively final' bleiben
		}
		
		
	}

}
