package exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class B15_try_with_resources_suppressed_Exceptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/*
	 * Vor Java 7
	 */
	static void copy(String inputFile, String outputFile) {
		
		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
		
		String line;
		while( (line = in.readLine()) != null ) {
			out.write(line);
			out.newLine();
		}
		
		in.close();
		out.close();
		
	}
	
}
