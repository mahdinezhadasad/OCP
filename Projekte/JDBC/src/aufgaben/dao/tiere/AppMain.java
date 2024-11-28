package aufgaben.dao.tiere;

import java.util.List;
import java.util.Scanner;

public class AppMain {
	enum AppAction {
		EXIT ("Beenden"), 
		PRINT_ALL_ANIMALS ("Alle Tiere ausgeben"), 
		CREATE_ANIMAL("Tier hinzufügen"), 
		DELETE_ANIMAL("Tier löschen");
		
		private String displayText;

		private AppAction(String displayText) {
			this.displayText = displayText;
		}
		
		@Override
		public String toString() {
			return displayText;
		}
	}

	public static void main(String[] args) {
		
		TierDAO tierDAO = TierDAO.getInstance(); 

		while(true) {
			printMenu();
			
			AppAction userChoice = readUserChoice();
	
			switch(userChoice) {
				case EXIT: 
					System.out.println("Die Anwendung wird beendet");
					return;
				
				case PRINT_ALL_ANIMALS: 
					printAllAnimals(tierDAO);
					break;
					
				case CREATE_ANIMAL: 
					createAnimal(tierDAO);
					break;
			
				case DELETE_ANIMAL: 
					deleteAnimal(tierDAO);
					break;
					
				default:
					throw new UnsupportedOperationException("unbehandelte AppAction: " + userChoice);
			}
		}
	}
	
	private static void printAllAnimals(TierDAO dao) {
		List<Tier> alleTiere = dao.getAllTiere();
		
		System.out.println("Alle Tiere: ");
		
		String fmt = "%02d. %10s. %10s. %d%n";
		for (Tier t : alleTiere) {
			System.out.printf(fmt, t.getId(), t.getName(), t.getArt(), t.getGeburtsjahr());
		}
	}
	private static void deleteAnimal(TierDAO dao) {
		throw new UnsupportedOperationException("not yet implemented");
		
		// User nach Tier-ID fragen
		// int id = ...;
		// Tier löschen
		// dao.deleteOnId(id);
	}
	private static void createAnimal(TierDAO dao) {
		throw new UnsupportedOperationException("not yet implemented");
		
		// User nach Daten für das neue Tier fragen
		// danach
		// Tier t = new Tier(...);
		// dao.add(t);
	}

	private static void printMenu() {
		System.out.println("Bitte eine Option auswählen: ");
		
		for (AppAction a : AppAction.values()) {
			System.out.println(a.ordinal() + " = " + a);
		}
		
		System.out.print("Ihre Wahl: ");
	}
	
	private static AppAction readUserChoice() {
		
		String line = new Scanner(System.in).nextLine();
		
		int value = Integer.parseInt(line);
		
		return AppAction.values()[value];
	}
	
}
