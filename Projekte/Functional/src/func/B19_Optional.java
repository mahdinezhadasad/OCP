package func;

import java.util.Optional;

public class B19_Optional {
	
	/*
	 * Wozu gibt es die Klasse Optional:
	 * 
	 * https://www.oracle.com/technical-resources/articles/java/java8-optional.html
	 */
	
	
	/*
	 * Entwickler Tom.
	 * 
	 * Version 1.
	 * 
	 * Diese Version erhöht die Wahrscheinlichkeit
	 * einer NullPointerException in der Anwendung. 
	 */
//	static String getAny(String... array) {
//		if(array==null || array.length==0) {
//			return null;
//		}
//		
//		return array[0];
//	}
	
	/*
	 * Entwickler Tom.
	 * 
	 * Version 2.
	 * 
	 * Diese Version macht den Benutzer darauf aufmerksam,
	 * dass der String auch nicht gefunden werden kann 
	 */
	static Optional<String> getAny(String... array) {
		if(array==null || array.length==0) {
			return Optional.empty();
		}
		
		for(String s : array) {
			if(s!=null) {
				return Optional.of(s);
			}
		}
		
		return Optional.empty();
	}

	public static void main(String[] args) {
		/*
		 * Komplizirte Anwendung.
		 * Entwickler Jerry.
		 * Irgendwo in seinem Code:
		 */
		
		String[] array = {};
		
		Optional<String> maybeString = getAny(array);
		
		if(maybeString.isPresent()) {
			String s = maybeString.get();
			System.out.println(s.toUpperCase());
		}

		/*
		 *  String s = getAny(array);
		 *  
		 * Mit der Version 1 der Methode getAny kann die 
		 * notwendige if-Abfrage vergessen werden:
		 * 
		 * if(s!=null) {
		 *   System.out.println( s.toUpperCase() );
		 * }
		 * 
		 * Ohne if-Abfrage kommt es zu NullPointerException:
		 * 
		 * 	 System.out.println( s.toUpperCase() );
		 */

	}
}
