package aufgaben.stats;

import java.util.Comparator;
import java.util.Optional;

public interface TextStatistics {
	
	public Comparator<String> CMP_STRING_DEFAULT = 
			Comparator.comparing(String::length)
			.thenComparing(Comparator.naturalOrder());
	
	
	public int getCountChars();
	
	public int getCountSpecialChars();
	
	public int getCountLetters();
	
	public Optional<String> getLongestWord();

}
