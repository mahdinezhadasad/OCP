package func;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class WdhMethodenreferenz2 {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		// void forEach(Consumer<Integer> action)
		list.forEach(System.out::println);

		/*
		Consumer<Integer> action = System.out::println;
		
		Consumer<Integer> action2 = new Consumer<Integer> () {
			public void accept(Integer param) {
				System.out.println(param);
			}
		};
		*/
	}

}
