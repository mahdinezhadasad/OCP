package func;

import java.util.function.Supplier;

public class B16_MethodenreferenzV3 {

	/*
	 * Variante 3: Referenz auf eine Instanzmethode eines
	 * vorhandenen Objektes
	 * (Reference to an instance method of a particular object)
	 * 
	 * Voraussetzungen:
	 * 
	 * 1. Der Rumpf hat genau eine Anweisung
	 * 
	 * 2. Diese Anweisung ist der Aufruf einer Instanzmethode
	 *    mit einer bekannten Referenz
	 *    (oder return mit dem Aufruf einer Instanzmethode
	 *     mit einer bekannten Referenz als return-Argument)
	 *    
	 * 3. Alle Parameter der zu realisierenden abstrakten Methode
	 *    werden als Argumente an die Instanzmethode übergeben
	 */
	public static void main(String[] args) {
		Integer ref = 42;
		
		// anonyme Klasse
		Supplier<Double> s1 = new Supplier<Double> () {
			public Double get() {
				return ref.doubleValue();
			}
		};
		
		Double d1 = s1.get();
		System.out.println("d1: " + d1);
		
		
		// normale Lambda
		Supplier<Double> s2 = () -> ref.doubleValue();
		
		Double d2 = s2.get();
		System.out.println("d2: " + d2);
		
		// Methodenreferenz
		Supplier<Double> s3 = ref::doubleValue;
		
		Double d3 = s3.get();
		System.out.println("d3: " + d3);
		
	}

	
}
