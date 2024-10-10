package map;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class B01_Map_BasicAPI {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		
		/*
		 * int size()
		 */
		System.out.println("1. size(): " + map.size()); // 0
	
		/*
		 * V put(K key, V value)
		 * 
		 * 		put kann fürs Speichern der Key-Value-Paare verwendet werden
		 */
		map.put(1, "mo");
		map.put(2, "di");
		map.put(3, "mi");
		
		System.out.println("2. size(): " + map.size()); // 3
		
		/*
		 * String toString()
		 * 	
		 * 		{key1=value1, key2=value2, key3=value3}
		 */
		System.out.println("map: " + map); // {1=mo, 2=di, 3=mi} Reihenfolge der Schlüßel ist in HashMap nicht garantiert
		
		/*
		 * V get(Object key)
		 */
		Integer key = 77;
		String value = map.get(key);
		
		System.out.println("key = 77, value = " + value); // null
		
		key = 2;
		value = map.get(key);
		System.out.println("key = 2, value = " + value); // di

		/*
		 * V put(K key, V value)
		 * 
		 * 		put kann fürs Aktualisieren der Werte verwendet werden.
		 * 		Der alte Wert wird ersetzt und zurück geliefert.
		 */
		String oldValue = map.put(2, "Dienstag");
		
		System.out.println("oldValue: " + oldValue); // di
		
		System.out.println("map: " + map); // {1=mo, 2=Dienstag, 3=mi} 

		/*
		 * V remove(Object key)
		 */
		key = 33333;
		String removedValue = map.remove(key);
		System.out.println("remove(33333): " + removedValue); // null
		
		key = 2;
		removedValue = map.remove(key);
		System.out.println("remove(2): " + removedValue); // Dienstag
		
		System.out.println("map: " + map); // {1=mo, 3=mi} 
		
		/*
		 * boolean isEmpty()
		 */
		boolean empty = map.isEmpty();
		System.out.println("isEmpty(): " + empty); // false
		
		/*
		 * void clear()
		 */
		map.clear();
		System.out.println("3. size(): " + map.size()); // 0
		System.out.println("map: " + map); // {} 
	}

}
