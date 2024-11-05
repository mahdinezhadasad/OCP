package io;

import java.io.Console;
import java.util.Arrays;

public class B06_Console {

	/*
	 * Achtung! Eclipse startet die JVM ohne System-Konsole!
	 * Beim Starten dieses Beispiels aus Eclipse liefert die Methode
	 * System.console() null zurück.
	 * 
	 * Um das Beispiel auszuprobieren, muss man manuell die main-Methode starten:
	 * 
	 * Die Datei test-console.bat ausführen.
	 * 
	 * Das kann auch unter Eclipse im 'Terminal' gemacht werden. 
	 * 'Terminal' unter Eclipse im Menu finden: Window->Show View->Terminal.
	 * Aber einfacher ist es: im Package-Explorer auf 'test-console.bat' Rechtclick machen
	 * und im Kontext-Menu 'Show In'->'Terminal' auswählen.
	 * 
	 * 
	 */
	public static void main(String[] args) {

//		Console c0 = new Console();			// cf
//		Console c1 = Console.getInstance(); // cf
		
		Console c = System.console();
		
		String day = "Dienstag";
		c.format("Heute ist %s%n", day);
		c.printf("Gestern war Montag%n");

		/*
		 * String readLine()
		 */
		c.format("Bitte den Namen eingeben: ");
		String userName = c.readLine();
		
		c.format("gelesen: %s%n", userName);
		
		/*
		 * String readLine(String fmt, Object ... args)
		 */
		String userAnswer = c.readLine("Ist der Name %s richtig? (j/n): ", userName);
		c.format("gelesen: %s%n", userAnswer);

		/*
		 * char[] readPassword()
		 * char[] readPassword(String fmt, Object ... args)
		 */
		c.format("Passwort eingeben: ");
		char[] pwd = c.readPassword();
		
		c.format("pwd-Array: %s%n", Arrays.toString(pwd));
		
		/*
		 * Exam:
		 */
		// String s = c.readPassword(); // cf: String <- IST-KEIN <- char[]
		
	}

}
