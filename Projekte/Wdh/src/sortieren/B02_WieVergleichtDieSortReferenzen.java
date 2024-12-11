package sortieren;

import java.util.Comparator;

public class B02_WieVergleichtDieSortReferenzen {

	public static void main(String[] args) {
		Comparator<Object> myComparator = (a, b) -> 0; 
		
		Object[] arr = {
			"gg", "kk"	
		};
	
		int i = 0;
		
		// irgendwo in der sort-Methode...
		// sort nimmt zwei Elemente aus dem Array,
		// und überprüft, ob sie in der richtigen 
		// Reihenfolge stehen
		
		Object elementX = arr[i]; 
		Object elementY = arr[i+1]; 

		/*
		 * so geht es nicht, da es keinen Operator > für Referenzen gibt:
		 */
//		if(elementX > elementY) {  
//			// Positionen von elementX und elementY vertauschen...
//		}
		
		/*
		 * es gibt zwei mögliche Lösungen:
		 * 
		 * Lösung A: mit Comparable
		 * Lösung B: mit Comparator
		 */
		
		
		/*
		 * wenn Lösung A aktiviert ist:
		 */
		Comparable x = (Comparable)elementX;
		if( x.compareTo(elementY) > 0 ) {
			// Positionen von elementX und elementY vertauschen...
		}
		
		/*
		 * wenn Lösung B aktiviert ist, dann hat
		 * die sort einen Comparator
		 */
		if( myComparator.compare(elementX, elementY) > 0 ) {
			// Positionen von elementX und elementY vertauschen...
		}
		
		
	}
	
	

}
