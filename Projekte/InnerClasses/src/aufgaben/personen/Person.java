package aufgaben.personen;

public class Person {

	private String vorname;
	private String nachname;
	private int geburtsjahr;
	
	public Person(String vorname, String nachname, int geburtsjahr) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsjahr = geburtsjahr;
	}
	
	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public int getGeburtsjahr() {
		return geburtsjahr;
	}

	@Override
	public String toString() {
		return vorname + " " + nachname + " (" + geburtsjahr + ")";
	}
	
}
