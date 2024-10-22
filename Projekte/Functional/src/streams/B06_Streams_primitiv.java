package streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B06_Streams_primitiv {

	public static void main(String[] args) {
		Stream<Integer> stream = Stream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2);
		// Streams mit primitven Variablen (int, double, long)
		IntStream intStream = IntStream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2);

//		OptionalDouble optDurchschnitt = intStream.average();
//		if (optDurchschnitt.isPresent()) {
//			double durchschnitt = optDurchschnitt.getAsDouble();
//			System.out.println("durchschnitt = " + durchschnitt);
//		}
		int summe = intStream.sum();
		System.out.println("summe = " + summe);

		OptionalDouble optDurchschnitt = stream.mapToInt(i -> i.intValue()).average();
		if (optDurchschnitt.isPresent()) {
			double durchschnitt = optDurchschnitt.getAsDouble();
			System.out.println("durchschnitt = " + durchschnitt);
		}
		
		Integer[] arr1 = { 1, 2, 3, 4, 5, 6};
		stream = Arrays.stream(arr1);
		int[] arr2 = { 1, 2, 3, 4, 5, 6};
		intStream = Arrays.stream(arr2);
		
		Random r = new Random();
		intStream = r.ints().limit(5);
		
		String s = "abcdefgh";
		s.chars().forEach(i -> System.out.println((char)i));
		
		Object[] objArr = Stream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2).filter(i -> i < 3).toArray();
		System.out.println(Arrays.toString(objArr));
		Integer[] intArr = Stream.of(3, 4, 2, 1, 6, 5, 4, 3, 2, 1, 4, 5, 3, 2).filter(i -> i < 3).toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArr));
	}

}
