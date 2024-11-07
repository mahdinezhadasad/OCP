package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.concurrent.TimeUnit;

public class B08_Files_Attribute_mehrereAufEinmal {

	/*
	 *               BasicFileAttributes
	 *                        |
	 *               ---------------------
	 *               |                   |
	 *   DosFileAttributes           PosixFileAttributes
	 *   
	 * 
	 *               BasicFileAttributeView
	 *                        |
	 *               ---------------------
	 *               |                   |
	 *   DosFileAttributeView        PosixFileAttributeView
	 * 
	 */
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("autos.txt");

		/*
		 * static <A extends BasicFileAttributes> A readAttributes(Path path,
                                                                   Class<A> type,
		 */
		
		// Basic <- IS-A <- Basic
		BasicFileAttributes a1 = Files.readAttributes(path, BasicFileAttributes.class);
		// Basic <- IS-A <- Dos
		BasicFileAttributes a2 = Files.readAttributes(path, DosFileAttributes.class); // Exception auf einem Linux-Rechner
		try {
			// Basic <- IS-A <- Posix
			BasicFileAttributes a3 = Files.readAttributes(path, PosixFileAttributes.class); // Exception auf einem Windows-Rechner
		} catch (Exception e) {
			System.out.println("Fehler! Keine Posix-Attribute unter Windows!");
		}
		
		// cf: Dos <- IST-KEIN <- Basic
//		DosFileAttributes a4 = Files.readAttributes(path, BasicFileAttributes.class);
		
		// cf: Dos <- IST-KEIN <- Posix
//		DosFileAttributes a5 = Files.readAttributes(path, PosixFileAttributes.class);
		
		
		/*
		 * static <V extends FileAttributeView> V getFileAttributeView(Path path,
                                                                   Class<V> type,
                                                                   LinkOption... options)
		 */
		
		// Basic <- IS-A <- Basic
		BasicFileAttributeView v1 = Files.getFileAttributeView(path, BasicFileAttributeView.class);
		
		// cf: Dos <- IST-KEIN <- Posix
//		DosFileAttributeView v2 = Files.getFileAttributeView(path, PosixFileAttributeView.class);

		// usw...
		
		FileTime lastModifiedTime = null;
		FileTime lastAccessTime = null;
		FileTime creationTime = FileTime.from(0, TimeUnit.MILLISECONDS); // 1.1.1970
		
		v1.setTimes(lastModifiedTime, lastAccessTime, creationTime);
		
	}

}
