package aufgaben;

class Fahrzeug {}
class PKW extends Fahrzeug {} 
class LKW extends Fahrzeug {} 

class Garage <T extends Fahrzeug> {
	T f;
	
	void reinfahren(T f) {
		this.f = f;
	}
	
	@Override
	public String toString() {
		if(f==null) {
			return "Die Garage ist leer";
		}
		return "In der Garage steht: " + f.getClass().getSimpleName();
	}
}

public class AufgabeGenericsGarage {

	public static void main(String[] args) {
		
		PKW pkw = new PKW();
		LKW lkw = new LKW();

		Fahrzeug f;
		
		f = pkw; // Fahrzeug <- IS-A <- PKW
		f = lkw; // Fahrzeug <- IS-A <- LKW
		
//		pkw = lkw; // cf: PKW <- IST-KEIN <- LKW
//		lkw = pkw; // cf: LKW <- IST-KEIN <- PKW
		
		Garage<PKW> garagePKW = new Garage<>();
		garagePKW.reinfahren(pkw);
//		garagePKW.reinfahren(lkw); // darf nicht kompilieren
		System.out.println("1. PKW-Garage. " + garagePKW);
		
		Garage<LKW> garageLKW = new Garage<>();
		garageLKW.reinfahren(lkw);
//		garageLKW.reinfahren(pkw); // darf nicht kompilieren
		System.out.println("2. LKW-Garage. " + garageLKW);
	
//		garagePKW = garageLKW; // darf nicht kompilieren
//		garageLKW = garagePKW; // darf nicht kompilieren
		
//		Garage<String> sinnlos; // cf: String passt nicht für den Type Bound
	}

}
