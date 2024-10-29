package streams.wdh;

import java.util.stream.Stream;

public class B11_terminal_count {

	/*
	 * long count()
	 */
	public static void main(String[] args) {
		
		/*
		 * Exam:
		 */
//		int c1 = Stream.of(1, 2, 3, 4).count();  // cf
		long c2 = Stream.of(1, 2, 3, 4).count();

		/*
		 * 	In Java 8: count aktiviert die Pipeline immer?
		 * 	In Java 21: count aktiviert die Pipeline nur, 
		 *              wenn es wirklich nötig ist. 
		 */
		
		System.out.println("*** Bsp 1");
		Stream.of(1, 2, 3, 4, 5, 6)
			.map(x -> {
					System.out.println(x); // keine Ausgaben in Java 21
					return x + 10;
				})
			.count(); // liefert 6 zurück ohne die Pipeline zu aktivieren (in Java 21)
		
		System.out.println("\n*** Bsp 2");
		Stream.of(1, 2, 3, 4, 5, 6)
			.map(x -> {
					System.out.println(x); // Ausgaben
					return x + 10;
				})
			.filter(x -> true) // könnte die Anzahl der Elemente ändern
			.count(); 
		
		System.out.println("end of main");
	}

}
