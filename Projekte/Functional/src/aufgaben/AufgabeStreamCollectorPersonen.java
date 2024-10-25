package aufgaben;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import person.Person;

public class AufgabeStreamCollectorPersonen {
	
	static Person[] personen = {
			new Person("Tom", "Bauarbeiter(in)"),	
			new Person("Jerry", "Lehrer(in)"),	
			new Person("Peter", "Metzger(in)"),	
			new Person("Paul", "Bauarbeiter(in)"),	
			new Person("Mary", "Lehrer(in)"),	
		};

	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
//		a4();
		Map<Boolean, List<Person>> mapBauarbeiter = Arrays.stream(personen)
				.collect(Collectors.partitioningBy(person -> person.getBeruf().equals("Bauarbeiter(in)")));
		mapBauarbeiter.forEach((bauarbeiter, personen) -> System.out.println((bauarbeiter ? "Bauerbeiter(in)" : "Kein(e) Bauarbeiter(in)") + " " + personen));
		
	}
	
	static void a4() {
		Map<String, List<Person>> mapBerufe = Arrays.stream(personen).collect(Collectors.groupingBy(Person::getBeruf));
		mapBerufe.forEach((beruf, personen) -> System.out.println(beruf + " " + personen));
	}
	
	static void a3() {
		Set<String> berufe = Arrays.stream(personen).collect(Collectors.mapping(Person::getBeruf, Collectors.toSet()));
		berufe.forEach(System.out::println);
	}
	
	static void a2() {
		Map<String, Person> mapPersonen = Arrays.stream(personen).collect(Collectors.toMap(Person::getName, person -> person));
		mapPersonen.forEach((name, person) -> System.out.println(name + " " + person));
	}
	
	static void a1() {
		TreeSet<Person> setPersonen = Arrays.stream(personen).collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));
		setPersonen = Arrays.stream(personen).collect(Collectors.toCollection(TreeSet::new));
		setPersonen.forEach(System.out::println);

	}

}

