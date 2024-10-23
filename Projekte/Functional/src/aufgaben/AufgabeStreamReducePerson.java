package aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class AufgabeStreamReducePerson {

	public static void main(String[] args) {
		List<Person> personen = Arrays.asList(
				new Person("Tom","Katze"),
				new Person("Jerry","Maus"),
				new Person("Alexander","Poe"));
		
		// Akkumulator mit Tom Katze und Jerry Maus liefert Tom Maus
		// Akkumulator mit Tom Maus und Alexander Poe liefert Tom Poe
		
		BinaryOperator<Person> acc = (Person p1, Person p2) -> {
			String maxVorname = p1.getVorname().compareTo(p2.getVorname()) < 0 ? p2.getVorname() : p1.getVorname();
			String maxNachname = p1.getNachname().compareTo(p2.getNachname()) < 0 ? p2.getNachname() : p1.getNachname();		
			Person person =  new Person(maxVorname, maxNachname);
			System.out.println("acc = " + p1 + " : " + p2 + " = " + person);
			return person;
		};
		
		Optional<Person> optPerson = personen.stream().reduce(acc);
		optPerson.ifPresent(System.out::println);
		System.out.println("****************");
		// Akkumulator mit Winnie Poo und Tom Katze liefert  Winnie Poo
		// Akkumulator mit Winnie Poo und Jerry Maus liefert Winnie Poo
		// Akkumulator mit Winnie Poo und Alexander Poe liefert Winnie Poo
		
//		Person identity = new Person("Winnie","Poo");	
//		Person person = personen.stream().reduce(identity, acc);
//		System.out.println("person = " + person);
//		System.out.println("****************");
		// Akkumulator mit "" "" und Tom Katze liefert  Tom Katze
		// Akkumulator mit Tom Katze und Jerry Maus liefert Tom Maus
		// Akkumulator mit Tom Maus und Alexander Poe liefert Tom Poe
		
		Person identity = new Person("","");	
		Person person = personen.stream().reduce(identity, acc);
		System.out.println("person = " + person);
		System.out.println("****************");
		
		BinaryOperator<Person> comb = (Person p1, Person p2) -> {
			String maxVorname = p1.getVorname().compareTo(p2.getVorname()) < 0 ? p2.getVorname() : p1.getVorname();
			String maxNachname = p1.getNachname().compareTo(p2.getNachname()) < 0 ? p2.getNachname() : p1.getNachname();		
			Person p =  new Person(maxVorname, maxNachname);
			System.out.println("comb = " + p1 + " : " + p2 + " = " + p);
			return p;
		};
		
		identity = new Person("","");	
		person = personen.stream().sequential().parallel().reduce(identity, acc, comb);
		System.out.println("person = " + person);

	}

}

class Person {
	private String vorname;
	private String nachname;
	
	Person() {
		
	}
	Person(String vorname, String nachname) {
		this.setVorname(vorname);
		this.setNachname(nachname);
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	public String toString() {
		return vorname + " " + nachname;
	}
	
	
}
