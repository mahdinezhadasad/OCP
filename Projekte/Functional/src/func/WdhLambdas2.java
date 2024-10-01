package func;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class WdhLambdas2 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
//		Predicate<Object> p = x -> list.add(x); // cf
		
		/*
		 * eine Klasse nachbilden:
		 * 
		 * class Blabla implements Predicate<Object> {
		 * 
		 * 		public boolean test(Object x) {
		 * 			return list.add(x); // cf: Object-Argument
		 *      }
		 * 
		 * }
		 * 
		 */

		
		StringBuilder sb = new StringBuilder();
//		Predicate<Object> p2 = i -> sb.append(i).append(" "); // cf
		
		/*
		 * eine Klasse nachbilden:
		 * 
		 * class Blabla implements Predicate<Object> {
		 * 
		 * 		public boolean test(Object i) {
		 * 			return sb.append(i).append(" "); // cf: return StringBuilder
		 * 		}
		 * 
		 * }
		 * 
		 */

	}

}
