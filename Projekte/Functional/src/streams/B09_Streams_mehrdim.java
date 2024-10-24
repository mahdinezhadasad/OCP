package streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class B09_Streams_mehrdim {

	public static void main(String[] args) {
		Integer[] umsaetze2021 = {2000, 1500, 3500, 2750};
		Integer[] umsaetze2022 = {3000, 2250, 4250, 3000};
		Integer[] umsaetze2023 = {2250, 1750, 3250, 2500};
		
		Stream<Integer> stream2021 = Arrays.stream(umsaetze2021);
		Stream<Integer> stream2022 = Arrays.stream(umsaetze2022);
		Stream<Integer> stream2023 = Arrays.stream(umsaetze2023);
		
		Stream<Stream<Integer>> streamGesamt = Stream.of(stream2021, stream2022, stream2023);
		
		streamGesamt.flatMap(Function.identity()).filter(umsatz -> umsatz >= 2000).forEach(System.out::println);
	}

}
