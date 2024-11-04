package streams.wdh;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B23_Collectors_groupingBy {

	public static void main(String[] args) {

		testV1();
		testV2();

	}
	
	/*
	 * static <T, K> Collector<T, ?, Map<K, List<T>>>
     *		groupingBy(Function<? super T, ? extends K> classifier)
     *
     *  Der erzeugte Collector hat die Logiken:
     *  
     *  
     *  supplier	: eine Map erzeugen
     *  accumulator : - aus jedem Element der Pipeline wird mit der classifier-Function
     *                  der Key seiner Gruppe berechnet.
     *                - falls es in der Map (s. supplier-Logik) den Key noch nicht gibt,
     *                  dann wird die Liste für die neue Gruppe erzeugt,
     *                  das Element in der Liste gespeichert,
     *                  die Key und die Liste als Value werden in der Map gespeichert.
     *                - falls es in der Map (s. supplier-Logik) den Key bereits gibt,
     *                  wird in der vorhandene Liste das Element gespeichert
     *                  
     *	combiner    :   die Gruppen aus der 2. Map in die richtigen 
     *                  Gruppen der 1. Map kopieren
     *
	 */
	static void testV1() {
		System.out.println("*** groupngBy. V1");
		
		List<Integer> datenquelle = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		/*
		 * Aufgabe: zwei Gruppen bilden:
		 * 
		 * "ungerade" -> 1 3 5 7
		 * "gerade" -> 2 4 6
		 */
		Function<Integer, String> classifier = i -> {
			if(i%2==0) {
				return "gerade";
			}
			return "ungerade";
		};
		
		Collector<Integer, ?, Map<String, List<Integer>>> c1 = 
				Collectors.groupingBy(classifier);
		
		Map<String, List<Integer>> gruppenMap = datenquelle.stream().collect(c1);
	
		System.out.println("gruppenMap: " + gruppenMap);
	}
	
	/*
	 * static <T, K> Collector<T, ?, Map<K, List<T>>>
     *		groupingBy(Function<? super T, ? extends K> classifier)
     *
     *  Der erzeugte Collector hat die Logiken:
     *  
     *  
     *  supplier	: eine Map erzeugen
     *  accumulator : - aus jedem Element der Pipeline wird mit der classifier-Function
     *                  der Key seiner Gruppe berechnet.
     *                - falls es in der Map (s. supplier-Logik) den Key noch nicht gibt,
     *                  dann wird das Bilden des Zielcontainers dem downstream-Collector
     *                  überlassen und das Element der Pipeline dem downstream-Collector übergeben.
     *                - falls es in der Map (s. supplier-Logik) den Key bereits gibt,
     *                  wird das Element der Pipeline dem downstream-Collector übergeben
     *	combiner    :   die Gruppen aus der 2. Map in die richtigen 
     *                  Gruppen der 1. Map kopieren
     *
     *  downstream  : - Die Logiken zum Verwalten der Elemente einer Gruppe
	 */
	static void testV2() {
		System.out.println("*** groupngBy. V2");
		
		List<Integer> datenquelle = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		/*
		 * Aufgabe: zwei Gruppen bilden:
		 * 
		 * "ungerade" -> 1 3 5 7
		 * "gerade" -> 2 4 6
		 * 
		 * Die Elemente einer Gruppe sollen in einem ArrayDeque gespeichert werden
		 */
		Function<Integer, String> classifier = i -> i % 2 == 0 ? "gerade" : "ungerade";
		
		Collector<Integer, ?, ArrayDeque<Integer>> downstream = 
				Collectors.toCollection(ArrayDeque::new);
		
		Collector<Integer, ?, Map<String, ArrayDeque<Integer>>> c1 = 
				Collectors.groupingBy(classifier, downstream);
		
		Map<String, ArrayDeque<Integer>> gruppenMap = datenquelle.stream().collect(c1);
		
		System.out.println("gruppenMap (String-to-ArrayDeque): " + gruppenMap);
		
		
		/*
		 * Aufgabe: zwei Gruppen bilden:
		 * 
		 * "ungerade" -> 1 3 5 7
		 * "gerade" -> 2 4 6
		 * 
		 * Die Elemente einer Gruppe sollen in einem TreeSet gespeichert werden,
		 * absteigend sortiert
		 */
		
		Supplier<TreeSet<Integer>> factory = () -> new TreeSet<>(Comparator.reverseOrder());
		
		Collector<Integer, ?, TreeSet<Integer>> downstream2 = 
				Collectors.toCollection(factory);
		
		Collector<Integer, ?, Map<String, TreeSet<Integer>>> c2 = 
				Collectors.groupingBy(classifier, downstream2); 
		
		Map<String, TreeSet<Integer>> gruppenMap2 = datenquelle.stream().collect(c2);
		
		System.out.println("gruppenMap2 (String-to-TreeSet): " + gruppenMap2);
	}

}
