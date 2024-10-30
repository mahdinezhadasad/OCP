package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B22_Collectors_mapping {

	public static void main(String[] args) {
		
		List<Integer> datenquelle = Arrays.asList(1, 5, 3, 4, 5, 1);

		/*
		 * ohne mapping-Collector
		 */
		Collector<String, ?, Set<String>> c1 = Collectors.toSet();
		
		Function<Integer, String> f1 = i -> "<" + i + ">";
		
		Set<String> set1 = datenquelle.stream() // Stream<Integer>
				.map(f1) // Stream<String>
				.collect(c1);
		
		System.out.println("set1: " + set1); //  [<5>, <4>, <3>, <1>]
		
		/*
		 * mit mapping-Collector
		 * 
		 * seine Logiken
		 * 
		 * 	supplier	: die supplier-Logik des downstream-Collector 
		 * 
		 *  accumulator : mit der mapper-Function aus jdem Element der Pipeline
		 *  			  einen Wert berechnen.
		 *  			  Den berechneten Wert dem downstream-accumulator übergeben 
		 *  
		 *  combiner	: die combniner-Logik des downstream-Collector
		 */
		
		Function<Integer, String> mapper = i -> "(" + i + ")";
		
		Collector<String, ?, Set<String>> downstream = Collectors.toSet();
		Collector<Integer, ?, Set<String>> c2 = Collectors.mapping(mapper, downstream);
		
		Set<String> set2 = datenquelle.stream().collect(c2);
		
		System.out.println("set2: " + set2); // [(1), (5), (4), (3)]
		
	}

}
