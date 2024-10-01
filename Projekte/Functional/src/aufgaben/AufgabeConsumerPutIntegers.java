package aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AufgabeConsumerPutIntegers {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		putIntegers( i -> sb.append(i).append(" ") );
		System.out.println(sb); 	// 1 2 3 4

		
		List<Integer> list = new ArrayList<>();
		putIntegers( i -> list.add(i) );
		System.out.println(list); // [1, 2, 3, 4]

		
		putIntegers( System.out::print ); 	// 1234
											// Zeile C, optionale Aufgabe, 
											// die Zeile C kann entfernt werden
	}

	static void putIntegers(Predicate<Integer> p) {
		
	}
	
}
