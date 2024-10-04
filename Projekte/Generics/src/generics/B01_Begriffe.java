package generics;

// Typparameter kann den Namen wie ein Java-Identifier
// bekommen (sollte aber aus Grossbuchstaben bestehen)
class C1 <bUchStaben_1234_$> { // geht, aber nicht so gut
}
class C2 <A> { // ok
}

public class B01_Begriffe {

	public static void main(String[] args) {
		
		/*
		 * Z.B. das Interfaces java.util.List aus der Standardbibliothek:
		 * 
		 * 	Definition:
		 * 	
		 * 		public interface List <E> ... 
		 * 
		 * 
		 * List <E>		- generischer Typ
		 * 
		 * E			- formaler Typparameter (Typvariable)
		 */
		  
		/* 
		 * Programmieren mit List:
		 * 
		 * 		List<String> list = ...;
		 * 
		 * String 		- aktueller Typparameter (Parametrisierung)
		 * 
		 * List<String> - parametrisierter Typ
		 */ 
		 
		/* 
		 * Programmieren mit List:
		 * 
		 * 		List list = ...; // bitte niemals so programmieren
		 * 
		 * List			- raw type (Originaltyp)
		 * 
		 */

		/*
		 * Definition einer generischen Klasse:
		 * 
		 * 		class Steckdose <T extends TV> ...
		 * 
		 * T extends TV		- type bound (Typeinschränkung)
		 */
	}		
}