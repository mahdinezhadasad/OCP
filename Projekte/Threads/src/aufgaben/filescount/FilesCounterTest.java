package aufgaben.filescount;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;

import Threads.src.aufgaben.filescount.FilesCounter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FilesCounterTest {
	
	@Test
	void testCount(@TempDir Path dir) throws Exception {
		
		Path file = dir.resolve("file1.txt"); // 1
		Files.createFile(file);
		
		file = dir.resolve("file2.tXt"); // 2
		Files.createFile(file);
		
		file = dir.resolve("file3.txT"); // 3
		Files.createFile(file);
		
		file = dir.resolve("file4.txt.jpg");
		Files.createFile(file);
		
		file = dir.resolve("file5.pdf");
		Files.createFile(file);
		
		Path subdir = dir.resolve("subdir");
		Files.createDirectories(subdir);
		
		file = subdir.resolve("file1.txt"); // 4
		Files.createFile(file);
		
		file = subdir.resolve("file2.tXt"); // 5
		Files.createFile(file);
		
		file = subdir.resolve("file5.xls");
		Files.createFile(file);
		
		FilesCounter instance = new FilesCounter(dir);
		
		int actual = instance.getCount("txt");
		int expected = 5;
		
		assertEquals(expected, actual);
	}

}