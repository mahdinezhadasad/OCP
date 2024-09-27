package aufgaben.personen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AufgabeNestedPredicatePersonen {

	public static void main(String[] args) {

		Person[] arr = {
			new Person("Max", "Mustermann", 1970),	
			new Person("Alex", "Mustermann", 1978),	
			new Person("Ute", "Meyer", 2001),	
			new Person("Maria", "Krause", 1998),	
			new Person("Klaus", "Schulz", 2011),	
		};
		
		/*
		 * A3
		 */
		System.out.println("*** A3. Personen, geboren nach 1990:");
		
		Predicate<Person> pA3 = new PredicatePersonGeborenNach(1990);
		
		List<Person> listA3 = filtern(arr, pA3);
		
		print(listA3);
		
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
}
