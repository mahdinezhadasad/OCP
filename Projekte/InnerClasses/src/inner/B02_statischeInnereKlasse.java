package inner;

class Sonnensystem {
	private static int maxSize = 3333;
	
	private int size;
	
	
	static class Planet {
		private String name = "Erde";
		
		public String getName() {
			return name;
		}
		
		void testAccess() {
			// Zugriff auf das private statische Element der äußeren Klasse
			System.out.println(maxSize); 
			System.out.println(Sonnensystem.maxSize); 
			
			// kein Sonnensystem Objekt = kein Zugriff auf Objektattribute
			// System.out.println(size); // cf
			
			Sonnensystem s = new Sonnensystem();
			System.out.println(s.size);
		}
		
	} // end of class Planet
}

public class B02_statischeInnereKlasse {

	/*
	 * bei den inneren Klassen: static = 'normal' 
	 * (in Bezug auf die Instanzbildung)
	 */
	public static void main(String[] args) {

		/*
		 * Achtung! Der Compiler sucht nach verwendeten Typen
		 * von innen nach außen:
		 * 
		 * 		- in der umschliessenden Methode (hier 'main')
		 * 		- in der umschliessenden Klasse
		 * 		- in dem aktuellen Package (nur bei den Toplevelklassen)
		 */
		// Planet p1; // cf: der Compiler findet die Klasse nicht

		Sonnensystem.Planet p2;
		
		/*
		 * Objekt erzeugen wie mit jeder normalen Klasse:
		 */
		
		// new Planet(); // cf: der Compiler findet die Klasse nicht
		
		new Sonnensystem.Planet();
		
		/*
		 * Insgesamt:
		 */
		Sonnensystem.Planet p3 = new Sonnensystem.Planet();
		String n = p3.getName();
		//...
		
	}

}
