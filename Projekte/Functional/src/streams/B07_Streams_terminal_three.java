package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class B07_Streams_terminal_three {

	public static void main(String[] args) {
//		Stream.iterate(1, i -> i + 1).limit(100).forEach(System.out::println);
		
		BinaryOperator<Integer> op = (i1, i2) -> i1 + i2;
		
		Optional<Integer> optSumme = Stream.iterate(1, i -> i + 1).limit(100).reduce(op);
		if(optSumme.isPresent()) {
			Integer summe = optSumme.get();
			System.out.println("summe = " + summe);
		} else {
			System.out.println("Keine Summe vorhanden");
		}
		
		Integer summe = Stream.iterate(1, i -> i + 1).limit(100).reduce(0, op);
		System.out.println("summe = " + summe);
		
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");
		System.out.println(list);
		
		BinaryOperator<String> stringOp = (s1, s2) -> s1 + (s1.length() > 0 ? ", " : "") + s2;
		Optional<String> optNamen = list.stream().reduce(stringOp);
		System.out.println(optNamen.orElseGet(() -> "Keine Namen vorhanden"));
		
		String namen = list.stream().reduce("", stringOp);
		System.out.println(namen);
		System.out.println(namen.substring(namen.indexOf(",") + 1).trim());
		
		String[] arr = { "Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam"};
		
		Integer idt = 0;
		
		BiFunction<Integer, String, Integer> func = (Integer idtOrPrevResult, String nextElement) -> idtOrPrevResult + nextElement.length();
		
		BinaryOperator<Integer> intOp = (i1, i2) -> i1 + i2;
		
		Integer count = Arrays.stream(arr).reduce(idt, func, intOp);
		
		System.out.println("count = " + count);
		
	}

}
