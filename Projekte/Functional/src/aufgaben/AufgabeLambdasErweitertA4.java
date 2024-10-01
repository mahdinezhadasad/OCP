package aufgaben;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AufgabeLambdasErweitertA4 {

	public static void main(String[] args) {
		// Typ ref = x -> y -> x;
		
		/*
		 * Variante 1
		 * 
		 * ListeDerParameter -> x
		 * ListeDerParameter -> Rumpf
		 * 
		 *  TypVonX method(ListeDerParameter) {
		 *     return x;
		 *  }		
		 *  TypVonX method(x -> y) {
		 *     return x;
		 *  }		
		 *  
		 *  Ergibt kein Sinn
		 */
		
		/*
		 * Variante 2
		 * 
		 * ListeDerParameter -> y -> x
		 * ListeDerParameter -> Rumpf
		 * 
		 * 
		 * TypFürLambda method(ListeDerParameter) {
		 * 	return y -> x; 
		 * }
		 * 
		 * TypFürLambda method(TypVonX x) {
		 * 	return y -> x; 
		 * }
		 * 
		 * 
		 * Erkennen den Typ von x aus der Zuweisung
		 * 
		 * Typ ref = x -> etwas;
		 * 
		 * Function<TypVonX, R> = x -> etwas
		 * Function<TypVonX, TypVonEtwas> = x -> etwas
		 * 
		 * TypVonEtwas tmp = etwas
		 * TypVonEtwas tmp = y -> x
		 * Function<TypVonY, TypVonX> tmp = y -> x
		 * 
		 * Zusammen wird aus
		 * 	Function<TypVonX, TypVonEtwas> = x -> etwas
		 * 	Function<TypVonX, Function<TypVonY, TypVonX>> = x -> y -> x
		 * 
		 */
		
		Function<Integer, Function<String, Integer>> f1 = x -> y -> x;
		Function<Integer, Function<Integer, Integer>> f2 = x -> y -> x;
		Function<Integer, UnaryOperator<Integer>> f3 = x -> y -> x;
		
		Function<Integer, UnaryOperator<Integer>> f4 = (Integer x) -> {
			return y -> x;
		};
		Function<Integer, UnaryOperator<Integer>> f5 = (Integer x) -> {
			UnaryOperator<Integer> op = y -> x;
			return op;
		};
		
		UnaryOperator<Integer> op = f5.apply(3);
		int x = op.apply(777);
		System.out.println(x);
		
	}
}
