package enums;

import java.util.Arrays;

enum Color {
	RED, GREEN, BLUE // statische Konstanten vom Typ Color
	
	// default-enum-Constructor:
	// private Color() ...
}

public class WasJedeEnumKlasseHat {

	public static void main(String[] args) {
		
		Color v1 = Color.BLUE;	// static
		// Color.BLUE = null;   // final
		
		/*
		 * statische Methoden 
		 */
		Color[] allColors = Color.values();
		System.out.println("1. values(): " + Arrays.toString(allColors));
		
		Color v2 = Color.valueOf("GREEN");
		System.out.println("2. v2 = " + v2); // GREEN
		
		/*
		 * Instanzmethoden
		 */
		String name = v2.name();
		System.out.println("3. name = " + name); // GREEN
		
		int ord = v2.ordinal();
		System.out.println("4. ordinal = " + ord); // 1
		
		/*
		 * jede enum ist Comparable
		 */
		Comparable<Color> c1 = Color.BLUE;
		
		int result = v2.compareTo(v1);
		System.out.println("5. GREEN compareTo BLUE = " + result); // negativ

	}

}
