package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) throws IOException {
		Path p = Paths.get("herrscher.txt");
		System.out.println(Files.lines(p).reduce(0,(a,b)->a + b.length() ,(a,b) -> a+b));
	}

}
