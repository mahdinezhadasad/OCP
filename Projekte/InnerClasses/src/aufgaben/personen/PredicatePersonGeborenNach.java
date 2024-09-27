package aufgaben.personen;

import java.util.function.Predicate;

public class PredicatePersonGeborenNach implements Predicate<Person> {

	private int minGeburtsjahr;

	public PredicatePersonGeborenNach(int minGeburtsjahr) {
		this.minGeburtsjahr = minGeburtsjahr;
	}
	
	public boolean test(Person p) {
		return p.getGeburtsjahr() > minGeburtsjahr;
	}
	
}
