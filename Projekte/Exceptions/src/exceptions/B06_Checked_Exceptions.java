package exceptions;

import java.io.IOException;

public class B06_Checked_Exceptions {

	public static void main(String[] args) {

	}
	
	static void m1() {
		throw new RuntimeException(); // unchecked
	}
	
	static void m2() {
//		throw new IOException(); // cf: checked
	}

	/*
	 * die checked Exception muss nicht wirklich entstehen:
	 */
	static void someMethod() throws IOException {
		
	}
	static void m3() {
//		someMethod();  // cf: checked Exception deklariert
	}
	
	
	/*
	 * 1. Möglichkeit eine checked Exception zu berücksichtigen
	 */
	static void m4() {
		try {
			someMethod(); // deklariert checked Exception
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 2. Möglichkeit eine checked Exception zu berücksichtigen
	 */
	static void m5() throws IOException {
		someMethod();
	}
}
