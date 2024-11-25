package concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCyclicBarrier {

	/*
	 * Was ist das Ergebnis?
	 * 
	 * A. 1 2 a
	 * B. 2 1 a
	 * C. 1 2 a ODER 2 1 a
	 * D. 1 (Anwendung wird danach nicht beendet)               <- richtig
	 * E. 1 ODER 2 (Anwendung wird danach nicht beendet)
	 */
	public static void main(String[] args) {
		
		CyclicBarrier barrier = new CyclicBarrier(2, () -> System.out.print("a "));

		Runnable r1 = () -> {
			System.out.print("1 ");
			try { barrier.await(); } // der Thread vom SingleThreadExceutor wird hier angehalten
			catch (Exception e) { e.printStackTrace(); }
		};
		
		Runnable r2 = () -> {
			System.out.print("2 ");
			try { barrier.await(); }
			catch (Exception e) { e.printStackTrace(); }
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
//		ExecutorService service = Executors.newFixedThreadPool(2); // damit kann die Anwendung beendet werden 
		
		service.execute(r1);
		service.execute(r2);
		
		service.shutdown();

	}

}
