package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class B10_ExecutorService_Strategien {

	public static void main(String[] args) {

		ExecutorService service;

		/*
		 * newSingleThreadExecutor:
		 * 
		 * 		- hat einen extra-Thread
		 * 		- wenn der Thread gerade beschäftigt ist, wird die
		 *        weitere registrierte Task in einer Schlange gespeichert.
		 */
		service = Executors.newSingleThreadExecutor();
		tasksRegistrieren(service);

	}
	
	static void tasksRegistrieren(ExecutorService service) {
		
		/*
		 * 100 Tasks dem ExecutorService übergeben,
		 * damit sie in den Threads des ExecutorServices
		 * ausgeführet werden
		 */
		for (int i = 0; i < 100; i++) {
			int taskNr = i;
			
			Runnable task = () -> {
				String threadName = Thread.currentThread().getName();
				System.out.println("Task " + taskNr + " in Thread " + threadName);
			};
			
			service.execute(task);
		}
		
		/*
		 * Das Serviceherunterfahren
		 */
		service.shutdown();
	}

}
