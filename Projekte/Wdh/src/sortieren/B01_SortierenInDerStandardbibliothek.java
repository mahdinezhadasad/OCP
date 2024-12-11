package sortieren;

import java.util.Arrays;


class Foo {
	int a, b;

	public Foo(int a, int b) {
		this.a = a;
		this.b = b;
	}
}

public class B01_SortierenInDerStandardbibliothek {

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
		
	}

}
