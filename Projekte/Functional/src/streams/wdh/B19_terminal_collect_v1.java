package streams.wdh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class B19_terminal_collect_v1 {

	/*
	 * collect: mutable Reduction (der 1. Parameter ist der Zielcontainer)
	 * 
	 * 
	 * <R> R collect(Supplier<R> supplier,
     *             BiConsumer<R, ? super T> accumulator,
     *             BiConsumer<R, R> combiner);
     *             
     * supplier:	Die Logik, mit der ein Zielcontainer erzeugt werden kann
     * 
     * accumulator: Die Logik zum Speichern in einem collect-Schritt von dem 
     * 				nächsten Element der Pipeline in dem Zielcontainer
     * 
     * combiner:	kombiniert die Zielcontainer, die in einzelnen Threads
     * 				mit Teildaten erstellt werden, zu dem Gesamtergebnis.
     * 				Im ersten Parameter die Daten aus dem zweiten Parameter kopieren!
     * 				
	 */
	public static void main(String[] args) {

		Integer[] array = { 1, 2, 3, 4, 5 };
		
		/*
		 * Aufgabe: Integer aus dem Array in einer List speichern
		 */
		
		/*
		 * - sequentiell
		 * 
		 * Zielcontainer erzeugen
		 * 
		 * Schritt 1
		 * 
		 * targetList = der erzeugte Zielcontainer
		 * nextElement = 1
		 * 
		 * acc.apply(targetList, nextElement)
		 * 
		 * Schritt 2
		 * 
		 * targetList = der erzeugte Zielcontainer
		 * nextElement = 2
		 * 
		 * acc.apply(targetList, nextElement)
		 * 
		 * Schritt 3
		 * 
		 * targetList = der erzeugte Zielcontainer
		 * nextElement = 3
		 * 
		 * acc.apply(targetList, nextElement)
		 * 
		 * ...
		 * 
		 * Am Ende den Zielcontainer zurückliefern
		 */
		
		Supplier<List<Integer>> supp = () -> new ArrayList<>();
		
		BiConsumer<List<Integer>, Integer> acc = 
				(targetList, nextElement) -> targetList.add(nextElement);
				
		BiConsumer<List<Integer>, List<Integer>> cmb = (list1, list2) -> list1.addAll(list2); 	
		
		List<Integer> list = Arrays.stream(array)
			.collect(supp, acc, cmb);

		System.out.println("1. list: " + list);
		
		
		/*
		 * - parallel
		 * 
		 * Beispiel für 2 CPUs:
		 * 
		 * CPU A										CPU B
		 * Daten: 1, 2, 3								Daten: 4, 5
		 * 
		 * Zielcontainer A erzeugen						Zielcontainer B erzeugen
		 * 
		 * Schritt 1									Schritt 1
		 * 
		 * targetList = Zielcontainer A					targetList = Zielcontainer B
		 * nextElement = 1								nextElement = 4
		 * 
		 * acc.accept(targetList, nextElement)			acc.accept(targetList, nextElement)
		 * 
		 * Schritt 2									Schritt 2
		 * 
		 * targetList = Zielcontainer A					targetList = Zielcontainer B
		 * nextElement = 2								nextElement = 5
		 * 
		 * acc.accept(targetList, nextElement)			 acc.accept(targetList, nextElement)
		 * 
		 * Schritt 3
		 * 
		 * targetList = Zielcontainer A
		 * nextElement = 3
		 * 
		 * acc.accept(targetList, nextElement)
		 * 
		 * 
		 * Abwarten (wenn nötig) bis die Arbeit auf der CPU B fertig ist.
		 * 
		 * In dem Zielcontainer A die Daten aus dem Zielcontainer B übernehmen:
		 *   list1 = Zielcontainer A
		 *   list2 = Zielcontainer B
		 *   
		 *   cmb.accept(list1, list2)
		 *   
		 * 
		 * Am Ende den Zielcontainer A zurückliefern
		 */		
		List<Integer> list2 = Arrays.stream(array)
				.parallel()
				.collect(supp, acc, cmb);
		
		System.out.println("2. list2: " + list2);
		
	}

}
