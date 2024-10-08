package aufgaben;

import java.util.Iterator;

class MyList implements Iterable<String> {
	private static final int maxSize = 10;
	
	private String[] data = new String[maxSize];
	
	private int nextFreePos = 0;
	
	public void add(String s) {
		if(size() == maxSize) {
			throw new IllegalStateException("Kein Platz mehr");
		}
		
		data[nextFreePos] = s;
		nextFreePos++;
	}
	
	public int size() {
		return nextFreePos;
	}
	
	public String get(int index) {
		if(index < 0 || index >= maxSize) {
			throw new IndexOutOfBoundsException("Falscher Index: " + index);
		}
		
		if(index >= nextFreePos) {
			throw new IndexOutOfBoundsException("Position nicht belegt: " + index);
		}
		
		return data[index];
	}
	
	public Iterator<String> iterator() {
		return new MyIterator();
	}
}

public class AufgabeListIterable {

	public static void main(String[] args) {
		
		MyList list = new MyList();
		System.out.println("1. size: " + list.size()); // 0
		
		list.add("s0");
		System.out.println("2. size: " + list.size()); // 1
		
		for (int i = 1; i < 10; i++) {
			list.add("s"+i);
		}
		System.out.println("3. size: " + list.size()); // 10

		try {
			list.add("moin");
		} catch (IllegalStateException e) {
			System.out.println("4. Exception! MyList ist voll");
		}
		
		System.out.println("\n----- neue MyList");
		
		list = new MyList();
		
		System.out.println("1. size: " + list.size()); // 0
		
		try {
			list.get(0);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("2. Exception! Pos. 0 ist nicht belegt");
		}
		
		list.add("mo");
		list.add("di");
		list.add("mi");
		
		String s = list.get(1);
		System.out.println("3. get(1): " + s); // di
		
		try {
			list.get(-1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("4. Exception! Negativer Index");
		}
		
		System.out.println("\n*** forEach: ");
		
		for(String str : list)  {
			System.out.println(str);
		}
		
	}

}
