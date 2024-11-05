package aufgaben;

import java.util.Random;

public class MyArrayUtils {

	/**
	 * Erzeugt ein Array mit Zufallswerten
	 * 
	 * @param length Die Größe des Arrays
	 * @param min kleinstmöglicher Zufallswert inklusive
	 * @param max größtmöglicher Zufallswert exklusive
	 * @return
	 */
	public static int[] createArray(int length, int min, int max) {
		if(min>=max) {
			throw new IllegalArgumentException("min muss kleiner als max sein");
		}
		
		Random rnd = new Random();
		
		int[] arr = new int[length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rnd.nextInt(max-min) + min;
		}
		
		return arr;
	}
	
//	public static void main(String[] args) {
//		System.out.println( Arrays.toString(createArray(10, -1, 0)) );
//	}

}
