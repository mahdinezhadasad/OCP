package aufgaben.autos;

public class Rennwagen {
	
	public static class Fahrer {
		private String vorname, nachname;

		public Fahrer(String vorname, String nachname) {
			this.vorname = vorname;
			this.nachname = nachname;
		}
		
		public String toString() {
			return vorname + " " + nachname;
		}
		
	} // end of class Fahrer
	
	public class Motor {
		private String typ;
		
		public Motor(String typ) {
			this.typ = typ;
		}
		
		public String toString() {
			return "Motor " + typ + " aus dem Rennwagen " 
						+ hersteller; // implizit Rennwagen.this.hersteller
		}
	} // end of class Motor
	
	/*
	 * Weitere Elemente der Klasse Rennwagen
	 */
	private String hersteller;
	private Fahrer fahrer;
	private Motor motor;

	public Rennwagen(String hersteller) {
		this.hersteller = hersteller;
		this.motor = new Motor("Type1"); // implizit this.new Motor("Type1");
	}
	
	public void setFahrer(Fahrer fahrer) {
		this.fahrer = fahrer;
	}
	
	public Motor getMotor() {
		return motor;
	}
	
	@Override
	public String toString() {
		String fahrerText = (fahrer==null) ? "kein Fahrer" : fahrer.toString();
		
		return "Rennwagen " + hersteller + ". Fahrer: " + fahrerText;
	}

}
