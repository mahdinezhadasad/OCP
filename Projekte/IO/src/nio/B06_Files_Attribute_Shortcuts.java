package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class B06_Files_Attribute_Shortcuts {

	/*
	 * Hinweise zu den Atributen:
	 * 
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/BasicFileAttributes.html
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/DosFileAttributes.html
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/PosixFileAttributes.html
	 * 
	 * Oder:
	 * 
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/BasicFileAttributeView.html
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/DosFileAttributeView.html
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/PosixFileAttributeView.html
	 * 
	 */
	
	public static void main(String[] args) {
		testShorcuts(Paths.get("nichtda"));
		testShorcuts(Paths.get("mydir"));
		testShorcuts(Paths.get("autos.txt"));
	}
	
	/*
	 * static boolean isDirectory(Path path, LinkOption... options)
	 * static boolean isRegularFile(Path path, LinkOption... options)
	 * static long size(Path path) throws IOException 
	 * static FileTime getLastModifiedTime(Path path, LinkOption... options) throws IOException
	 * 
	 */
	static void testShorcuts(Path path) {
		System.out.println("\n***");
		System.out.println("path: " + path);
		
		boolean result = Files.isDirectory(path);
		System.out.println("isDirectory: " + result); // false
		
		result = Files.isRegularFile(path);
		System.out.println("isRegularFile: " + result); // false
		
		try {
			result = Files.isHidden(path);
			System.out.println("isHidden: " + result);
		} catch (IOException e) {
			System.out.println("isHidden hat IOException geworfen: " + e.getMessage());
		}
		
		try {
			long size = Files.size(path);
			System.out.println("size: " + size + " byte");
		} catch (IOException e) {
			System.out.println("size hat IOException geworfen: " + e.getMessage());
		}
		
		try {
			FileTime time = Files.getLastModifiedTime(path);
			System.out.println("getLastModifiedTime: " + time);
		} catch (IOException e) {
			System.out.println("getLastModifiedTime hat IOException geworfen: " + e.getMessage());
		}
		
	}

}
