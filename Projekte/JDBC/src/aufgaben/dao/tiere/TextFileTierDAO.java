package aufgaben.dao.tiere;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextFileTierDAO implements TierDAO {
	
	private Path file = Paths.get("tiere.txt");

	@Override
	public List<Tier> getAllTiere() throws UncheckedIOException, IllegalArgumentException {
		
		if(!Files.isRegularFile(file)) {
			throw new IllegalArgumentException("Datei mit Tieren nicht gefunden: " + file);
		}
		
		try (Stream<String> s = Files.lines(file)) {
			return s.map(line -> parseTier(line)).collect(Collectors.toList());
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	/*
	 * Format der line:
	 * 
	 * 		id, Name, Art, 1960
	 */
	private static Tier parseTier(String line) {
		String[] data = line.split(", ");
		
		int id = Integer.parseInt(data[0]);
		String name = data[1];
		String art = data[2];
		int geburtsjahr = Integer.parseInt(data[3]);
		
		return new Tier(id, name, art, geburtsjahr);
	}

	@Override
	public void deleteOnId(int id) {
		throw new UnsupportedOperationException("not yet implemented");
	}

	@Override
	public void add(Tier t) {
		throw new UnsupportedOperationException("not yet implemented");
	}
	
	
}
