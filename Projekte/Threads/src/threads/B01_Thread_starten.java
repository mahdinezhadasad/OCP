package threads;

public class B01_Thread_starten {

	public static void main(String[] args) {

		/*
		 * Einen neuen Thread (Zustand: NEW) reservieren.
		 */
		Thread th = new Thread();
		
		/*
		 * Den Thread beim Scheduler als RUNNABLE registrieren:
		 */
		th.start();

	}

}
