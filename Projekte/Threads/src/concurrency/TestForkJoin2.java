package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;


public class TestForkJoin2 {
	
	static class TaskB extends RecursiveAction {
		protected void compute() {
			System.out.print("mo ");
		}
	}
	static class TaskC extends RecursiveAction {
		protected void compute() {
			System.out.print("di ");
		}
	}
	
	static class TaskA extends RecursiveTask<String> {
		protected String compute() {
			TaskB tb = new TaskB();
			TaskC tc = new TaskC();
			
			invokeAll(tb, tc);
			return "fr";
		}
	}

	/*
	 * Was ist das Ergebnis?
	 * 
	 * A. mo di fr ODER di mo fr		<- richtig
	 * B. mo di fr 
	 * C. di mo fr
	 * D. Reihenvolge der Ausgaben ist beliebig 
	 * 
	 * invoke ist synchron (main wartet auf das Beenden der Berechnungen im ForkJoinPool),
	 * also ist 'fr' die letzte Ausgabe
	 * 
	 * invokeAll aktiviert zwei Actions in parallelen Threads 
	 * (im aktuellen und in einem weiteren)
	 */
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		String result = pool.invoke(new TaskA());
		System.out.print(result + " ");
	}

}
