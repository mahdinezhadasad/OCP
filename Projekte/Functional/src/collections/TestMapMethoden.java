package collections;

import java.util.HashMap;
import java.util.Map;

public class TestMapMethoden {

	public static void main(String[] args) {
		
		Integer[] zahlen = {
			1, 33, 1, 50, 7, 1, 33, 4, 33, 1 	
		};
		
		/*
		 * Map mit Anzahl der geraden und ungeraden Werten in dem Array 
		 * 
		 * "gerade"   : 2
		 * "ungerade" : 8
		 */
		
		/*
		 * Version 1
		 */
		Map<String, Integer> map1 = new HashMap<>();
		
		for(Integer x : zahlen) {
			String key = x % 2 == 0 ? "gerade" : "ungerade";
			
			Integer value = map1.get(key);
			
			if(value==null) {
				map1.put(key, 1);
			} else {
				map1.put(key, value + 1);
			}
		}
		
		System.out.println("map1: " + map1);

		/*
		 * Version 2
		 */
		Map<String, Integer> map2 = new HashMap<>();
		
		for(Integer x : zahlen) {
			String key = x % 2 == 0 ? "gerade" : "ungerade";
			
			map2.merge(key, 1, (value, passedValue) -> value+passedValue);
		}
		
		System.out.println("map2: " + map2);
	}

}
