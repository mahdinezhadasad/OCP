package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B23_Collectors_groupingBy {

	public static void main(String[] args) {

		testV1();

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

}
