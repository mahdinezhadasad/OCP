package aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class AufgabeIntermediateOperations {

	public static void main(String[] args) {
		// a1();
		// a2();
		// a3();
		// a4();
		// a5();
		// a6();
	}
	
	static void a6() {
		List<String> mailsErsthelfer = Arrays.asList("tom@mycompany.com", "jerry@mycompany.com");
		List<String> mailsIT = Arrays.asList("tom@mycompany.com", "mary@mycompany.com");
		List<String> mailsQM = Arrays.asList("peter@mycompany.com", "jerry@mycompany.com");
		
		Stream.of(mailsErsthelfer, mailsIT, mailsQM)
			.flatMap(List::stream)
			.distinct()
			.map(s -> s.split("@")[0])
			.forEach(System.out::println);
	}
	
	static void a5() {
		Tier[] array = {
				new Tier("Rex"),
				new Tier("Tom"),
				new Tier("Jerry"),
				new Tier("Tom"),
				new Tier("Jerry"),
			};
		
		Arrays.stream(array).distinct().forEach(System.out::println);
	}
	
	static void a4() {
		Random rand = new Random();
		// Variante 1
		Stream.generate(() -> rand.nextInt(41) - 20)
			.filter(i -> i < -15 || i > -10)
			.limit(30)
//			.map(i -> Double.valueOf(i))
			.map(Double::valueOf)
			.forEach(System.out::println)
			;
		// Variante 2
		rand.ints(30, -20, 21)
			.filter(i -> i < -15 || i > -10)
			.mapToDouble(Double::valueOf)
			.forEach(System.out::println)
			;
	}
	
	static void a3() {
		List<String> list = Arrays.asList("Tom", "Jerry", "Rex");
		list.stream().map(name -> new Tier(name)).forEach(System.out::println);
		list.stream().map(Tier::new).forEach(System.out::println);
	}
	
	static void a2() {
		Integer[] array = { 1, 4, 7, 3, -8 };
		// Variante 1 mit map
		Arrays.stream(array).map(i -> i % 2 == 0 ? "gerade" : "ungerade").forEach(System.out::println);
		// Variante 2 mit foreach
		Arrays.stream(array).forEach(i -> System.out.println(i % 2 == 0 ? "gerade" : "ungerade"));
	}

	static void a1() {
		List<Integer> list = Arrays.asList(13, 15, 17, 19, 21);
		list.stream().filter(i -> i == 15 || i == 19).forEach(i -> System.out.println("Treffer: " + i));
	}
}

class Tier {
	private String name;

	public Tier(String name) {
		this.name = name;
	}
	public String toString() {
		return "Tier " + name;
	}
	public boolean equals(Object o) {
		Tier t = (Tier) o;
		return this.name.equals(t.name);
	}
	public int hashCode() {
		return name.hashCode();
	}
}