package Functional.src.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class B04_List_sort {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("hh", "u", "aaaa", "mmm");
		
		System.out.println("1. list: " + list); // [hh, u, aaaa, mmm]

		/*
		 * default void sort(Comparator<? super E> c) 
		 */
		
		// wenn der Comparator null ist, müssen
		// die Elemente der List Comparable sein:
		Comparator<String> c1 = null;
		list.sort(c1);
		
		System.out.println("2. list: " + list); // [aaaa, hh, mmm, u]
		
		Comparator<String> c2 = Comparator.comparing(String::length);
		list.sort(c2);
		
		System.out.println("3. list: " + list); // [u, hh, mmm, aaaa]
		
	}

}