package sortieren;

import java.util.Arrays;
import java.util.Comparator;


class Foo implements Comparable<Foo> {
	int a, b;

	public Foo(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(Foo f2) {
		Foo f1 = this;
		
		return f1.b - f2.b;
	}
	
	@Override
	public String toString() {
		return "(a=" + a + ", b=" +b + ")";
	}
}

public class B01_SortierenVonArrays {

	public static void main(String[] args) {
		/*
		 * primitive Arrays
		 */
		int[] a1 = { 7, -2, 5, 3 };
		Arrays.sort(a1);
		
		System.out.println("a1: " + Arrays.toString(a1));  // [-2, 3, 5, 7]

		/*
		 * Arrays mit Referenen
		 */
		
		System.out.println("*** sort für Comparable");
		
		/*
		 * Lösung A. 
		 * 
		 * sort für Comparable
		 */
		String[] a2 = {
			"hh", "gg", "bb", "jj"	
		};
		
		Arrays.sort(a2);
		System.out.println("a2: " + Arrays.toString(a2)); // bb gg hh jj
		
		Foo[] a3 = { 
			new Foo(1, 10), 
			new Foo(2, 9), 
			new Foo(3, 8), 
			new Foo(4, 7), 
		};
		
		Arrays.sort(a3); // nach b-Werten sortiert (da compareTo so den Vergleich realisiert)
		System.out.println("a3: " + Arrays.toString(a3));
		//  [(a=4, b=7), (a=3, b=8), (a=2, b=9), (a=1, b=10)]
		
		/*
		 * Lösung B.
		 * 
		 * sort mit Comparator
		 */
		System.out.println("\n*** sort, die Comparator verwendet");
		
		Comparator<String> cmp2 = (a, b) -> b.compareTo(a);
		Arrays.sort(a2, cmp2);
		
		System.out.println("a2: " + Arrays.toString(a2)); // [jj, hh, gg, bb]
		
		Comparator<Foo> cmp3 = (x, y) -> x.a - y.a;
		
		Arrays.sort(a3, cmp3); // nach a-Werten sortieren, da compare im Comparator so den Vergleich realisiert)
		System.out.println("a3: " + Arrays.toString(a3));
		// [(a=1, b=10), (a=2, b=9), (a=3, b=8), (a=4, b=7)]
	}

}
