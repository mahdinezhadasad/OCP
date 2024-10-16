package aufgaben;

import java.io.IOException;
import java.util.function.Supplier;

class IntPositive {
	private static <T extends Throwable> void checkAndThrow(boolean check, Supplier<T> s) 
	        throws T {
	        
	    if(!check) {
	        throw s.get();
	    }
	}
	void setValue(int value) {
		/*
		 * class Blabla implements Supplier<Exception> {
		 *    public Exception get() {
		 *       return new IllegalArgumentException();
		 *    }
		 * }
		 */
	    checkAndThrow(value>0, IllegalArgumentException::new);
	}	
	void writeValue(int value) {
		/*
		 * class Blabla implements Supplier<Exception> {
		 *    public Exception get() {
		 *       return new java.io.IOException();
		 *    }
		 * }
		 */
		try {
			checkAndThrow(value>0, java.io.IOException::new);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

public class AufgabeGenerischeMethodenA2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
