package wdh.methoden;

public class VarargsMethoden {

	/*
	 * Regel für Varargs: der Varargs-Parameter muss der 
	 * letzte Parameter in der Liste der Parameter sein 
	 */
	public static void main(String[] args) {
		
		// ein Array wird automatisch erzeugt, wenn man vereinfacht die
		// Elemente des Arrays beim Methodenaufruf übergibt.
		print(); 			// new int[] { }
		print(12);			// new int[] { 12 }
		print(12, 13);		// new int[] { 12, 13 }
		print(12, 13, 14);  // new int[] { 12, 13, 14 }
		
		int[] a1 = { 6, 7, 8 };
		print(a1);
		
		print( new int[] { 20, 30, 40 } );
	}
	
	static void print(int... values) {
		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}

//	static void print(int[] values) {
//		for (int i = 0; i < values.length; i++) {
//			System.out.print(values[i] + " ");
//		}
//		System.out.println();
//	}
	
	/*
	 * Regel für Varargs: der Varargs-Parameter muss der 
	 * letzte Parameter in der Liste der Parameter sein 
	 */
	static void m1(String... p) {}
	static void m2(int x, String... p) {}
	static void m3(String[] p1, String... p2) {}
	
//	static void m4(String... p, int x) {} 			// cf
//	static void m5(String... p1, String... p2) {}	// cf
}
