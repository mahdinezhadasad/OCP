package wdh.methoden;

import java.util.ArrayList;
import java.util.List;

public class RichtigeUeberladeneMethodeFinden {

	public static void main(String[] args) {
//		kleineFrage1(); // wirft Exception
		kleineFrage2();
	}

	/*
	 * Was ist das Ergebnis?
	 * 
	 * A. Compilerfehler
	 * B. 2
	 * C. 3
	 * D. IndexOutOfBoundsException			<- richtig
	 */
	static void kleineFrage1() {
		List<Integer> list = new ArrayList<>();
		
		list.add(12);
		list.add(13);
		list.add(14);
		
		list.remove(12); // remove(int index)
		
		System.out.println( list.size() );
	}
	
	/*
	 * Was ist das Ergebnis?
	 * 
	 * A. Compilerfehler
	 * B. 2					<- richtig
	 * C. 3
	 * D. Exception
	 */
	static void kleineFrage2() {
		List<String> list = new ArrayList<>();
		
		list.add("mo");
		list.add("di");
		list.add("mi");
		
		list.remove("mo"); // remove(Object element)
		
		System.out.println( list.size() );
	}
}
