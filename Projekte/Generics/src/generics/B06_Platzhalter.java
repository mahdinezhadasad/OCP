package generics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Tier {}
class Katze extends Tier {} // todo: Klasse fürs Speichern in einem HashSet gestalten
class Hund extends Tier {}
class Wildhund extends Hund {}

public class B06_Platzhalter {

	public static void main(String[] args) {
		
		List<Hund> listHunde = new ArrayList<Hund>();
		
		listHunde.add(new Hund());
		listHunde.add(new Wildhund());  // Hund param = new Wildhund()
										// 1. Hund <- IS-A <- Wildhund		- OK

		print(listHunde); // Collection<Tier> coll = listHunde
						  // 1. Collection <- IS-A <- List
						  // 2. <Tier> nicht gleich <Hund>
		
		Set<Katze> setKatzen = new HashSet<Katze>();
		setKatzen.add(new Katze());
		setKatzen.add(new Katze());
		
		print(setKatzen);   // Collection<Tier> coll = setKatzen
							// 1. Collection <- IS-A <- Set
						 	// 2. <Tier> nicht gleich <Katze>
		
		Collection<Tier> collTiere = new ArrayDeque<Tier>();
		collTiere.add(new Hund());
		collTiere.add(new Wildhund());
		collTiere.add(new Katze());
		
		print(collTiere);   // Collection<Tier> coll = collTiere
							// 1. Collection <- IS-A <- Collection
							// 2. <Tier> nicht gleich <Tier>		
	}
	
	/*
	 * Collection<? extends Tier> coll bedeutet:
	 * 
	 * Bei der 2. Kontrolle der Zuweisung in die Referenz coll
	 * darf die rechte Referenz mit Tier parametrisiert sein
	 * oder mit dem von Tier abgeleiteten Typ.
	 * 
	 * Unwahrscheinlich in der Prüfung:
	 * Die mit '? extends' parametrisierte Referenz kann nicht
	 * benutzt werden, um eine Methode mit dem generischen Parameter
	 * aufzurufen
	 */
	static void print(Collection<? extends Tier> coll) {
		
		System.out.println("size: " + coll.size());
		
		for(Tier t : coll) {
			System.out.println(t);
		}
		
//		coll.add(new Tier());  // cf
//		coll.add(new Hund());
//		coll.add(new Wildhund());
//		coll.add(new Katze());
		
		coll.remove(new Hund()); // hat Objet-Parameter
		coll.contains(new Hund()); // hat Objet-Parameter
	}

}
