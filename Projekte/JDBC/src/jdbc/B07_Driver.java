package jdbc;

public class B07_Driver {

	public static void main(String[] args) {
		/*
		 * Vor JDBC 4: Driver musste 'manuell' geladen werden.
		 * 
		 * Dafür sollte man in der Treiber-Dokumentation den Namen
		 * der Klasse suchen, die das Interface 'Driver' realisiert,
		 * und diese Klasse laden:
		 */
		try {
			Class.forName("org.apache.derby.iapi.jdbc.AutoloadedDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Ab JDBC 4: Driver wird automatisch geladen, wenn Connection
		 * zum ersten Mal erstellt wird.
		 * 
		 * Dafür wird die Treiber-Jar-Datei so aufgebaut:
		 * 
		 * 	/META-INF/
		 * 	    |-services/
		 *           |-java.sql.Driver           <- Textdatei mit dem Namen der Driver-Klasse	
		 */

		/*
		 * Eine zusätzliche Möglichkeit:
		 * 
		 * DriverManager lädt auch die Driver, die beim Start der Anwendung
		 * in System-Properties mit der Property 'jdbc.drivers' festgelegt 
		 * werden können:
		 * 
		 * 	java -Djdbc.drivers=foo.bah.Driver MyApp
		 * 
		 */
		
		
		
	}

}
