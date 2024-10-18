package collections;

import java.util.Map;
import java.util.function.BiFunction;

public class B08_Map_computeIfPresent {

	public static void main(String[] args) {
		
		Map<Integer, String> map = MyMapUtils.mapWoche();
		
		// {1=mo, 2=di, 3=mi, 4=do, 5=fr}
		System.out.println("1. map: " + map);

		/*
		 * default V computeIfPresent(K key,
                BiFunction<? super K, ? super V, ? extends V> remappingFunction)
                
           vereinfacht:
           
           default V computeIfPresent(K key,
                BiFunction<K, V, V> remappingFunction)

		 */
		
		map.computeIfPresent(key, remappingFunction);
		
	}

}
