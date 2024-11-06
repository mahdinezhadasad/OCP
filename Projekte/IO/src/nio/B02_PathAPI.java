package nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B02_PathAPI {

	public static void main(String[] args) {
		bilden();
		test_getNameCount_getName_subpath();
		test_();
	}
	static void test_() {
		System.out.println("\n*** ");
		
		Path p1 = Paths.get("C:\\Windows\\MyDir");
		
		// The file name is the farthest element from the root in the directory hierarchy
		Path fileName = p1.getFileName();
		System.out.println("getFileName: " + fileName); // MyDir
		
		
	}
	
	static void test_getNameCount_getName_subpath() {
		System.out.println("\n*** getNameCount, getName, subpath");
		
		//                            0      1         2       3
		Path p1 = Paths.get("C:\\Windows\\MyDir\\MySubdir\\MyFile");
		System.out.println("p1: " + p1);
		
		int nameCount = p1.getNameCount();
		System.out.println("getNameCount(): " + nameCount); // 4
		
		int index = 2;
		Path p2 = p1.getName(index);
		System.out.println("getName(2): " + p2); // MySubdir
		
		Path p3 = p1.subpath(1, 3);
		System.out.println("subpath(1, 3): " + p3); // MyDir\MySubdir
	}
	
	static void bilden() {
		System.out.println("*** Path-Objekte bilden");
		/*
		 * Ab Java 11 gibt es im Interface Path die Methode:
		 *  
		 *  	static Path of(String first, String... more)
		 *  
		 *  (nicht in der Prüfung)
		 */
		
		/*
		 * Klasse 'FileSystem' hat die Methode
		 * 
		 * 		Path getPath(String first, String... more)
		 * 
		 * So kann sie verwendet werden:
		 * 
		 * 		FileSystems.getDefault().getPath("dir", "file");
		 * 
		 * (unwahrscheinlich in der Prüfung)
		 * 
		 */
		
		/*
		 * Utility-Klasse 'Paths' hat die Methode:
		 * 
		 * 		static Path get(String first, String... more)
		 * 
		 */
		Path p1 = Paths.get("C:\\MyDir\\MyFile");
		System.out.println("p1: " + p1); // C:\MyDir\MyFile
		
		Path p2 = Paths.get("C:", "MyDir\\MyFile");
		System.out.println("p2: " + p2); // C:\MyDir\MyFile
		
		Path p3 = Paths.get("C:", "MyDir", "MyFile");
		System.out.println("p3: " + p3); // C:\MyDir\MyFile
	
		Path p4 = Paths.get("C:\\\\", "\\MyDir\\", "\\MyFile");
		System.out.println("p4: " + p4); // C:\MyDir\MyFile
		
		Path p5 = Paths.get(".");
		System.out.println("p5: " + p5); // .    - aktuelles Arbeitsverzeichnis
		
		Path p6 = Paths.get("..");
		System.out.println("p6: " + p6); // ..    - Oberverzeichnis des aktuellen Arbeitsverzeichnis
		
	}

}
