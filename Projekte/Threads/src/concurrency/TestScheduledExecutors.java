package concurrency;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledExecutors {
	
	public static void main(String[] args) throws InterruptedException {
//		test_scheduleAtFixedRate();
		test_scheduleWithFixedDelay();
	}

	public static void test_scheduleWithFixedDelay() throws InterruptedException {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		Runnable command = () -> {
			Thread th = Thread.currentThread();
			System.out.println("command im Thread " + th.getName() + 
					" - " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		int initialDelay = 2;   // 2 Sekunden vor der ersten Aktivierung
		int delay = 3; 			// Nach dem Beenden eines vorherigen Commandos 
								// das nächste Commando in 3 Sek. aktivieren 
		
		TimeUnit unit = TimeUnit.SECONDS;
		
		System.out.println("main. command registrieren");
		service.scheduleWithFixedDelay(command, initialDelay, delay, unit);
		
		Thread.sleep(20_000);
		System.out.println("main. service herunterfahren");
		service.shutdown();
	}
	
	public static void test_scheduleAtFixedRate() throws InterruptedException {
		
//		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		
		Runnable command = () -> {
			Thread th = Thread.currentThread();
			System.out.println("command im Thread " + th.getName() + 
					" - " + LocalTime.now().truncatedTo(ChronoUnit.SECONDS));
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		
		int initialDelay = 2;   // 2 Sekunden vor der ersten Aktivierung
		int period = 3;			// Jede 3 Sekunden wieder aktivieren
		
		TimeUnit unit = TimeUnit.SECONDS;
		
		System.out.println("main. command registrieren");
		service.scheduleAtFixedRate(command, initialDelay, period, unit);

		Thread.sleep(20_000);
		System.out.println("main. service herunterfahren");
		service.shutdown();
	}

}
