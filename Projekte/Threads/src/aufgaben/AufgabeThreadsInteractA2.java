package aufgaben;

public class AufgabeThreadsInteractA2 {
	
	static volatile int count;

	public static void main(String[] args) {

		Thread th = new Thread(() -> {
			for (int i = 0; i < 1_000_000; i++) {
				count++;
			}
		}); 
		
		th.start();
		
		try {
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("count: " + count);
	}

}
