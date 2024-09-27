package func;

public class B01_FunctionalInterface {

	interface I1 {} // kein funkt. Interface
	
	interface I2 { // funkt. Interface
		void m();
	} 
	
	interface I3 { // kein funkt. Interface
		void m1();
		int m2(int x);
	} 
	
	interface I4 { // funkt. Interface
		void m1();
		default void m2() {}
		static void m3() {}
	}
	
	interface I5 { // funkt. Interface
		String toString();
		int hashCode();
		boolean equals(Object obj);
		
		void m();
	}
	
	/*
	 * - Ein funktionales Interface ist das Interface mit genau 
	 *   einer abstrakten Methode
	 *   
	 * - Achtung! Die Methoden mit den Signaturen aus der 
	 *   Klasse Object zählen nicht als abstract
	 */
	public static void main(String[] args) {

//		I1 v1 = () -> {}; // cf
		I2 v2 = () -> {};
//		I3 v3 = () -> {}; // cf
		I4 v4 = () -> {};
		I5 v5 = () -> {};
	}

}
