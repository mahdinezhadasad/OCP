package exceptions;

import java.util.Random;

public class B04_Multicatch {

	public static void main(String[] args) {
		
		/*
		 * 	Wenn z.B. ArithmeticException und NumberFormatException
		 *  gleich behandelt werden sollen, ist es möglich
		 *  einen Multicatch-Block zu erstellen, der NUR die
		 *  beiden Exceptions-Typen abfängt.
		 *    
		 */
		try {
			methodeMitExc();
			
		} catch (ArithmeticException | NumberFormatException e) { // Multicatch
			System.out.println("Multicatch hat abgefangen: " + e);
		} catch (IllegalArgumentException e) { // normaler catch-Block
			System.out.println("speziell die IllegalArgumentException behandeln");
		} 

	}

	static void methodeMitExc() {
		switch(new Random().nextInt(3)) {
			case 0: throw new ArithmeticException();
			case 1: throw new NumberFormatException();
			default: throw new IllegalArgumentException();
		}
	}
}
