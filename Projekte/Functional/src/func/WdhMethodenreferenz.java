package func;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class WdhMethodenreferenz {

	public static void main(String[] args) {

		double d = Math.random();

		Supplier<Double> s1 = Math::random;

		/*
		 * Klasse nachbilden
		 * 
		 * class Blabla implements Supplier<Double> {
		 * 	  public Double get() {
		 *       return Math.random();
		 *    }
		 * }
		 * 
		 *  
		 *  
		 *  Supplier<Double> s1 = new Blabla();
		 *  
		 */
		
		/*
		 * -------------------------------------------------
		 */
		
		Consumer<String> c1 = StringBuilder::new;
		
		/*
		 * Klasse nachbilden:
		 * 
		 * class Blabla implements Consumer<String> {
		 *    public void accept(String param) {
		 *    	 new StringBuilder(param);
		 *    }
		 * }
		 */
		
		/*
		 * -------------------------------------------------
		 */
		
		String str = "ja"; 
		
//		Function<String, String> f77 = str::concat("va");
		
		/*
		 * Compilerfehler! Bitte keine Liste der Argumente
		 * bei Methodenreferenzen!
		 */
		
		/*
		 * -------------------------------------------------
		 */
		Function<String, String> f78 = str::concat;
		
		/*
		 * class Blabla implements Function<String, String> {
		 * 		public String apply(String param) {
		 * 			return str.concat(param);
		 *      }
		 * }
		 */
	}

}










