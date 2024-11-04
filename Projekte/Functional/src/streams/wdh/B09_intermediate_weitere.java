package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class B09_intermediate_weitere {

	public static void main(String[] args) {
		/*
		 * parallel()
		 * sequential()
		 * unoredered()
		 * 
		 * s. auch Bsp. B26
		 */
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		
		list.stream()
			.parallel()
			.sequential()
			.parallel()
			.sequential()
			.unordered()
			.forEach(System.out::println);

	}

}
