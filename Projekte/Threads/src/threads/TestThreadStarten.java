package threads;

public class TestThreadStarten {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}
	
	/*
	 * Ergebnis: a danach Exception
	 */
	static void f4() {
		
		System.out.println("a");
		
		Runnable task = () -> System.out.println("b");
		
		Thread t1 = new Thread(task);
		t1.start(); // NEW -> RUNNABLE
		t1.start(); // Exception! Der Thread kann nur aus dem Zustand NEW gestartet werden 
		
		System.out.println("c");
	}
	
	/*
	 * Ergebnis: a b c ODER a c b
	 */
	static void f3() {
		
		System.out.println("a");
		
		Runnable task = () -> System.out.println("b");
		Thread t1 = new Thread(task);
		t1.start(); // endlich richtig
		
		System.out.println("c");
	}
	/*
	 * Ergebnis: a b c
	 */
	static void f2() {
		
		System.out.println("a");
		
		Runnable task = () -> System.out.println("b");
		Thread t1 = new Thread(task);
		t1.run(); // <- in dem main-Thread aufgerufen (blöd)
		
		System.out.println("c");
	}
	
	/*
	 * Ergebnis: a c
	 */
	static void f1() {
		
		System.out.println("a");
		
		Runnable task = () -> System.out.println("b");
		Thread t1 = new Thread(task);
		
		System.out.println("c");
		
	}

}
