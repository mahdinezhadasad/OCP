package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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


	}

}
