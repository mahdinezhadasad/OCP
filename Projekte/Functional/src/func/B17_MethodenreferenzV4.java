package func;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class B17_MethodenreferenzV4 {

	/*
	 * Variante 4: Referenz auf eine Instanzmethode eines
	 * unbestimmten Objektes von einem bekannten Typ
	 * (Reference to an instance method of an arbitrary object 
	 *  of a particular type)
	 *  
	 * Anders gesagt:
	 * 
	 * Referenz auf die Instanzmethode des ersten Parameters
	 * (der zu realisierenden abstrakten Methode)
	 *  
	 * 
	 * Voraussetzungen:
	 * 
	 * 1. Der Rumpf hat genau eine Anweisung
	 * 
	 * 2. Diese Anweisung ist der Aufruf einer Instanzmethode
	 *    mit dem ersten Parameter der zu realisierenden abstrakten Methode
	 *    (oder return mit dem Aufruf dieser Instanzmethode)
	 *    
	 * 3. Alle weiteren Parameter der zu realisierenden abstrakten Methode
	 *    werden als Argumente an die Instanzmethode übergeben
	 */
	public static void main(String[] args) {

		// anonyme Klasse
		BinaryOperator<String> op1 = new BinaryOperator<String> () {
			public String apply(String s1, String s2) {
				return s1.concat(s2);
			}
		};
		
		String str1 = op1.apply("ja", "va");
		System.out.println("str1: " + str1);
		
		// normale Lambda
		BinaryOperator<String> op2 = (s1, s2) -> s1.concat(s2);
		
		String str2 = op2.apply("ja", "va");
		System.out.println("str2: " + str2);

		// Methodenreferenz
		BinaryOperator<String> op3 = String::concat;
		
		String str3 = op3.apply("ja", "va");
		System.out.println("str3: " + str3);
		
		// Test
		// UnaryOperator<String> op4 = String::concat; // cf
		
		
	}

}
