package wdh.strings;

public class B01 {

	public static void main(String[] args) {
		
		/*
		 * Wie viele neue String-Objekte werden durch den Aufruf
		 * der Methode m() in der Zeile A erzeugt?  
		 */
		String s = m(); // Zeile A
	}

	static String m() {
		String s = "mo";
		
		String s2 = s;
		
		String s3 = "mo";
		
		String s4 = att;
		
		return s.toString();
	}
	
	static String att = "mo";
	
}
