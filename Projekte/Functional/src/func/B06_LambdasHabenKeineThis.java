package func;

public class B06_LambdasHabenKeineThis {

	/*
	 * Unwahrscheinlich in der Prüfung
	 */
	public static void main(String[] args) {
		
		Runnable v1 = () -> {
//			System.out.println(this); // cf: keine this in Lambda
//			toString(); // cf: keine this in Lambda für this.toString()
		};
		
		// zum Vergleich: anonyme Klasse

		Runnable v2 = new Runnable() {
			public void run() {
				System.out.println(this);
				toString();
			}
		};
		
		System.out.println("main");
		System.out.println(v1.getClass()); // func.B06_LambdasHabenKeineThis$$Lambda/0x0000000800000a00
		System.out.println(v2.getClass()); // func.B06_LambdasHabenKeineThis$1
		
	} // end of main

	/*
	 * Achtung! 
	 * Eine Instanzmethode hat eigene this (this der umschliessenden Klasse)
	 */
	void m() {
		Runnable r1 = () -> {
			System.out.println(this); // das ist die this aus m()
		};
		
		
		System.out.println(this); // die this aus m()
	}
	
}
