package concurrency;

import java.time.LocalDate;
import java.util.concurrent.Callable;

public class B14_CallableVsRunnable {

	public static void main(String[] args) {
		
		class MyRunnable implements Runnable {
			public void run() {
				
			}
		}
		
		class MyCallable implements Callable<LocalDate> {
			public LocalDate call() throws Exception {
				return LocalDate.now();
			}
		}

	}

}
