package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B03_Arrays_asList_List_toArray {

	public static void main(String[] args) {
		
		List<String> listGehtAuch = new ArrayList<>();
		listGehtAuch.add("mo");
		listGehtAuch.add("di");
		listGehtAuch.add("mi");
		
//		List<String> listAbJava9 = List.of("mo", "di", "mi"); // nicht in der Prüfung
		
		/*
		 * static <T> List<T> asList(T... a)
		 */
		List<String> listStr = Arrays.asList("mo", "di", "mi");
		
		System.out.println("1. listStr: " + listStr);
		
	}

}
