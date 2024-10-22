package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class B03_Streams_terminal_three {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam", "Betty");
		
		List<String> listNamen = list.stream().collect(Collectors.toList());
		ArrayList<String> arrayListNamen = list.stream().collect(Collectors.toCollection(ArrayList::new));
		arrayListNamen.forEach(System.out::println);
		System.out.println("***********");
		
		Set<String> setNamen = list.stream().collect(Collectors.toSet());
		setNamen.forEach(System.out::println);
		System.out.println("***********");
		setNamen = list.stream().collect(Collectors.toCollection(TreeSet::new));
		setNamen.forEach(System.out::println);
		
		String namen = list.stream().collect(Collectors.joining(", "));
		System.out.println(namen);
		
		StringBuilder namenSB = list.stream().parallel().collect(StringBuilder::new, (sb1, sb2) -> sb1.append(sb2), (sb1, sb2) -> sb1.append(sb2));
		System.out.println(namenSB);
		System.out.println("***********");
		
		Integer[] arr = { 12, -7, 22, -1000, 333, 5, 12, 0 };
		
		Function<Integer, String> classifier = i -> i > 0 ? "positiv" : i < 0 ? "negativ" : "weder noch";
		
//		Map<String, List<Integer>> gruppierung = Arrays.stream(arr).collect(Collectors.groupingBy(classifier));
//		for(String key : gruppierung.keySet()) {
//			System.out.println(key + " " + gruppierung.get(key));
//		}
		
		Arrays.stream(arr)
		 	.collect(Collectors.groupingBy(classifier))
		 	.forEach((key, value) -> System.out.println(key + ": " + value));
		 
		System.out.println("***********");
		
		Predicate<Integer> pred = i -> i % 2 == 0;
		
		Arrays.stream(arr)
			.collect(Collectors.partitioningBy(pred))
			.forEach((k, v) -> System.out.println(k + ": " + v));
		System.out.println("***********");
		
		Arrays.stream(arr)
		.collect(Collectors.partitioningBy(pred, Collectors.counting()))
		.forEach((k, v) -> System.out.println((k.equals(true) ? "gerade" : "ungerade") + ": " + v));
		System.out.println("***********");
		
		Arrays.stream(arr)
		 	.collect(Collectors.groupingBy(classifier,Collectors.counting()))
		 	.forEach((key, value) -> System.out.println(key + ": " + value));
		System.out.println("***********");
		
		list = Arrays.asList("Wilma", "Fred", "Pebbles", "Barney", "Betty", "Bambam");
		
		list.stream()
			.collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()))
			.forEach((key, value) -> System.out.println(key + ": " + value));
		
		
	}

}
