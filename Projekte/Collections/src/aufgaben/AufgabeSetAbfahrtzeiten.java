package aufgaben;

import java.time.LocalTime;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class AufgabeSetAbfahrtzeiten {

	public static void main(String[] args) {
		
		NavigableSet<String> abfahrtzeiten = getAbfahrtzeiten();
		System.out.println(abfahrtzeiten);

		System.out.println();
		System.out.print("die erste Abfahrtzeit nach 12:03: ");
		String zeit = abfahrtzeiten.higher("12:03");
		System.out.println(zeit);
		
		System.out.print("erste Abfahrtzeit vor 12:03: ");
		zeit = abfahrtzeiten.lower("12:03");
		System.out.println(zeit);
		
		System.out.print("erste Abfahrtzeit nach 17:12 inklusive: ");
		zeit = abfahrtzeiten.ceiling("17:12");
		System.out.println(zeit);
		
		System.out.print("erste Abfahrtzeit nach 17:12 exklusive: ");
		zeit = abfahrtzeiten.higher("17:12");
		System.out.println(zeit);
		
		System.out.print("alle Abfahrtzeiten zwischen 12:00 bis 13:00: ");
		SortedSet<String> subSet = abfahrtzeiten.subSet("12:00", "13:00");
		System.out.println(subSet);
		
		System.out.println("alle Abfahrtzeiten zwischen 11:52 exklusive "
				+ "bis 13:12 inklusive: ");
		NavigableSet<String> subSet2 = abfahrtzeiten.subSet("11:52", false, 
				"13:12", true);
		System.out.println("    " + subSet2);
		
		System.out.print("erstmögliche Abfahrtzeit: ");
		zeit = abfahrtzeiten.first();
		System.out.println(zeit);
		
		System.out.print("letztmöglichen Abfahrtzeit: ");
		zeit = abfahrtzeiten.last();
		System.out.println(zeit);
		
	}

	private static NavigableSet<String> getAbfahrtzeiten() {
		
		NavigableSet<String> set = new TreeSet<String>();
		
		for (int stunde = 6; stunde < 24; stunde++) {
			for (int minute = 12; minute < 60; minute+=20) {
				String zeit = String.format("%02d:%02d", stunde, minute);
				set.add(zeit);
			}
		}

		return set;
	}
	
	

}
