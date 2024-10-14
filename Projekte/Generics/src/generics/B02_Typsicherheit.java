package generics;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B02_Typsicherheit {

	public static void main(String[] args) {
		/*
		 * Generics garantieren die Typsicherheit.
		 * Dafür muss man IMMER parametrisieren!
		 */
		
		// Nach dem Erzeugen des neuen Objektes und nach der
		// Zuweisung in die Referenz wird garantiert,
		// dass in der ArrayList nur Integer-Elemente gespeichert werden.
		List<Integer> listInt = new ArrayList<Integer>(); 

		/*
		 * Der Compiler kontrolliert die Arbeit mit der
		 * parametrisierten Referenz:
		 */
		
		listInt.add(12); //Integer <- IS-A <- Integer
//		listInt.add(false); // cf: Integer <- IST-KEIN <- Boolean
		
		Integer value = listInt.get(0);
		
		List<Boolean> listBool = new ArrayList<>();
	
		/*
		 * Der Compiler kontrolliert die Zuweisungen
		 * mit der parametrisierten Referenz:
		 */
//		listBool = listInt;		// cf: Parametrisierungen sind nicht gleich.
								// Dadurch kann kein falsches Element
								// in dem von listInt referenzierten Objekt
								// gespeichert werden
		listBool.add(false);
		
		/*
		 * Achtung! Wenn man nicht parametrisiert,
		 * gibt es keine Typsicherheit mehr!!!
		 * 
		 * Bitte immer parametrisieren!
		 * 
		 * Die Typsicherheit geht verloren:
		 */
		List list = listInt; // Schlecht!
		list.add(false);
		list.add(12.0);
		list.add(LocalDate.now());
		
		System.out.println(listInt); // [12, false, 12.0, 2024-10-11]
		
		Arrays.sort(args);
	}

}
