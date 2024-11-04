package aufgaben.words;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import words.Words;

public class AufgabeWords {

	public static void main(String[] args) {
		
//		List<String> daten = Words.passwords();
		List<String> daten = Words.englishWords();
		
		a1(daten);
		a2(daten);
		a3(daten);
		a4(daten);
		a5(daten);
				
		a6(Words.passwords());
		a7(Words.englishWords());
		a8(Words.englishWords());
		
	} // end of main
	
	static void a8(List<String> daten) {
		System.out.println("\n*** A8");
		
		Collector<String, ?, Long> downstream = Collectors.counting();
		
		Collector<String, ?, Map<Integer, Long>> c1 = 
				Collectors.groupingBy(String::length, downstream);
		
		Map<Integer, Long> groupMap = daten.stream()
				.collect(c1);
		
		groupMap.forEach( (length, count) -> {
			System.out.println(length + ": " +  count);
		});
	}

	static void a7(List<String> daten) {
		System.out.println("\n*** A7");
		
		Function<String, Integer> classifier = String::length;
		
		Map<Integer, List<String>> groupMap = daten.stream()
				.collect(Collectors.groupingBy(classifier));

		System.out.println("*** nicht sortierte Keys: ");
		groupMap.forEach( (length, list) -> {
			System.out.println(length + ": " + list.size());
		});
		
//		System.out.println( daten.stream().max(Comparator.comparing(String::length)).get() );
		
		System.out.println("\n*** sortierte Keys: ");
		
		TreeMap<Integer, List<String>> groupMap2 = daten.stream()
				.collect(Collectors.groupingBy(String::length, 
						TreeMap::new, Collectors.toList()));
		
		groupMap2.forEach( (length, list) -> {
			System.out.println(length + ": " + list.size());
		});
	}
		
	static void a6(List<String> daten) {
		System.out.println("\n*** A6");
		
		String myPassword = "12345";
		
		Optional<String> maybeString =daten.stream()
			.filter(s -> s.equals(myPassword))
			.findAny();
		
		if(maybeString.isPresent()) {
			System.out.println("Passwort " + myPassword + " gefunden");
		} else {
			System.out.println("Passwort " + myPassword + " NICHT gefunden");
		}
	}
		
	static void a5(List<String> daten) {
		System.out.println("\n*** A5");
		
		LinkedList<String> list = daten.stream()
			.filter(s -> s.contains("aba"))
			.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
			
		System.out.println("Wörter mit aba-Substring: " + list.size());
		
		list = daten.stream()
				.filter(s -> s.contains("aba"))
				.collect(Collectors.toCollection(LinkedList::new));

		System.out.println("Wörter mit aba-Substring: " + list.size());
	}
	
	static void a4(List<String> daten) {
		System.out.println("\n*** A4");
		System.out.println("überprüfen, ob es mindestens ein Wort gibt, "
				+ "in dem es den Unterstring 'ooo' gibt.");
		
		Optional<String> maybeStr = daten.stream()
			.filter(s -> s.contains("ooo"))
			.findAny();
		
		if(maybeStr.isPresent()) {
			System.out.println("Gefunden: " + maybeStr.get());
		} else {
			System.out.println("Kein String gefunden");
		}
		
	}
	
	static void a3(List<String> daten) {
		System.out.println("\n*** A3");
		System.out.println("20 Wörter überspringen und dann die nächsten 10 Wörter ausgeben:");
		
		daten.stream()
			.skip(20)
			.limit(10)
			.forEach(System.out::println);
	}	

	static void a2(List<String> daten) {
		System.out.println("\n*** A2");
//		String str2 = daten.stream().filter(s -> s.startsWith("m")).sorted().getFirst();
//		String str2 = daten.stream().filter(s -> s.startsWith("m")).sorted().findFirst();
		Optional<String> maybeStr2 = daten.stream()
				.filter(s -> s.startsWith("m"))
				.sorted()
				.findFirst();

		if(maybeStr2.isPresent()) {
			String str2 = maybeStr2.get();
			System.out.println("kleinster String von den Strings, die mit 'm' starten: " + str2);
		} else {
			System.out.println("Keine Strings gefunden, die mit m anfangen");
		}
	}
	
	static void a1(List<String> daten) {
		System.out.println("*** A1");
		
		long count1 = daten.stream().filter(s -> s.length() > 5).count(); 

		System.out.println("Anzahl der Wörter der Länge größer als 5: " + count1);
	}
	
}
