package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

	}

}
