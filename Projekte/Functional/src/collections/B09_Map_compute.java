package Functional.src.collections;

import java.util.Map;
import java.util.function.BiFunction;

public class B09_Map_compute {

	public static void main(String[] args) {
		
		Map<Integer, String> map = collections.MyMapUtils.mapWoche();
		
		// {1=mo, 2=di, 3=mi, 4=do, 5=fr}
		System.out.println("1. map: " + map);

		/*
		 * default V compute(K key,
             BiFunction<? super K, ? super V, ? extends V> remappingFunction)
             
           vereinfacht:
           
           default V compute(K key,
             BiFunction<K, V, V> remappingFunction)
		 */
		
		BiFunction<Integer, String, String> remappingFunction = 
				(Integer k, String oldValue) -> {

					if(oldValue==null) {
						return "new value for new key (" + k + ")";
					}
					
					return oldValue.toUpperCase() + "!!!";
				};
		
		/*
		 * Test 1. Den Schlüßel gibt es nicht
		 */
		Integer key = 333;
		map.compute(key, remappingFunction);

		// {1=mo, 2=di, 3=mi, 4=do, 5=fr, 333=new value for new key (333)}
		System.out.println("2. map: " + map);
		
		/*
		 * Test 2. Den Schlüßel gibt es
		 */
		key = 2;
		map.compute(key, remappingFunction);
		
		// {1=mo, 2=DI!!!, 3=mi, 4=do, 5=fr, 333=new value for new key (333)}
		System.out.println("3. map: " + map);
	}

}