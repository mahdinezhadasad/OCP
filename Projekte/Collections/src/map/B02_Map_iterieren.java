package map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class B02_Map_iterieren {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("jan", 31);
		map.put("feb", 28);
		map.put("mär", 31);
		

		/*
		 * Map ist NICHT Iterable
		 */
//		for(Object obj : map) {} // cf

		/*
		 * Set<K> keySet()
		 */
		System.out.println("*** keySet()");
		Set<String> allKeys = map.keySet();
		
		for(String key : allKeys) {
			Integer value = map.get(key);
			System.out.println(key + "=" + value); 
		}
		
		/*
		 * forEach wird später im Projekt 'Functional' im Package 
		 * 'collections' besprochen
		 */
		
		/*
		 * Collection<V> values()
		 */
		System.out.println("\n*** values()");
		Collection<Integer> allValues = map.values();
		System.out.println("allValues: " + allValues);
		
		/*
		 * Map:
		 * 		Map<String, Integer> map
		 * 
		 * Eintrag dieser Map besteht aus Key und Value
		 * und wird in einem Objekt vom Typ Map.Entry gespeichert
		 * 
		 * Der Eintrag dieser Map hat den Typ:
		 * 
		 * 		Map.Entry<String, Integer>
		 * 
		 * Ein Set mit solchen Elementen hat den Typ:
		 * 		
		 * 		Set<Map.Entry<String, Integer>>
		 */
		System.out.println("\n*** entrySet");
		
//		Map.Entry<String, Integer> entry; // 
		
		Set<Map.Entry<String, Integer>> allEntries = map.entrySet();
		
		for(Map.Entry<String, Integer> entry : allEntries) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + "=" + value);
		}
		
	}

}
