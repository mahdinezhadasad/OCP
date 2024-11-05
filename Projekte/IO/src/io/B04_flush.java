package io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class B04_flush {

	public static void main(String[] args) throws IOException {

		Writer fw = new FileWriter("lines.txt");
		
		fw.write("Line A\n"); // Die Zeichen werden im Puffer vom FileWriter gespeichert
	
		fw.flush(); // Inhalte aus dem Puffer an das Ziel weiter schieben
		
		// fw.close(); // wurde fürs Testen ausgelassen
		
		System.out.println("fertig");
		
		/*
		 * Exam! Nur Writer (oder OutputStream) haben die Methode flush()
		 */
		
		Reader in = null;
//		in.flush(); // cf: Reader hat keine Methode flush()
		
	}

}
