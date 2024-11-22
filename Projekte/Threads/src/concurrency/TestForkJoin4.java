package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import concurrency.TestForkJoin3.TaskA;
import concurrency.TestForkJoin3.TaskB;
import concurrency.TestForkJoin3.TaskC;

public class TestForkJoin4 {

	static class TaskB extends RecursiveTask<String> {
		protected String compute() {
			System.out.print("b ");
			return "mo ";
		}
	}
	static class TaskC extends RecursiveTask<String> {
		protected String compute() {
			System.out.print("c ");
			return "di ";
		}
	}
	
	static class TaskA extends RecursiveTask<String> {
		@Override
		protected String compute() {
			TaskB tb = new TaskB();
			TaskC tc = new TaskC();
			
			/*
			 * Achtung in der Praxis!
			 * 
			 * Die Reihenfolge sollte so sein:
			 * 
			 * 	tc.fork()      <- tc parallel
			 *  tb.compute()   <- tb im aktuellen Thread
			 *  tc.join()      <- im aktuellen Thread auf tc-Ergebnis wwarten
			 *  
			 * Der Code, so wie er hier steht, vernichtet paralleles Ausführen:
			 * 	tc.fork()      <- tc parallel
			 *  tc.join()      <- im aktuellen Thread auf tc-Ergebnis warten
			 *  tb.compute()   <- tb im aktuellen Thread
			 * 
			 */
			tc.fork();
			return tc.join() + tb.compute();
		}
	}

	/*
	 * A. c b di mo
	 * B. b c di mo
	 * C. c b di mo ODER b c di mo 
	 * D. etwas anderes
	 */
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		String result = pool.invoke(new TaskA());
		System.out.print(result + " ");
	}
	
}
