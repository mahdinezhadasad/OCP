package aufgaben;

import java.util.Collection;
import java.util.Map;

public class AufgabeMapTextStatistics {

	public static void main(String[] args) {
		
		String text = "Heute ist Montag!";
		TextStatistics stat = TextStatistics.of(text);
		
		Collection<Character> chars = stat.getUniqueChars();
		
		System.out.println("Text: '" + text + "'");
		System.out.println("Text-Size: " + text.length());
		System.out.println("Einzigartige Zeichen: " + chars.size());
		System.out.println(chars);

		Map<Character, Integer> mapCounts = stat.getCharCounts();
		
		System.out.println("\nCounts: ");
		for(Character ch : mapCounts.keySet()) {
			Integer count = mapCounts.get(ch);
			System.out.println(ch + ": " + count);
		}
	}

}
