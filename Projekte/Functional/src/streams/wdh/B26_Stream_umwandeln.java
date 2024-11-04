package streams.wdh;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B26_Stream_umwandeln {
	static class Blume {
		int preis;

		Blume(int preis) {
			this.preis = preis;
		}
		
		public int getPreis() {
			return preis;
		}
		
		public String toString() {
			return "B (" + preis + ")";
		}
	}

	public static void main(String[] args) {
		StreamA_to_StreamB();
		StreamA_to_XxxStream();
		XxxStream_to_StreamA();
		XxxStream_to_YyyStream();
	}
	
	/*
	 * XxxStream to YyyStream:
	 * 
	 * 		mapToYyy
	 * 
	 * - mit 'map' bleibt der Xxx-Typ gleich
	 */
	static void XxxStream_to_YyyStream() {
		System.out.println("\n*** IntStream to DoubleStream");
		
		IntStream.of(10, 20, 30, 40) // IntStream
			.mapToDouble(intZahl -> intZahl * 1.1) // DoubleStream
			.forEach(System.out::println);
		
		System.out.println("\n*** intermediate map kann den Typ nicht ändern");
		
//		IntUnaryOperator opBad = i -> i * 2.0; // cf: muss int zurück liefern
		IntUnaryOperator op = i -> i * 2; 
		
		IntStream.of(10, 20, 30, 40) // IntStream
			.map(op) // IntStream
			.forEach(System.out::println);
	}
	
	
	/*
	 * XxxStream to Stream<T>:
	 * 
	 * 		mapToObj
	 * 		boxed()
	 */
	static void XxxStream_to_StreamA() {
		System.out.println("\n*** IntStream zum Stream mit Referenzen");
	
		System.out.println("* mit mapToObj");
		
		IntStream.of(10, 200, 90, 111) // IntStream
			.mapToObj(zahl -> new Blume(zahl)) // Stream<Blume>
			.forEach(System.out::println);
		
		System.out.println("* mit boxed");
		
		DoubleStream.of(3.3, 4.4, 5.5) // DoubleStream
			.boxed() // Stream<Double>
			.forEach(System.out::println);
	}
		
	/*
	 * Stream<T> to XxxStream:
	 * 
	 * 		mapToXXX
	 */
	static void StreamA_to_XxxStream() {
		System.out.println("\n*** Stream mit Referenzen zum IntStream");
		
		Stream.of(new Blume(90),
				new Blume(120), 
				new Blume(110)) // Stream<Blume>
			.mapToInt(blume -> blume.getPreis()) // IntStream
			.forEach(System.out::println);
	}
	
	static void StreamA_to_StreamB() {
		System.out.println("*** Stream<String> to Stream<Blume>");
		
		Function<String, Blume> f1 = s -> {
			int preis = Integer.valueOf(s);
			return new Blume(preis);
		};
		
		Stream.of("10", "120", "33", "90") // Stream<String>
			.map(f1)// Stream<Blume>
			.forEach(System.out::println);
		
	}

}
