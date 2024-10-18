package collections;

import java.util.Map;
import java.util.function.BiFunction;

public class B06_Map_replaceAll {

	public static void main(String[] args) {
		
		Map<Integer, String> map = MyMapUtils.mapWoche();
		
		// {1=mo, 2=di, 3=mi, 4=do, 5=fr}
		System.out.println("1. map: " + map);

		/*
		 * default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
		 *
		 * vereinfacht:
		 * default void replaceAll(BiFunction<K, V, V> function)
		 */
		
		BiFunction<Integer, String, String> bf1 = 
				(Integer key, String oldValue) -> {
					if(key==4) {
						return "Donnerstag";
					}
					
					return oldValue.toUpperCase();
				};
		
		map.replaceAll(bf1);
		
		// {1=MO, 2=DI, 3=MI, 4=Donnerstag, 5=FR}
		System.out.println("2. map: " + map);

		map.replaceAll((k,v) -> "<"+v+">");
		
		// {1=<MO>, 2=<DI>, 3=<MI>, 4=<Donnerstag>, 5=<FR>}
		System.out.println("3. map: " + map);
	}

}
