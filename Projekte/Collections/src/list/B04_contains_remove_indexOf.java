package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

final class Blume {
	int preis;

	Blume(int preis) {
		this.preis = preis;
	}
	
	public String toString() {
		return "Blume (" + preis + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if( !(obj instanceof Blume) ) {
			return false;
		}
		
		Blume b2 = (Blume)obj;
		return preis == b2.preis;
	}
}

public class B04_contains_remove_indexOf {

	/*
	 * Achtung!
	 * 	die contains, remove, indexOf und lastIndexOf
	 *  benutzen fürs Vergleichen die equals-Methode 
	 *  der gespeicherten Elemente
	 */
	public static void main(String[] args) {
		
		test_mit_Strings();
		test_mit_Blumen();

	}
	
	static void test_mit_Blumen() {
		System.out.println("\n*** Test mit Blumen");
		List<Blume> listBlumen = new ArrayList<>();
		listBlumen.add(new Blume(120));
		listBlumen.add(new Blume(90));
		listBlumen.add(new Blume(200));
		System.out.println("a. listBlumen: " + listBlumen);
		
		Blume key = new Blume(90);
		// [Blume (120), Blume (90), Blume (200)]
		System.out.println("contains und remove mit " + key);
		
		boolean result = listBlumen.contains(key);
		System.out.println("contains: " + result);
		
		result = listBlumen.remove(key);
		System.out.println("remove: " + result);
		
		// [Blume (120), Blume (200)]
		System.out.println("b. listBlumen: " + listBlumen);
		
		key = new Blume(200);
		System.out.println("indexOf mit " + key);

		int index = listBlumen.indexOf(key);
		System.out.println("indexOf: " + index);
	}

	static void test_mit_Strings() {
		System.out.println("*** Test mit Strings");
		
		List<String> listStr = Arrays.asList("mo", "di", "mi"); // Liste mit fixierten Größe
		
		listStr = new LinkedList<>(listStr); // normale Liste
		
		String key = "Freitag";
		
		// Bsp. 1
		boolean result = listStr.contains(key);
		System.out.println("1. " + result); // false
		
		// Bsp. 2
		result = listStr.remove(key);
		System.out.println("2. " + result);
		
		// Bsp. 3
		key = "di";
		result = listStr.remove(key);
		System.out.println("3. " + result); // true
		
		System.out.println("listStr: " + listStr); // [mo, mi]
		
		// Bsp. 4
		key = "MI".toLowerCase();
		int index = listStr.indexOf(key);
		System.out.println("index: " + index); // 1
		
	}
}
