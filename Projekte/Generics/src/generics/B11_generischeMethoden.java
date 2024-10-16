package generics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NormaleKlasse {
	void normaleMethode() {}
	
	<T> void generischeMethode() {}
	
//	<T> static void generischeMethodeFalsch() {} // cf
//	static void <T> generischeMethodeFalsch2() {} // cf
	
	static <T> void generischeMethode2(T param) {}
	
	<T> T generischeMethode3(T param) {
		T tmp = param;
		return tmp; 
	}
}


class GenerischeKlasse <E> {
	
	E normaleMethode(E e) { return e; }
	
	// Die Methode hat ihre eigene Typariable,
	// es ist nicht die Typariable der Klasse
	<Z> Z generischeMethode(Z param, E param2) { return param; }
}

public class B11_generischeMethoden {

	/*
	 * - generische Methode: Methode mit eigenen Typparameter (Typvariable)
	 * 
	 * - generische Methode wird beim Aufruf parametrisiert
	 */
	public static void main(String[] args) {

		/*
		 * Beispiel. Methode asList der Klasse Arrays:
		 * 
		 * 		public static <T> List<T> asList(T... a)
		 */
		
		/*
		 * Parametrisieren durch das Übergeben von Integer[]:
		 * 
		 * 		List<Integer> asList(Integer[] param)
		 */
		List<Integer> listA = Arrays.asList(1, 2, 3);
		
		/*
		 * Parametrisieren durch das Übergeben von String[]:
		 * 
		 * 		List<String> asList(String[] param)
		 */
		List<String> listB = Arrays.asList("a", "b", "c");
		
		/*
		 * Beispiel. Methode reverseOrde aus Comparator:
		 * 
		 *  	 <T extends Comparable<? super T>> Comparator<T> reverseOrder()
		 *  
		 *  Vereinfacht:
		 *  	<T> Comparator<T> reverseOrder()
		 */
		
		/*
		 * Parametrisieren beim Zuweisen:
		 * 
		 * 		Comparator<String> reverseOrder()
		 */
		Comparator<String> cmp = Comparator.reverseOrder();
		
		/* 
		 * Typebound ist auch für generische Methoden möglich:
		 * 
		 *  	 <T extends Comparable<? super T>> Comparator<T> reverseOrder()
		 *  
		 *  Einschränkung: T muss Comparable sein
		 */
		
		/*
		 * Compilerfehler wegen des Typebound.
		 * 
		 * Thread ist nicht Comparable:
		 */
		// Comparator<Thread> cmp2 = Comparator.reverseOrder(); // cf
		
		
		/*
		 * Beispiel. Methode sort aus Collections
		 * 
		 * 		static <T extends Comparable<? super T>> void sort(List<T> list)
		 */
		
		/*
		 * Parametrisierung durch Argument List<String>:
		 * 
		 * 		void sort(List<String> list)
		 */
		List<String> listStr = Arrays.asList("mm", "bb", "ff", "aa");
		Collections.sort(listStr);
		
		/*
		 * Parametrisierung durch Argument List<LocalDate>:
		 * 
		 * 		void sort(List<LocalDate> list) 
		 */
		List<LocalDate> listDate = Collections.emptyList();
		Collections.sort(listDate);
		
		/*
		 * Parametrisierung durch Argument List<Thread>:
		 * 
		 * 		void sort(List<Thread> list)
		 * 
		 * Compilerfehler wegen des Typebound:
		 * 
		 * 		Thread ist nicht Comparable
		 */
		List<Thread> listThread = Arrays.asList(new Thread(), new Thread());
		// Collections.sort(listThread); // cf
		
	}

}
