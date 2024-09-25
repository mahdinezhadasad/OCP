package inner;

class Roboter {
	private String name;
	
	public Roboter(String name) {
		this.name = name;
	}

	class Arm {
		
		void testAccess() {
			/*
			 * Impliziter Zugriff auf ein Objekt vom äußeren Typ.
			 * 
			 *  Das funktioniert, weil die nichstatische innere Klasse
			 *  eine spezielle Referenz hat:
			 *  		NameDerÄußerenKlasse.this
			 */
			System.out.println(name); // mit Roboter.this
			System.out.println(Roboter.this.name);
			
			Roboter ref = Roboter.this;
			System.out.println(ref.name);
		}

	} // end of class Arm
}

public class B03_nichtstatische_innere_Klasse {

	/*
	 * in Bezug auf die Instanzbildung ist eine nichtstatische 
	 * innere Klasse sehr seltsam.
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
		
		// Arm a1; // cf
		Roboter.Arm a2;
		
		/*
		 * Achtung! 
		 * Zum Erzeugen eines Objektes der inneren nichtstatischen Klasse
		 * braucht man ein Objekt vom äußeren Typ!
		 */
		// new Roboter.Arm(); // cf
		
		Roboter r1 = new Roboter("R2D2");
		r1.new Arm();
		

		/*
		 * Insgesamt:
		 */
		Roboter.Arm a3 = r1.new Arm();
		Roboter.Arm a4 = new Roboter("C3PO").new Arm();
		
		System.out.println("*** testAccess mit a3: ");
		a3.testAccess();
		
		System.out.println("*** testAccess mit a4: ");
		a4.testAccess();
		
	}

}
