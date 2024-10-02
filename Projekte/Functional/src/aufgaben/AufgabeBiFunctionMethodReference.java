package aufgaben;

import java.util.function.BiFunction;

class Auto {
	/*
	 * sinnlose Methode. Nur für die Lernaufgabe ok:
	 */
	Besitzer createBesitzer(Integer id) {
		return new Besitzer(this, id);
	}
}

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

class BesitzerBuilder {
	Besitzer build(Auto a, Integer id) {
		return new Besitzer(a, id);
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
		 * public Besitzer apply(Auto a, Integer id) {
		 * 		return Klasse.statischeMethode(a, id);
		 * }
		 */
		BiFunction<Auto, Integer, Besitzer> f3 = Besitzer::createInstance;
		
		Besitzer b3 = f3.apply(new Auto(), 3);
		System.out.println("b3: " + b3);
	
		/*
		 * A4
		 * 
		 * public Besitzer apply(Auto a, Integer id) {
		 * 		return new Besitzer(a, id); 
		 * }
		 */
		BiFunction<Auto, Integer, Besitzer> f4 = Besitzer::new;
		
		Besitzer b4 = f4.apply(new Auto(), 4);
		System.out.println("b4: " + b4);
		
		/*
		 * A5
		 * 
		 * public Besitzer apply(Auto a, Integer id) {
		 * 		return obj.instanzMethode(a, id); 
		 * }
		 */
		BesitzerBuilder obj = new BesitzerBuilder();
		BiFunction<Auto, Integer, Besitzer> f5 = obj::build;
		
		Besitzer b5 = f5.apply(new Auto(), 5);
		System.out.println("b5: " + b5);
		
		/*
		 * A6
		 * 
		 * public Besitzer apply(Auto a, Integer id) {
		 * 		return a.instanzMethode(id);
		 * }
		 */
		BiFunction<Auto, Integer, Besitzer> f6 = Auto::createBesitzer;
		
		Besitzer b6 = f6.apply(new Auto(), 6);
		System.out.println("b6: " + b6);
	}

}
