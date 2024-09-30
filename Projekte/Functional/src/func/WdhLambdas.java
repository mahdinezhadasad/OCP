package func;

public class WdhLambdas {

	/*
	 * interface Runnable {
	 *    void run();
	 * }
	 */
	public static void main(String[] args) {

//		Runnable v1 () -> { ; };	// cf: Zuweisung fehlt
		Runnable v2 = () -> { ; };

//		Runnable v3 = () -> ; ; 
		Runnable v4 = () -> { ; } ; 
		
		/*
		 * Bsp. 1
		 * 
		 * Ausgabe: di
		 */
		System.out.println("*** Bsp. 1");
		Runnable v5 = () -> System.out.println("mo");
		System.out.println("di");
		
		/*
		 * Bsp. 2
		 * 
		 * Ausgabe: so mo 
		 */
		System.out.println("\n*** Bsp. 2");
		
		Runnable v6 = () -> 
			System.out.println("sa");  // <- Rumpf der Lambda vor dem Semikolon
			System.out.println("so");  // Aufruf in der main
		
		System.out.println("mo");
		
		
	}

}
