package func;

import java.util.function.Function;

public class B11_Function {

	/*
	 * interface Function <T, R> {
	 * 		R apply(T param);
	 * }
	 */
	public static void main(String[] args) {
		// anonyme Klasse
		Function<String, Integer> f1 = new Function<String, Integer> () {
			public Integer apply(String s) {
				return s.length();
			}
		};

		int sum1 = computeSum(f1, "a", "bb", "ccc");
		System.out.println("sum1: " + sum1);
		
		// Lambda, ausführlich
		Function<String, Integer> f2 = (String s) -> {
			return s.length();
		};
		
		int sum2 = computeSum(f2, "a", "bb", "ccc");
		System.out.println("sum2: " + sum2);
		
		// Lambda, kompakt
		Function<String, Integer> f3 = s -> s.length();   
		
		int sum3 = computeSum(f3, "a", "bb", "ccc");
		System.out.println("sum3: " + sum3);
		
		/*
		 * Sehr kompakt, ohne Zwischenvariable
		 */
		int sum4 = computeSum(s -> s.length(), "a", "bb", "ccc");
		System.out.println("sum4: " + sum4);
	}

	static int computeSum(Function<String, Integer> f, String... strings) {
		System.out.println("*** Bilde Summe aus Werten, die die Function für Strings berechnet");
		
		int sum = 0;
		
		for(String s : strings) {
			int value = f.apply(s);
			sum += value;
		}
		
		return sum;
	}
	
}















