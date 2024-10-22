package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class B05_Streams_terminal_two {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam", "Betty");
		
		Optional<String> optName = list.stream().parallel().filter(s -> s.startsWith("B")).findAny();
		if(optName.isPresent()) {
			String name = optName.get();
			System.out.println(name);
		}
		
		optName = list.stream().parallel().filter(s -> s.startsWith("B")).findFirst();
		if(optName.isPresent()) {
			String name = optName.get();
			System.out.println(name);
		}
		
		Optional<Integer> optPrimzahl = Stream.iterate(1_000_000, i -> i + 1).parallel().filter(Math::isPrime).findAny();
		System.out.println("primzahl = " + optPrimzahl.get());
		
		Integer[] arr = { 12, -5, 33, 7, 9 };
		Predicate<Integer> isPositive = i -> i > 0;
		
		boolean allMatch = Arrays.stream(arr).allMatch(isPositive);
		System.out.println("allMatch = " + allMatch);
		boolean anyMatch = Arrays.stream(arr).anyMatch(isPositive);
		System.out.println("anyMatch = " + anyMatch);
		boolean noneMatch = Arrays.stream(arr).noneMatch(isPositive);
		System.out.println("noneMatch = " + noneMatch);
		
	}
	
	
	
	public static boolean isPrime(int zahl) {
		for (int i = 2; i <= zahl / 2; i++) {
			if (zahl % i == 0) {
				return false;
			}
		}
		return true;	
	}

}

class Math {
	public static boolean isPrime(int zahl) {
		for (int i = 2; i <= zahl / 2; i++) {
			if (zahl % i == 0) {
				return false;
			}
		}
		return true;	
	}
}
