package steckdosen.ohnegenerics;

interface TV {}

class TVUK implements TV {}
class TVDE implements TV {}

class SteckdoseUK {
	private TVUK tv;
	
	void anschliessen(TVUK tv) {
		if(this.tv != null) {
			throw new IllegalStateException("Steckdose ist belegt");
		}
		this.tv = tv;
	}
	
	TVUK getTV() {
		return this.tv;
	}
}

class SteckdoseDE {
	private TVDE tv;
	
	void anschliessen(TVDE tv) {
		if(this.tv != null) {
			throw new IllegalStateException("Steckdose ist belegt");
		}
		this.tv = tv;
	}
	
	TVDE getTV() {
		return this.tv;
	}
}


public class ProblemBeschreiben {

	/*
	 * Aufgabe:
	 * 
	 * - Es gibt englische TV-Geräte
	 * - Es gibt deutsche TV-Geräte
	 * - Deutsche und englische TV-Geräte sind nicht kompatibel (wichtig!)
	 * 
	 * - Es gibt englische Steckdosen
	 * - Es gibt deutsche Steckdosen
	 * - Deutsche und englische Steckdosen sind nicht kompatibel (wichtig!)
	 * 
	 * - An einer deutsche Steckdose kann nur ein 
	 *   deutsches TV-Gerät angeschlossen werden (wichtig!)
	 * 
	 * - An einer englische Steckdose kann nur ein 
	 *   englisches TV-Gerät angeschlossen werden (wichtig!)
	 *  
	 * Nachdem die Aufgabe gelöst wurde, zeigt die Lösung
	 * das Design-Problem:
	 *   - Fast identische Steckdosen-Klassen (doppelter Code).
	 *   - Wird ein weiterer Steckdosen-Typ benötigt, muss eine weitere 
	 *     fast identische Steckdose-Klasse erzeugt werden 
	 * 
	 */
	public static void main(String[] args) {
		
		TVUK tvUK = new TVUK();
		TVDE tvDE = new TVDE();

//		tvUK = tvDE; // darf nicht kompilieren
//		tvDE = tvUK; // darf nicht kompilieren 
		
		SteckdoseDE sdDE = new SteckdoseDE();
		sdDE.anschliessen(tvDE); // muss funktionieren
//		sdDE.anschliessen(tvUK); // darf nicht kompilieren
		
		SteckdoseUK sdUK = new SteckdoseUK();
		sdUK.anschliessen(tvUK); // muss funktionieren
//		sdUK.anschliessen(tvDE); // darf nicht kompilieren
		
//		sdDE = sdUK; // darf nicht kompilieren
//		sdUK = sdDE; // darf nicht kompilieren
		
		TVDE a = sdDE.getTV(); // sollte bequem ohne Casting gehen
//		TVUK b = sdDE.getTV(); // darf nicht kompilieren
		
		TVUK c = sdUK.getTV(); // sollte bequem ohne Casting gehen
//		TVDE d = sdUK.getTV(); // darf nicht kompilieren
	}

}
