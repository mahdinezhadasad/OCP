package aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class AufgabeCollectionsFunctional {
	
	public static void main(String[] args) {
		// a1();
		// a2();
		// a3();
		// a4();
		List<Integer> list = Arrays.asList(5, 2, 3, -6, -7, 42, null, 0, 77, 3);
		// Variante 1 über eigenen Consumer
		class SumConsumer implements Consumer<Integer> {
			int summe = 0;
			@Override
			public void accept(Integer i) {
				if (i != null) {
				  summe += i;
				}		
			}		
		}
		SumConsumer sumCon = new SumConsumer();
		list.forEach(sumCon);
		System.out.println("summe = " + sumCon.summe);
		
		// Variante 2 mit Stream
		int summe = list.stream().filter(i -> i != null).mapToInt(x -> x).sum();
		System.out.println("summe = " + summe);
	}
	
	static void a1() {
		List<Integer> list = Arrays.asList(5, 2, 3, -6, -7, 42, 0, 77, 3);
		Iterable<Integer> it = list;
		Consumer<Integer> consumer = (Integer i) -> System.out.println(i);
		consumer = i -> System.out.println(i);
		consumer = System.out::println;
		it.forEach(consumer);
		// Kurzform
		// list.forEach(System.out::println);
	}
	
	static void a2() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		Predicate<Integer> pred = i -> i % 2 == 1;
		System.out.println("vorher: " + list);
		// list.removeIf(pred);
		list.removeIf(i -> i % 2 == 1);
		System.out.println("nachher: " + list);
	}
	
	static void a3() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		UnaryOperator<Integer> op = i -> i % 2 == 1 ? 0 : i;
		System.out.println("vorher: " + list);
		list.replaceAll(op);
		System.out.println("nachher: " + list);
	}
	
	static void a4() {
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
		
		// anonyme Klasse
		Comparator<Integer> comp = new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
			
		};
		
		// Lambda-Funktion
		comp = (i1, i2) -> i2 - i1;
		
		// Methodenreferenz
		comp = MyUtil::reverseOrder;
		
		
		System.out.println("vorher: " + list);
		list.sort(comp);
		System.out.println("nachher: " + list);
	}

}

class MyUtil {
	
	static int reverseOrder(Integer i1, Integer i2) {
		return Integer.compare(i2, i1);
	}
}
