package func;

import java.util.function.Function;

public class B15_MethodenreferenzV2 {

	/*
	 * Variante 2: Referenz auf einen Konstruktor
	 * 
	 * Voraussetzungen:
	 * 
	 * 1. Der Rumpf hat genau eine Anweisung
	 * 
	 * 2. Diese Anweisung ist der Aufruf eines Konstruktors
	 *    (oder return mit dem Aufruf eines Konstruktors als 
	 *    return-Argument)
	 *    
	 * 3. Alle Parameter der zu realisierenden abstrakten Methode
	 *    werden als Argumente an den Konstruktor übergeben
	 */
	public static void main(String[] args) {
		
		// anonyme Klasse
		Function<String, StringBuilder> f1 = new Function<String, StringBuilder> () {
			public StringBuilder apply(String s) {
				return new StringBuilder(s);
			}
		};
		
		StringBuilder sb1 = f1.apply("Heute ist ");
		sb1.append("Di");
		System.out.println(sb1.toString());
		
		// normale Lambda
		Function<String, StringBuilder> f2 = s -> new StringBuilder(s);
		StringBuilder sb2 = f2.apply("Heute ist ");
		sb2.append("Di");
		System.out.println(sb2.toString());
		
		// Methodenreferenz
		Function<String, StringBuilder> f3 = StringBuilder::new;
		StringBuilder sb3 = f3.apply("Heute ist ");
		sb3.append("Di");
		System.out.println(sb3.toString());
		
		
	}

}
