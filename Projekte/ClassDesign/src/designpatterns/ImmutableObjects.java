package designpatterns;

import java.time.LocalDate;

public class ImmutableObjects {

	/*
	 * Immutable Object: Klasse so gestalten, dass die Objekte davon 
	 * nicht geändert werden können.
	 */
	public static void main(String[] args) {
		/*
		 * Exam:
		 * 
		 * - String ist immutable
		 * - Wrapper-Klassen sind immutable
		 * - Klassen aus Date&Time sind immutable
		 */
		
		String s = "java";
		s.toUpperCase(); // erstellt neues Objekt
		System.out.println("1. s = " + s); // java
		
		s = s.toUpperCase(); // richtig das neue Objekt behalten
		System.out.println("2. s = " + s); // JAVA
		
		LocalDate d = LocalDate.of(2020, 3, 25);
		d.plusDays(3);
		System.out.println(d.getDayOfMonth()); // 25

		d = d.plusDays(3);
		System.out.println(d.getDayOfMonth()); // 28
		
		Integer x = 1200; // Integer.valueOf(1200)
		Integer y = x;
		
		x++; // x = Integer.valueOf( x.intValue() + 1 )
		
		System.out.println( x == y ); // false: zwei Referenzen, 
									  // die auf unterschiedliche 
									  // Integer-Objekte zeigen
	}

}
