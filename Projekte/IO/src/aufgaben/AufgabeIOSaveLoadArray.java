package aufgaben;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AufgabeIOSaveLoadArray {

	public static void main(String[] args) {

		int len = new java.util.Random().nextInt(100) + 1;
		
		int[] arr1 = MyArrayUtils.createArray(len, -20, 21);
		
		System.out.println("arr1: " + Arrays.toString(arr1));
	
		saveArray(arr1, "array.txt");
		
		int[] arr2 = loadArray("array.txt");
		
		System.out.println("arr2: " + Arrays.toString(arr2));
	}
	
	
	static void saveArray(int[] arr, String fileName) {
		try(BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
			
			for(int x : arr) {
//				out.write(x); // falsch! Diese Methode ist zum Speichern von einem char!
				out.write(String.valueOf(x));
				out.newLine();
			}
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	static int[] loadArray(String fileName) {
		
		List<Integer> values = new ArrayList<>();
		
		try(BufferedReader in = new BufferedReader(new FileReader(fileName))) {
			
			String line;
			while( (line = in.readLine()) != null ) {
				int x = Integer.parseInt(line);
				values.add(x);
			}
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
		return values.stream().mapToInt(x -> x).toArray();
	}
	
}
