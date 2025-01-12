package JDBC.src.aufgaben.dao.tiere;

/*
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextFileTierDAO implements aufgaben.dao.tiere.TierDAO {
	
	private Path file = Paths.get("tiere.txt");
	
	public TextFileTierDAO() {
		try {
			if(!Files.exists(file))
				Files.createFile(file);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	@Override
	public List<aufgaben.dao.tiere.Tier> getAllTiere() throws UncheckedIOException, IllegalArgumentException {
		
		if(!Files.isRegularFile(file)) {
			throw new IllegalArgumentException("Datei mit Tieren nicht gefunden: " + file);
		}
		
		try (Stream<String> s = Files.lines(file)) {
			return s.map(line -> parseTier(line)).collect(Collectors.toList());
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	*/
/*
	 * Format der line:
	 * 
	 * 		id, Name, Art, 1960
	 *//*

	private static aufgaben.dao.tiere.Tier parseTier(String line) {
		String[] data = line.split(", ");
		
		int id = Integer.parseInt(data[0]);
		String name = data[1];
		String art = data[2];
		int geburtsjahr = Integer.parseInt(data[3]);
		
		return new aufgaben.dao.tiere.Tier (id, name, art, geburtsjahr);
	}

	@Override
	public boolean deleteOnId(int id) {
		
		List<Tier> tiere = getAllTiere();
		
		int size = tiere.size();
		
		tiere.removeIf(t -> t.getId()==id);
		
		if(tiere.size() == size) {
			return false;
		}
		
		save(tiere);
		return true;
	}

	@Override
	public void add(aufgaben.dao.tiere.Tier newTier) throws IllegalArgumentException {
		
		List<aufgaben.dao.tiere.Tier> alleTiere = getAllTiere();
		
		boolean idExistiert = alleTiere.stream().anyMatch(t -> t.getId()==newTier.getId());
		
		if(idExistiert) {
			throw new IllegalArgumentException("Es gibt bereits ein Tier mit der id = " + newTier.getId());
		}
		
		alleTiere.add(newTier);
		save(alleTiere);
	}
	
	private void save(List<Tier> tiere) {
		try (PrintWriter out = new PrintWriter(file.toFile())) {
			
			for(Tier t : tiere) {
				out.format("%d, %s, %s, %d%n", t.getId(), t.getName(), t.getArt(), t.getGeburtsjahr());
			}
			
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
}*/