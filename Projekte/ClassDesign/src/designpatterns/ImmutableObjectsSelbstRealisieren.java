package designpatterns;

import java.util.Arrays;

/*
 * Entwickler Tom garantiert, dass Laden-Objekte immutable sind
 */
final class Laden {
	
	/*
	 * Klasse gut kapseln
	 */
	private String[] produkte;
	
	Laden(String... produkte) {
		// this.produkte = produkte; // falsch, der Parameter ist mutable
		
		// defensiv das mutable Argument behandeln:
		this.produkte = Arrays.copyOf(produkte, produkte.length);
	}
	
	/*
	 * es darf keine Methoden geben, die das Laden-Objekt ändern 
	 */
//	public void setProdukte(String[] produkte) {
//		this.produkte = produkte;
//	}
	
	public String[] getProdukte() {
		// return produkte; // falsch, das Attribut ist mutable
		
		// 'defensiv' das mutable Attribut liefern
		return Arrays.copyOf(produkte, produkte.length);
	}
	
	public String toString() {
		return "Laden hat " + Arrays.toString(produkte);
	}
	
	//...
}


public class ImmutableObjectsSelbstRealisieren {

	public static void main(String[] args) {
		/*
		 * Entwickler Jerry verwendet die Klasse Laden
		 */
		String[] arr = { "Milch", "Wurst", "Brot" };
		
		final Laden laden = getInstance(arr);
		System.out.println("1. " + laden); // "Milch", "Wurst", "Brot"
		
		// laden.produkte[0] = "Butter";
		arr[0] = "Butter";
		laden.getProdukte()[0] = "Zitrone";
		
		//...
		
		System.out.println("2. " + laden); // "Milch", "Wurst", "Brot"
	}

	/*
	 * Entwicklerint Ute realisiert eine Fabrikmethode
	 */
	static Laden getInstance(String... produkte) {
		return new Laden(produkte);
	}
	
//	private static class RandomLaden extends Laden {
//		public RandomLaden(String... produkte) {
//			super(produkte);
//		}
//		
//		@Override
//		public String toString() {
//			if(new Random().nextBoolean()) {
//				return Arrays.toString(new String[] { "mo", "di", "mi" });
//			}
//			
//			return super.toString();
//		}
//	}
	
}


