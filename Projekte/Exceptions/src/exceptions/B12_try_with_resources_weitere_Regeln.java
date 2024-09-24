package exceptions;

class MyResA implements AutoCloseable {
	public void close() {
		System.out.println("close A");
	}
}

public class B12_try_with_resources_weitere_Regeln {

	/*
	 * Automatischen Aufruf der close-Methode gibt es beim
	 * Beenden von dem try-Block.
	 * Wenn der catch-Block aktiviert wird, wird er DANACH aktiviert.
	 * Wenn es den finally-Block gibt, läuft er ganz am Ende
	 */
	public static void main(String[] args) {
		
		System.out.println("*** Bsp. 1");
		/*
		 * Ausgaben:
		 * 
		 * 		1. try
		 * 		close A
		 */
		try(MyResA r = new MyResA()) {
			System.out.println("1. try");
		} // r.close() wird automatisch aufgerufen

		
		System.out.println("\n*** Bsp. 2");
		/*
		 * Ausgaben:
		 * 
		 * 		close A
		 * 		2. catch
		 */
		try(MyResA r = new MyResA()) {
			throw new ArithmeticException();
			
		} catch (Exception e) {
			System.out.println("2. catch");
		}
		
		System.out.println("\n*** Bsp. 3");
		/*
		 * Ausgaben:
		 * 
		 * 		close A
		 * 		3. catch
		 * 		3. finally
		 */
		try(MyResA r = new MyResA()) {
			throw new ArithmeticException();
			
		} catch (Exception e) {
			System.out.println("3. catch");
		} finally {
			System.out.println("3. finally");
		}
		
	}

}
