package exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class MyResourceA implements AutoCloseable {
	public void close() {
		throw new RuntimeException("exc close A");
	}
}
class MyResourceB implements AutoCloseable {
	public void close() {
		throw new RuntimeException("exc close B");
	}
}

public class B15_try_with_resources_suppressed_Exceptions {

	public static void main(String[] args) {
		
		System.out.println("*** Bsp. 1");
		try (MyResourceA rA = new MyResourceA();
				MyResourceB rB = new MyResourceB()) {
			
			throw new RuntimeException("exc aus try"); // wird an den catch übergeben
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); // exc aus try
			
			Throwable[] arrSuppressed = e.getSuppressed();
			for(Throwable supp : arrSuppressed) {
				System.out.println(supp.getMessage()); // exc close B
														// exc close A
			}
		}
		
		System.out.println("\n*** Bsp. 2");
		try (MyResourceA rA = new MyResourceA()) {
			
		} catch (Exception e) {
			System.out.println(e.getMessage()); // exc close A
		}

	}

	
	/*
	 * Aufgaben
	 * 		- garantiert die Ressourcen schliessen
	 * 		- keine Exceptions verlieren
	 * 
	 * ab Java 7
	 * 
	 * Wenn es eine oder mehrere Exceptions gibt, werden sie
	 * alle erhalten bleiben: eine wird die Haupexception sein,
	 * die anderen die suppressed Esxceptions
	 */
	static void copy(String inputFile, String outputFile) throws IOException {
		try(BufferedReader in = new BufferedReader(new FileReader(inputFile));
			BufferedWriter out = new BufferedWriter(new FileWriter(outputFile))) {
			
			String line;
			while( (line = in.readLine()) != null ) {
				out.write(line);
				out.newLine();
			}
		}
	}
	
	/*
	 * Aufgaben
	 * 		- garantiert die Ressourcen schliessen
	 * 		- keine Exceptions verlieren
	 * 
	 * Vor Java 7
	 * 
	 */
	static void copyOld(String inputFile, String outputFile) throws IOException {
		
		BufferedReader in = null;
		BufferedWriter out = null;
		
		IOException exc = null;
		
		try {
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));
			
			String line;
			while( (line = in.readLine()) != null ) {
				out.write(line);
				out.newLine();
			}
		} catch (IOException e) {
			exc = new IOException(e);
			
		} finally {
			try {
				if(out!=null) 
					out.close();
			} catch (IOException e) {
				if(exc==null) {
					exc = new IOException(e);
				} else {
					exc.addSuppressed(e);
				}
			}
			
			try {
				if(in!=null)
					in.close();
			} catch (IOException e) {
				if(exc==null) {
					exc = new IOException(e);
				} else {
					exc.addSuppressed(e);
				}
			}
		}
		
		if(exc!=null) {
			throw exc;
		}
		
	}
	
}
