package streams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("\n------------");
		
		HashMap<String, ArrayDeque<Integer>>  gruppenMap = Arrays.stream(arr)
				.collect( Collectors.groupingBy( x -> x%2==0 ? "gerade" : "ungerade",
						HashMap::new, Collectors.toCollection(ArrayDeque::new)) );
		
		System.out.println(gruppenMap);

	}

}
