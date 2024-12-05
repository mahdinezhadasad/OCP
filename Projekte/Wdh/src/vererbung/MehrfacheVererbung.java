package vererbung;


public class MehrfacheVererbung {
	
	
	interface I1 {
		default void m() { System.out.println(1); }
		
		void m222();
	}
	interface I2 {
		void m();
		
		void m222();
	}
	
//	abstract class MyClass1 implements I1, I2 { // cf: muss m() realisieren
//	}

	abstract class MyClass2 implements I1, I2 {
		public void m() {}
	}
	
	public static void main(String[] args) {

	}

}
