package vererbung;


interface MyTestInterface {
	
	/*
	 * Java 8: alle Elemente sind public
	 */
	
	
	/*
	 * abstrakte Instanzmethoden
	 */
	void m1(); 						// implizit: public abstract 
	public abstract void m11(); 	//  
	abstract void m12(); 			// implizit: public  
	public void m13(); 				// implizit: abstract  
	
	/*
	 * default Instanzmethoden
	 */
	default void m2() { 			// implizit: public 
		System.out.println(this);
	}			
	
	/*
	 * statische Methoden
	 */
	static void m3() { // implizit: public
		// System.out.println(this);
	}
	
	/*
	 * statische Konstanten 
	 */
//	int K0; // cf: Konstante muss vorinitialisiert werden
	
	int K1 = 1;							// implizit: public static final
	public static final int K2 = 2;		// 
	final int K3 = 3;					// implizit: public static
	
	/*
	 * innere Typen (auch alle public)
	 */
	class InnerClass {}
	interface InnerInterface {}
	enum InnerEnum {}
	
} // end of MyTestInterface

class MyTestClass implements MyTestInterface {
	public void m1() {}
	public void m11() {}
	public void m12() {}
	public void m13() {}
}

public class InterfaceElemente {

	public static void main(String[] args) {

		MyTestInterface myObj = new MyTestClass();

		myObj.m1();
//		MyTestInterface.m1();
		
		myObj.m2();
		
		MyTestInterface.m3(); // static call
		
		System.out.println(MyTestInterface.K1); // static access
		
		// MyTestInterface.K1 = 33;
	}

}
