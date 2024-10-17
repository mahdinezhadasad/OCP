package aufgaben.autos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
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
