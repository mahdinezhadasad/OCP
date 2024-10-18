package collections;

import java.util.Map;
import java.util.function.BiFunction;

public class B10_Map_merge {

	public static void main(String[] args) {
		
		Map<Integer, String> map = MyMapUtils.mapWoche();
		
		// {1=mo, 2=di, 3=mi, 4=do, 5=fr}
		System.out.println("1. map: " + map);

		/*
		 * default V merge(K key, V value,
            BiFunction<? super V, ? super V, ? extends V> remappingFunction)
            
            vereinfacht:
            
           default V merge(K key, V value,
            BiFunction<V, V, V> remappingFunction)
            
		 */
		
		BiFunction<String, String, String> remappingFunction = 
				(String oldValue, String passedValue) -> {
					return oldValue.toUpperCase() + passedValue;
				};

		/*
		 * Test 1. Den Schlüßel gibt es noch nicht.
		 * 
		 * merge speichert einfach den Schlüßel (und den übergebenen Wert)
		 * in der Map.
		 */
		Integer key = 6;
		
		map.merge(key, "sa", remappingFunction);
		
		// {1=mo, 2=di, 3=mi, 4=do, 5=fr, 6=sa}
		System.out.println("2. map: " + map);
		
		/*
		 * Test 2. Den Schlüßel gibt es bereits.
		 *
		 * merge aktiviert die remappingFunction und übergibt
		 * an die apply den alten Wert und den übergebenen Wert.
		 * 
		 * merge ersetzt den alten Wert durch den Wert, 
		 * den die remappingFunction berechnet.
		 */
		
		key = 2;
		map.merge(key, "!!!", remappingFunction);
		
		// {1=mo, 2=DI!!!, 3=mi, 4=do, 5=fr, 6=sa}
		System.out.println("3. map: " + map);
	}

}
