package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class B18_terminal_reduce_v3 {

	/*
	 * <U> U reduce(U identity,
     *            BiFunction<U, ? super T, U> accumulator,
     *            BinaryOperator<U> combiner)
     *            
     *            
     *     - kann den Datentyp ändern
	 */
	public static void main(String[] args) {
		bsp1();
		bsp2();
		bsp3();
		bsp4();
	}
	
	
	/*
	 * Bsp. 1
	 * 
	 * - sequentiell
	 * - Datentyp wird nicht geändert
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
	static void bsp1() {
		System.out.println("*** Bsp. 1");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		Integer idt = 0;
		BiFunction<Integer, Integer, Integer> acc = (a, b) -> a + b;
		BinaryOperator<Integer> cmb = (x, y) -> x + y; 
		
		Integer sum = list.stream().reduce(idt, acc, cmb);
		
		System.out.println("Summe: " + sum);
	}
	
	
	/*
	 * <U> U reduce(U identity,
     *            BiFunction<U, ? super T, U> accumulator,
     *            BinaryOperator<U> combiner)
     *            
     *            
     *     - kann den Datentyp ändern
	 */
	
	/*
	 * - sequentiell
	 * - Datentyp wird geändert
	 * 
	 * Aufgabe hier: Zahlen in Strings verwandeln 
	 * und solche Strings zu einem Gesamtstring zu konkatenieren
	 * 
	 * 
	 * Daten: 1, 2, 3, 4, 5
	 * 
	 * Schritt 1:
	 * 
	 * 	s = "" (Identity)
	 *  i = 1 (1. Element)
	 *  
	 *  erg = acc.apply(a, b) = "1"
	 *  
	 * Schritt 2:
	 * 
	 * 	s = "1" (Das Ergebnis aus Schritt 1)
	 *  i = 2 (2. Element)
	 *  
	 *  erg = acc.apply(a, b) = "12"
	 *  
	 * Schritt 3:
	 * 
	 * 	s = "12" (Das Ergebnis aus Schritt 2)
	 *  i = 3 (3. Element)
	 *  
	 *  erg = acc.apply(a, b) = "123"
	 *  
	 *  usw...
	 *   
	 *  Am Ende das Ergebnis "12345" zurückliefern
	 */
	static void bsp2() {
		System.out.println("*** Bsp. 2");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		String idt = "";
		BiFunction<String, Integer, String> acc = (String s, Integer i) -> s + i;
		BinaryOperator<String> cmb = (s1, s2) -> s1 + s2;
		
		String s = list.stream() // Stream<Integer>
				.reduce(idt, acc, cmb);
		
		System.out.println("Ergebnis: " + s);
	}

	
	/*
	 * <U> U reduce(U identity,
     *            BiFunction<U, ? super T, U> accumulator,
     *            BinaryOperator<U> combiner)
     *            
     *            
     *     - kann den Datentyp ändern
	 */
	
	/*
	 * - parallel
	 * - Datentyp wird nicht geändert (Aufgabe: Summe berechnen)
	 * 
	 * Beispiel für zwei CPUs: 
	 * 
	 * 
	 * CPU A 							CPU B
	 * Daten: 1, 2 						Daten: 3, 4, 5
	 * 
	 * Schritt 1.						Schritt 1.
	 * 
	 * a = 0 (Identity)					a = 0 (Identity)
	 * b = 1 (Element 1)				b = 3 (eigenes Element 1)
	 * 
	 * erg = acc.apply(a, b) = 1		erg = acc.apply(a, b) = 3
	 * 
	 * Schritt 2.						Schritt 2.
	 * 
	 * a = 1 (Erg. aus Schritt 1)		a = 3 (Erg. aus Schritt 1)
	 * b = 2 (nächstes Element)			b = 4 (nächstes Element)
	 * 
	 * erg = acc.apply(a, b) = 3		erg = acc.apply(a, b) = 7
	 * 
	 * 									Schritt 3.
	 * 
	 * 									a = 7 (Erg. aus dem Schritt 2)
	 * 									b = 5 (nächstes Element)
	 * 
	 * 									erg = acc.apply(a, b) = 12
	 * 
	 * Teilergebnisse zum Gesamtergebnis
	 * kombinieren:
	 * 
	 * x = 3 (Ergebnis der CPU A)
	 * y = 12 (Ergebnis der CPU B)
	 * 
	 * erg = cmb.apply(x, y)
	 * 
	 * Gesamtergebnis zurückliefern
	 */
	
	static void bsp3() {
		System.out.println("*** Bsp. 3");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		Integer idt = 0;
		BiFunction<Integer, Integer, Integer> acc = (a, b) -> a + b;
		BinaryOperator<Integer> cmb = (x, y) -> x + y;
		
		Integer sum = list.stream()
				.parallel()
				.reduce(idt, acc, cmb);
		
		System.out.println("Summe: " + sum);
	}
	
	
	
	/*
	 * - parallel
	 * - Datentyp wird geändert (Aufgabe: Integer zu Strings, die Strings konkatenieren)
	 * 
	 * Beispiel für zwei CPUs: 
	 * 
	 * 
	 * CPU A 							CPU B
	 * Daten: 1, 2 						Daten: 3, 4, 5
	 * 
	 * Schritt 1.						Schritt 1.
	 * 
	 * a = "" (Identity)				a = "" (Identity)
	 * b = 1 (Element 1)				b = 3 (eigenes Element 1)
	 * 
	 * erg = acc.apply(a, b) = "1"		erg = acc.apply(a, b) = "3"
	 * 
	 * Schritt 2.						Schritt 2.
	 * 
	 * a = "1" (Erg. aus Schritt 1)		a = "3" (Erg. aus Schritt 1)
	 * b = 2 (nächstes Element)			b = 4 (nächstes Element)
	 * 
	 * erg = acc.apply(a, b) = "12"		erg = acc.apply(a, b) = "34"
	 * 
	 * 									Schritt 3.
	 * 
	 * 									a = "34" (Erg. aus dem Schritt 2)
	 * 									b = 5 (nächstes Element)
	 * 
	 * 									erg = acc.apply(a, b) = "345"
	 * 
	 * Teilergebnisse zum Gesamtergebnis
	 * kombinieren:
	 * 
	 * x = "12" (Ergebnis der CPU A)
	 * y = "345" (Ergebnis der CPU B)
	 * 
	 * erg = cmb.apply(x, y)
	 * 
	 * Gesamtergebnis zurückliefern
	 */
	
	static void bsp4() {
		System.out.println("*** Bsp. 4");
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		String idt = "";
		BiFunction<String, Integer, String> acc = (s, i) -> s + i;
		BinaryOperator<String> cmb = (x, y) -> x + y;
		
		String s = list.parallelStream()
			.reduce(idt, acc, cmb);
		
		System.out.println("Ergebnis: " + s);
	}	
	
}

