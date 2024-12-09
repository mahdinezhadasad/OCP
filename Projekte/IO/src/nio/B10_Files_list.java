package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class B10_Files_list {

	public static void main(String[] args) {
		
		System.out.println("*** Items aus dem Verzeichnis src: ");
		Path dir = Paths.get("src");
		
		try (Stream<Path> s = Files.list(dir)) {
			
			s.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n*** Alle Items aus dem aktuellen Arbeitsverzeichnis: ");
		dir = Paths.get(".");
		
		try (Stream<Path> s = Files.list(dir)) {
			
			s.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
