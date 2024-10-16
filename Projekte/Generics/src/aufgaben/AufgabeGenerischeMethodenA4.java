package aufgaben;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.TreeSet;
import java.util.function.Supplier;

public class AufgabeGenerischeMethodenA4 {

	public static void main(String[] args) {
		
		String[] arrStr = { "a", "b", "c" };
		
		/*
		 * Parametrisierung:
		 * 
		 * 		build( Supplier<ArrayDeque<???> s, String[] values )
		 * 		A = String
		 * 		T = ArrayDeque<String>
		 */
		ArrayDeque<String> deque = build(ArrayDeque::new, arrStr);
		System.out.println("deque: " + deque);

		Integer[] arrInt = { 7, -3, 7, 22, 7, 11 };
		
		TreeSet<Integer> treeSet = build(TreeSet::new, arrInt);
		System.out.println("treeSet: " + treeSet);
	}

	@SafeVarargs
	public static <A, T extends Collection<A>> T build( Supplier<T> s, A... values ) {
						
		T c = s.get();
		for (A a : values) {
			c.add(a);
		}
		return c;
	}
	
	static void testSupplier() {
		Supplier<ArrayDeque<String>> supp = new Supplier<ArrayDeque<String>> () {
			public ArrayDeque<String> get() {
				return new ArrayDeque<>();
			}
		};
		
		Supplier<ArrayDeque<String>> supp2 = () -> {
			return new ArrayDeque<>();
		};
		
		Supplier<ArrayDeque<String>> supp3 = () -> new ArrayDeque<>();
		
		Supplier<ArrayDeque<String>> supp4 = ArrayDeque::new;
	}
	
}
