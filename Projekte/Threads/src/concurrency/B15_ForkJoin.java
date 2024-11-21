package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;


public class B15_ForkJoin {
	
	static class MyRecursiveAction extends RecursiveAction {
		@Override
		protected void compute() {
			/*
			 *  Hier kommt der spezielle Algorithmus,
			 *  um die Aufgabe rekursiv zu lösen:
			 *  
			 *  FALLS 
			 *  	die Aufgabe ist einfach genug
			 *  DANN
			 *  	die Aufgabe lösen
			 *  SONST
			 *  	- die Aufgabe in zwei (oder mehr) einfachere Aufgaben teilen
			 *      - die einfache Teilaufgaben an die Threads des ForkJoin-Pools
			 *        zum Ausführen übergeben  
			 */
			
			System.out.println("MyRecursiveAction. in compute im Thread " + Thread.currentThread().getName());
		}
	}
	
	static class MyRecursiveTask extends RecursiveTask<Integer> {
		@Override
		protected Integer compute() {
			/*
			 *  Hier kommt der spezielle Algorithmus,
			 *  um die Aufgabe rekursiv zu lösen...
			 *  
			 *  FALLS 
			 *  	die Aufgabe ist einfach genug und das Ergebnis zurück liefern
			 *  DANN
			 *  	die Aufgabe lösen
			 *  SONST
			 *  	- die Aufgabe in zwei einfachere Aufgaben teilen
			 *      - die Unteraufgabe B in einem anderen Thread aktivieren (fork)
			 *      - die Unteraufgabe A in dem aktuellen Thread aktivieren
			 *      - das Ergebnis der Unteraufgabe B im aktuellen Thread abwarten (join)
			 *      - die Ergebnisse A und B kombinieren und zurück liefern
			 */

			System.out.println("MyRecursiveTask. in compute im Thread " + Thread.currentThread().getName());
			return 42;
		}
	}
	

	/*
	 * ForkJoin-Framework: Teil des Concurrency-Framework, um die 
	 * rekursiven Lösungen zu parallelisieren.
	 */
	public static void main(String[] args) {

		ForkJoinPool pool = new ForkJoinPool();
		
		/*
		 * Variante 1
		 */
		RecursiveAction topLevelRecursiveAction = new MyRecursiveAction();
		pool.invoke(topLevelRecursiveAction); // synchron (main wird angehalten)
		System.out.println("main. RecursiveAction ist fertig");
		
		/*
		 * Variante 2
		 */
		RecursiveTask<Integer> topLevelRecursiveTask = new MyRecursiveTask();
		Integer result = pool.invoke(topLevelRecursiveTask); // synchron (main wird angehalten)
		System.out.println("main. Ergebnis aus der RecursiveTask: " + result);
		
	}

}
