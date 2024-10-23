package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("test.txt");
		Files.lines(p).forEach(System.out::println);;
	}

}
