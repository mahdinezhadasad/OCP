package generics;

import java.util.Comparator;

public class B07_PlatzhalterExam {

	public static void main(String[] args) {

		/*
		 * Number ist Basisklasse für Byte, Short, Integer, 
		 * Long, Float und Double
		 */
		
		Comparator<? extends Number> cmpExtendsNum = null;
		Comparator<Number> cmpNum = null;
		Comparator<Integer> cmpInt = null;
		
		cmpExtendsNum = cmpNum;
		cmpExtendsNum = cmpInt;
		
//		cmpNum = cmpExtendsNum; // cf, aber bereits unwahrscheinlich in der Prüfung
		
//		cmpNum = cmpInt; // cf: Parametrisierungen sind nicht gleich
	
		/*
		 * Unwahrscheinlich in der Prüfung ist 
		 * auch der folgende Compilerfehler:
		 */
		// cmpExtendsNum.compare(12, 13); // Referenz ist mit '? extends' parametrisiert
		
	}

}
