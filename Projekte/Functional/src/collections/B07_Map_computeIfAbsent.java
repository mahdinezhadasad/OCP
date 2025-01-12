package Functional.src.collections;

import java.util.Map;
import java.util.function.Function;

public class B07_Map_computeIfAbsent {

	public static void main(String[] args) {

		Map<Integer, String> map = collections.MyMapUtils.mapWoche();
		
		// {1=mo, 2=di, 3=mi, 4=do, 5=fr}
		System.out.println("1. map: " + map);
		
		/*
		 *  default V computeIfAbsent(K key,
                  Function<? super K, ? extends V> mappingFunction)
                  
            vereinfacht:
            
            default V computeIfAbsent(K key,
                  Function<K, V> mappingFunction)
		 */
		
		Function<Integer, String> mappingFunction = (Integer k) -> {
			switch(k) {
			   case 6: return "sa";
			   case 7: return "s0";
			}
			return "ungültig";
		};
		
		
		/*
		 * Test 1. Den Schlüßel gibt es nicht
		 */
		Integer key = 333;
		
		map.computeIfAbsent(key, mappingFunction);
		
		//  {1=mo, 2=di, 3=mi, 4=do, 5=fr, 333=ungültig}
		System.out.println("2. map: " + map);
		
		/*
		 * Test 2. Den Schlüßel gibt es bereits.
		 * 
		 * computeIfAbsent ändert diesmal nichts in der Map
		 */
		
		key = 1;
		
		map.computeIfAbsent(key, mappingFunction);
		
		// {1=mo, 2=di, 3=mi, 4=do, 5=fr, 333=ungültig}
		System.out.println("3. map: " + map);
	}

}