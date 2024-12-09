package io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;

public class TestUtils {

	/**
	 * Erzeugt im Projektverzeichnis im Unterverzeichnis 'mydata'
	 * das neue Verzeichnis mit dem gewünschten Namen.
	 * In dem Verzeichnis werden zwei Textdateien erzeugt.
	 */
	static Path createNonemptyTestDir(String dirName) {
		
		Path root = Paths.get("mydata");
		try {
			Path dir = root.resolve(dirName);
			
			deleteIfExists(dir);
			
			Files.createDirectories(dir);
			
			List<String> lines = Arrays.asList("line 1", "line 2", "line 3");
			
			for (int i = 0; i < 2; i++) {
				Path file = dir.resolve("file" + i + ".txt");
				Files.write(file, lines);
			}
			
			return dir;

		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
//	static void copyDeep(Path sourceDir, Path targetDir) {
//		if(!Files.isDirectory(sourceDir)) {
//			throw new IllegalArgumentException("es mus ein Verzeichnis sein: " + sourceDir);
//		}
//		
//		Files.createDirectories(targetDir);
//		
//		//...
//	}
	
	static void deleteIfExists(Path dir) {
		
		if(!Files.isDirectory(dir)) {
			return;
		}
		
		FileVisitor<Path> visitor = new SimpleFileVisitor<Path> () {
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}
		};

		try {
			Files.walkFileTree(dir, visitor);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
}
