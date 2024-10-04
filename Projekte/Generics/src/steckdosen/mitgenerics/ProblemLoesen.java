package steckdosen.mitgenerics;

interface TV {}

class TVDE implements TV {}
class TVUK implements TV {}

class Steckdose <T extends TV> { // extends TV = Type Bound
	private T tv;
	
	void anschliessen(T tv) {
		if(this.tv != null) {
			throw new IllegalStateException("Steckdose bereits belegt");
		}
		
		this.tv = tv;
	}
	
	T getTV() {
		return tv;
	}
}

public class ProblemLoesen {

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
	 */
	public static void main(String[] args) {
		
		TVDE tvDE = new TVDE();
		TVUK tvUK = new TVUK();
		
//		tvDE = tvUK; // darf nicht kompilieren
//		tvUK = tvDE; // darf nicht kompilieren
		
		Steckdose<TVUK> sdUK = new Steckdose<TVUK>();
		sdUK.anschliessen(tvUK); // muss funktionieren
//		sdUK.anschliessen(tvDE); // darf nicht kompilieren
		
		Steckdose<TVDE> sdDE = new Steckdose<TVDE>();
		sdDE.anschliessen(tvDE); // muss funktionieren
//		sdDE.anschliessen(tvUK); // darf nicht kompilieren
		
//		sdUK = sdDE; // darf nicht kompilieren
//		sdDE = sdUK; // darf nicht kompilieren
		
		TVDE a = sdDE.getTV();
//		TVUK b = sdDE.getTV(); // darf nicht kompilieren
		TVUK c = sdUK.getTV();
//		TVDE d = sdUK.getTV(); // darf nicht kompilieren
		
		// sinnlose Parametrisierung kompiliert nicht,
		// da es den Type Bound gibt (T extends TV):
//		Steckdose<String> sdSinnlos = new Steckdose<String>(); // cf 
//		sdSinnlos.anschliessen("ich bin kein Fernseher");
	}

}
