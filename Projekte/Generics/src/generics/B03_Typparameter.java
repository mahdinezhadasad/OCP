package generics;


public class B03_Typparameter {

	/*
	 * Typparameter kann den Namen wie ein Java-Identifier
	 * bekommen (sollte aber aus Grossbuchstaben bestehen)
	 */
	
	class C1 <bUchStaben_1234_$> { // geht, aber nicht so gut
	}
	
	class C2 <A> { // ok
	}
	
	
	/*
	 * Mehrere Typparameter kann es geben
	 */
	class C3 <T1, T2, T3, T4> {
		
	}
	
	/*
	 * Typparameter kann man erben 
	 * (generische 'Natur' der Basisklasse erben)
	 * (s. auch ArrayList implements List)
	 */
	
	static class Base <T> {
		T get() { return null; }
	}
	// 'normale' Klasse:
	static class DerivedA extends Base<String> {}
	
	// generische Klasse mit dem eigenen Typparameter:
	static class DerivedB <T> extends Base<String> {}
	
	// generische Klasse, die den Typparameter erbt
	static class DerivedC <T> extends Base<T> {} 
	
	public static void main(String[] args) {
		DerivedA v1 = new DerivedA();
		String s1 = v1.get(); 
		
		DerivedB<Integer> v2 = new DerivedB<>();
		String s2 = v2.get(); // DerivedB ist immer Base<String>
		
		DerivedC<Integer> v3 = new DerivedC<Integer>();
		Integer i1 = v3.get(); // DerivedC<Integer> ist Base<Integer>
	}

}
