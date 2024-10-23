package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class B08_Streams_Dateien {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("herrscher.txt");
		Files.lines(path).forEach(System.out::println);
		System.out.println("************");
		long anzahl = Files.lines(path).count();
		System.out.println("anzahl = " + anzahl);
		System.out.println("************");
		Files.lines(path)
			.filter(name -> name.startsWith("Heinrich"))
			.reduce((name1, name2) -> name1 + "," + name2)
			.ifPresent(System.out::println);
		
		System.out.println(Files.lines(path)
		.filter(name -> name.startsWith("Konrad"))
		.collect(Collectors.joining(", ")));
		System.out.println("************");
		// Gruppierung
//		Konrad		4
//		Heinrich 	6
//		Otto		4
//		Friedrich 	2
//		Lothar		1
//		Philipp		1
		
		Function<String, String> classifier = name -> name.split(" ")[0];
		
		Files.lines(path)
			.collect(Collectors.groupingBy(classifier))
			.forEach((key, value) -> System.out.println(key + ": " + value));
		
		System.out.println("************");
		Files.lines(path)
		.collect(Collectors.groupingBy(classifier,Collectors.counting()))
		.forEach((key, value) -> System.out.println(key + ": " + value));
		
		// Anzahl der Gesamt-Zeichen (mit Leerzeichen) im Stream (erwartes Ergebnis ca. 200)
		Integer identity = 0;
		
		BiFunction<Integer, String, Integer> acc = (teilGesamt, name) -> teilGesamt + name.length();
		
		BinaryOperator<Integer> comb = (i1, i2) -> i1 + i2;
		
		Integer anzahlZeichen = Files.lines(path).reduce(identity, acc, comb);
		System.out.println("************");
		System.out.println("anzahlZeichen = " + anzahlZeichen);
		
		long anzahlZeichenAsLong = Files.lines(path).mapToInt(String::length).sum();
		System.out.println("anzahlZeichenAsLong = " + anzahlZeichenAsLong);
	}

}
