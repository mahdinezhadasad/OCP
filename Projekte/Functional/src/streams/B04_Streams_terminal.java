package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B04_Streams_terminal {

	public static void main(String[] args) {
		
		// forEach
		// Reihenfolge bei parallelen Streams nicht vorhersehbar
		
		Stream.of(1, 2, 3, 4, 5 ,6)
			.parallel()
			.map(i -> i * 10)
			.forEach(System.out::println);
		System.out.println("********");
		
		// forEachOrdered
		// Reihenfolge auch bei parallelen Streams vorhersehbar
		
		Stream.of(1, 2, 3, 4, 5 ,6)
			.parallel()
			.map(i -> i * 10)
			.forEachOrdered(System.out::println);
		
		long anzahl = Stream.of(1, 2, 3, 4, 5 ,6).count();
		System.out.println("anzahl = " + anzahl);
		
		IntStream stream = new Random().ints(10, 100, 200);
		
		// min und max
		System.out.println("min = " + stream.min());
		stream = new Random().ints(10, 100, 200);
		System.out.println("max = " + stream.max());
		
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam", "Betty");
		System.out.println("min = " + list.stream().min(Comparator.naturalOrder()));
		System.out.println("max = " + list.stream().max(Comparator.naturalOrder()));
		System.out.println("**************");
		Optional<String> minimum = list.stream().filter(name -> name.equals("Luke")).min(Comparator.naturalOrder());
		System.out.println("minimum = " + minimum);
		System.out.println("minimum = " + minimum.orElseGet(() -> "Nicht vorhanden"));
		if (minimum.isPresent()) {
			String name = minimum.get();
			System.out.println("minimum = " + name);
		}
		Tier[] array = {
				new Tier("Rex"),
				new Tier("Tom"),
				new Tier("Jerry"),
				new Tier("Tom"),
				new Tier("Jerry"),
			};
		
		Optional<Tier> tier = Arrays.stream(array).min(Comparator.naturalOrder()); // CF, falls Tier nicht vergleichbar (Comparable)
		System.out.println("tier = " + tier);
	}

}

class Tier implements Comparable<Tier>{
	private String name;

	public Tier(String name) {
		this.name = name;
	}
	public String toString() {
		return "Tier " + name;
	}
	public boolean equals(Object o) {
		Tier t = (Tier) o;
		return this.name.equals(t.name);
	}
	public int hashCode() {
		return name.hashCode();
	}
	@Override
	public int compareTo(Tier t) {
		return this.name.compareTo(t.name);
	}
}
