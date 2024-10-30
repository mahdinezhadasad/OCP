package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B21_Collectors_toXxx {

	public static void main(String[] args) {
		
		Integer[] array = { 1, 5, 3, 4, 5 };
		
		/*
		 * toList()
		 * 
		 * 	supplier	- erzeugt eine List
		 *  accumulator - einzelne Elemente in einer List speichern
		 *  combiner	- Listen kombinieren
		 */
		Collector<Integer, ?, List<Integer>> c1 = Collectors.toList();
		
		List<Integer> list = Arrays.stream(array)
			.collect(c1);
		
		System.out.println("list: " + list);
		
		/*
		 * toSet()
		 * 
		 * 	supplier	- erzeugt ein Set
		 *  accumulator - einzelne Elemente in einem Set speichern
		 *  combiner	- Sets kombinieren
		 */
		Collector<Integer, ?, Set<Integer>> c2 = Collectors.toSet();
		
		Set<Integer> set = Arrays.stream(array)
				.collect(c2);
		
		System.out.println("set: " + set);
		
		/*
		 * toCollection(Supplier<C> collectionFactory)
		 * 
		 * 	supplier	- die Logik fehlt
		 *  accumulator - einzelne Elemente in einer Collection speichern
		 *  combiner	- Collections kombinieren
		 */
		Collector<Integer, ?, TreeSet<Integer>> c3 = Collectors.toCollection(TreeSet::new);
		
		TreeSet<Integer> treeSet = Arrays.stream(array)
				.collect(c3);
		
		System.out.println("treeSet: " + treeSet);
		
		/*
		 * Collectors.toMap(Function keyMapper, Function valueMapper)
		 * 
		 * 
		 * 	supplier	- eine Map erzeugen
		 *  accumulator - einzelne Elemente in der Map speichern
		 *  				- dabei werden aus dem Element der Key und das Value berechnet 
		 *  combiner	- Maps kombinieren
		 * 
		 * Test. Map erzeugen: Länge-to-String
		 * 		
		 * 		
		 */
		List<String> datenquelle = Arrays.asList("ccc", "a", "bb", "dddd");
		
		Function<String, Integer> keyMapper = String::length;
		Function<String, String> valueMapper = s -> s;
		
		Collector<String, ?, Map<Integer, String>> c4 = 
				Collectors.toMap(keyMapper, valueMapper);
		
		Map<Integer, String> map = datenquelle.stream().collect(c4);
		System.out.println("map: " + map);
	}
	


}
