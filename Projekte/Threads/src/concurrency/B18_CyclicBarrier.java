package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class B18_CyclicBarrier {

	public static void main(String[] args) throws InterruptedException {
		
		int parties = 3; // 3 Threads sind nötig, um die Barriere zu durchbrechen
		
		// Die Barrier-Action wird in dem Thread ausgeführet,
		// der die Barriere durchbricht.
		Runnable barrierAction = () -> {
			Thread th = Thread.currentThread();
			System.out.println("Die Barriere ist vom Thread " + 
					th.getName() + " durchbrochen!");
		};
		
		CyclicBarrier barrier = new CyclicBarrier(parties, barrierAction);

		Runnable task = () -> {
			Thread th = Thread.currentThread();
			try {
				
				System.out.println(th.getName() + " VOR der Barriere");
				barrier.await(); // der Thread meldet sich bei der Barriere und 
								 // wird angehalten bis insgesamt 3 Threads es tun
				
				System.out.println(th.getName() + " NACH der Barriere");
				
			} catch (BrokenBarrierException | InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
		
		Thread.sleep(2000);
		System.out.println("\n*** nochmal");
		
		new Thread(task).start();
		new Thread(task).start();
		new Thread(task).start();
	}

}
