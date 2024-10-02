package aufgaben;

import java.util.function.BiFunction;

class Auto {}

class Besitzer {
	
	static Besitzer createInstance(Auto a, Integer id) {
		return new Besitzer(a, id);
	}
	
	private Auto a;
	private int id;
	
	public Besitzer(Auto a, int id) {
		this.a = a;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Besitzer. id=" + id + ", Auto: " + a.hashCode();
	}
}

public class AufgabeBiFunctionMethodReference {

	public static void main(String[] args) {

		/*
		 * A1
		 */
		BiFunction<Auto, Integer, Besitzer> f1 = new BiFunction<Auto, Integer, Besitzer> () {
			public Besitzer apply(Auto a, Integer id) {
				return new Besitzer(a, id);
			}
		};
		
		Besitzer b1 = f1.apply(new Auto(), 1);
		System.out.println("b1: " + b1);
		
		/*
		 * A2
		 */
		BiFunction<Auto, Integer, Besitzer> f2 = (a, id) -> new Besitzer(a, id);
		
		Besitzer b2 = f2.apply(new Auto(), 2);
		System.out.println("b2: " + b2);
		
		/*
		 * A3
		 * 
		 * Besitzer apply(Auto a, Integer id) {
		 * 		return Klasse.statischeMethode(a, id);
		 * }
		 */
		BiFunction<Auto, Integer, Besitzer> f3 = Besitzer::createInstance;
		
		Besitzer b3 = f3.apply(new Auto(), 3);
		System.out.println("b3: " + b3);
		
	}

}
