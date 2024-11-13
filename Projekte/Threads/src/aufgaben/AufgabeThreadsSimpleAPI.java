package aufgaben;

import java.util.ArrayList;
import java.util.List;

import threads.MyThreadUtils;

public class AufgabeThreadsSimpleAPI {

	public static void main(String[] args) {
//		a1();
//		a2();
		a3();
//		a4();
		a4alternativ();
	}
	
	static void a4alternativ() {
		
		for (char ch = 'A'; ch<='Z'; ch++) {
			char chCopy = ch; 
			Runnable task = () -> System.out.println(chCopy); 
			Thread th = new Thread(task);
			th.start();
		}
	}
	
	static void a4() {
		class CharPrinter implements Runnable {
			char ch;
			
			public CharPrinter(char ch) {
				this.ch = ch;
			}

			public void run() {
				System.out.println(ch);
			}
		}
		
		for (char ch = 'A'; ch<='Z'; ch++) {
			Runnable task = new CharPrinter(ch); 
			Thread th = new Thread(task);
			th.start();
		}
	}
	
	static void a3() {
		Runnable task = () -> {
			Thread curThread = Thread.currentThread();
			System.out.println(curThread.getName() + " " + curThread.getId());
		};
		
		List<Thread> threads = new ArrayList<>();
		
		for (int i = 0; i < 37; i++) {
		 	threads.add( new Thread(task) );
		}
		
		for (Thread th : threads) {
			th.start();
		}
	}

	static void a2() {
		Runnable task = () -> {
			Thread curThread = Thread.currentThread();
			
			while(true) {
				System.out.println(curThread.getName() + " " + curThread.getId() + " läuft...");
				MyThreadUtils.pause(1000);
			}
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
