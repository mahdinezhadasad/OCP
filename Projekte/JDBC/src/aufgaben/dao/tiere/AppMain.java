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
		
		System.out.println("\n*** Alle Tiere: ");
		
		if(alleTiere.isEmpty()) {
			System.out.println("Es gibt keine Tiere");
		}
		
		String fmt = "%02d. %10s. %10s. %d%n";
		for (Tier t : alleTiere) {
			System.out.printf(fmt, t.getId(), t.getName(), t.getArt(), t.getGeburtsjahr());
		}
	}
	private static void deleteAnimal(TierDAO dao) {
		
		System.out.println("\n*** Tier löschen");
		System.out.print("Bitte die id vom Tier eingeben: ");
		int id = readUserInt();
		
		if(!dao.deleteOnId(id)) {
			System.out.println("Es gibt kein Tier mit der id=" + id);
		} else {
			System.out.println("Das Tier wurde entfernt");
		}
	}
	private static void createAnimal(TierDAO dao) {
		System.out.println("\n*** Tier erzeugen");
		// User nach Daten für das neue Tier fragen
		
		System.out.print("id: ");
		int id = readUserInt();
		
		System.out.print("Name: ");
		String name = readUserString();
		
		System.out.print("Art: ");
		String art = readUserString();
		
		System.out.print("Geburtsjahr: ");
		int geburtsjahr = readUserInt();
		
		Tier t = new Tier(id, name, art, geburtsjahr);
		dao.add(t);
		
		System.out.println("Das Tier gespeichert");
	}

	private static void printMenu() {
		System.out.println("\n*** Bitte eine Option auswählen: ");
		
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
	
	private static int readUserInt() {
		String line = new Scanner(System.in).nextLine();
		return Integer.parseInt(line);
	}
	private static String readUserString() {
		return new Scanner(System.in).nextLine();
	}
	
}
