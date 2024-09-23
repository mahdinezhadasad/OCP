package exceptions;

import java.util.Random;

public class B03_try_catch_Kombinationen {

	public static void main(String[] args) {

		/*
		 * Alle Exceptions gleich behandeln
		 */
		try {
			methodeMitExc();
		} catch (Exception e) {
			System.out.println("1. abgefangen: " + e);
		}
		
		
		
	}
	
	static void methodeMitExc() {
		switch(new Random().nextInt(3)) {
			case 0: throw new ArithmeticException();
			case 1: throw new NumberFormatException();
			default: throw new IllegalArgumentException();
		}
	}

}
