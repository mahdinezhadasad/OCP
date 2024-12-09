package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestFilesMove {

	public static void main(String[] args) {
		
		Path dir1 = TestUtils.createNonemptyTestDir("dir1");
		System.out.println("dir1: " + dir1);
		
		Path dir2 = Paths.get("mydata/dir2");
		TestUtils.deleteIfExists(dir2);

		/*
		 * Das Zielverzeichnis existiert nicht
		 */
		try {
			Files.move(dir1, dir2);
			System.out.println("a. Umbenannt: " + dir2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Das Zielverzeichnis existiert bereits. Exception
		 */
		dir1 = TestUtils.createNonemptyTestDir("dir1");
		
		try {
			Files.move(dir1, dir2);
			
		} catch (IOException e) {
			System.out.println("b. Exception: " + e);
		}
		
		/*
		 * Das NICHTLEERES Zielverzeichnis existiert bereits. 
		 */
		dir1 = TestUtils.createNonemptyTestDir("dir1");
		
		try {
			Files.move(dir1, dir2, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			System.out.println("c. Exception: " + e);
		}
		
		
	}

}
