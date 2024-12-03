package functional;

import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LambdasSyntax {

	public static void main(String[] args) {
		
		/*
		 * Parameterliste. Ausführliche Notation
		 */
		Runnable v1 = () -> {};
		Consumer<String> v2 = (String param) -> {};
		BiFunction<Integer, Boolean, String> v3 = (Integer x, Boolean y) -> "";

		/*
		 * Parameterliste. Kompakte Notation. Ohne Typen
		 * 
		 */
		Consumer<String> v22 = (param) -> {};
		BiFunction<Integer, Boolean, String> v33 = (x, y) -> "";
//		BiFunction<Integer, Boolean, String> v34 = (Integer x, y) -> ""; // cf
//		BiFunction<Integer, Boolean, String> v35 = (x, Boolean y) -> ""; // cf
		
		/*
		 * Parameterliste. Kompakte Notation. Ohne der runden Klammer
		 * 
		 * - Nur bei genau einem Parameter!
		 * - Nur ohne Parametertyp!
		 */
//		Runnable v111 =  -> {}; // cf
		Consumer<String> v222 = param -> {};
//		Consumer<String> v223 = String param -> {}; // cf
//		BiFunction<Integer, Boolean, String> v333 = x, y -> ""; // cf
		
		
		/*
		 * Rumpf. Ausführliche Notation
		 */
		Runnable v4 = () -> {};
		Callable<String> v5 = () -> { 
			return "mo";
		};
		Runnable v6 = () -> {
			System.out.println("di");
		};
		
		/*
		 * Rumpf. Kompakte Notation (ohne der geschweiften Klammer, 
		 *        ohne Semikolon, bei return ohne return)
		 * 
		 * - Nur wenn der Rumpf aus genau einer Anweisung besteht
		 * - Wenn die Anweisung die return-Anweisung ist, muss auch return weg.
		 */
//		Runnable v44 = () -> ; // cf
		Callable<String> v55 = () -> "mo" ;
		Runnable v66 = () -> System.out.println("di") ;
		
	}

}
