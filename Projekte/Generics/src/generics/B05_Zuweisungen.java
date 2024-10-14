package generics;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class B05_Zuweisungen {

	public static void main(String[] args) {
		/*
		 * Zuweisung bei 'normalen' Referenzen.
		 * 
		 * Compiler kontrolliert die IS-A-Beziehung von rechts nach links.
		 */
		Number  n1 = null;
		Integer i1 = null;
		Double  d1 = 12.3;

		i1 = i1; // Integer <- IS-A <- Integer
		n1 = i1; // Number <- IS-A <- Integer
		n1 = d1; // Number <- IS-A <- Double
		
		/*
		 * Zuweisungen bei parametrisierten Referenzen
		 * von generischen Typen hat zwei Compiler-Kontrollen:
		 * 
		 * 1. Is-A-Beziehung von rechts nach links muss es geben
		 * 2. Parametrisierungen müssen gleich sein. 
		 *    Vererbung ist nicht erlaubt!
		 * 		(Platzhalter/Wildcards werden später besprochen)
		 */
		
		List<Integer> listInt;
		Set<Integer> setInt;
		Collection<Number> collNum = new ArrayDeque<>();
		
		listInt = new LinkedList<Integer>();
		
//		setInt = listInt;	// 1. Set <- IST-KEIN <- List		- cf
		
//		collNum = listInt;	// 1. Collection <- IS-A <- List	- OK
							// 2. <Number> nicht gleich <Integer> - cf
		
		// da die Zuweisung collNum = listInt nicht kompiliert,
		// bleibt LinkedList-Objekt typsicher, sonst wäre es weiter möglich:
		collNum.add(n1);
		collNum.add(i1);
		collNum.add(d1);
		
		Collection<Integer> collInt;
		
		collInt = listInt;	// 1. Collection <- IS-A <- List	- OK
							// 2. <Integer> gleich <Integer>	- OK

		// LinkedList-Objekt bleibt typsicher, denn
		// auch mit der collInt können nur Integer-Elemente
		// gespeichert werden:
		collInt.add(i1);
//		collInt.add(n1); // cf
//		collInt.add(d1); // cf
		
	}

}
