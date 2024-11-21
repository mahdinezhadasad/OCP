package concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class MyRecursiveTask extends RecursiveTask<Integer> {
	
	public static final int THRESHOLD = 3; 
	
	private int[] array;
	private int indexFrom, indexTo;
	
	public MyRecursiveTask(int[] array, int indexFrom, int indexTo) {
		this.array = array;
		this.indexFrom = indexFrom;
		this.indexTo = indexTo;
	}

	@Override
	protected Integer compute() {
		/*
		 *  FALLS 
		 *  	die Aufgabe ist einfach genug
		 *  DANN
		 *  	die Aufgabe lösen und das Ergebnis zurück liefern
		 *  SONST
		 *  	- die Aufgabe in zwei einfachere Aufgaben teilen
		 *      - die Unteraufgabe B in einem anderen Thread aktivieren (fork)
		 *      - die Unteraufgabe A in dem aktuellen Thread aktivieren
		 *      - das Ergebnis der Unteraufgabe B im aktuellen Thread abwarten (join)
		 *      - die Ergebnisse A und B kombinieren und zurück liefern
		 */
		if ( (indexTo-indexFrom) <= THRESHOLD ) { // Aufgabe ist einfach genug
			// die Aufgabe lösen
			int summe = 0;
			for(int i=indexFrom; i<indexTo; i++) {
				summe += array[i]; 
			}
			
			return summe;
		} else {
			// die Aufgabe in zwei einfachere Aufgaben teilen
			int indexMitte = (indexFrom + indexTo) / 2;
			MyRecursiveTask taskLeft = new MyRecursiveTask(array, indexFrom, indexMitte);
			MyRecursiveTask taskRight = new MyRecursiveTask(array, indexMitte, indexTo);
			
			// die Unteraufgabe B in einem anderen Thread aktivieren (fork)
			taskRight.fork();
			
			// die Unteraufgabe A in dem aktuellen Thread aktivieren
			Integer resultA = taskLeft.compute();
			
			// das Ergebnis der Unteraufgabe B im aktuellen Thread abwarten (join)
			Integer resultB = taskRight.join();
			
			// die Ergebnisse A und B kombinieren und zurück liefern
			return resultA + resultB;
		}
	}
}

public class B17_ForkJoin_RecursiveTask {

	/*
	 * Aufgabe:
	 * 
	 * 		Summe der Werte aus einem Array berechnen
	 */
	public static void main(String[] args) {
		
		int[] array = { 10, 20, 30, 40, 50, 60, 1, 2, 3, 4, 5 };
		
		System.out.println("array: " + Arrays.toString(array));
		
		ForkJoinPool pool = new ForkJoinPool();
		
		Integer summe = pool.invoke(new MyRecursiveTask(array, 0, array.length));
		
		System.out.println("summe: " + summe);

	}

}
