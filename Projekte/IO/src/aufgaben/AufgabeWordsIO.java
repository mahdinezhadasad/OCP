package aufgaben;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import words.Words;

public class AufgabeWordsIO {

	public static void main(String[] args) {
		
		Path targetDir = Paths.get("wordFiles");
		
		/*
		 * A1
		 */
		List<String> listWords = Words.germanWords();
		Map<String, List<String>> mapFileNameToFileLines = buildFileContent(listWords);
		createFiles(targetDir, mapFileNameToFileLines);
		System.out.println("Dateien wurden erzeugt");
		
		/*
		 * A2
		 */
		deleteDirectory(targetDir);
		System.out.println("Verzeichnis gelöscht: " + targetDir);
	}
	
	static void deleteDirectory(Path dir) {
		if( !Files.isDirectory(dir) ) {
			throw new IllegalArgumentException("Es ist kein Verzeichnis: " + dir);
		}
		
//		try (Stream<Path> s = Files.list(dir)) {
//			
//			s.forEach(path -> {
//				try {
//					Files.delete(path);
//				} catch (IOException e) {
//					throw new UncheckedIOException(e);
//				}
//			});
//			
//			Files.delete(dir);
//			
//		} catch (IOException e) {
//			throw new UncheckedIOException(e);
//		}

		FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
			
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
		};
		
		try {
			Files.walkFileTree(dir, visitor);
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	static Map<String, List<String>> buildFileContent(List<String> listWords) {
		
		Function<String, String> classifier = word -> 
			(word.charAt(0) + ".txt").toLowerCase(); 
		
		return listWords.stream()
				.collect(Collectors.groupingBy(classifier));
	}
	
	static void createFiles(Path targetDir, Map<String, List<String>> mapContents) {
		if(Files.isRegularFile(targetDir)) {
			throw new IllegalArgumentException("Das Zielverzeichnis ist eine Datei: " + targetDir);
		}
		
		try {
			Files.createDirectories(targetDir);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
		try {
			for(String fileName : mapContents.keySet()) {
				List<String> lines = mapContents.get(fileName);
				
				Path file = targetDir.resolve(fileName);
				
				Files.write(file, lines);
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

}
