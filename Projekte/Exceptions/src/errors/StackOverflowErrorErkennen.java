package errors;

public class StackOverflowErrorErkennen {

	/*
	 * Exam:
	 * 
	 * 	- eine (auch endlose) Schleife ist kein Grund für StackOverflow
	 * 	- Rekursiver Aufruf ohne Abbruch verursacht StackOverflowError 
	 * 
	 */
	
	/*
	 * Was ist das Ergebnis?
	 * 
	 * A. 0 1 2 3 
	 * B. 0 0 0 ... gefolgt vom StackOverflowError			<- richtig
	 * C. Compilerfehler
	 * D. eine andere sinnlose Antwort
	 * 
	 *   
	 *   print(x = 0) {
	 *   
	 *     	ausgabe x
	 *   	
	 *      print(x' = 0) {
	 *      
	 *      	ausgabe x'
	 *      
	 *          SOE
	 *      }
	 *   }
	 */
	public static void main(String[] args) {
		print(0);
	}
	
	static void print(int x) {
		if(x>3) {
			return;
		}
		
		System.out.println(x);
		print(x++); // int x' = x++
	}
	
	
	/*
	 * StackOverflowError
	 */
	static void m2() {
		m2();
	}
	
	
	/*
	 * Methode hat eine endlose Schleife aber keinen StackOverflowError
	 */
	static void m1() {
		for (int i = 0; i < 1_000; i++) {
			if(i>100) {
				i=0;
			}
		}
	}

}
