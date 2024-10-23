package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class B01_Streams {
	
	/*
	 * Stream-API:
	 * 		https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
	 * 
	 * Wichtige Typen und Begriffe:
	 * 		https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
	 */

	public static void main(String[] args) {
		List<Integer> datenquelle = Arrays.asList(5, 2, 3, -6, -7, 42, 0, 77, 3);
		
		// Ein Stream (Datenstrom) ist eine Folge von Elementen (Objekten), die zur weiteren Verabeitung (typischerweise zusammenfassend) verwendet wird. Ein Stream speichert nicht die Daten.
		Stream<Integer> stream = datenquelle.stream();
		
		Stream<Integer> streamTemp = stream.filter(i -> i != null).filter(i -> i > 0); // filter mit Predicate erzeugt wieder einen Stream (intermediate)
		
		// streamTemp.forEach(System.out::println); // forEach ist eine terminal-Operation, sie bildet das Ende der Pipeline
		
		int summe = streamTemp.mapToInt(i -> i).sum(); // man kann einen terminierten Stream nicht noch einmal verwenden
		System.out.println("summe = " + summe);
		
		// Sequenzieller Stream als Einzeiler: Filter nach not null, Filter nach negativen Zahlen, Ausgabe untereinander
		datenquelle.stream().filter(i -> i != null).filter(i -> i < 0).forEach(System.out::println);
		
		System.out.println("**************");
		 
		// Paralleler Stream 
		datenquelle.parallelStream().map(i -> i + 1).map(i -> i * 2).forEach(System.out::println);
	}

}
