package aufgaben;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AufgabeGenerischeMethodenA3 {

	public static void main(String[] args) {
		
		List<Integer> listA = Arrays.asList(1, 2, 3);
		int sum = sum(listA);
		sum = sumAlternativ(listA);
		sum = sumInts(listA);
		System.out.println(sum);

		List<String> listB = Arrays.asList("1", "2", "3");
//		sum = sum(listB); // darf nicht kompilieren
		
		List<Short> listC = Arrays.asList((short)1, (short)2, (short)3);
		sum = sum(listC);
		sum = sumAlternativ(listC);
//		sum = sumInts(listC);
		System.out.println(sum);
	}

	public static <T extends Number> Integer sumAlternativ(Collection<T> zahlen) {
		int sum = 0;
		
		for(Number zahl : zahlen) {
			sum += zahl.intValue(); // Datenverlust möglich
		}
		
		return sum;
	}
	
	public static Integer sum(Collection<? extends Number> zahlen) {
		int sum = 0;
		
		for(Number zahl : zahlen) {
			sum += zahl.intValue(); // Datenverlust möglich
		}
		
		return sum;
	}
	
	public static Integer sumInts(Collection<Integer> zahlen) {
		int sum = 0;
		
		for(Integer zahl : zahlen) {
		   sum += zahl;
		}
		
		return sum;
	}
	
//	public static Integer sum(Collection zahlen) {
//		int sum = 0;
//		
//		for(Object zahlRef : zahlen) {
//			Integer zahl = (Integer) zahlRef;
//			sum += zahl.intValue();
//		}
//		
//		return Integer.valueOf(sum);
//	}
	
}
