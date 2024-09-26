package aufgaben.gebaeude;

public class Gebaeude {

	public class Stockwerk {
		
		private Raum[] raeume;
		private int nummer;
		
		public Stockwerk(int nummer, int anzahlRaeume) {
			this.nummer = nummer;
			
			if(anzahlRaeume<1) {
				throw new IllegalArgumentException("Anzahl der "
						+ "Räume darf nicht kleiner als 1 sein. Aktuell: " 
						+ anzahlRaeume);
			}
			
			this.raeume = new Raum[anzahlRaeume];
			for (int i=0; i<anzahlRaeume; i++) {
				this.raeume[i] = new Raum(i);
			}
		}
		
		public Raum getRaum(int raumNummer) {
			if(raumNummer>=raeume.length || raumNummer<0) {
				String errMsg = String.format("Falsche Raumnummer: %d. Gültige Werte: [%d .. %d)", 
						raumNummer, 0, raeume.length);
				throw new IllegalArgumentException(errMsg);
			}
			
			return raeume[raumNummer];
		}
		
		@Override
		public String toString() {
			return "Stockwerk " 
						+ nummer // this.nummer
						+ ", "
						+ strasse // Gebaeude.this.strasse
						+ " "
						+ Gebaeude.this.nummer
					;
		}
		

		public class Raum {
			private int nummer;
			
			public Raum(int nummer) {
				this.nummer = nummer;
			}

			// Raum 0.2 / Hauptstr. 45
			public String toString() {
				return "Raum "
						+ Stockwerk.this.nummer 	
						+ "."
						+ nummer	// this.nummer
						+ " / "
						+ strasse  // Gebaeude.this.strasse
						+ " "
						+ Gebaeude.this.nummer
						;
			}
			
		} // end of class Raum
		
		
	} // end of class Stockwerk
	
	
	/*
	 * weitere Elemente der Klasse Gebaeude
	 */
	private Stockwerk[] stockwerke;
	private String strasse;
	private String nummer;
	
	public Gebaeude(String strasse, String nummer, 
			int anzahlStockwerke, int anzahlRaeumeProStockwerk) {
		this.strasse = strasse;
		this.nummer = nummer;
		
		if(anzahlStockwerke < 1) {
			throw new IllegalArgumentException("Anzahl der "
					+ "Stockwerke darf nicht kleiner als 1 sein. Aktuell: " 
					+ anzahlStockwerke);
		}
		
		this.stockwerke = new Stockwerk[anzahlStockwerke];
		for (int i=0; i<anzahlStockwerke; i++) {
			this.stockwerke[i] = this.new Stockwerk(i, anzahlRaeumeProStockwerk);
		}
	}
	
	public int getAnzahlStockwerke() {
		return stockwerke.length;
	}
	public int getAnzahlRaeumeProStockwerk() {
		return stockwerke[0].raeume.length;
	}
	
	public Stockwerk.Raum getRaum(int stockwerkNr, int raumNr) {
		return getStockwerk(stockwerkNr).getRaum(raumNr);
	}
	
	public Stockwerk getStockwerk(int stockwerkNummer) {
		if(stockwerkNummer>=getAnzahlStockwerke() || stockwerkNummer<0) {
			String errMsg = String.format("Falsche Stockwerknummer: %d. Gültige Werte: [%d .. %d)", 
					stockwerkNummer, 0, getAnzahlStockwerke());
			throw new IllegalArgumentException(errMsg);
		}
		
		return stockwerke[stockwerkNummer];
	}
	
	@Override
	public String toString() {
		return strasse + " " + nummer 
				+ ". Stockwerke: " + getAnzahlStockwerke()
				+ ", Räume/Stockwerk: " + getAnzahlRaeumeProStockwerk();
	}
}
