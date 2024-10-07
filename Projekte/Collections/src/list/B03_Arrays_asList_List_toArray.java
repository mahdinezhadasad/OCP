package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class B03_Arrays_asList_List_toArray {
	public static void main(String[] args) {
		test_Arrays_asList();
		test_Collection_toArray();
	}
	
	static void test_Collection_toArray() {
		System.out.println(" \n*** test Collection/toArray");
		
		List<Integer> list = new ArrayList<>();
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		
		/*
		 * Object[] toArray()
		 */
		Object[] arrObj = list.toArray();
		System.out.println("1. arrObj: " + Arrays.toString(arrObj));
		
		try {
			Integer[] arrTmp = (Integer[])arrObj;
		} catch (ClassCastException e) {
			System.out.println("ClassCastException: Object[] ist nicht Integer[]");
		}
		
		/*
		 *  <T> T[] toArray(T[] a)
		 *  
		 *  	wenn das übergebene Array groß genug ist,
		 *  	speichert toArray die Elemente der Liste im
		 *  	übergebenen Array. Ansonsten wird ein neues
		 *  	Array erzeugt. 
		 */
		Integer[] arrInt = list.toArray(new Integer[0]);
		System.out.println("2. arrInt: " + Arrays.toString(arrInt));
		
		Integer[] arrInt2 = list.toArray(new Integer[10]);
		System.out.println("3. arrInt2: " + Arrays.toString(arrInt2));
		
		/*
		 * Ab Java 11:
		 * 
		 * <T> T[] toArray(IntFunction<T[]> generator) 
		 */
//		Integer[] arrInt3 = list.toArray( (int size) -> new Integer[size] );
//		System.out.println("3. arrInt3: " + Arrays.toString(arrInt3));
		
	}

	static void test_Arrays_asList() {
		System.out.println("*** test Arrays.asList");
		
		List<String> listGehtAuch = new ArrayList<>();
		listGehtAuch.add("mo");
		listGehtAuch.add("di");
		listGehtAuch.add("mi");
		
//		List<String> listAbJava9 = List.of("mo", "di", "mi"); // nicht in der Prüfung
		
		/*
		 * static <T> List<T> asList(T... a)
		 */
		List<String> listStr = Arrays.asList("mo", "di", "mi");
		
		System.out.println("1. listStr: " + listStr); // [mo, di, mi]
		
		/*
		 * Achtung! Prüfung!
		 * 
		 * Die Liste, die von asList erzeugt wird, hat fixierte Größe!
		 */
		
		try {
			listStr.add("do");
			
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException!");
		}
		
		// Elemente zu ersetzen ist ok:
		listStr.set(1, "Dienstag");
		System.out.println("2. listStr: " + listStr); // [mo, Dienstag, mi]
		
		/*
		 * Unwahrscheinlich in der Prüfung:
		 * 
		 * Die Liste aus asList ist mit dem Array 'verbunden'
		 */
		System.out.println("\n* Test 'backed' list");
		
		Double[] array = { 12.1, 13.2, 14.5 };
		List<Double> listDouble = Arrays.asList(array);
		
		System.out.println("a. array: " + Arrays.toString(array));
		System.out.println("a. listDouble: " + listDouble);
		
		array[0] = -5.1;
		System.out.println("b. array: " + Arrays.toString(array));
		System.out.println("b. listDouble: " + listDouble);
		
		listDouble.set(2, -7.8);
		System.out.println("c. array: " + Arrays.toString(array));
		System.out.println("c. listDouble: " + listDouble);
	}

}
