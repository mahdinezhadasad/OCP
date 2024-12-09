package io;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestFilesCopyMoveMitDateien {

	public static void main(String[] args) {

		TestUtils.deleteIfExists(Paths.get("mydata"));
		
		Path dir1 = TestUtils.createNonemptyTestDir("dir1");

		Path source = Paths.get("mydata/dir1/file0.txt");
		
		Path target = Paths.get("mydata"); // falsch
		
		try {
			Files.copy(source, target);
		} catch (FileAlreadyExistsException e) {
			System.out.println("a. Falsch! Exception: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			Files.move(source, target);
		} catch (FileAlreadyExistsException e) {
			System.out.println("b. Falsch! Exception: " + e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Richtig: target-Pfad soll den den neuen Dateinamen auch beinhalten
		 */
		target = Paths.get("mydata/fileA.txt"); // richtig
		
		try {
			Files.copy(source, target);
			
			System.out.println("c. Datei kopiert");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		target = Paths.get("mydata/fileB.txt"); // richtig
		try {
			source = Paths.get("mydata/dir1/file1.txt");
			Files.move(source, target);
			
			System.out.println("d. Datei kopiert");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
