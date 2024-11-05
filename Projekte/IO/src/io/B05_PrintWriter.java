package io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class B05_PrintWriter {

	public static void main(String[] args) {
		/*
		 * Es gibt viele Konstruktoren, mit denen viele unterschiedliche 
		 * Ziele festgelegt werden können
		 * 
		 * PrintWriter(File filePath)
		 * PrintWriter(String fileName)
		 * PrintWriter(OutputStream)
		 * PrintWriter(Writer)
		 * ...
		 */
		
		try( PrintWriter out = new PrintWriter("tiere.txt") ) {
			
			out.format("Katze %s%n", "Tom");
			out.println("Hund Rex");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("fertig");
	}

}
