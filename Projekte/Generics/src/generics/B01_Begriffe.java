package generics;

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