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
	
	/*
	 * statische innere anonyme Klasse
	 */
	static Object staticTest = new Object() {
		void testAccess() {
			System.out.println(staticAtt);
			System.out.println(OuterClass.staticAtt);
			staticMethod();
			OuterClass.staticMethod();
			
			// System.out.println(att); // cf
			// method();				// cf
		}
	};
	
	/*
	 * nichtstatische innere anonyme Klasse
	 */
	Object test = new Object() {
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
	};
	
	
	static void staticMthodWithLocalClasses() {
		
		/*
		 * lokale Klasse (wie eine statische innere Klasse)
		 */
		class StaticLocalClass {
			void testAccess() {
				System.out.println(staticAtt);
				System.out.println(OuterClass.staticAtt);
				staticMethod();
				OuterClass.staticMethod();
				
				 // System.out.println(att); // cf
				 // method();				// cf
			}
		}
		
		/*
		 * lokale anonyme Klasse (wie eine statische innere Klasse)
		 */
		new Object() {
			void testAccess() {
				System.out.println(staticAtt);
				System.out.println(OuterClass.staticAtt);
				staticMethod();
				OuterClass.staticMethod();
				
				// System.out.println(att); // cf
				// method();				// cf
			}
		};
		
	} // end of staticMthodWithLocalClasses
	
	void methodWithLocalClasses() {
		/*
		 * lokale Klasse (wie eine nichtstatische innere Klasse)
		 */
		class LocalClass {
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
		}
		
		/*
		 * lokale anonyme Klasse (wie eine nichtstatische innere Klasse)
		 */
		new Object() {
			void testAccess() {
				System.out.println(staticAtt);
				System.out.println(OuterClass.staticAtt);
				staticMethod();
				OuterClass.staticMethod();
				
				System.out.println(att); // ok: OuterClass.this.att
				method();				// ok: OuterClass.this.method()
			}
		};
	} // end of methodWithLocalClasses
	
} // end of OuterClass


public class AlleArtenDerInnerenKlassen {

	public static void main(String[] args) {

		OuterClass.InnerClass v1 = new OuterClass() .new InnerClass();
		OuterClass.InnerStaticClass v2 = new OuterClass.InnerStaticClass();
		
	}

}
