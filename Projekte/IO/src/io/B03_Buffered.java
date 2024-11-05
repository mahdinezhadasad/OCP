package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Stream;

public class B03_Buffered {

	/*
	 * BufferedReader unf BufferedWriter haben beide auch die Konstruktoren-Varianten,
	 * die es erlauben die Größe des internen Puffers festzulegen 
	 */
	public static void main(String[] args) {

		try (BufferedReader in = new BufferedReader(new FileReader("autos.txt"));
				BufferedWriter out = new BufferedWriter(new FileWriter("autos-kopie.txt"))) {

			String line;
			while( (line = in.readLine()) != null ) {
				out.write(line);
				out.write("\n");
			}
			
			System.out.println("fertig");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Interessant: es gibt Methode lines(), die ein Stream<String> öffnet
		 */
		
		String s = "Line A\nLine B\nLine C";
		
		try(BufferedReader br = new BufferedReader(new StringReader(s))) {
			br.lines() // Stream<String>
			  .forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
