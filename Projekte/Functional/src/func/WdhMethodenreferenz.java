package func;

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
		
	}

}
