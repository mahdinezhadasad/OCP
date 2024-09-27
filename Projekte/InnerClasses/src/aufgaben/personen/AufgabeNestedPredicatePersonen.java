package aufgaben.personen;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AufgabeNestedPredicatePersonen {

	public static void main(String[] args) {

		Person[] arr = {
			new Person("Max", "Mustermann", 1970),	
			new Person("Alex", "Mustermann", 1976),	
			new Person("Ute", "Meyer", 2001),	
			new Person("Maria", "Krause", 1998),	
			new Person("Klaus", "Schulz", 2012),	
		};
		
		/*
		 * A3
		 */
		System.out.println("*** A3. Personen, geboren nach 1990:");
		
		Predicate<Person> pA3 = new PredicatePersonGeborenNach(1990);
		
		List<Person> listA3 = filtern(arr, pA3);
		
		print(listA3);
		
		/*
		 * A4
		 */
		System.out.println("\n*** A4. Personen mit a im Nachnamen:");
		
		Predicate<Person> pA4 = PersonPredicates.getPredicateSubstringImNachnamen("a");
		
		List<Person> listA4 = filtern(arr, pA4);
		
		print(listA4);
		
		/*
		 * A5
		 */
		System.out.println("\n*** A5. Personen mit mindestens 6 Zeichen im Nachnamen:");

		Predicate<Person> pA5 = PersonPredicates.getPredicateMindestlaengeNachname(6);
		
		List<Person> listA5 = filtern(arr, pA5);
		
		print(listA5);
		
		/*
		 * A6
		 */
		System.out.println("\n*** A6.1 Personen geboren nach 1990 und mit a im Nachnamen:");
		
		Predicate<Person> pA6 = PersonPredicates.getCombined(pA3, pA4);
		
		List<Person> listA6 = filtern(arr, pA6);
		
		print(listA6);
		
		
		/*
		 * A6. Alternative
		 */
		System.out.println("\n*** A6.2 Personen geboren nach 1990 und mit a im Nachnamen:");
		
		Predicate<Person> pA62 = pA3.and(pA4);
		
		List<Person> listA62 = filtern(arr, pA62);
		
		print(listA62);
		
		/*
		 * A7. 
		 */
		System.out.println("\n*** A7 Personen geboren in einem Schaltjahr:");

		Predicate<Person> pA7 = p -> Year.isLeap(p.getGeburtsjahr());
		
		List<Person> listA7 = filtern(arr, pA7);
		
		print(listA7);
		
	} // end of main

	static List<Person> filtern(Person[] personen, Predicate<Person> filter) {
		
		List<Person> list = new ArrayList<>();
		
		for(Person p : personen) {
			if( filter.test(p) ) {
				list.add(p);
			}
		}
		
		return list;
	}
	
	static void print(List<Person> personen) {
		for (int i = 0; i < personen.size(); i++) {
			Person p = personen.get(i);
			System.out.format("| %d | %6s | %10s | %d |%n", 
					i, p.getVorname(), p.getNachname(), p.getGeburtsjahr());
		}
	}
}
