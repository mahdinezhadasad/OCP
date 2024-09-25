package exceptions;

class MyResB implements AutoCloseable {
	public MyResB() {
		System.out.println("open B");
	}
	public void close() {
		System.out.println("close B");
	}
}

class MyResC implements AutoCloseable {
	public MyResC() {
		System.out.println("open C");
	}
	public void close() {
		System.out.println("close C");
	}
}

public class B13_try_with_resources_und_mehrere_Ressourcen {

	public static void main(String[] args) {
		
		/*
		 * Achtung!
		 * Die Ressourcen werden in der umgekehrten Reihenfolge geschlossen
		 * 
		 * Ausgaben:
		 * 		open B
		 * 		open C
		 * 		close C
		 * 		close B
		 */
		try(MyResB rB = new MyResB(); 
				MyResC rC = new MyResC();) {
			
		}

		/*
		 * Achtung!
		 * Keine weiteren Anweisungen in den Runden Klammern!
		 */
		try(MyResB rB = new MyResB();
//			System.out.println("moin"); // cf
			MyResC rC = new MyResC()) {
			
		}
	}

}
