package generics;

import java.util.Comparator;

public class PlatzhalterErweitert {

	/*
	 * 
	 * <? extends X>  beschreibt eine Menge: X und abgeleitet von X
	 * <? super Y> beschreibt eine Menge: Y und Basistypen von Y
	 *    (diese Menge ist oben von Object beschränkt) 
	 *    
	 * <Z> beischreibt eine Menge: Z
	 * 
	 * Die 2. Zuweisungskontrolle ist OK, wenn die Menge links komplett 
	 * die rechte Menge einschliesst. 
	 * 
	 */
	public static void main(String[] args) {
		
		Comparator<Number> cmpNum = null;
		Comparator<Integer> cmpInt = null;
		Comparator<? extends Integer> cmpExtendsInt = null;
		Comparator<? extends Number> cmpExtendsNum = null;
		Comparator<? super Integer> cmpSuperInt = null;

//		cmpNum = cmpInt; // <Number> erlaubt nicht <Integer>
		cmpExtendsInt = cmpInt; // <? extends Integer> erlaubt <Integer> 

		cmpExtendsNum = cmpNum; // <? extends Number> erlaubt <Number>
		cmpExtendsNum = cmpNum; // <? extends Integer> erlaubt <Integer>

		cmpExtendsNum = cmpExtendsInt;
		
//		cmpSuperInt = cmpExtendsInt;
//		cmpSuperInt = cmpExtendsNum;
		
		Comparator<Object> cmpObj = null;
		Comparator<? super Object> cmpSuperObj = null;
		cmpSuperObj = cmpObj;
		cmpObj = cmpSuperObj; // Ausnahme: Der Compiler weißt, dass 
							  // Object keine Basisklassen hat
	
//		cmpInt = cmpExtendsInt; // cf: keine Ausnahme, obwohl <? extends Integer>
								//     nur die Klasse Integer beschreibt,
								//     da Integer final ist.
	}

}
