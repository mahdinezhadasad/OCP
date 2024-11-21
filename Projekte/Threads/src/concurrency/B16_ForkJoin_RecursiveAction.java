package concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class MyRecursiveAction extends RecursiveAction {
	
	public static final int THRESHOLD = 3; 
	
	private int[] array;
	private int indexFrom, indexTo;
	
	public MyRecursiveAction(int[] array, int indexFrom, int indexTo) {
		this.array = array;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}

	@Override
	protected void compute() {
		/*
		 *  FALLS 
		 *  	die Aufgabe ist einfach genug
		 *  DANN
		 *  	die Aufgabe lösen
		 *  SONST
		 *  	- die Aufgabe in zwei (oder mehr) einfachere Aufgaben teilen
		 *      - die einfache Teilaufgaben an die Threads des ForkJoin-Pools
		 *        zum Ausführen übergeben  
		 */
		
//		long threadId = Thread.currentThread().getId();
//		System.out.printf("thread: %d, [%d .. %d] %n", threadId, indexFrom, indexTo);
		
		if ((indexTo-indexFrom) <= THRESHOLD) { // FALLS die Aufgabe einfach genug ist 
			for (int i = indexFrom; i < indexTo; i++) {
				array[i] = array[i]*2;
			}
		} else { // Aufgabe ist zu kompliziert
			// die Aufgabe in zwei (oder mehr) einfachere Aufgaben teilen:
			int indexMitte = (indexFrom + indexTo) / 2;
			
			RecursiveAction leftAction = new MyRecursiveAction(array, indexFrom, indexMitte);
			RecursiveAction rightAction = new MyRecursiveAction(array, indexMitte, indexTo);
			
			// die einfache Teilaufgaben an die Threads des ForkJoin-Pools
			// zum Ausführen übergeben:
			invokeAll(leftAction, rightAction);
		}
		
	}
}

public class B16_ForkJoin_RecursiveAction {

	/*
	 * Aufgabe:
	 * 
	 * 		in einem Array die Werte verdoppeln
	 */
	public static void main(String[] args) {

		int[] array = { 12, 6, -2, 0, 11, 5, 1, 2, 3, 4, 5, 6, 7 };
		
		System.out.println("1. array: " + Arrays.toString(array));
		
		ForkJoinPool pool = new ForkJoinPool();
		
		pool.invoke(new MyRecursiveAction(array, 0, array.length));
		
		System.out.println("2. array: " + Arrays.toString(array));

	}

}
