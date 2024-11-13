package aufgaben.filescount;

import java.nio.file.Path;

public class PathUtils {

	public static boolean hasExtension(Path file, String extension) {
		
		String fileName = file.getFileName().toString().toLowerCase();
		
		int indexOfPoint = fileName.lastIndexOf('.');
		
		String fileExtension = fileName.substring(indexOfPoint+1);
		
		return fileExtension.equals(extension.toLowerCase());
		
	}
}
