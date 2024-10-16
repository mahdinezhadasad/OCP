package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsUndArrays <T> {
	
	
	T[] arr;
	
	void test() {
//		T[] ref = new T[2]; // cf: keine Generic-Arrays möglich
		
		List<T> ref2 = new ArrayList<T>();
	}
	

	/*
	 * Arrays unterstützen Generics schlecht
	 */
	public static void main(String[] args) {
		Number[] arr = new Integer[10];
		testGenericUndArray(22.0, arr);
		
		// zum Vergleich:
//		List<Number> list = new ArrayList<Integer>(); // cf
	}
	
	static <A> void testGenericUndArray(A value, A... arr) {
		// Generics garantieren keine absolüte Typsicherheit
		// bei Arrays. Das Array kann beschädigt werden:
		if(arr.length>0) {
			arr[0] = value; // evtl. ArrayStoreException
		}
	}

}
