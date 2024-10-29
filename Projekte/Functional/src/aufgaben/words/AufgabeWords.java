package aufgaben.words;

import java.util.List;
import java.util.Optional;

import words.Words;

public class AufgabeWords {

	public static void main(String[] args) {
		
		List<String> daten = Words.passwords();
		a1(daten);
		a2(daten);
		a3(daten);
		a4(daten);
		a5(daten);
				
	} // end of main
	
	static void a5(List<String> daten) {
		System.out.println("\n*** A5");
		
		throw new UnsupportedOperationException("noch nicht gelöst");
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
