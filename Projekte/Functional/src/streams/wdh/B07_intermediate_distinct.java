package streams.wdh;

import java.util.stream.Stream;

public class B07_intermediate_distinct {

	/*
	 *  Stream<T> distinct()
	 */
	public static void main(String[] args) {
		
		/*
		 * Bsp. 1
		 */
		Stream.of(1, 2, 1, 3, 1)
			.distinct()
			.forEach(System.out::println);

		System.out.println();
		

		/*
		 * Bsp. 2
		 */
		Stream.of(new Blume(1), new Blume(2), new Blume(1), new Blume(3), new Blume(1) )
			.distinct()
			.map(b -> b.preis)
			.forEach(System.out::println);
		
	} // end of main
	
	static class Blume {
		int preis;
		Blume(int preis) { this.preis = preis; }
		
		public boolean equals(Object obj) {
			return ((Blume)obj).preis == preis;
		}
		public int hashCode() {
			return preis;
		}
	}

}
