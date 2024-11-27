package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class B16_Transaction {

	/*
	 * Transaktion:
	 * 
	 * 		- besteht aus mehereren Schritten
	 * 			- Den Betrag von Konto A abheben
	 * 			- Den Betrag auf das Konto B gutschreiben
	 * 
	 *      - sollte atomar laufen (keine parallelen Änderungen dürfen vorkommen)
	 *      
	 *      - sollten nur stattfinden, wenn alle Schritte erfolgreich sind
	 */
	public static void main(String[] args) {

		JDBCUtils.rebuildTestTable();
		JDBCUtils.printTestTable();
		
		try (Connection c = DriverManager.getConnection("jdbc:derby:mydb")) {
			
			transaktionDurchfuehren(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JDBCUtils.printTestTable();
	}
	
	/*
	 * Gelb überweisen
	 * 
	 * von Konto A: Mary
	 * nach Konto B: Paul
	 * Betrag: 1500 
	 */
	private static void transaktionDurchfuehren(Connection c) throws SQLException {
		
		// aktuellen AutoCommit-Zustand merken, 
		// um nach der Transaktion die Connection in dem
		// Zustand wiederherstellen.
		boolean lastAutoCommit = c.getAutoCommit();
		
		try(Statement stm = c.createStatement()) {
			
			/*
			 * Transaktion starten
			 */
			c.setAutoCommit(false);
			
			final int betrag = 1500;
			
			final int idKontoA = 3;
			final int idKontoB = 2;
			
			/*
			 * Transaktion, Schritt 1
			 * 
			 * Geld vom Konto A abziehen
			 */
			int kontostandA = getKontostand(idKontoA, stm);
			//System.out.println("Kontostand A: " + kontostandA);
			
			if(kontostandA >= betrag) {
				kontostandA -= betrag;
				setKontostand(idKontoA, kontostandA, stm);
			}
			
			/*
			 * Abbruch simulieren (z.B. Stromausfall oder Netzwerkausfall)
			 */
			if(new Random().nextBoolean()) {
				throw new RuntimeException("Netzwerkausfall");
			}
			
			/*
			 * Transaktion, Schritt 2
			 * 
			 *  Geld auf dem Konto B addieren
			 */
			int kontostandB = getKontostand(idKontoB, stm);
			//System.out.println("Kontostand B: " + kontostandB);
			kontostandB += betrag;
			setKontostand(idKontoB, kontostandB, stm);
			
			/*
			 * Transaktion abschliessen und
			 * dadurch die Änderungen in der Datenbank übernehmen.
			 */
			c.commit();
			
		} catch (Exception e) {
			System.out.println("Fehler während der Transaktion! " + e.getMessage());
			c.rollback(); // Teiländerungen zurücksetzen
		}
		
		c.setAutoCommit(lastAutoCommit);
	}
	
	
	private static void setKontostand(int id, int betrag, Statement stm) throws SQLException {
		String sql = "UPDATE kunden SET kontostand=" + betrag + " WHERE id=" + id;
		int result = stm.executeUpdate(sql);
		if (result!=1) {
			throw new SQLException("Anzahl der betroffenen Zeilen muss 1 sein, ist aber " + result);
		}
	}
	
	private static int getKontostand(int id, Statement stm) throws SQLException {
		String sql = "select kontostand from kunden where id=" + id;
		try (ResultSet res = stm.executeQuery(sql)) {
			if(!res.next()) {
				throw new IllegalArgumentException("Unbekannte id: " + id);
			}
			
			int result = res.getInt(1);
			
			if(res.next()) {
				throw new IllegalStateException("Mehrfache id: " + id);
			}
			
			return result;
		}
	}

}
