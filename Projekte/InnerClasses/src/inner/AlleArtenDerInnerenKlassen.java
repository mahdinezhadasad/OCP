package inner;

class OuterClass {
	
	/*
	 * inner (nested, member) 
	 */
	class InnerClass {
		void testAccess() {
			System.out.println(staticAtt);
			System.out.println(OuterClass.staticAtt);
			staticMethod();
			OuterClass.staticMethod();
			
			System.out.println(att); // OuterClass.this.att 
			System.out.println(OuterClass.this.att); 
			method(); // OuterClass.this.method()
			OuterClass.this.method();			
		}
		
	} // end of InnerClass
	
	/*
	 * static inner (static nested, static member) 
	 */
	static class InnerStaticClass {
		
		void testAccess() {
			System.out.println(staticAtt);
			System.out.println(OuterClass.staticAtt);
			staticMethod();
			OuterClass.staticMethod();
			
			// System.out.println(att); // cf
			// method();				// cf
		}
		
	} // end of InnerStaticClass
	
	
	/*
	 * Weitere Elemente der OuterClass
	 */
	private static int staticAtt = 1;
	
	private static void staticMethod() { System.out.println("3"); }
	
	private int att = 2;
	
	private void method() { System.out.println("4"); }
} // end of OuterClass


public class AlleArtenDerInnerenKlassen {

	public static void main(String[] args) {

		OuterClass.InnerClass v1 = new OuterClass() .new InnerClass();
		OuterClass.InnerStaticClass v2 = new OuterClass.InnerStaticClass();
		
	}

}
