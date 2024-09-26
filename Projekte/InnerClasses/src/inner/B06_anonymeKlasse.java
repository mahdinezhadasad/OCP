package inner;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 1. Toplevel-Klasse definieren 
 */
class ToplevelCmp /*extends Object*/ implements Comparator<Integer> {
	/*
	 * ToplevelCmp() {
	 *    super();
	 * }
	 */
	public int compare(Integer x, Integer y) {
		return x - y;
	}
}

public class B06_anonymeKlasse {
	
	/*
	 * 1. innere Klasse definieren
	 */
	static class InnerCmp /*extends Object*/ implements Comparator<Integer> {
		/*
		 * InnerCmp() {
		 *    super();
		 * }
		 */
		public int compare(Integer x, Integer y) {
			return x - y;
		}
	}

	public static void main(String[] args) {

		/*
		 * 2. Toplevel-Klasse instanziieren
		 */
		Comparator<Integer> c1 = new ToplevelCmp();
		
		/*
		 * 2. Innere Klasse instanziieren
		 */
		Comparator<Integer> c2 = new InnerCmp();
		
		/*
		 * 1. lokale Klasse definieren
		 */
		class LocalCmp /*extends Object*/ implements Comparator<Integer> {
			/*
			 * LocalCmp() {
			 *    super();
			 * }
			 */
			public int compare(Integer x, Integer y) {
				return x - y;
			}
		}
		
		/*
		 * 2. lokale Klasse instanziieren
		 */
		Comparator<Integer> c3 = new LocalCmp();
		
		/*
		 * 1+2. anonyme Klasse definieren und sofort instanziieren
		 */
		Comparator<Integer> c4 = new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return x - y;
			}
		};
		
		
		/*
		 * 1+2 mit einer Lambda
		 */
		Comparator<Integer> c5 = (Integer x, Integer y) -> {
			return x - y;
		};
		
		Comparator<Integer> c6 = (x, y) -> x - y;
		
		/*
		 * Comparator weiter verwenden
		 * 
		 */
		Integer[] arr = { 7, 3, 7, 2, 11, -5 };
		Arrays.sort(arr, new ToplevelCmp());
		Arrays.sort(arr, new InnerCmp());
		Arrays.sort(arr, new LocalCmp());
		
		Arrays.sort(arr, new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return x - y;
			}
		});
		
		Arrays.sort(arr, (Integer x, Integer y) -> {
			return x - y;
		});
		Arrays.sort(arr, (x, y) -> x - y);
		
	} // end of main
	

}
