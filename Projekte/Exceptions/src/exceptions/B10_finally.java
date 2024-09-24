package exceptions;

import java.io.FileReader;
import java.io.IOException;

public class B10_finally {

	/*
	 *  - finally läuft immer, wenn der try (und evtl. catch) beendet wird
	 *  
	 *  - in dem finally-Block kann man garantiert 'Ressourcen' schliessen
	 * 
	 *  - Sinnvolles Bsp. gibt es im Projekt 'Threads' (Interface 'Lock') 
	 */
	public static void main(String[] args) {
		vorJava7();
	}

	/*
	 * In dem finally-Block wird die Ressource garantiert geschlossen,
	 * falls sie geöffnet wird.
	 * So hat man programmiert, bevor es in Java try-with-resources gab:
	 */
	static void vorJava7() {
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("file.txt");
			
			// Datei lesen...
			// andere Sachen erledigen...
			// Datei lesen...
			// andere Sachen erledigen...
			System.out.println("Datei geöffnet");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fr!=null) {
					fr.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
