package streams.wdh;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class B08_intermediate_peek {

	/*
	 * Stream<T> peek(Consumer<? super T> action)
	 */
	public static void main(String[] args) {

		/*
		 * Bsp. 1
		 */
		Stream.of(1, 2, 3)
			.peek(x -> System.out.print(x)); // keine Ausgaben
		
		
		/*
		 * Bsp. 2. Was ist das Ergebnis?
		 * 
		 * A.  1 2 3 4 5              <- richtig mit Java 8 Standardbibliothek?
		 * B.  keine Ausgaben         <- richtig mit Java 21 Standardbibliothek
		 */
		Stream.of(1, 2, 3, 4, 5)
			.peek(x -> System.out.print(x + " ")) // keine Ausgaben mit Java 21
			.count(); // aktiviert die Pipeline nicht (Java 21)
		
		
		/*
		 * Bsp. 3. Was ist das Ergebnis?
		 * 
		 * A.  1 2 3 4 5              <- richtig
		 * B.  keine Ausgaben         
		 */
		System.out.println("Bsp. 3:");
		Stream.of(1, 2, 3, 4, 5)
			.filter(x -> true)
			.peek(x -> System.out.print(x + " ")) 
			.count(); // aktiviert die Pipeline auch mit Java 21, da es filter gibt.
		
		System.out.println();
	}

}
