package streams.wdh;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class B25_Streams_mit_primitiven {

	/*
	 * XxxStreams. Xxx steht für Int, Long oder Double:
	 * 
	 * 		IntStream
	 * 		LongStream
	 * 		DoubleStream
	 * 
	 */
	public static void main(String[] args) {
		
		/*
		 * - Erzeugen und Datenquelle bestimmen ähnlich wie Stream<T>
		 * - Intermediate Ops ähnlich wie im Stream<T>
		 * - Terminal Ops ähnlich wie im Stream<T>
		 */
		
		IntStream.of(11, -7, 22, 3, 5, -4)
			.filter(i -> i > 0)
			.map(i -> i*2)
			.forEach(System.out::println);
		
		/*
		 * Spezielle terminal Ops
		 */
		System.out.println();
		
		double sum = DoubleStream.iterate(1.0, d -> d + 1.0)
			.limit(3)
			.sum();
		
		System.out.println("sum: " + sum); // 6.0
		
	}
}
