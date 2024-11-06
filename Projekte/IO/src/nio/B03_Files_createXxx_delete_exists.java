package nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class B03_Files_createXxx_delete_exists {

	public static void main(String[] args) {
		
		/*
		 * static boolean exists(Path path, LinkOption... options)
		 */
		Path p1 = Paths.get("nichtda");
		System.out.println("p1: " + p1);
		
		boolean result = Files.exists(p1);
		System.out.println("Existiert p1: " + result); // false
		
		Path p2 = Paths.get("src");
		result = Files.exists(p2);
		System.out.println("Existiert p2: " + result); // true
		
		/*
		 * static Path createFile(Path path, FileAttribute<?>... attrs)
                             throws IOException
                             
              - Datei darf nicht existieren
              - Das Parent-Verzeichnis muss existieren
		 */
		
		Path path = Paths.get("hallo");
		
		try {
			Files.createFile(path);
			System.out.println("1. Datei hallo erzeugt");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * static void delete(Path path) throws IOException
		 * 
		 * 		kann eine Datei oder ein leeres Verzeichnis löschen
		 */
		try {
			Files.delete(path);
			System.out.println("2. Datei hallo gelöscht");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * static Path createDirectory(Path dir, FileAttribute<?>... attrs)
                            throws IOException
                            
              - Das Verzeichnis darf nicht existieren 
		      - Das Parent-Verzeichnis muss existieren
		 */
		Path dirPath = Paths.get("mydir.txt");
		
		try {
			Files.createDirectory(dirPath);
			System.out.println("3. Verzeichnis mydir.txt erzeugt");
			
			Files.delete(dirPath);
			System.out.println("4. Verzeichnis mydir.txt gelöscht");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		 * static Path createDirectories(Path dir, FileAttribute<?>... attrs)
                             throws IOException
		 */
		dirPath = Paths.get("dir/subdir/subsubdir");
		try {
			Files.createDirectories(dirPath);
			System.out.println("5. Die Struktur dir/subdir/subsubdir wurde erzeugt");
			
			Files.createDirectories(dirPath);
			System.out.println("6. Nach dem 2. Aufruf der createDirectories");

			System.out.println("7. Aufräumen");
			while(dirPath!=null) {
				Files.delete(dirPath);
				System.out.println("gelöscht: " + dirPath);
				dirPath = dirPath.getParent();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * static boolean deleteIfExists(Path path) throws IOException 
		 * 
		 * - kann eine Datei löschen  
		 * - kann ein leeres Verzeichnis löschen (muss leer sein)
		 * - wirft keine Exception, wenn das Element nicht existiert
		 */
		
		try {
			path = Paths.get("nichtda");
			System.out.println("8. path: " + path);
			
			boolean existierteUndWurdeGeloescht = Files.deleteIfExists(path);
			System.out.println("8. existierte und wurde geloescht: " + 
					existierteUndWurdeGeloescht); // false
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
