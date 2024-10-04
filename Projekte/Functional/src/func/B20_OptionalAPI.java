package func;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

public class B20_OptionalAPI {

	public static void main(String[] args) {
		/*
		 * Optional mit statischen Fabrikmethoden erzeugen 
		 */
		
		Optional<Integer> op1 = Optional.empty();

		Optional<Integer> op2 = Optional.of(12);
		
		Optional<Integer> op3 = Optional.ofNullable(12); 
		Optional<Integer> op4 = Optional.ofNullable(null); 
		
		/*
		 * einige Instanzmethoden:
		 * 
		 * 		boolean isPresent()
		 * 		T get()
		 * 		void ifPresent(Consumer action)
		 */
		
		Optional<Integer> maybeInt = Optional.of(42);
		
		if( maybeInt.isPresent() ) {
			Integer value = maybeInt.get();
			System.out.println("value = " + value);
		}
		
		maybeInt = Optional.empty();
		try {
			maybeInt.get(); // NoSuchElementException
		} catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException!");
		}
		
		Consumer<Integer> action = x -> System.out.println("x = " + x);
		
		System.out.println("\n* Test mit empty-Optional");
		maybeInt = Optional.empty();
		maybeInt.ifPresent(action); // maybeInt ist empty, es passiert nichts
		
		System.out.println("\n* Test mit dem Optional, das einen Integer hat");
		maybeInt = Optional.of(42);
		maybeInt.ifPresent(action); // x = 42
		
	}
}
