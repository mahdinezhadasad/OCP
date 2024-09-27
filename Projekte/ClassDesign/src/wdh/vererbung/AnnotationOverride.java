package wdh.vererbung;

public class AnnotationOverride {

	/*
	 * Die Annotation @Override schalten nur eine weitere 
	 * Compiler-Kontrolle ein:
	 * 
	 *  Der Compiler überprüft, ob es wirklich eine 
	 *  Überschreibung/Implementierung ist.
	 *  D.h. es wird überprüft, ob ein Basistyp die Methoden 
	 *  mit derselben Signatur hat
	 */
	public static void main(String[] args) {
	}
	
	/*
	 * gültige Java-Methode
	 */
	private Integer getValue() {
		return 42;
	}

	/*
	 * gültige Java-Methode
	 */
//	@Override
//	private String getText() { // cf: es ist kein Überschreiben
//		return "moin";
//	}
	
	/*
	 * gültige Java-Methode.
	 * Der Entwickler wollte hashCode() überschreiben, 
	 * hat sich aber vertippt:
	 */
	public int hasCode() { return 22; } // der Fehler bleibt unbemerkt
	
	/*
	 * gültige Java-Methode.
	 * Der Entwickler wollte toString() überschreiben, 
	 * hat sich aber vertippt:
	 */
//	@Override
//	public String ToString() { // cf: es ist kein Überschreiben, der Fehler wird erkannt
//		return "moin";
//	}
	
	
}
