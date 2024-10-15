package aufgaben;

interface Tontraeger {}

class Schallplatte implements Tontraeger {}
class Tonband implements Tontraeger {}
class CD implements Tontraeger {}

class Abspielgeraet {
	void abspielen(Tontraeger t) {}
}


public class AufgabeGenericsTontraeger {

	public static void main(String[] args) {
		
//	    Abspielgerät nur für Schallplatten
		Abspielgeraet ag1 = new Abspielgeraet();
		ag1.abspielen(new Schallplatte());
		ag1.abspielen(new CD());
		ag1.abspielen(new Tonband());
		
//	    Abspielgerät nur für CDs
		
//	    Kein Abspielgerät für Strings ist möglich
	}

}
