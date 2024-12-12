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
			
			int att;
			
			// init-Block
			{
				add(12);
				add(13);
				add(14);
				
				System.out.println(att);
				myMethod();
			}
			
			void myMethod() {}
		};
		
		// v7.myMethod(); // cf: myMethod() gibt es nicht im Interface List
		
		/*
		 * Anonyme Klasse hat eigene this-Referenz.
		 * Eine Lambda hat keine eigenen this-Referenz.
		 */
		Runnable v8 = () -> {
			System.out.println("*** run() der Lambda");
			// System.out.println(this.getClass()); // cf: keine this in Lambda
		};
		
		Runnable v9 = new Runnable() {
			public void run() {
				System.out.println("*** run() der anonymen Klasse");
				System.out.println(" das Objekt hat den Typ: " + this.getClass());
			}
		};
		
		v8.run();
		v9.run();
		
		System.out.println("---- nach run-Aufrufen");
		System.out.println("Typ von Lambda-Objekt: " + v8.getClass());
		System.out.println("Typ von Objekt der anonymen Klasse: " + v9.getClass());
		
		
	} // end of main

}
