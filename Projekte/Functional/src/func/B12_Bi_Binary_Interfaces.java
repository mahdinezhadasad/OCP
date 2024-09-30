package func;

import java.util.function.*;

public class B12_Bi_Binary_Interfaces {

	public static void main(String[] args) {
		
		//zum Vergleich: Predicate
		Predicate<Integer> p1 = (Integer param) -> true;
		
		/*
		 * BiPredicate
		 */
		BiPredicate<Integer, String> p2 = 
				(Integer param1, String param2) -> true;

			
		// zum Vergleich: Consumer
		Consumer<String> c1 = (String param) -> {};	
		
		/*
		 * BiConsumer
		 */
		BiConsumer<String, Integer> c2 = (String param1, Integer param2) -> {};


		// zum Vergleich: Function
		Function<Integer, String> f1 = (Integer param) -> "moin";
		
		/*
		 * BiFunction
		 */
		BiFunction<Integer, Double, String> f2 = 
				(Integer param1, Double param2) -> "moin";
		
		/*
		 * BinaryOperator ist im nächsten Bsp.
		 */
		
	}

}
