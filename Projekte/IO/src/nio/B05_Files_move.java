package nio;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class B05_Files_move {

	/*
	 * static Path move(Path source, Path target, CopyOption... options)
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
	 * - Methode move kann als Source ein Verzeichnis bekommen. 
	 *   Sie kann damit fürs Umbenennen verwendet werden..
	 */
	public static void main(String[] args) {
		
		Path sourceFile = Paths.get("autos-kopie-2.txt"); // existiert
		Path targetFile = Paths.get("mydir/autos.txt"); // nicht existiert
		
		try {
			// sicherstellen für den Test, dass es die Source-File gibt
			Files.copy(Paths.get("autos.txt"), sourceFile, 
					StandardCopyOption.REPLACE_EXISTING); 
			Files.deleteIfExists(targetFile); // Ziel-Datei aus alten Tests löschen
			
			Files.move(sourceFile, targetFile);
			System.out.println("1. Datei wurde verschoben");
			
			// sicherstellen für den Test, dass es die Source-File gibt
			Files.copy(Paths.get("autos.txt"), sourceFile, 
					StandardCopyOption.REPLACE_EXISTING);
			
			Files.move(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("2. Datei wurde verschoben, Zieldatei wurde überschrieben");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Exam! Achtung! 
		 * Das 2. Argument für die copy (und move) muss der Pfad sein, der
		 * auch den neuen Dateinamen hat:
		 */
		
		Path source = Paths.get("autos-kopie-2.txt"); // existiert
		Path target = Paths.get("mydir"); // existiert und ist nicht leeres Verzeichis
		
		try{
			// sicherstellen für den Test, dass es die Source-File gibt
			Files.copy(Paths.get("autos.txt"), sourceFile, 
					StandardCopyOption.REPLACE_EXISTING);
			
			Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (DirectoryNotEmptyException e) {
			System.out.println("3. Fehler! Das Ziel ist ein nichtleeres Verzeichnis, "
					+ "sollte aber die neue Datei sein");
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
