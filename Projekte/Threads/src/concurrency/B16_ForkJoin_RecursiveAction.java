package concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class B16_ForkJoin_RecursiveAction {

	/*
	 * Aufgabe:
	 * 
	 * 		in einem Array die Werte verdoppeln
	 */
	public static void main(String[] args) {

		int[] array = { 12, 6, -2, 0, 11, 5 };
		
		System.out.println("1. array: " + Arrays.toString(array));
		
		ForkJoinPool pool = new ForkJoinPool();
		
		pool.invoke(new MyRecursiveAction());
		
		System.out.println("2. array: " + Arrays.toString(array));

	}

}
