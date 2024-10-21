package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class B02_Streams_erzeugen {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		
		// Stream aus einer Collection erzeugen
		Stream<Integer> streamCol = list.stream();
		streamCol.forEach(System.out::println);
		System.out.println("**************");
		
		Integer[] arr = { 10, 11, 12, 13, 14, 15, 16, 17 };
		
		// Stream aus Array erzeugen
		Stream<Integer> streamArr = Arrays.stream(arr);
		streamArr.forEach(System.out::println);
		
		System.out.println("**************");
		streamArr = Arrays.stream(arr, 0, 4);
		streamArr.forEach(System.out::println);
		System.out.println("**************");
		
		// Stream mit statischer Methode of erzeugen
		Stream<Integer> streamOfInt = Stream.of(1, 2, 3, 4, 5, 6, 7);
		streamOfInt.forEach(System.out::println);
		System.out.println("**************");
		
		Stream<String> streamWochentage = Stream.of("Montag");
		streamWochentage.forEach(System.out::println);
		System.out.println("**************");
		
		// Leerer Stream
		Stream<Integer> streamLeer = Stream.empty();
		streamLeer.forEach(System.out::println);
		System.out.println("**************");
		
		// Generate mit Supplier (Lieferant für Objekte)
		// Nur im Zusammenhang mit limit sinnvoll
		Supplier<Integer> suppl = () -> new Random().nextInt(49) + 1;
		Stream.generate(suppl).limit(6).forEach(System.out::println);
		System.out.println("**************");
		
		// Iterate mit Seed und UnaryOperator
		// Nur im Zusammenhang mit limit sinnvoll
		UnaryOperator<Integer> op = i -> i + 1;
		Stream.iterate(100, op).limit(100).forEach(System.out::println);
		System.out.println("**************");
		
		// Stream mit Zufallszahlen
		Random rand = new Random();
		rand.ints(6, 1, 50).forEach(System.out::println);
		System.out.println("**************");
		
		// Stream aus String
		String s = "Das ist das Haus vom Nikolaus";
		s.chars().mapToObj(i -> (char)i).forEach(System.out::println);
	}

}
