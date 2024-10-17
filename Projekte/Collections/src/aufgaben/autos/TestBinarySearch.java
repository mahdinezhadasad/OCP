package aufgaben.autos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestBinarySearch {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(57, -13, 22, -4, 11, 3);
		System.out.println("1. list: " + list);
		
		/*
		 * binarySearch sucht korrekt nur 
		 * in sortierten Listen (oder Arrays)
		 * 
		 * 
		 * [57, -13, 22, -4, 11, 3]
		 *              |              1. Schritt 57 > 22, weiter rechts suchen
		 *              [-4, 11, 3]
		 *                    |        2. Schritt 57 > 11, weiter rechts suchen
		 *                      [3]
		 *                       |     3. Schritt 57 != 3, nicht gefunden
		 */
		
		Integer key = 57;
		int index = Collections.binarySearch(list, key);
		System.out.println("key: " + key + ", index: " + index); // -7

		/*
		 * Die Liste sollte sortiert werden
		 * 
		 * [-13, -4, 3, 11, 22, 57]
		 *             |                1. Schritt 57 > 3, weiter rechts suchen
		 *             [11, 22, 57]
		 *                   |          2. Schritt 57 > 22, weiter rechts suchen
		 *                     [57]
		 *                       |      3. Schritt 57 == 57, Treffer
		 * 
		 */
		Collections.sort(list);
		System.out.println("2. list: " + list);
		index = Collections.binarySearch(list, key);
		System.out.println("key: " + key + ", index: " + index); // 5
	}

}
