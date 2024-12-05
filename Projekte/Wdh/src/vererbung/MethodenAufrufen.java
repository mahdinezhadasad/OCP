package vererbung;

public class MethodenAufrufen {
	
	interface MyInterface {
		static void staticMethodA() {}
		
		default void innerhalbDesInterfaces() {
			MyInterface.staticMethodA();
			staticMethodA();
		}
		
		default void instanceMethodA() {}
	}
	
	static class BaseClass {
		static void staticMethodB() {}
		
		void instanceMethodB() {}
	}
	
	static class DerivedClass extends BaseClass implements MyInterface {
		void innerhalbDerKlasse() {
			/*
			 * statische Methoden
			 */
			MyInterface.staticMethodA();
			// staticMethodA();
			
			BaseClass.staticMethodB();
			DerivedClass.staticMethodB();
			staticMethodB();
			
			/*
			 * Instanzmethoden
			 */
			instanceMethodA();
			this.instanceMethodA(); // daselbe wie instanceMethodA(); 
			DerivedClass.this.instanceMethodA(); // daselbe wie instanceMethodA(); 
			
			MyInterface.super.instanceMethodA(); // überschriebene Version aus dem Basisinterface
			
			instanceMethodB();
			this.instanceMethodB(); // daselbe wie instanceMethodB(); 
			DerivedClass.this.instanceMethodB(); // dasselbe wie instanceMethodB();
			
			super.instanceMethodB(); // überschriebene Version aus der Basisklasse
			DerivedClass.super.instanceMethodB(); // dasselbe wie super.instanceMethodB()
		}
		
		@Override
		public void instanceMethodA() {
			System.out.println("instanceMethodA aus DerivedClass");
		}
		
		@Override
		void instanceMethodB() {
			System.out.println("instanceMethodB aus DerivedClass");
		}
	}

	public static void main(String[] args) {

		/*
		 * Außerhalb
		 */
		MyInterface.staticMethodA();
		// DerivedClass.staticMethodA();
		
		BaseClass.staticMethodB();
		DerivedClass.staticMethodB();
		
		MyInterface ref1 = new DerivedClass();
		ref1.instanceMethodA(); // instanceMethodA aus DerivedClass
		
		BaseClass ref2 = new DerivedClass();
		ref2.instanceMethodB();
	}

}
