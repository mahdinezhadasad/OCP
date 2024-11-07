package nio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B01_Pfade {

	public static void main(String[] args) throws Exception {
		/*
		 * Pfadangaben mit Strings
		 */

		/*
		 * absolute Pfade
		 */
		String p1 = "C:\\Windows\\Temp"; 	// Windows-Notation
		String p2 = "/Windows/Temp"; 		// Unix-Notation 
		
		/*
		 * relative Pfade (relativ zum aktuellen Arbeitsverzeichnis)
		 */
		
		String p3 = "dir\\subdir\\file"; 	// Windows-Notation
		String p4 = "dir/subdir/file"; 		// Unix-Notation
		
		/*
		 * Spezielle relative Pfadangaben:
		 * 
		 * 		.		- aktuelles Verzeichnis
		 *      ..		- Oberverzeichnis 
		 */
		
		/*
		 * Pfadangaben mit java.io.File (bereits vor Java 8, wird aber weiter verwendet)
		 * 
		 * 	Klasse File kann:
		 * 		- virtuell Pfade beschreiben
		 * 		- auf Dateisystem zugreifen
		 */
		
		File p5 = new File("C:\\Windows");
		System.out.println("p5: " + p5);
		
		File p6 = new File("/Windows");
		System.out.println("p6: " + p6);
		
		File p7 = new File("dirA\\dirB", "dirC\\file");
		System.out.println("p7: " + p7); // dirA\dirB\dirC\file
		
		File p8 = new File("dirA/dirB", "dirC/file");
		System.out.println("p8: " + p8); // dirA\dirB\dirC\file
		
		File pathAktuellRelativ = new File(".");
		File pathAktuellAbsolut = pathAktuellRelativ.getAbsoluteFile();
		System.out.println("Aktuelles Arbeisverzeichnis: " + pathAktuellAbsolut);
		
		File pathAktuellAbsolutNormalisiert = pathAktuellAbsolut.getCanonicalFile();
		System.out.println("Aktuelles Arbeisverzeichnis nomalisiert: " + pathAktuellAbsolutNormalisiert);
		
		
		/*
		 * Pfadangaben mit java.nio.file.Path (ab Java 8)
		 * 
		 * 	Interface Path kann:
		 * 		- virtuell Pfade beschreiben
		 * 
		 *  Klasse java.nio.file.Files kann:
		 * 		- auf Dateisystem zugreifen
		 * 
		 */
		Path p9 = Paths.get("C:\\Windows");
		Path p10 = Paths.get("dirA/dirB/dirC/file");
		Path p11 = Paths.get("dirA", "dirB/dirC/file");
		
		/*
		 * File to Path to File
		 */
		File f = new File(".");
		
		Path p = f.toPath();
		
		f = p.toFile();
		
	}

}
