package sortieren;

import java.util.Arrays;
import java.util.Comparator;

public class B04_binarySearch {

	public static void main(String[] args) {
		b1();
		b2();
		b3();
		b4();
	}
	
	
	static void b4() {
		System.out.println("\n*** Bsp. 3");
		String[] arr = { "e", "a", "b", "c", "d" }; // Array mit Referenzen!
		
		Comparator<String> cmp = (x, y) -> y.compareTo(x);

		Arrays.sort(arr, cmp); // [e, d, c, b, a]
		
		/*
		 * falsch. Array ist nicht 'natürlich aufsteigend' sortiert
		 */
		int index = Arrays.binarySearch(arr, "e");
		System.out.println("arr nicht normal sortiert: " + Arrays.toString(arr));
		System.out.println("Falsche Suche nach e. index: " + index); // ???
		
		/*
		 * richtig: alternatieve binarySearch mit Comparator
		 */
		index = Arrays.binarySearch(arr, "e", cmp);
		System.out.println("arr nicht normal sortiert: " + Arrays.toString(arr));
		System.out.println("Falsche Suche nach e. index: " + index); // 0
		
	}
	
	static void b3() {
		System.out.println("\n*** Bsp. 3");
		String[] arr = { "e", "a", "b", "c", "d" }; // Array mit Referenzen!
		
		/*
		 * falsch. Array ist nicht sortiert
		 */
		int index = Arrays.binarySearch(arr, "e");
		System.out.println("arr nicht sortiert: " + Arrays.toString(arr));
		System.out.println("Falsche Suche nach e. index: " + index); // ???
		
		Arrays.sort(arr);
		
		index = Arrays.binarySearch(arr, "e");
		System.out.println("arr sortiert: " + Arrays.toString(arr));
		System.out.println("Richtige Suche nach e. index: " + index); // 4
	}
	
	static void b2() {
		System.out.println("\n*** Bsp. 2");
		Integer[] arr = { 5, 1, 2, 3, 4 }; // Array mit Referenzen!
		
		/*
		 * falsch. Array ist nicht sortiert
		 */
		int index = Arrays.binarySearch(arr, 5);
		System.out.println("arr nicht sortiert: " + Arrays.toString(arr));
		System.out.println("Falsche Suche nach 5. index: " + index); // ???
		
		Arrays.sort(arr);
		
		index = Arrays.binarySearch(arr, 5);
		System.out.println("arr sortiert: " + Arrays.toString(arr));
		System.out.println("Richtige Suche nach 5. index: " + index); // 4
	}
	
	static void b1() {
		System.out.println("\n*** Bsp. 1");
		int[] arr = { 5, 1, 2, 3, 4 };
		
		/*
		 * falsch. Array ist nicht sortiert
		 */
		int index = Arrays.binarySearch(arr, 5);
		System.out.println("arr nicht sortiert: " + Arrays.toString(arr));
		System.out.println("Falsche Suche nach 5. index: " + index); // ???
		
		Arrays.sort(arr);
		
		index = Arrays.binarySearch(arr, 5);
		System.out.println("arr sortiert: " + Arrays.toString(arr));
		System.out.println("Richtige Suche nach 5. index: " + index); // 4
	}

}
