package loc;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Properties;

public class B02_Properties {

	/*
	 * - Properties sind Konfigurationen für ein Programm.
	 * 
	 * z.B. wenn ein Programm übers Netzwerk von einem Server Daten 
	 * holen soll, kann die Server-IP-Adresse eine Property sein.
	 * 
	 * - Klasse java.util.Properties: Klasse zum Speichern/Laden der 
	 *   Konfigurationen
	 *   
	 * - Datei 'name.properties': Datei mit Properties
	 * 
	 */
	public static void main(String[] args) {
		
		Properties props = new Properties();
		
		/*
		 *  Properties aus der Datei in das Properties-Objekt laden
		 */
		try (Reader in = new FileReader("myapp.properties")) {
			props.load(in);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		
		/*
		 * Statt die Server-IP hartkodiert zu haben, wird sie
		 * als Property 'server-ip' geladen
		 */
//		String serverIP = "192.168.1.1";
		String serverIP = props.getProperty("server-ip");
		System.out.println("server-ip: " + serverIP);

		
	}

}
