package exceptions;

import java.io.IOException;

public class B09_Rethrow_Regeln {

	/*
	 * try-Block-Analyse: Der Compiler analysiert
	 * den try-Block und sammelt die Liste aller möglichen
	 * checked Exceptions.
	 * Diese Info (solange sie noch gültig ist) verwendet
	 * der Compiler für die weiteren Entscheidungen in dem catch-Block
	 */
	public static void main(String[] args) {
		

	}
	
	static void m1() {
		RuntimeException e = new ArithmeticException();
		throw e; // ok, e hat den unchecked Typ
	}

	static void m2() {
		Exception e = new ArithmeticException();
//		throw e; // cf: e hat den CHECKED Typ
	}
	
	static void m3() {
		try {
			
		} catch (Exception e) {
			throw e; // rethrow. Es kompiliert! 
				     // Nach der try-Analyse ist bekannt,
					 // dass e keine checked-Exception referenziert
		}
	}
	
	static void m4() throws IOException {
		Exception e = new IOException();
//		throw e; // cf: e hat den Typ Exception - Basistyp für ALLE checked Exceptions
	}

	static void m5() {
		try {
			throw new IOException();
		} catch (Exception e) {
//			throw e; // cf bei rethrow: e kann IOException sein (try-Analyse)
		}
	}
	static void m6() throws IOException {
		try {
			throw new IOException();
		} catch (Exception e) {
			throw e; // rethrow. e kann IOException sein (try-Analyse)
		}
	}
	
	/*
	 * Achtung! Die Zuweisung der catch-Variable löscht die
	 * try-Block-Analyse-Ergebnisse!
	 */
	static void m7() {
		try {
			
		} catch (Exception e) {
			e = new ArithmeticException(); // löscht die Infos der try-Analyse
			
//			throw e; // cf: e hat den checked Typ
		}
	}
	
}
