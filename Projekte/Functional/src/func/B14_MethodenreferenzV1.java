package func;

import java.util.function.Function;

public class B14_MethodenreferenzV1 {

	
	/*
	 * Variante 1: Referenz auf eine statische Methode
	 * 
	 * Voraussetzungen:
	 * 
	 * 1. Der Rumpf hat genau eine Anweisung
	 * 
	 * 2. Diese Anweisung ist der Aufruf einer statischen Methode
	 *    (oder return mit dem Aufruf einer statischen Methode als Argument)
	 *    
	 * 3. Alle Parameter der zu realisierenden abstrakten Methode
	 *    werden als Argumente an die statische Methode übergeben
	 */
	public static void main(String[] args) {

		// anonyme Klasse
		Function<String, Integer> f1 = new Function<String, Integer> (){
			public Integer apply(String s) {
				return Integer.valueOf(s);
			}
		};
		
		Integer i1 = f1.apply("+42");
		System.out.println("i1 = " + i1);
		
		// normale Lambda
		Function<String, Integer> f2 = s -> Integer.valueOf(s);
		
		Integer i2 = f2.apply("+42");
		System.out.println("i2 = " + i2);
		
		// Methodenreferenz
		Function<String, Integer> f3 = Integer::valueOf;
		
		Integer i3 = f3.apply("+42");
		System.out.println("i3 = " + i3);

	}

}
