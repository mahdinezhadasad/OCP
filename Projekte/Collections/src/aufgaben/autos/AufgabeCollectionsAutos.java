package aufgaben.autos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class AufgabeCollectionsAutos {

	public static void main(String[] args) {
		
		VW vw1 = new VW("Golf", 1990);
		System.out.println(vw1); // VW. Modell: Golf, Baujahr 1990
		VW vw2 = new VW("Polo", 2021);
		VW vw3 = new VW("Golf", 2024);
		
		/*
		 * A4
		 */
		
		// LinkedList
		List<VW> listVW = new LinkedList<>();
		listVW.add(vw1);
		listVW.add(vw2);
		listVW.add(vw3);
		
		print(listVW);
		
		// HashSet
		Set<VW> hashSetVW = new HashSet<>();
		hashSetVW.addAll(listVW);
		
		hashSetVW.add(new VW("Polo", 2021)); // Test auf doppelte Elemente
		print(hashSetVW);
		
		// TreeSet
		Set<VW> treeSetVW = new TreeSet<>(listVW);
		
		treeSetVW.add(new VW("Polo", 2021));
		print(treeSetVW);
		
		// PriorityQueue
		Queue<VW> queueVW = new PriorityQueue<>(listVW);
		print(queueVW);
		
		System.out.println("--- Queue leeren: ");
		while(!queueVW.isEmpty()) {
			System.out.println(queueVW.remove());
		}

		/*
		 * A6
		 */
		
		BMW bmw1 = new BMW("Z4", 2000);
		BMW bmw2 = new BMW("Z2", 2021);
		System.out.println(bmw1); // BMW. Modell: Z4, Baujahr 2000

		// ArrayList
		List<BMW> listBMW = new ArrayList<>();
		listBMW.add(bmw1);
		listBMW.add(bmw2);
		 
		print(listBMW);
		
		// HashSet
		Set<BMW> hashSetBMW = new HashSet<>(listBMW);
		
		hashSetBMW.add(new BMW("Z4", 2000)); // Test auf doppelte
		print(hashSetBMW);
		
		// TreeSet
		Set<BMW> treeSetBMW = new TreeSet<>(listBMW);
		
		treeSetBMW.add(new BMW("Z4", 2000)); // Test auf doppelte
		//treeSetBMW.add(new BMW("Z2", 2017)); // ok: Test auf Sortieren bei gleichen Modellen
		print(treeSetBMW);
		
		// ArrayDeque
		Deque<BMW> dequeBmw = new ArrayDeque<>(listBMW);
		
		print(dequeBmw);
		
		/*
		 * A7
		 */
		System.out.println("\n--------------");
		System.out.println("----- A7 -----");
		System.out.println("--------------");
		print(hashSetBMW);
		
		System.out.println("hashSetBMW.contains(bmw1): " + 
				hashSetBMW.contains(bmw1)); // true
		
		/*
		 * A8
		 */
		System.out.println("\n--------------");
		System.out.println("----- A8 -----");
		System.out.println("--------------");
		
		bmw1.setBaujahr(3333); // Ändert auch den Hashcode des Objektes!
		print(hashSetBMW);
		
		System.out.println("hashSetBMW.contains(bmw1): " + 
				hashSetBMW.contains(bmw1)); // false: das Element kann nicht mehr gefunden werden
		
		/*
		 * A9, A10
		 */
		System.out.println("\n--------------");
		System.out.println("----- A9, 10 -----");
		System.out.println("--------------");
		listVW.add(new VW("Polo", 2200));
		
		print(listVW);
		
		// falsch: binarySearch braucht eine sortierte Liste:
		int index = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("index of Polo 2200: " + index); // 3 (zufällig richtig)
		
		// falsch: binarySearch braucht eine sortierte Liste:
		index = Collections.binarySearch(listVW, new VW("Golf", 2024));
		System.out.println("index of Golf 2024: " + index); // -2 
		
		/*
		 * A11
		 */
		System.out.println("\n--------------");
		System.out.println("----- A11 -----");
		System.out.println("--------------");
		
		Collections.sort(listVW);
		print(listVW);
		
		// richtig: binarySearch braucht eine sortierte Liste:
		index = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("index of Polo 2200: " + index); // 3
		
		// richtig: binarySearch braucht eine sortierte Liste:
		index = Collections.binarySearch(listVW, new VW("Golf", 2024));
		System.out.println("index of Golf 2024: " + index); // 1
		
		/*
		 * A12, A13
		 */
		System.out.println("\n--------------");
		System.out.println("----- A12, A13 -----");
		System.out.println("--------------");
		
		Collections.sort(listVW, Comparator.reverseOrder());
		print(listVW);
		
		// falsch: diese binarySearch braucht eine 'natürlich' sortierte Liste,
		//         und vergleicht die Elemente 'natürlich' (als Comparable)
		index = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("index of Polo 2200: " + index); // -5

		// richtig: überladene binarySearch einsetzen, die
		//          denselben Comparator für die Vergleiche benutzt,
		//          der beim Sortieren verwendet wurde		
		index = Collections.binarySearch(listVW, 
				new VW("Polo", 2200), Comparator.reverseOrder());
		System.out.println("index of Polo 2200: " + index); // 0

		/*
		 * A14
		 */
		System.out.println("\n*** suche nach Polo 3300");
		VW key = new VW("Polo", 3300);
		Comparator<VW> cmp = Comparator.reverseOrder();
		index = Collections.binarySearch(listVW, key, cmp);
		System.out.println("index = " + index); // -1
		
	} // end of main

	static void print(Collection<? extends Auto> coll) {
		System.out.println("\n*** " + coll.getClass().getSimpleName());
		
		int i = 0;
		for(Auto a : coll) {
//			System.out.println(i++ + ". " + a);
			System.out.format("|%2d|%5s|%5s|%5d|%n", i++, 
					a.getHersteller(), a.getModell(), a.getBaujahr());
		}
	}
}
