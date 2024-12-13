package functional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ForEachTest {

	public static void main(String[] args) {
		
		
		Consumer<Integer> argA = i -> System.out.println(i);
		
		Stream.of(1, 2, 3)
			.forEach(argA);

		BiConsumer<Integer, String> argB = (i, s) -> System.out.println(i + "=" + s);
		
		Map<Integer, String> map = new HashMap<>();
		map.forEach(argB);
		
	}

}
