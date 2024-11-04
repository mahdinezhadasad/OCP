package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class B02_manuellerPuffer {

	public static void main(String[] args) {
		
		char[] cbuf = new char[16];
		
		try ( Reader in = new FileReader("autos.txt") ) {
			
			int anzahlGelesen;
			while( (anzahlGelesen = in.read(cbuf)) != -1 ) {
				
				String s = String.valueOf(cbuf, 0, anzahlGelesen);
				
				System.out.print(s);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
