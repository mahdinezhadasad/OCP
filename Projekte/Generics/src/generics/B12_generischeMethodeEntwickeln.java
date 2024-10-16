package generics;

import java.time.LocalDate;

public class B12_generischeMethodeEntwickeln {

	public static void main(String[] args) {

		int x = getMax(12, -3);
		System.out.println("x = " + x);

		double d = getMax(33.0, 77.3);
		System.out.println("d = " + d);
		
		String s = getMax("mm", "aa");
		System.out.println("s = " + s);
		
		LocalDate date1 = LocalDate.of(2024, 1, 1);
		LocalDate date2 = LocalDate.of(2003, 1, 1);
		LocalDate date = getMax(date1, date2);
		System.out.println("date = " + date);
		
//		getMax(12, date1);     // darf nicht kompilieren (Typsicherheit)
//		getMax("moin", 33.0);  // darf nicht kompilieren (Typsicherheit)
//		getMax(12, 33.0);      // darf nicht kompilieren
//		getMax(new Thread(), new Thread()); // cf: Type Bound
	}
	
	static <T extends Comparable<? super T>> T getMax(T a, T b) {
		if(a.compareTo(b) > 0) {
			return a;
		}
		
		return b;
	}
	
	/*
	 * Mit der Methode kompiliert der Aufruf nicht:
	 * 
	 * 		LocalDate date = getMax(date1, date2);
	 * 
	 * Da: 
	 * 		LocalDate extends ChronoLocalDate
	 * Und:
	 * 		ChronoLocalDate implements Comparable<ChronoLocalDate>
	 * folgt:
	 * 
	 * 		LocalDate IST Comparable<ChronoLocalDate>
	 * 
	 * aber Typebound sagt, dass T muss Comparable<T> sein
	 */
//	static <T extends Comparable<T>> T getMax(T a, T b) {
//		if(a.compareTo(b) > 0) {
//			return a;
//		}
//		
//		return b;
//	}
	
	
//	static int getMax(int a, int b) {
//		if(a > b) {
//			return a;
//		}
//		
//		return b;
//	}
	
//	static double getMax(double a, double b) {
//		if(a > b) {
//			return a;
//		}
//		
//		return b;
//	}
}
