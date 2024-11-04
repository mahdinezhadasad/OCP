package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class B01_KonzeptLesenSchreiben {

	/*
	 * Bitte in der Praxis die Mehoden 'read()' und 'write(int)' 
	 * nicht verwenden. Es gibt alternativen, die effizienter arbeiten
	 */
	public static void main(String[] args) {

		/*
		 * Schreiben, danach Schliessen (hier mit try-with-resources)
		 */
		try (Writer out = new FileWriter("abc.txt")) {
		
			out.write('a');
			out.write('b');
			out.write('c');
			
			System.out.println("Datei geschrieben");
			
		} catch (IOException e) {
			System.out.println("Fehler beim Schreiben: " + e);
		}
		
		/*
		 * Lesen, danach Schliessen (hier mit try-with-resources)
		 */
		try (Reader in = new FileReader("abc.txt")) {
		
			int x = in.read();
			char ch = (char) x;
			System.out.println("gelesen: " + ch);
			
			ch = (char)in.read();
			System.out.println("gelesen: " + ch);
			
			ch = (char)in.read();
			System.out.println("gelesen: " + ch);
			
		} catch (IOException e) {
			System.out.println("Fehler beim Lesen: " + e);
		}

		
	}

}
