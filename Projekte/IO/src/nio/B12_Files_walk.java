package nio;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class B12_Files_walk {

	
	public static void main(String[] args) {

		/*
		 * static Stream<Path> walk(Path start,
                                    int maxDepth,
                                    FileVisitOption... options)
                 throws IOException
        
		 */
		Path start = Paths.get("src");
		int maxDepth = Integer.MAX_VALUE;
		
		try (Stream<Path> s = Files.walk(start, maxDepth)) {
			
			s.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * static Stream<Path> walk(Path start, FileVisitOption... options) 
		 * 		throws IOException {
         
		 */
		System.out.println("\n\n*** Version 2");
		
		try (Stream<Path> s = Files.walk(start)) {
			
			s.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
