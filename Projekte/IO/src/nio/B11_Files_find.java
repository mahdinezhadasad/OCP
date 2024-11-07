package nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class B11_Files_find {

	/*
	 * static Stream<Path> find(Path start,
                                    int maxDepth,
                                    BiPredicate<Path, BasicFileAttributes> matcher,
                                    FileVisitOption... options)
        throws IOException
	 */
	public static void main(String[] args) {
		
		Path start = Paths.get(".");
//		int maxDepth = 0; // nur das Startverzeichnis im Stream
		int maxDepth = Integer.MAX_VALUE;
		
		try (Stream<Path> s = Files.find(start, maxDepth, (p, atts) -> true)) {
			
			s.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
