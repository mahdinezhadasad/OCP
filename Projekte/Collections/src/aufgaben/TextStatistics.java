package aufgaben;

import java.util.Collection;
import java.util.HashSet;

public class TextStatistics {

	public static TextStatistics of(String text) {
		return new TextStatistics(text);
	}
	
	private String text;
	
	public TextStatistics(String text) {
		this.text = text;
	}

	public Collection<Character> getUniqueChars() {
		
		Collection<Character> coll = new HashSet<Character>();
		
		for(int i=0; i<text.length(); i++) {
			
			char ch = text.charAt(i);
			
//			if(!coll.contains(ch)) {
//				coll.add(ch);
//			}
			
			coll.add(ch);
		}
		
		return coll;
	}
	
}
