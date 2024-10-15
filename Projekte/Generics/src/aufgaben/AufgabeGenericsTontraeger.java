package aufgaben;

interface Tontraeger {}

class Schallplatte implements Tontraeger {}
class Tonband implements Tontraeger {}
class CD implements Tontraeger {}

class Abspielgeraet <T extends Tontraeger> {
	void abspielen(T t) {}
}


public class AufgabeGenericsTontraeger {

	public static void main(String[] args) {
		
/*
 * 	    Abspielgerät nur für Schallplatten
 */
		Abspielgeraet<Schallplatte> plattenSpieler = new Abspielgeraet<>();
		plattenSpieler.abspielen(new Schallplatte());
//		plattenSpieler.abspielen(new CD());
//		plattenSpieler.abspielen(new Tonband());
		
/*
 * 	    Abspielgerät nur für CDs
 */
		Abspielgeraet<CD> cdSpieler = new Abspielgeraet<>();
		cdSpieler.abspielen(new CD());
//		cdSpieler.abspielen(new Schallplatte());
//		cdSpieler.abspielen(new Tonband());
		
/*
 * 	    Kein Abspielgerät für Strings ist möglich
 */
//		Abspielgeraet<String> sinnlos = new Abspielgeraet<>();
//		sinnlos.abspielen("moin");
	}

}
