package coll;

import java.util.ArrayList;
import java.util.Collection;

public class B01_Collection_basic_API {

	public static void main(String[] args) {

		Collection<Integer> coll = new ArrayList<Integer>();
		
		/*
		 * int size()
		 * boolean isEmpty()
		 */
		System.out.println("1. size(): " + coll.size()); // 0
		System.out.println("1. isEmpty(): " + coll.isEmpty()); // true
		
		/*
		 * boolean add(E e)
		 */
		coll.add(12);	// Integer <- IS-A <- Integer
//		coll.add(12.0); // Integer <- IST KEIN <-  Double 
		coll.add(13);
		coll.add(14);
		
		System.out.println("2. size(): " + coll.size()); // 3
		System.out.println("2. isEmpty(): " + coll.isEmpty()); // false
		
		/*
		 * boolean remove(Object e)
		 */
		coll.remove(12);
		coll.remove(12.0); // sinnlos, kompiliert aber
		
		System.out.println("3. size(): " + coll.size()); // 2
		System.out.println("3. isEmpty(): " + coll.isEmpty()); // false
		
		/*
		 * boolean contains(Object e)
		 */
		boolean result = coll.contains(12);
		System.out.println("4. coll.contains(12): " + result); // false
		System.out.println("4. coll.contains(13): " + coll.contains(13)); // true
		
		result = coll.contains(12.0); // definitiv false
		
		/*
		 * toString()
		 */
		System.out.println("5. coll: " + coll); // [13, 14]
		
		/*
		 * void clear()
		 */
		coll.clear();
		System.out.println("6. size(): " + coll.size()); // 0
		System.out.println("6. isEmpty(): " + coll.isEmpty()); // true
		System.out.println("6. coll: " + coll); // []
		
		/*
		 * weitere Methoden
		 * 
		 * toArray (überladen)
		 * addAll(Collection)
		 * ...
		 * 
		 * 
		 * Methoden, die das funktionale Programmieren unterstützen,
		 * werden im Projekt 'Functional' im Package 'collections'
		 * vorgestellt.
		 * 
		 */
		
		
	}

}
