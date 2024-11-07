package nio;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class B04_Files_copy {

	/*
	 * static Path copy(Path source, Path target, CopyOption... options)
	 * 	throws IOException
	 * 
	 * - eine mögliche CopyOption in der Prüfung:
	 * 
	 * 		StandardCopyOption.REPLACE_EXISTING
	 * 
	 * - Source-File muss existieren
	 * - ohne REPLACE_EXISTING-Option: Target-File darf nicht existieren
	 * - Zielverzeichnis muss existieren
	 * 
	 *   Unwahrscheinlich in der Prüfung:
	 * - Methode copy kann als Source ein Verzeichnis bekommen. Sie erstellt 
	 *   dabei ein neues LEERES Verzeichnis. Sie kann keine Inhalte aus dem 
	 *   Source-Verzeichnis kopieren.
	 * 
	 */
	public static void main(String[] args) {

		Path sourceFile1 = Paths.get("nichtda");
		Path targetFile1 = Paths.get("nichtda-kopie");
		
		try {
			// Files.copy(sourceFile1, targetFile1, StandardCopyOption.REPLACE_EXISTING);
			Files.copy(sourceFile1, targetFile1);
		} catch (NoSuchFileException e) {
			System.out.println("1. Fehler! Source-File existiert nicht");
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		sourceFile1 = Paths.get("autos.txt"); // existiert
		targetFile1 = Paths.get("autos-kopie.txt"); // existiert bereits
		
		try {
			Files.copy(sourceFile1, targetFile1);
			
		} catch (FileAlreadyExistsException e) {
			System.out.println("2. Fehler! Target-File existiert bereits!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sourceFile1 = Paths.get("autos.txt"); // existiert
		targetFile1 = Paths.get("autos-kopie-2.txt"); // existiert noch nicht
		
		try {
			Files.deleteIfExists(targetFile1); // Datei aus dem letzten Test löschen
			
			Files.copy(sourceFile1, targetFile1);
			System.out.println("3. Datei wurde kopiert");
			
			Files.copy(sourceFile1, targetFile1, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("4. Datei wurde kopiert, Zieldatei wurde überschrieben");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Exam! Achtung! 
		 * Das 2. Argument für die copy (und move) muss der Pfad sein, der
		 * auch den neuen Dateinamen hat:
		 */
		
		Path source = Paths.get("autos.txt"); // existiert
		Path target = Paths.get("mydir"); // existiert und ist nicht leeres Verzeichis
		
		try{
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (DirectoryNotEmptyException e) {
			System.out.println("5. Fehler! Das Ziel ist ein nichtleeres Verzeichnis, "
					+ "sollte aber die neue Datei sein");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
