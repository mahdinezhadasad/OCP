package aufgaben.words;

import java.util.List;
import java.util.Optional;

import words.Words;

public class AufgabeWords {

	public static void main(String[] args) {
		
		List<String> daten = Words.germanWords();

		System.out.println("*** A1");
		
		long count1 = daten.stream().filter(s -> s.length() > 5).count(); 

		System.out.println("Anzahl der Wörter der Länge größer als 5: " + count1);
		
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
			System.out.println("Keine String s gefunden, die mit m anfangen");
		}
		
		
		
		
	}

}
