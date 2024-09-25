package errors;

import java.util.Arrays;

public class B02_AssertionsStatements {

	/*
	 * nicht vergessen die Assertions zu aktivieren:
	 * 
	 * 
	 * 		java -ea NameDerKlasseMitDerMain
	 */
	public static void main(String[] args) {
		/*
		 * Statement I:
		 * 		assert <boolean>;
		 * 
		 * Statement II:
		 * 		assert <boolean> : <value>;
		 */

//		assert 22; // cf
		
		assert true;
		
		int x = 0;
		
		assert x == 0;
		
		assert x == 0 : "x sollte 0 sein";
		
		x = 1;
		assert x == 0 : "Nochmals. x sollte 0 sein";
		
		assert true : 12;
		assert true : new Object();
		assert true : Arrays.asList(1, 2, 3, 4, 5);
//		assert true : System.out.println("hallo welt"); // cf: println ist void
		
		System.out.println("end of main");
	}

}
