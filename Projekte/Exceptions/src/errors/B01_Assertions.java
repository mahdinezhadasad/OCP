package errors;


class Auto {
	private int baujahr;

	public Auto(int baujahr) {
		if(baujahr<1900) {
			throw new IllegalArgumentException("Falsches Baujahr: " + baujahr);
		}
		
		this.baujahr = baujahr;
	}

	/*
	 * Was ist wenn späte diese Methode erzeugt wird?
	 */
//	public void setBaujahr(int baujahr) {
//		this.baujahr = baujahr;
//	}
	
	@Override
	public String toString() {
		/*
		 * if-Abfrage ist sinnlos. Die Klasse ist bereits garantiert korrekt.
		 * 
		 * Garantiert ist: baujahr >= 1900 (Invariante) 
		 */
//		if(baujahr<1900) {
//			throw new IllegalStateException("Auto hat falsches Baujahr: " + baujahr);
//		}
		
		assert baujahr >= 1900;
		
		return "Auto. Bj: " + baujahr;
	}
}


public class B01_Assertions {

	/*
	 * - Assertions bitte nur beim Testen verwenden
	 * - Assertions dürfen die Logik der Anwendung nicht ändern
	 * - Assertions müssen aktiviert werden 
	 */
	public static void main(String[] args) {

	}

}
