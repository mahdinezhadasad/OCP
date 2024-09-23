package wdh.compare;

import java.util.Arrays;
import java.util.Comparator;

class MyStringComparator implements Comparator<String> {
	public int compare(String s1, String s2) {
		return s2.compareTo(s1);
	}
}

public class InterfaceComparator {

	public static void main(String[] args) {
		
		String s1 = "mo";
		String s2 = "di";

		/*
		 * Wenn eine Klasse das Interface Comparator implementiert,
		 * ensteht ein alternativer Vergleicher (Comparator),
		 * mit dem Elemente einer anderen Klasse vergliechen werden können.
		 * 
		 * (alternativ = nicht 'natürlich')
		 */
		Comparator<String> cmp = new MyStringComparator();
		
		int result = cmp.compare(s1, s2);
		
		if(result < 0) {
			System.out.println("mo ist kleiner als di"); // Ausgabe
		} else if (result > 0) {
			System.out.println("mo ist grösser als di"); 
		} else {
			System.out.println("mi ist gleich di");
		}
		
		/*
		 * Alternative Sortierung verwendent fürs Vergleichen 
		 * einen Comparator: 
		 */
		String[] arr = {
			"mo", "di", "mi", "do"
		};
		
		Arrays.sort(arr, cmp);
		
		System.out.println(Arrays.toString(arr)); // [mo, mi, do, di]
	}

}
