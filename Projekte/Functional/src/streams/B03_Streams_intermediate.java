package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class B03_Streams_intermediate {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam", "Betty");
		
		// filter-Methode mit Predicate
		list.stream().filter(name -> name.startsWith("B")).forEach(System.out::println);
		System.out.println("*************");
		
		// sorted-Methode mit Comparator
		list.stream().filter(name -> name.startsWith("B")).sorted().forEach(System.out::println);
		System.out.println("*************");
		list.stream().sorted().filter(name -> name.startsWith("B")).forEach(System.out::println); // Reihenfolge sorted - filter unerheblich
		System.out.println("*************");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("*************");
		
		// limit-Methode
		list.stream().limit(3).forEach(System.out::println);
		System.out.println("*************");
		list.stream().limit(3).sorted().forEach(System.out::println);
		System.out.println("*************");
		list.stream().sorted().limit(3).forEach(System.out::println); // Reihenfolge sorted - limit wichtig!
		System.out.println("*************");
		
		// skip-Methode
		list.stream().skip(3).forEach(System.out::println);
		System.out.println("*************");
	
		// map-Methode
		Function<String, String> f1 = s -> s.toLowerCase();
		UnaryOperator<String> op = s -> s.toUpperCase();
		// Methodenreferenz
		f1 = String::toLowerCase;
		op = String::toUpperCase;
		
		list.stream().map(f1).filter(name -> name.startsWith("B")).forEach(System.out::println);
		System.out.println("*************");
		list.stream().filter(name -> name.startsWith("B")).map(f1).forEach(System.out::println); // Reihenfolge wichtig!
		System.out.println("*************");
		
		Function<String, Integer> f2 = String::length;
		list.stream().map(f2).forEach(System.out::println);
		long anzahl = list.stream().map(f2).count();
		int summe = list.stream().map(f2).mapToInt(i -> i).sum();
		System.out.println("anzahl = "+ anzahl);
		System.out.println("summe = " + summe);
		System.out.println("*************");
		
		// distinct-Methode
		list.stream().forEach(System.out::println);
		System.out.println("*************");
		list.stream().distinct().forEach(System.out::println);
		System.out.println("*************");
		
		// peek-Methode
		Consumer<String> consumer = s -> System.out.println("peek = " + s);
		list.stream()
			.distinct()		
			.filter(name -> name.startsWith("B"))	
			.peek(consumer)
			.map(String::toUpperCase)		
			.sorted()
			.forEach(System.out::println)
			;
		
		// Streams sind lazy (faul), sie werden nur angestoßen, wenn eine terminal-Operation am Ende vorhanden ist
		
	}

}
