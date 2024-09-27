package inner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

interface Moveable {
	void move();
}

public class B07_anonymeKlassenVsLambdas {

	public static void main(String[] args) {

		/*
		 * Lambda kann NUR ein funktionales Interface implementieren.
		 * Eine anonyme Klasse kann auch funktionales Interface implementieren.
		 */
		Moveable v1 = () -> {};
		
		Moveable v2 = new Moveable() {
			public void move() {}
		}; 
		
		/*
		 * Eine anonyme Klasse kann beliebige Interfaces implementieren
		 */
//		Iterator<String> v3 = keine Lambda möglich;
		
		Iterator<String> v4 = new Iterator<String>() {
			public boolean hasNext() {
				return false;
			}
			public String next() {
				return null;
			}
		};
		
		/*
		 * Eine anonyme Klasse kann eine Klasse erweitern
		 */
		
		List<Integer> v5 = new ArrayList<Integer> () { // super();
			
		};
		
		/*
		 * Wenn eine anonyme Klasse eine Klasse erweitert,
		 * kann sie aus alternativen Konstruktoren einen auswählen
		 */
		Collection<String> tmp = Arrays.asList("mo", "di", "mi");
		
		List<String> v6 = new ArrayList<String> (tmp) { // super(tmp);
			
		};
		
		System.out.println("v6: " + v6);
		
		/*
		 * Eine anonyme Klasse kann nicht nur überschreiben.
		 * Sie kann auch eigene Elemente haben, die aber nur innerhalb 
		 * der Klasse gültig sind
		 */
		
		List<Integer> v7 = new ArrayList<Integer> () {
			
			// init-Block
			{
				add(12);
				add(13);
				add(14);
				
				myMethod();
			}
			
			void myMethod() {}
		};
		
		// v7.myMethod(); // cf: myMethod() gibt es nicht im Interface List
		
		
		
	}

}
