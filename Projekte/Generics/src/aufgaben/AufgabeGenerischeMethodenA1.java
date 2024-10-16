package aufgaben;

import java.util.Date;
import java.util.Random;

public class AufgabeGenerischeMethodenA1 {

	public static void main(String[] args) {
		// Bitte definieren Sie eine generische statische Methode `getRandom`, 
		// die so verwendet werden darf:
			
		String s = getRandom("abc", "def"); // getRandom liefert zufällig entweder "abc" oder "def"
		System.out.println(s);
		
		Integer i = getRandom(14, 12);
		System.out.println(i); // entweder 14 oder 12

		Date d = getRandom(new Date(), new Date(0));  // java.util.Date
		System.out.println(d);
		
		Object obj = getRandom("hallo", 22); 
		System.out.println(obj); // entweder hallo oder 22
			
		// Dagegen darf folgende Aufruf nicht kompilieren:
			
//		String erg = getRandom("hallo", 22); // hier soll ein Compilerfehler entstehen

	}
	
	static <T> T getRandom(T a, T b) {
		if(new Random().nextBoolean()) {
			return a;
		}
		
		return b;
	}

}
