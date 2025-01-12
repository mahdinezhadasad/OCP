package aufgaben;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.util.Arrays;

public class AufgabeIOSaveLoadArrayMitSerialisieren {

	public static void main(String[] args) {

		int len = new java.util.Random().nextInt(100) + 1;
		
		int[] arr1 = aufgaben.MyArrayUtils.createArray(len, -20, 21);
		
		System.out.println("arr1: " + Arrays.toString(arr1));
	
		saveArray(arr1, "array.bin");
		
		int[] arr2 = loadArray("array.bin");
		
		System.out.println("arr2: " + Arrays.toString(arr2));
	}

	static void saveArray(int[] array, String fileName) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
			oos.writeObject(array);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	static int[] loadArray(String fileName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
			return (int[])ois.readObject();
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
}