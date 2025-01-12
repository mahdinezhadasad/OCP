package aufgaben.philosophenproblem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AufgabePhilosophenproblem {
	
	private static String[] namen = {
		"Sokrates", "Platon", "Aristoteles", "Bacon", 
		"Decartes", "Hegel", "Kant", "Konfuzius", 	
	};

	public static void main(String[] args) {
		
		int anzahlPlatze = 5;
		
		List<aufgaben.philosophenproblem.PhilosophMitDeadlock> philosophen = Arrays.stream(namen)
			.limit(anzahlPlatze)
			.map(PhilosophMitDeadlock::new)
			.collect(Collectors.toList());
		
		List<Object> gabeln = Stream.generate(Object::new)
				.limit(anzahlPlatze)
				.collect(Collectors.toList());

		// Gabeln verteilen
		for (int index = 0; index < anzahlPlatze; index++) {
			aufgaben.philosophenproblem.PhilosophMitDeadlock p = philosophen.get(index);

			p.setLinkeGabel(gabeln.get(index));
			
			int indexRechteGabel = index + 1;
			if(index == anzahlPlatze-1) {
				indexRechteGabel = 0; // Gabel für den letzten Philosophen
			}
			
			p.setRechteGabel(gabeln.get(indexRechteGabel));
		}
		
		// Threads starten
		philosophen.forEach(PhilosophMitDeadlock::start);
	}

}