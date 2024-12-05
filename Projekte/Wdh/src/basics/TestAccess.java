package basics;

public class TestAccess {
	
	int x1 = 111;
	static int x2 = 222;
	
	static void m2() { System.out.println("m2"); }

	public static void main(String[] args) {
//		b1();
		b2();
	}

	static void b2() {
		TestAccess myVar = null;
		System.out.println(myVar.x2);  // myVar.x2 wird ersetzt durch TestAccess.x2
		myVar.m2(); // TestAccess.m2() 
	}
	
	static void b1() {
		TestAccess myVar = null;
		System.out.println(myVar.x1); // NullPointerException 
	}
	
}
