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
	
	static class Hund extends Tier {
		static int maxAlter = 22;
		
		public static int getMaxAlter() {
			return maxAlter;
		}
		
		int alter = 3;
		
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
		
		System.out.println( Tier.maxAlter ); // 1000
		System.out.println( Tier.getMaxAlter() ); // 1000 
												  // starte getMaxAlter() aus Tier
		
		Tier t1 = new Hund();
		System.out.println( t1.alter );	// 12

		/*
		 * Late Binding = JVM entscheidet, aus welcher Klasse die 
		 * Instanzmethode aufgerufen werden soll 
		 */
		System.out.println( t1.getAlter() ); // 3
											 // suche das Objekt,
											 // ermittle seine Klasse,
											 // starte getAlter() aus der 
											 // ermittelten Klasse
		/*
		 * Weitere Tests
		 */
		System.out.println("weitere Tests...");
		Tier t2 = null;
		System.out.println( t2.maxAlter ); // 1000 (Tier.maxAlter)
		System.out.println( t2.getMaxAlter() ); // 1000 (Tier.getMaxAlter())
		
		t2 = new Hund();
		System.out.println( t2.maxAlter ); // 1000 (Tier.maxAlter)
		System.out.println( t2.getMaxAlter() ); // 1000 (Tier.getMaxAlter())
		
		System.out.println( t2.alter ); // 12 (early binding)
		System.out.println( t2.getAlter() ); // 3 (late binding)
		
		/*
		 * Casting:    (GewünschterTyp)ReferenzRechts
		 * 		
		 * 		für den Compiler: der Compiler soll die Referenz rechts
		 * 						  als Referenz von einem gewünschten Typ
		 * 						  betrachten
		 * 
		 * 	    für JVM: überprüfen ob die Referenz rechts
		 *               zum Objekt führt, das vom Typ ist,
		 *               der IS-A-Beziehung zum gewünschten Typ hat.
		 *               Wenn nicht: ClassCastException werfen
		 */
		System.out.println("mit casting testen...");
		
		Hund h1 = new Hund();
		System.out.println( h1.alter ); // 3
		
		System.out.println( ((Tier)h1).alter ); // 12
		
		Tier t3 = new Hund();
		System.out.println( ((Hund)t3).alter ); // 3
		System.out.println( t3.alter ); // 12
		
		System.out.println( h1.getMaxAlter() ); // 22 Hund.getMaxAlter()
		System.out.println( ((Tier)h1).getMaxAlter() ); // 1000 Tier.getMaxAlter()
		
		
		System.out.println( t3.getAlter() ); // 12
		
	}

}
