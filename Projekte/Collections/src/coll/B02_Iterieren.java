package coll;

import java.util.*;

public class B02_Iterieren {

	public static void main(String[] args) {

//		Collection<Integer> coll = new ArrayList<Integer>();
//		Collection<Integer> coll = new LinkedList<Integer>();
		Collection<Integer> coll = new Vector<Integer>();
		coll.add(12);
		coll.add(13);
		coll.add(14);
		
		/*
		 * Bsp. 1
		 */
		System.out.println("*** mit der while-Schleife");
		
		Iterable<Integer> iterable = coll; // Iterable <- IS-A <- Collection

		Iterator<Integer> it = iterable.iterator();

		while( it.hasNext() ) {
			Integer x = it.next();
			System.out.println("x = " + x);
		}
		
		/*
		 * Bsp. 2
		 */
		System.out.println("\n*** mit der for-Schleife");
		
		for(Iterator<Integer> myIter = coll.iterator(); myIter.hasNext();) {
			Integer x = myIter.next();
			System.out.println("x = " + x);
		}
		
		/*
		 * Bsp. 3
		 * 
		 * Im Hintergrund ist die foreach-Schleife mit einer 'normalen' Schleife realisiert
		 */
		System.out.println("\n*** mit der foreach-Schleife");
		
		for(Integer x : coll) {
			System.out.println("x = " + x);
		}
		
	}

}
