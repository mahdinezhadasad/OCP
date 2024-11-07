package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class B07_Files_Attribute_getAttribute_setAttribute {

	/*
	 * Namen der Attribute:
	 * 
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/BasicFileAttributeView.html
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/DosFileAttributeView.html
	 * https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/PosixFileAttributeView.html
	 * 
	 * 
	 * static Object getAttribute(Path path, String attribute,
                                      LinkOption... options)
             	throws IOException
             
       
       static Path setAttribute(Path path, String attribute, Object value,
                                    LinkOption... options)
        		throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("tiere.txt");
		System.out.println("path: " + path);
		
		Boolean result = (Boolean)Files.getAttribute(path, "dos:hidden");
		System.out.println("dos:hidden: " + result);
		
		Files.setAttribute(path, "dos:hidden", true);
		System.out.println("dos:hidden wirde auf true gesetzt");

		result = (Boolean)Files.getAttribute(path, "dos:hidden");
		System.out.println("dos:hidden: " + result);
		
		Files.setAttribute(path, "dos:hidden", false);
		System.out.println("dos:hidden wirde auf false gesetzt");
		
	}

}
