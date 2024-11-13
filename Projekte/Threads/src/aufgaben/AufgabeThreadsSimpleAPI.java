package aufgaben;

import threads.MyThreadUtils;

public class AufgabeThreadsSimpleAPI {

	public static void main(String[] args) {
//		a1();
		a2();
	}

	static void a2() {
		Runnable task = () -> {
			
		};
		
		Thread th = new Thread(task);
		
		th.start();
		
		System.out.println("main-Thread gat den extra-Thread gestartet");
	}
	
	static void a1() {
		Thread th = new Thread() {
			public void run() {
				while(true) {
					System.out.println(getName() + " " + getId() + " läuft...");
					MyThreadUtils.pause(1000);
				}
			}
		};
		
		th.start();
		
		Thread curThread = Thread.currentThread();
		System.out.println(curThread.getName() + "-Thread hat den extra-Thread " + 
				th.getName() + " gestartet");
		
	}
}
