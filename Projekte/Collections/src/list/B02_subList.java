package list;

import java.util.ArrayList;
import java.util.List;

public class B02_subList {

	public static void main(String[] args) {
		/*
		 * Achtung!
		 * 
		 * subList liefert eine 'View' der Basisliste zurück.
		 * Die View speichert die Elemente nicht selbst.
		 * Die View speichert nur die Adresse der Basisliste 
		 * und die eigenen Grenzen.
		 * 
		 * Doku: 
		 * "Returns a view of the portion of this list between the specified 
		 *  fromIndex, inclusive, and toIndex, exclusive. 
		 *  The returned list is backed by this list, so non-structural
		 *  changes in the returned list are reflected in this list, 
		 *  and vice-versa."
		 */
		List<Integer> basisList = new ArrayList<>();
		
		basisList.add(2);
		basisList.add(7);
		basisList.add(11);
		basisList.add(13);
		basisList.add(17);

		/*
		 *  0  1   2   3   4
		 * [2, 7, 11, 13, 17]
		 */
		System.out.println("1. basisList: " + basisList);
		
		int fromIndex = 1; // inklusive
		int toIndex = 4; // exklusive
		
		List<Integer> subList = basisList.subList(fromIndex, toIndex);
		
		// subList = new ArrayList<>(subList); // so kann die Kopplung zu 
												// Basisliste entfernt werden
		
		/*
		 * 		 0   1   2          <- index in subList
		 * 		[7, 11, 13]
		 */
		System.out.println("1. subList: " + subList);
		
		Integer x = subList.get(1);
		System.out.println("x = " + x); // 11
		
		
		/*
		 * Basisliste ändern (aber keine Größe ändern)
		 */
		basisList.set(3, -555);
		System.out.println("2. basisList: " + basisList); // [2, 7, 11, -555, 17]
		System.out.println("2. subList: " + subList); // [7, 11, -555]
		
		/*
		 * subList ändern (aber keine Größe ändern)
		 */
		subList.set(0, -712);
		System.out.println("3. basisList: " + basisList); // [2, -712, 11, -555, 17]
		System.out.println("3. subList: " + subList); // [-712, 11, -555]
		
		/*
		 * Nicht in der Prüfung:
		 * 
		 * 'Struktur-Änderung' führt dazu, dass subList ungültig wird
		 */
		basisList.add(1000);
		
		try {
			System.out.println(subList);
		} catch (Exception e) {
			System.out.println("Fehler! subList ist ungültig: " + e);
		}
			
	}

}
