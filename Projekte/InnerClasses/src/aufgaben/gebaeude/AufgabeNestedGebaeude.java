package aufgaben.gebaeude;

public class AufgabeNestedGebaeude {

	public static void main(String[] args) {
		
		int anzahlStockwerke = 3;
		int anzahlRaeumeProStockwerk = 10;
		Gebaeude g = new Gebaeude("Hauptstr.", "45", 
				anzahlStockwerke, anzahlRaeumeProStockwerk);
		System.out.println(g);
		
		Gebaeude.Stockwerk s = g.getStockwerk(0);
		System.out.println(s);
		
		Gebaeude.Stockwerk.Raum r = g.getRaum(0, 2);
		System.out.println(r); // Raum 0.2 / Hauptstr. 45
	}

}
