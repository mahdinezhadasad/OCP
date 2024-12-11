package sortieren;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Blume implements Comparable<Blume> {
	
	String name;
	int preis;
	
	Blume(String name, int preis) {
		this.name = name;
		this.preis = preis;
	}
	
	public String toString() {
		return name + "(" + preis + ")";
	}
	
	@Override
	public int compareTo(Blume b2) {
		int res = name.compareTo(b2.name);
		
		if(res==0) {
			res = preis - b2.preis;
		}
		
		return res;
	}
}

public class B03_SortierenInDerStandardbibliothek {

	public static void main(String[] args) {
		
		/*
		 * Sortieren von Arrays (s. Bsp. B01)
		 */
		
		
		/*
		 * Sortieren von Listen
		 */
		
		List<Blume> listBlumen = Arrays.asList(
				new Blume("Rose", 200),
				new Blume("Astra", 130),
				new Blume("Nelke", 90),
				new Blume("Astra", 77)
			); 
		
		/*
		 * Lösung A mit Comparable
		 * 
		 * Collections.sort(List)
		 */
		System.out.println("Collections.sort für List mit Comparable");
		Collections.sort(listBlumen);
		System.out.println("listBlumen: " + listBlumen);
		// [Astra(77), Astra(130), Nelke(90), Rose(200)]
		
		/*
		 * Lösung B mit Comparator
		 * 
		 * Collections.sort(List, Comparator)
		 */
		System.out.println("\nCollections.sort für List und Comparator");
		Comparator<Blume> cmpBlumen = (b1, b2) -> b2.preis - b1.preis;
		
		Collections.sort(listBlumen, cmpBlumen); // absteigend nach Preisen sortieren
		System.out.println("listBlumen: " + listBlumen);
		// [Rose(200), Astra(130), Nelke(90), Astra(77)]

		/*
		 * 
		 * List hat auch eine sort(Comparator)
		 * 
		 * Lösung A mit Comparable: 
		 * 
		 */
		System.out.println("\nList#sort(null)");
		listBlumen.sort(null);
		System.out.println(listBlumen);
		
		/*
		 * 
		 * Lösung B mit Comparator: 
		 * 
		 */
		System.out.println("\nList#sort(cmpBlumen)");
		listBlumen.sort(cmpBlumen);// absteigend nach Preisen sortieren
		System.out.println(listBlumen);
		
		/*
		 * TreeSet ist automatisch sortiert (und ConcurrentSkipListSet auch)
		 * 
		 * Lösung A mit Comparable: 
		 */
		Set<Blume> setBlumen = new TreeSet<>();
		setBlumen.addAll(listBlumen);
		System.out.println("\nTreeSet mit Comparable");
		System.out.println(setBlumen);
		
		/*
		 * 
		 * Lösung B mit Comparator: 
		 * 
		 */
		setBlumen = new TreeSet<>(cmpBlumen);// absteigend nach Preisen sortieren
		setBlumen.addAll(listBlumen);
		
		System.out.println("\nTreeSet mit Comparator");
		System.out.println(setBlumen);
		
		/*
		 * TreeMap sortiert die Schlüßel wie TreeSet die Elemente sortiert
		 */
		
		/*
		 * funktionale Streams können auch sortieren/vergleichen
		 * 
		 * Lösung A mit Comparable: 
		 */
		System.out.println("\n*** Stream sortiert Comparable");
		listBlumen.stream().sorted().forEach(System.out::println);
		
		/*
		 * 
		 * Lösung B mit Comparator: 
		 * 
		 */
		System.out.println("\n*** Stream sortiert, vergleicht mit Comparator");
		listBlumen.stream().sorted(cmpBlumen).forEach(System.out::println);
		
		
		/*
		 * Terminal max(Comparator):
		 * 
		 * Lösung A mit Comparable gibt es nicht direkt.
		 * 
		 * Ersatz: natural-order-Comparator nehmen mit Lösung B
		 */
		System.out.println("\n*** max mit natural-order-Comparator");
		listBlumen.stream()
			.max(Comparator.naturalOrder())
			.ifPresent(b -> System.out.println("max: " + b));
		
	}

}
