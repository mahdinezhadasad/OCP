package func;

import java.util.Random;
import java.util.function.Consumer;

public class B09_Consumer {

	/*
	 * interace Consumer <T> {
	 * 		void accept(T param);
	 * }
	 */
	public static void main(String[] args) {
		
		// anonyme Klasse
		Consumer<String> c1 = new Consumer<String> () {
			public void accept(String s) {
				System.out.println(s.toUpperCase());
			}
		};
		
		generateStrings(3, c1);

		// Lambda ausführlich
		Consumer<String> c2 = (String s) -> {
			System.out.println(s.toUpperCase());
		};
		
		generateStrings(3, c2);
		
		
		// Lambda ausführlich
		Consumer<String> c3 = s -> System.out.println(s.toUpperCase());
		
		generateStrings(3, c3);
	}

	static void generateStrings(int count, Consumer<String> c) {
		System.out.println("*** Strings generieren und dem Consumer übergeben");
		
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			String s = "i=" + String.valueOf(r.nextInt(10));
			c.accept(s);
		}
	}
	
}
