package Threads.src.aufgaben.philosophenproblem.lock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AufgabePhilosophenproblem {
	
	private static String[] namen = {
		"Sokrates", "Platon", "Aristoteles", "Bacon", 
		"Decartes", "Hegel", "Kant", "Konfuzius", 	
	};

	public static void main(String[] args) {
		
		int anzahlPlatze = 5;
		
		List<aufgaben.philosophenproblem.lock.Philosoph> philosophen = Arrays.stream(namen)
			.limit(anzahlPlatze)
			.map(aufgaben.philosophenproblem.lock.Philosoph::new)
			.collect(Collectors.toList());
		
		List<Lock> locks = Stream.generate(ReentrantLock::new)
				.limit(anzahlPlatze)
				.collect(Collectors.toList());

		// Lock-Objekte verteilen
		for (int index = 0; index < anzahlPlatze; index++) {
			aufgaben.philosophenproblem.lock.Philosoph p = philosophen.get(index);

			p.setLeftLock(locks.get(index));
			
			int indexRechteGabel = index + 1;
			if(index == anzahlPlatze-1) {
				indexRechteGabel = 0; // Lock-Objekt für den letzten Philosophen
			}
			
			p.setRightGabel(locks.get(indexRechteGabel));
		}
		
		// Threads starten
		philosophen.forEach(aufgaben.philosophenproblem.lock.Philosoph::start);
	}

}