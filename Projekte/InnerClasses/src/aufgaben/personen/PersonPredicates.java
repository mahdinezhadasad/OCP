package aufgaben.personen;

import java.util.function.Predicate;

public class PersonPredicates {
	
	private static class PredicateSubstringImNachnamen implements Predicate<Person> {

		private String substr;
		
		public PredicateSubstringImNachnamen(String substr) {
			this.substr = substr;
		}

		public boolean test(Person p) {
			return p.getNachname().contains(substr);
		}
	}

	public static Predicate<Person> getPredicateSubstringImNachnamen(String substr) {
		return new PredicateSubstringImNachnamen(substr);
	}
	
	public static Predicate<Person> getPredicateMindestlaengeNachname(int minLength) {
		
		class MyPredicate implements Predicate<Person> {
			public boolean test(Person p) {
				return p.getNachname().length() >= minLength;
			}
		}
		
		return new MyPredicate();
	}
	
	public static Predicate<Person> getCombined(Predicate<Person> predicate1, 
			Predicate<Person> predicate2) {
		
		return new Predicate<Person>() {
			public boolean test(Person p) {
				return predicate1.test(p) && predicate2.test(p);
			}
		};
	}
	
	
	
}
