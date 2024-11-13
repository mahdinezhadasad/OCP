package aufgaben.filescount;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FilesCounter {
	
	private Path dir;
	
	public FilesCounter(Path dir) {
		this.dir = dir;
	}
	
	public int getCount(String extension) {
		
		try (Stream<Path> s = Files.walk(dir)) {
			return (int)s.filter(Files::isRegularFile)
					.filter(f -> PathUtils.hasExtension(f, extension))
					.count();
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
	}

	
}
