package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TestFilesCopy {

	public static void main(String[] args) throws IOException {
		
		Path dir1 = io.TestUtils.createNonemptyTestDir("dir1");
		Path dir2 = Paths.get("mydata/dir2");
		
		Files.copy(dir1, dir2, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Kopiert");

	}

}