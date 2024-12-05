package vererbung;

public class PolymorphieOderNicht {
	
	
	static class Tier {
		static int maxAlter = 1000;
		
		public static int getMaxAlter() {
			return maxAlter;
		}
		
		int alter = 12;
		
		public int getAlter() {
			return alter;
		}
	}
	

	public static void main(String[] args) {
		/*
		 * Early Binding = Compiler legt fest, 
		 * aus welcher Klasse ein Element (Attribut oder Methode) 
		 * verwendet wird. 
		 * 
		 * Für die Entscheidung verwendet der Compiler 
		 * 	- den Typ einer Referenz
		 *  - oder den Klassennamen
		 */
		
		System.out.println( Tier.maxAlter );
		System.out.println( Tier.getMaxAlter() ); // starte getMaxAlter() aus Tier
		
		Tier t1 = new Tier();
		System.out.println( t1.alter );		

		/*
		 * Late Binding = JVM entscheidet, aus welcher Klasse die 
		 * Instanzmethode aufgerufen werden soll 
		 */
		System.out.println( t1.getAlter() ); // suche das Objekt,
											 // ermittle seine Klasse,
											 // starte getAlter() aus der 
											 // ermittelten Klasse

	}

}
