package aufgaben;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class AufgabeStreamCollectorWarenkorb {
	
	static Map<String, Integer> produktPreis = new HashMap<>();
	
	static {
		produktPreis.put("Brot", 129);
		produktPreis.put("Wurst", 199);
		produktPreis.put("Milch", 119);
	}

	public static void main(String[] args) {
//		a1();
//		a2();
	}
	
	static void a2() {
		List<Bestellung> bestellungen = new ArrayList<>();
		bestellungen.add(new Bestellung("Brot", 3));
		bestellungen.add(new Bestellung("Wurst", 1));
		bestellungen.add(new Bestellung("Milch", 2));
		
		List<Produkt> produkteImWarenkorb = buildWarenkorb(bestellungen);
		produkteImWarenkorb.forEach(System.out::println);
	}
	
	static List<Produkt>  buildWarenkorb(List<Bestellung> bestellungen) {
		Supplier<List<Produkt>> supp = ArrayList::new;
		
		BiConsumer<List<Produkt>, Bestellung> acc = (listProdukte, bestellung) -> {
			String produktName = bestellung.getProduktName();
			int preis = produktPreis.get(produktName);
			for(int i = 0; i < bestellung.getAnzahl(); i++) {
				listProdukte.add(new Produkt(produktName, preis));
			}
		};
		
		BiConsumer<List<Produkt>, List<Produkt>> comb = (list1, list2) -> list1.addAll(list2);
		comb = List::addAll;
		
		return bestellungen.stream().collect(supp, acc, comb );
	}
	
	static void a1() {
		List<Produkt> warenkorb = new ArrayList<>();
		warenkorb.add(new Produkt("Brot", 129));
		warenkorb.add(new Produkt("Wurst", 230));
		warenkorb.add(new Produkt("Milch", 99));
		warenkorb.add(new Produkt("Milch", 99));
		
		int gesamtsumme = warenkorb.stream().map(produkt -> produkt.getPreis()).reduce(0, (p1 , p2) -> p1 + p2);
		System.out.println("gesamtsumme = " + gesamtsumme);
		
		gesamtsumme = warenkorb.stream().mapToInt(produkt -> produkt.getPreis()).sum();
		System.out.println("gesamtsumme = " + gesamtsumme);
	}

}

class Produkt {
	private String name;
	private int preis;
	
	// Konstruktoren und Methoden hier, wenn nötig...
	Produkt(String name, int preis) {
		this.name = name;
		this.setPreis(preis);
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}
	
	public String toString() {
		return name + " " + preis/100.;
	}
}

class Bestellung {
	private String produktName;
	private int anzahl; // gewünschte Anzahl der Produkt-Objekte
	
	// Konstruktoren und Methoden hier, wenn nötig...
	Bestellung(String produktName, int anzahl) {
		this.produktName = produktName;
		this.anzahl = anzahl;
	}

	public String getProduktName() {
		return produktName;
	}

	public void setProduktName(String produktName) {
		this.produktName = produktName;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	
	
	
	
	
}
