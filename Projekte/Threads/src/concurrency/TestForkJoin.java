package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin {

	/*
	 * Was ist das Ergebnis?
	 * 
	 * A. Exception
	 * B. Reihenfolge der Ausgaben ist unvorhersehbar: mo fr oder fr mo
	 * C. mo fr			<- richtig
	 * D. fr mo
	 */
	static class TaskA extends RecursiveTask<String> {
		public String compute() {
			System.out.print("mo ");
			return "fr";
		}
	}
	
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		String result = pool.invoke(new TaskA()); // invoke hält den main-Thread an
		System.out.print(result + " ");
	}

}
