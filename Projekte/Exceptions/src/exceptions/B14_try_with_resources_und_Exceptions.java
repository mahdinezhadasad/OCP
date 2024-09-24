package exceptions;

class MyRes1 implements AutoCloseable {
	public void close() {
	}
}
class MyRes2 implements AutoCloseable {
	public void close() throws Exception {
	}
}

public class B14_try_with_resources_und_Exceptions {

	public static void main(String[] args) {
		
		/*
		 * close-Methode deklariert keine checked Exception
		 */
		try(MyRes1 r = new MyRes1()) {
			
		}
		
		/*
		 * close-Methode deklariert checked Exception
		 */
//		try(MyRes2 r = new MyRes2()) {	// cf
//			
//		}
		
		try(MyRes2 r = new MyRes2()) { 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		/*
		 *  close-Methode deklariert checked Exception
		 *  (Typ der Variable r ist entscheidend)
		 */
//		try (AutoCloseable r = new MyRes1()) {	// cf
//			
//		}
		
	}

}
