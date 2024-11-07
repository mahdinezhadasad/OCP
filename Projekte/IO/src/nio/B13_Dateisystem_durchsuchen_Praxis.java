package nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class B13_Dateisystem_durchsuchen_Praxis {

	/*
	 * Nicht prüfungsrelevant
	 */
	public static void main(String[] args) {
//		mitWalk();
		mitWalkFileTree();
	}
	
	/*
	 * walkFileTree ist nicht in der Prüfung
	 */
	static void mitWalkFileTree() {
		/*
		 * Aufgabe: Anzahl der Dateien (rekursiv) ermitteln
		 */ 
//		Path start = Paths.get("src");
		Path start = Paths.get("C:\\");
		
		AtomicLong count = new AtomicLong();
		
		FileVisitor<Path> visitor = new FileVisitor<Path>() {
			
			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				System.out.println("Fehler beim Zugriff: " + exc);
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				// System.out.println("Datei gefunden: " + file);
				count.incrementAndGet();
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				//System.out.println("ein weiteres Verzeichnis gefunden: " + dir);
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				//System.out.println("mit dem Verzeichnis fertig: " + dir);
				return FileVisitResult.CONTINUE;
			}
		};
		
		try {
			Files.walkFileTree(start, visitor);
			System.out.println("count: " + count.get());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void mitWalk() {
		
		/*
		 * Aufgabe: Anzahl der Dateien (rekursiv) ermitteln
		 * 
		 * Wenn walk ein Verzeichnis liest, das nicht gelesen werden darf,
		 * wirft sie eine Exception
		 */
//		Path start = Paths.get("src");
		Path start = Paths.get("C:\\");

		System.out.println("Verzeichnis: " + start);

		try( Stream<Path> s = Files.walk(start) ) {
			
			long count = s
					.filter(Files::isRegularFile)
					.collect(Collectors.counting());

			System.out.println("Anzahl der Dateien: " + count);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
