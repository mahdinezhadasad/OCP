package loc;

import java.util.ResourceBundle;

public class B06_ResourceBundle {

	/*
	 * Mit ResourceBundle wird eine Anwendung so programmiert,
	 * dass man die Anwendung einfacher lokalisieren kann.
	 */
	public static void main(String[] args) {
		mitResourceBundle();
	}
	
	static void mitResourceBundle() {
		String baseName = "loc.res.app";
		ResourceBundle bundle = ResourceBundle.getBundle(baseName);
		
		String greeting = bundle.getString("greeting");
		System.out.println(greeting);
	}
	
	static void ohneResourceBundle() {
		String greeting = "Guten Tag!";
		System.out.println(greeting);
	}

}
