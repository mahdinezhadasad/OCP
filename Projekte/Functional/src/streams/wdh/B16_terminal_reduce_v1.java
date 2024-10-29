package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class B16_terminal_reduce_v1 {

	/*
	 * reduce: für immutable Reduction (keine Objekte aus dem Kontext ändern)
	 * 
	 * 
	 * Optional<T> reduce(BinaryOperator<T> accumulator)
	 * 
	 */
	public static void main(String[] args) {


		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		BinaryOperator<Integer> acc = (a, b) -> a + b;
		
		Optional<Integer> maybeSum = list.stream().reduce(acc);
		
		System.out.println("Summe: " + maybeSum.get());

		/*
		 * reduce, sequentiell
		 * 
		 * Daten: 1, 2, 3, 4, 5
		 * 
		 * Schritt 1:
		 * 
		 * 	a = 1
		 *  b = 2
		 *  
		 *  erg = acc.apply(a, b) = 3
		 *  
		 * Schritt 2:
		 * 
		 *  a = 3 (Ergebnis aus Schritt 1)
		 *  b = 3 (nächstes Element)
		 *  
		 *  erg = acc.apply(a, b) = 6
		 *  
		 * Schritt 3:
		 * 
		 *  a = 6 (Ergebnis aus Schritt 2)
		 *  b = 4 (nächstes Element)
		 *  
		 *  erg = acc.apply(a, b) = 10
		 *  
		 * Schritt 4:
		 * 
		 *  a = 10 (Ergebnis aus Schritt 3)
		 *  b = 5 (nächstes Element)
		 *  
		 *  erg = acc.apply(a, b) = 15
		 *  
		 * Das Ergebnis im Optional zurückliefern
		 *  
		 */
		
	}

}
