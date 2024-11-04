package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B24_Collectors_partitioningBy {

	public static void main(String[] args) {
		
		List<Integer> datenquelle = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		Predicate<Integer> predicate = i -> i%2==0;
		
		/*
		 * static <T>
    			Collector<T, ?, Map<Boolean, List<T>>> 
    				partitioningBy(Predicate<? super T> predicate)
		 */
		Collector<Integer, ?, Map<Boolean, List<Integer>>> c1 = 
				Collectors.partitioningBy(predicate);
		
 		Map<Boolean, List<Integer>> partsMap1 = datenquelle.stream().collect(c1);

 		List<Integer> partGerade = partsMap1.get(true);
 		List<Integer> partUngerade = partsMap1.get(false);
 		
 		System.out.println("gerade: " + partGerade);
 		System.out.println("ungerade: " + partUngerade);
 		
 		/*
 		 * static <T, D, A>
    			Collector<T, ?, Map<Boolean, D>> 
    				partitioningBy(Predicate<? super T> predicate,
                    	Collector<? super T, A, D> downstream)
 		 */
 		
 		Collector<Integer, ?, Set<Integer>> downstream = Collectors.toSet();
 		
 	 	Collector<Integer, ?, Map<Boolean, Set<Integer>>> c2 = 
 	 			Collectors.partitioningBy(predicate, downstream);
 	 	
 	 	Map<Boolean, Set<Integer>> partsMap2 =  datenquelle.stream().collect(c2);
 	 	
 	 	Set<Integer> setGerade = partsMap2.get(true);
 	 	Set<Integer> setUngerade = partsMap2.get(false);
 	 	
 	 	System.out.println("set gerade: " + setGerade);
 	 	System.out.println("set ungerade: " + setUngerade);
	}

}
