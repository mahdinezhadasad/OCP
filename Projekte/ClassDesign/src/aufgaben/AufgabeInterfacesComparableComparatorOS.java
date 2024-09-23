package aufgaben;

import java.util.Arrays;
import java.util.Comparator;

public class AufgabeInterfacesComparableComparatorOS {

	public static void main(String[] args) {

		OS[] arr = {
			new OS("Linux", 3),
			new OS("Windows", 95),
			new OS("Mac", 9),
			new OS("Linux", 1),	
		};
		
		print(arr);
		
		System.out.println("\nSortiert aufsteigend: ");
		
		Arrays.sort(arr);
		
		print(arr);
		
		System.out.println("\nSortiert absteigend: ");
		
//		Comparator<OS> cmp = new OSReverseComparator();
		Comparator<OS> cmp = Comparator.reverseOrder();
		
		Arrays.sort(arr, cmp);
		
		print(arr);
	}
	
	/*
		 | 1. | Linux   |  3 |
		 | 2. | Windows | 95 |
		 | 3. | Mac     |  9 |
		 | 4. | Linux   |  1 |
		 
		 Wie die Methode 'format' funktioniert:
		 https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html 
		 
	*/
	static void print(OS[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			OS os = arr[i];
			System.out.format("| %d. | %-7s | %2s |%n", i+1,
					os.getName(), 
					os.getVersion());
		}
		
	}

}
