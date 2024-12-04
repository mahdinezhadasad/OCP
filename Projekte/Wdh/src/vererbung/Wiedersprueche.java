package vererbung;

public class Wiedersprueche {

	// abstract final class C1 {} // cf: abstract + final
	
	private abstract class C2 {} // private + abstract für eine Klasse ist ok, 
								 // da die Klasse doch innerhalb der äußeren
								 // Klasse sichtbar ist und kann erweitert werden
	
	private final class C3 {}
	
	abstract class MyClass {
//		final abstract void m() {} // cf: abstract + final
	
//		private abstract void m2(); // cf: private + abstract für Methoden
								    // geht nicht, da private Methoden
									// nicht vererbt werden
		
		private final void m3() {}
	}
	
}
