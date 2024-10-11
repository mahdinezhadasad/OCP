package aufgaben;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TextStatistics {

	public static TextStatistics of(String text) {
		return new TextStatistics(text);
	}
	
	private String text;
	
	public TextStatistics(String text) {
		this.text = text;
	}

	/**
	 * Liefert eine Collection von `Character` zurück, in der alle 
	 * auftretenden Zeichen von dem zu untersuchenden String 
	 * aufgelistet sind und einmalig auftauchen
	 * 
	 * @return
	 */
	public Collection<Character> getUniqueChars() {
		
		Collection<Character> coll = new HashSet<Character>();
		
		for(int i=0; i<text.length(); i++) {
			char ch = text.charAt(i);
			coll.add(ch);
		}
		
		return coll;
	}
	
	/**
	 * Jedem in Text gefundenen Zeichen wird in der Map die Zahl 
	 * zugeordnet, die sagt, wie oft das Zeichen in dem Text vorkommt.
	 * 
	 * @return
	 */
	public Map<Character, Integer> getCharCounts() {
		Map<Character, Integer> map = new HashMap<>();
		
		// text = "aaa"
		
		for(int i=0; i<text.length(); i++) {
			char ch = text.charAt(i);
			
			// falls es das Zeichen noch nicht in der Map gibt,
			//     dann speichere das Zeichen und Value=1
			// sonst
			//     das alte Value holen, inkrementieren, Map updaten
			
			Integer value = map.get(ch);
			
//			map.put(ch, 1);
		}
		
		return map;
	}
	
}
