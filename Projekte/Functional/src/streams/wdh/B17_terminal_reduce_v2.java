package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class B17_terminal_reduce_v2 {

	/*
	 * T reduce(T identity, BinaryOperator<T> accumulator)
	 * 
	 * 
	 * - kann den Datentyp nicht ändern
	 * - im parallelen Modus wird der Accumulator 
	 *   auch als Combiner verwendet
	 * 
	 */
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		Integer idt = 0; // 'berechnungsneutraler' Wert
		BinaryOperator<Integer> acc = (a, b) -> a + b;
		
		Integer sum = list.stream().reduce(idt, acc);

		System.out.println("Summe = " + sum);
		
		/*
		 * reduce, sequentiell
		 * 
		 * Daten: 1, 2, 3, 4, 5
		 * 
		 * Schritt 1:
		 * 
		 * 	a = 0 (Identity)
		 *  b = 1 (1. Element)
		 *  
		 *  erg = acc.apply(a, b) = 1
		 *  
		 * Schritt 2:
		 * 
		 * 	a = 1 (Ergebnis aus Schritt 1)
		 *  b = 2 (nächstes Element)
		 *  
		 *  erg = acc.apply(a, b) = 1
		 *  
		 * Schritt 3:
		 * 
		 *  a = 3 (Ergebnis aus Schritt 2)
		 *  b = 3 (nächstes Element)
		 *  
		 *  erg = acc.apply(a, b) = 6
		 *  
		 * Schritt 4:
		 * 
		 *  a = 6 (Ergebnis aus Schritt 3)
		 *  b = 4 (nächstes Element)
		 *  
		 *  erg = acc.apply(a, b) = 10
		 *  
		 * Schritt 5:
		 * 
		 *  a = 10 (Ergebnis aus Schritt 4)
		 *  b = 5 (nächstes Element)
		 *  
		 *  erg = acc.apply(a, b) = 15
		 *  
		 * Das Ergebnis zurückliefern
		 *  
		 */		
	}

}
