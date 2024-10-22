package aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class AufgabeStreamBilden {

	public static void main(String[] args) {
		// a1();
		// a2();
		// a3();
		// a4();
		// a5();
		
	}
	
	static void a5() {
		// Version 1
		Collection<String> coll = new ArrayList<>();
		coll.add("/a");
		coll.add("/a/b");
		coll.add("/a/b/c");
		coll.add("/a/b/c/d");
		coll.stream().forEach(System.out::println);
		
		// Version 2
		Stream.of("/a", "/a/b", "/a/b/c", "/a/b/c/d").forEach(System.out::println);
		
		// Version 3
		UnaryOperator<String> op = s -> {
			int nextChar = s.charAt(s.length()-1) + 1;
			return s + "/" + (char)nextChar;
		};
		Stream.iterate("/a", op)
			.limit(4)
			.forEach(System.out::println);
	}
	
	static void a4() {
		String[] a1 = { "a", "b" };
	    String[] a2 = { "c", "d" };
		Stream.concat(Arrays.stream(a1),Arrays.stream(a2)).forEach(System.out::println);
	}
	
	static void a3() {
		Stream.iterate(100, i -> i - 1).limit(100).forEach(System.out::println);
	}
	
	static void a2() {
		Stream.generate(Test::nextInt).limit(99).forEach(System.out::println);
	}
	
	static void a1() {
		List<Integer> list1 = Arrays.asList( 1, 2, 3 );
		List<Integer> list2 = Arrays.asList( 55, 77 );
		
		Stream.of(list1, list2).forEach(l -> System.out.println("size = " + l.size() + ". elements = " + l));

	}
	
	

}

class Test {
	
	 static Integer nextInt() {
	        return new Random().nextInt();
	 }
}
