package aufgaben;

public class AufgabeThreadsInteractA3 {

	public static void main(String[] args) throws InterruptedException {

		Runnable task = () -> {
			
			Thread curThread = Thread.currentThread();
			while(true) {
				System.out.println(curThread.getName() + " läuft...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(curThread.getName() + " interrupted!");
					break;
				}
			}
		};
		
		Thread th = new Thread(task);
		th.start();
		
		Thread.sleep(5000);
		System.out.println("main ruft th.interrupt() auf");

		th.interrupt();
	}

}
