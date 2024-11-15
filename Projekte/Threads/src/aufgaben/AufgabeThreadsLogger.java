package aufgaben;

class MyLogger {
	private StringBuilder sb = new StringBuilder();
//	private StringBuffer sb = new StringBuffer();
	
	public synchronized void addMessage(String caller, String message) {
		sb.append(caller)
			.append(" - ")
			.append(message)
			.append("\n");
	}
	
	public synchronized String getLog() {
		return sb.toString();
	}
}

public class AufgabeThreadsLogger {

	public static void main(String[] args) throws InterruptedException {

		MyLogger logger = new MyLogger();
		
		Runnable task = () -> {
			String caller = Thread.currentThread().getName();
			String message = "Msg ";
			for (int i = 0; i < 10; i++) {
				logger.addMessage(caller, message+i);
			}
		};
		
		Thread tA = new Thread(task);
		Thread tB = new Thread(task);

		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		System.out.println(logger.getLog());
	}

}
