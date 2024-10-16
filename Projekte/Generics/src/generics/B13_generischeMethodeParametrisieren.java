package generics;

import java.util.Arrays;
import java.util.List;

public class B13_generischeMethodeParametrisieren {

	public static void main(String[] args) {
		/*
		 * Normalerweise wird eine generische Methode
		 * bei dem Aufruf automatisch parametrisiert 
		 */
		
		Integer[] arrInt = { 1, 2, 3 };
		
		// parametrisiert mit Integer
		List<Integer> listInt = Arrays.asList(arrInt);
		
		// parametrisiert mit Number
		List<Number> listNum = Arrays.asList(arrInt);

		/*
		 * Explizite Parametrisierung ist auch möglich:
		 */
		listInt = Arrays.<Integer>asList(arrInt);
//		listInt = Arrays.<Number>asList(arrInt); // List<Integer> und List<Number>
		listNum = Arrays.<Number>asList(arrInt);
		
//		Arrays.<Integer>asList(args); // cf: asList(Integer...) mit String[] als Argument
		
	}

}
