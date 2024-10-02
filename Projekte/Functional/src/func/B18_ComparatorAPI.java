package func;

import java.util.Comparator;
import java.util.function.Function;

class Person {
	private String vorname;
	private String nachname;
	private int geburtsjahr;
	
	public Person(String vorname, String nachname, int geburtsjahr) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}
	
	public String toString() {
		return vorname + " " + nachname + " (" + geburtsjahr + ")";
	}
}


public class B18_ComparatorAPI {
	public static void main(String[] args) {
		test_compare();
		test_naturalOrder_reverseOrder();
		test_comparing();
	}

	/*
	 * static Comparator comparing(Function keyExtractor)
	 * 
	 * Der Comparator vergleicht zwei Elemente so:
	 * 	- mit keyExtraktor wird für das 1. Element ein Comparable-Key berechnet
	 * 	- mit keyExtraktor wird für das 2. Element ein Comparable-Key berechnet
	 *  - Das Ergebnis aus compare ist der key1.compareTo(key2)
	 * 
	 */
	static void test_comparing() {
		System.out.println("\n*** comparing");
		
//		Comparator<Person> c1 = (personA, personB) -> {
//			Comparable keyA = personA.getNachname();
//			Comparable keyB = personB.getNachname();
//			return keyA.compareTo(keyB);
//		};
		
		Function<Person, String> keyExtractor = p -> p.getNachname();
		
//		Comparator<Person> c2 = (personA, personB) -> {
//			Comparable keyA = keyExtractor.apply(personA);
//			Comparable keyB = keyExtractor.apply(personB);
//			return keyA.compareTo(keyB);
//		};
		
		Comparator<Person> c3 = Comparator.comparing(keyExtractor);
		
		Person p1 = new Person("Max", "Mustermann", 1990);
		Person p2 = new Person("Ute", "Auerbach", 1995);
		
		int result = c3.compare(p1, p2);
		System.out.println("compare(p1, p2): " + result); // positiv
		
		result = c3.compare(p2, p1);
		System.out.println("compare(p2, p1): " + result); // negativ
		
		/*
		 * Test
		 * 
		 * Function<Person, String> extr = (Person p) -> {
		 * 		return p.getNachname();
		 * }
		 */
		Comparator<Person> test = Comparator.comparing(Person::getNachname);
		
	}
	
	/*
	 * static Comparator naturalOrder() 
	 * static Comparator reverseOrder()
	 */
	static void test_naturalOrder_reverseOrder() {
		System.out.println("\n*** naturalOrder, reverseOrder");
		
		Comparator<Integer> cmpNatural = Comparator.naturalOrder();
		Comparator<Integer> cmpReverse = Comparator.reverseOrder();
		
//		Comparator<Person> cmp = Comparator.naturalOrder(); // cf: Person ist nicht Comparable

		Integer x = 12;
		Integer y = 1200;
		
		System.out.println("natural: " + cmpNatural.compare(x, y)); // negativ
		System.out.println("reverse: " + cmpReverse.compare(x, y)); // positiv
	}
	
	/*
	 * die einzige abstrakte Methode 
	 * 
	 * 		'int compare(T x, T y)'
	 */
	static void test_compare() {
		System.out.println("*** compare");
		
		Comparator<String> cmp = new Comparator<String> () {
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
//				return s1.length() - s2.length();
			}
		};
		
		String x = "bbbb";
		String y = "mm";
		
		int result = cmp.compare(x, y);
		if (result < 0) {
			System.out.println("'" + x + "' ist kleiner als '" + y + "'");
		} else if (result > 0) {
			System.out.println("'" + x + "' ist größer als '" + y + "'");
		} else {
			System.out.println("'" + x + "' ist gleich '" + y + "'");
		}
	}

}
