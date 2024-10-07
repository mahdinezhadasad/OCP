package list;

import java.util.ArrayList;
import java.util.List;

public class B01_List_basic_API {

	public static void main(String[] args) {
		/*
		 * Alle Methoden, die Collection deklariert
		 * 
		 * add(E e)
		 * size()
		 * clear()
		 * ...
		 */
		List<String> list = new ArrayList<>();
		
		list.add("mo");
		list.add("mi");
		list.add("fr");

		System.out.println("1. list: " + list); // [mo, mi, fr]
		
		/*
		 * Spezielle index-Methoden
		 * 
		 * 
		 */
		
		/* 
		 * add(int index, E e)
		 * 
		 * 					  0   1   2
		 * 		vorher:		[mo, mi, fr]
		 * 
		 * 					  0   1   2   3
		 * 		nacher:		[mo, di, mi, fr]
		 */
		int index = 1;
		list.add(index, "di");
		
		System.out.println("2. list: " + list); // [mo, di, mi, fr]
		
		list.add(4, "sa");
		
		System.out.println("3. list: " + list); // [mo, di, mi, fr, sa]
		
		/*
		 * set(int index, E e) : E
		 * 
		 */
		index = 2;
		
		String oldValue = list.set(index, "MITTWOCH");
		
		System.out.println("oldValue =  " + oldValue); // mi
		
		System.out.println("4. list: " + list); // [mo, di, MITTWOCH, fr, sa]
		
		/*
		 * E get(int index)
		 * 
		 * 
		 */
		System.out.println("list.get(1) = " + list.get(1)); // di
		
		/*
		 * 
		 * remove(int index)
		 */
		index = 2;
		
		String removedValue = list.remove(index);
		
		System.out.println("removedValue = " + removedValue); // MITTWOCH
		
		System.out.println("5. list: " + list); // [mo, di, fr, sa]
		
		/*
		 * indexOf
		 * lastIndexOf
		 * 
		 * liefern -1, wenn das Element nicht gefunden wird
		 */
		
		index = list.indexOf("fr");
		System.out.println("indexOf 'fr': " + index); // 2
		
		index = list.indexOf("mi");
		System.out.println("indexOf 'mi': " + index); // -1
		
		/*
		 * subList wird im nächsten Bsp. gezeigt
		 */
		
		/*
		 * weitere Methoden werden im Projekt 'Functional' 
		 * im Package 'collections' gezeigt
		 */
		
	}

}
