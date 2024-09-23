package exceptions;

public class B01_Propagieren {

	/*
	 * Ergebnis:
	 * 
	 * 		a c e gefolgt von ArithmeticException
	 */
	public static void main(String[] args) {
		System.out.print("a ");
		m1();
		System.out.print("b ");
	}
	
	static void m1() {
		System.out.print("c ");
		m2();
		System.out.print("d ");
	}
	
	static void m2() { 
		System.out.print("e ");
		System.out.print(5/0);
		System.out.print("f ");
	}

}
