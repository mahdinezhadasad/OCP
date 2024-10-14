package generics;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B10_Diamond {

	/*
	 * Diamond-Operator = Type-Inference-Operator
	 */
	public static void main(String[] args) {

		/*
		 * Ohne Diamond-Operator:
		 */
		Map<LocalDateTime, List<String>> map = 
				new HashMap<LocalDateTime, List<String>>(); 

		/*
		 * Mit Diamond-Operator:
		 */
		Map<LocalDateTime, List<String>> map2 = 
				new HashMap<>(); 

		/*
		 * Warum überhaupt den Konstruktor-Aufruf parametrisieren,
		 * wenn es Erasure gibt?
		 * 
		 * Ein Beispiel.
		 * Die Klasse Array list hat unter anderem die Konstruktoren:
		 * 
		 * ArrayList()
		 *   und
		 * ArrayList(Collection<? extends E> c)
		 */
		List<Integer> listA = new ArrayList<Integer>();
		// List<Integer> listA2 = new ArrayList<Double>();
		List<Integer> listB = new ArrayList<>();
		
		// zuerst war es so: listC = new ArrayList<Double>()
		// danach geändert zu: listC = new ArrayList<Double>(listA)
		// List<Double> listC = new ArrayList<Double>(listA); // cf: listA ist ArrayList<Integer>
	
		// List<Double> listD = new ArrayList<>(listA); // cf
		List<Number> listE = new ArrayList<>(listA);
		
		/*
		 * Parametrisierung kann auch durch den Aufruf entstehen
		 */
		new ArrayList<>();      // <Object>
		new ArrayList<>(listA); // <Integer>
		
		/*
		 * Exam: 
		 * 		- Diamond nur für Konstruktoraufrufe
		 * 		- Platzhalter nie bei einem Konstruktoraufruf 
		 */
		List<Integer> list1 = new ArrayList<>();
 		// List<> list2 = new ArrayList<Integer>(); // cf
		
		List<?> list3 = new ArrayList<Integer>();
		//List<Integer> list4 = new ArrayList<?>();
		
	}

}
