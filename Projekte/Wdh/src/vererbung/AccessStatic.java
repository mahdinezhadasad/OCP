package vererbung;


interface MyInterface {
	int KI = 1;
	static void mI() {} // kann nur mit dem Interface-Namen aufgerufen werden!
}

class MyBase {
	static final int KB = 2;
	static void mB() {}
}

class MyDerived extends MyBase implements MyInterface {
	
	
}



public class AccessStatic {

	public static void main(String[] args) {

		System.out.println( MyDerived.KI ); // 1
		System.out.println( MyDerived.KB ); // 2

//		MyDerived.mI(); // cf
		
		MyDerived.mB();
		
		MyInterface ref1 = null;
		System.out.println( ref1.KI ); // MyInterface.KI 
		
//		ref1.mI(); // cf
	}

}
