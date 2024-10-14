package generics;

import java.util.ArrayList;
import java.util.List;

public class ArraysUndGenerics <T> {
	
	
	T[] arr;
	
	void test() {
//		T[] ref = new T[2]; // cf: keine Generic-Arrays möglich
		
		List<T> ref2 = new ArrayList<T>();
	}
	

	/*
	 * Arrays unterstützen Generics schlecht
	 */
	public static void main(String[] args) {

		

	}

}
