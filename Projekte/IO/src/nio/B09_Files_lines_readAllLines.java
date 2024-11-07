package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class B09_Files_lines_readAllLines {

	/*
	 * Exam!
	 */
	public static void main(String[] args) {

		Path file = Paths.get("autos.txt");
		
		/*
		 * static Stream<String> lines(Path path) throws IOException
		 */
		System.out.println("*** lines");
		
		try (Stream<String> s = Files.lines(file)) {
			
			s.forEach(System.out::println);
			
		} catch(IOException e) {
			e.printStackTrace();
		}

		/*
		 * static List<String> readAllLines(Path path) throws IOException
		 */
		System.out.println("\n*** readAllLines");
		
		try {
			List<String> lines = Files.readAllLines(file);
			
			lines.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
