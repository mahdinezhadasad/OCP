package nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B02_PathAPI {

	public static void main(String[] args) {
		bilden(); // Exam!
		
		test_getNameCount_getName_subpath();
		test_getFileName_getParent_getRoot();
		test_toAbsolutePath_normalize();
		
		test_resolve(); // Exam!
		test_relativize(); // Exam!
	}
	
	static void test_relativize() {
		System.out.println("\n*** relativize");
		
		System.out.println("***** beide Pfade sind relativ: ");
		
		Path p1 = Paths.get("a/b/c/d");
		Path p2 = Paths.get("a/b/x/y");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		Path p3 = p1.relativize(p2);
		System.out.println("p1.relativize(p2): : " + p3); // ..\..\x\y
		
		p1 = Paths.get("c/d");
		p2 = Paths.get("x/y");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		p3 = p2.relativize(p1);
		System.out.println("p1.relativize(p2): : " + p3); // ..\..\c\d
		
		System.out.println("***** beide Pfade sind absolut (derselber logischer Laufwerk): ");
		
		p1 = Paths.get("C:\\mydir\\c\\d");
		p2 = Paths.get("C:\\mydir\\x\\y");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		p3 = p1.relativize(p2);
		System.out.println("p1.relativize(p2): : " + p3); // ..\..\x\y
		
		System.out.println("***** ein Pfad ist relativ, anderer ist absolut");
		
		p1 = Paths.get("C:\\mydir\\c\\d");
		p2 = Paths.get("x\\y");
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		
		try {
			p3 = p2.relativize(p1);
		} catch (Exception e) {
			System.out.println("Fehler! Ein Path ist relativ, der andere ist absolut");
		}
	}
		
	/*
	 * Path resolve(String subPath)
	 * Path resolve(Path subPath)
	 */
	static void test_resolve() {
		System.out.println("\n*** resolve");

		System.out.println("***** beide Pfade sind relativ: ");
		Path parent = Paths.get("mydir");
		System.out.println("parent: " + parent); // mydir
		
		Path file = parent.resolve("mysubdir/myfile");
		System.out.println("file: " + file);  // mydir\mysubdir\myfile
		
		System.out.println("***** 1. Pfad ist absolut, 2. Pfad ist relativ: ");
		parent = Paths.get("C:\\mydir");
		System.out.println("parent: " + parent); // C:\mydir
		
		file = parent.resolve("mysubdir/myfile");
		System.out.println("file: " + file);  // C:\mydir\mysubdir\myfile
		
		System.out.println("***** 2. Pfad ist absolut: "); 
		// resolve liefert einfach den 2. Pfad zurück
		parent = Paths.get("C:\\mydir");
		System.out.println("parent: " + parent); // C:\mydir
		
		file = parent.resolve("C:/mysubdir/myfile");
		System.out.println("file: " + file);  // C:\mysubdir\myfile
	}
		
	static void test_toAbsolutePath_normalize() {
		System.out.println("\n*** toAbsolutePath, normalize");
		
		Path p1 = Paths.get("dir/file");
		System.out.println("p1: " + p1);
		
		Path pathAbs = p1.toAbsolutePath();
		System.out.println("p1.toAbsolutePath(): " + pathAbs); // absoluter aktueller Pfad
		
		Path p2 = Paths.get("dir/subdirA/../subdirB/./file");
		System.out.println("p2: " + p2);
		
		Path pathNorm = p2.normalize();
		System.out.println("p2.normalize(): " + pathNorm); // dir\subdirB\file
		
	}
	
	static void test_getFileName_getParent_getRoot() {
		System.out.println("\n*** getFileName, getParent, getRoot");
		
		Path p1 = Paths.get("C:\\Windows\\MyDir");
		
		// The file name is the farthest element from the root in the directory hierarchy
		Path fileName = p1.getFileName();
		System.out.println("getFileName: " + fileName); // MyDir
		
		Path parent = p1.getParent();
		System.out.println("getParent(): " + parent); // C:\Windows
		
		Path root = p1.getRoot();
		System.out.println("getRoot(): " + root); // C:\
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
