package exceptions;

import java.io.Closeable;
import java.io.IOException;

public class AutoCloseableUndCloseable {

	public static void main(String[] args) {
		
		/*
		 * interface AutoCloseable {
		 * 	   public void close() throws Exception ;
		 * }
		 */
		AutoCloseable a = new AutoCloseable() {
			public void close() throws Exception {
				System.out.println("ac");
			}
		};
		
		/*
		 * interface Closeable extends AutoCloseable {
		 * 	   public void close() throws IOException ;
		 * }
		 */
		java.io.Closeable c = new Closeable() {
			public void close() throws IOException {
				System.out.println("cc");
			}
		};
		

	}

}
