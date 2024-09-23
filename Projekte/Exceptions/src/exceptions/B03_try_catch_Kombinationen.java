package exceptions;

import java.util.Random;

public class B03_try_catch_Kombinationen {

	public static void main(String[] args) {

		/*
		 * Alle Exceptions gleich behandeln
		 */
		try {
			methodeMitExc();
		} catch (RuntimeException e) {
			System.out.println("1. abgefangen: " + e);
		}
		
		/*
		 * Jede Exception speziell behandeln.
		 * 
		 * Achtung! Zuerst den catch-Block für abgeleitete Exception,
		 * danach für Basisklassen-Exception!
		 */
		try {
			methodeMitExc();
		} catch(ArithmeticException e) {
			System.out.println("2. ArithmeticException");
		} catch (NumberFormatException e) {
			System.out.println("2. NumberFormatException");
		} catch (IllegalArgumentException e) {
			System.out.println("2. IllegalArgumentException");
		}
		
		// Geschwisterklassen-Exceptions: Reihenfolge ist egal
		try {
		} catch (ArithmeticException e) {	
		} catch (NumberFormatException e) {
		}
		
		// Geschwisterklassen-Exceptions: Reihenfolge ist egal
		try {
		} catch (NumberFormatException e) {
		} catch (ArithmeticException e) {
		} 
		
		// Exceptions mit Vererbung: Reihenfolge ist wichtig
		try {
		} catch (NumberFormatException e) {
		} catch (IllegalArgumentException e) {
		} 
//		try {
//		} catch (IllegalArgumentException e) {
//		} catch (NumberFormatException e) {    // cf: unreachable catch block
//		} 
		
		
		/*
		 * 	Wenn z.B. ArithmeticException und NumberFormatException
		 * gleich behandelt werden sollen, ist es also mit dem 
		 * Basistyp-Exception-Block möglich.
		 * 
		 * Das kleine Design-Problem: catch für RuntimeException kann
		 * nicht nur die ArithmeticException und NumberFormatException
		 * abfangen.
		 * Das Problem soll Multicatch lösen.
		 */
		try {
			methodeMitExc();
		} catch (IllegalArgumentException e) {
			System.out.println("3. IllegalArgumentException");
		} catch (RuntimeException e) {
			System.out.println("3. ArithmeticException und NumberFormatException");
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
