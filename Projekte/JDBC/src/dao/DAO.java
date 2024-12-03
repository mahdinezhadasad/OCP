package dao;

public class DAO {

	/*
	 * DAO = Data Access Object
	 * 
	 * DAO: Design Pattern. Datenverwaltung vom Rest der Anwendung trennen 
	 *      und die Details der Realisierung der Datenverwaltung zu verstecken
	 * 
	 * Datenverwaltung: Speichern, Laden, Ändern, Löschen der Daten (CRUD)
	 * 
	 * DAO schlägt vor:
	 * 
	 * 		DAO-Interface (auf das Interface programmiert der Rest der Anwendung)
	 * 		DAO-Implementierungen (konkrete Realisierungen vom DAO-Interface)	
	 * 
	 * DAO-Interface sollte keine Details zu der konkreten Realisierung 
	 * der Datenverwaltung verraten 
	 * 
	 * Beispiel im Package 'aufgaben.dao.tiere':
	 * 
	 * 		DAO-Interface: TierDAO
	 * 
	 * 		DAO-Implementierung: TextFileTierDAO
	 * 
	 * 		Rest der Anwendung: AppMain (benutzt nur die Methoden vom TierDAO,
	 * 		kennt keine Details der Realisierung der Datenverwaltung)
	 * 
	 * Exam:
	 * 
	 * Welche Methoden sind für folgendes DAO-Interface sinnvoll?
	 * 
	 * interface PersonDAO {
	 *        void create(Person p);					// ok
	 *        void removeOnId(int id, Connection c);	// nicht sinnvoll: verrät Details der Realisierung
	 *        List<Person> getAll();					// ok
	 *        void setName(String name);				// nicht sinnvoll: ist sinnvoll in einer einfachen Klasse 'Person' 
	 *        Person getOnId(int id);					// ok
	 * }
	 * 		 
	 */
	public static void main(String[] args) {

	}

}
