package Functional.src.collections;

import java.util.Map;
import java.util.function.BiConsumer;

public class B05_Map_forEach {

	public static void main(String[] args) {
		
		Map<Integer, String> map = collections.MyMapUtils.mapWoche();
		
		/*
		 * default void forEach(BiConsumer<? super K, ? super V> action)
		 * 
		 * vereinfacht betrachtet:
		 * default void forEach(BiConsumer<K, V> action)
		 */
		BiConsumer<Integer, String> bc1 = (Integer key, String value) -> {
			System.out.println(key + " = " + value);
		};
		
		map.forEach(bc1);

	}

}