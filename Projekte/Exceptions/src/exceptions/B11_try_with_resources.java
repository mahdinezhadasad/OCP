package exceptions;

import java.io.FileReader;
import java.io.IOException;

class MeineRessource implements AutoCloseable {
	public void close() {
	}
}

public class B11_try_with_resources {

	public static void main(String[] args) {

		/*
		 * So kann man garantiert eine Ressource mit
		 * try-with-resources schliessen:
		 */
		try (FileReader fr = new FileReader("file.txt")) {
			// Datei lesen hier...
			System.out.println("Datei geöffnet");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * Achtung!
		 * Mit try-with-resources funktionieren NUR
		 * die Typen, die das Interface AutoCloseable als
		 * Basistyp haben.
		 */
		
//		try(String s = new String("abc")) { // cf: String ist nicht AutoCloseable
//			
//		}
		
		/*
		 * Achtung!
		 * Nach dem try-with-resources muss kein catch oder finally stehen
		 */
		
//		try {} // cf: nach dem try-Block muss catch oder finally stehen
		
		try (MeineRessource r = new MeineRessource()) {
			
		}
		
		/*
		 * Nach dem try-with-ressources kann alles stehen,
		 * was nach einem try-Block stehen kann
		 */
		try (MeineRessource r = new MeineRessource()) {
			
		} catch (Exception e) {
			
		}
		
		try (MeineRessource r = new MeineRessource()) {
			
		} finally {
			
		}
		
	}

}
