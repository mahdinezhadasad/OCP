package aufgaben;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import words.Words;

public class AufgabeWordsIO {

	public static void main(String[] args) {
		
		Path targetDir = Paths.get("wordFiles");
		
		/*
		 * A1
		 */
//		List<String> listWords = Words.germanWords();
//		Map<String, List<String>> mapFileNameToFileLines = buildFileContent(listWords);
//		createFiles(targetDir, mapFileNameToFileLines);
//		System.out.println("Dateien wurden erzeugt");
		
		/*
		 * A2
		 */
		deleteAll(targetDir);
		System.out.println("Verzeichnis gelöscht: " + targetDir);
	}
	
	
	
	static Map<String, List<String>> buildFileContent(List<String> listWords) {
		
		Function<String, String> classifier = word -> word.charAt(0) + ".txt"; 
		
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
