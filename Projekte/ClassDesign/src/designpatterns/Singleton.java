package designpatterns;


class AppSettingsV1 {
	
	/*
	 * Singleton: statisches Attribut 
	 */
	public static final AppSettingsV1 INSTANCE = new AppSettingsV1();
	
	/*
	 * Singleton: alle Konstruktoren sind public
	 */
	private AppSettingsV1() {}
	
	/*
	 * weitere Attribute und Methoden der Klasse
	 */
	private String appDir = "mydir";
	
	public String getAppDir() {
		return appDir;
	}
	
	public void setAppDir(String appDir) {
		this.appDir = appDir;
	}
	
	//...
}


/*
 * eine weitere Variante einer Singleton-Klasse
 */
class AppSettingsV2 {
	
	private static AppSettingsV2 instance;
	
	public static AppSettingsV2 getInstance() {
		if(instance==null) {
			instance = new AppSettingsV2();
		}
		return instance;
	}
	
	private AppSettingsV2() {
		
	}
	
	// weitere Attribute und Methoden...
}


/*
 * eine weitere Variante einer Singleton-Klasse
 */
enum AppSettingsV3 {
	INSTANCE
}


public class Singleton {

	/*
	 * Singleton: die Klasse so gestalten, dass nur ein einziges 
	 * Objekt dieser Klasse erstellt werden kann.
	 * 
	 *  Exam! Achten Sie darauf, dass alle Konstruktoren private sind!
	 */
	public static void main(String[] args) {
		
//		new AppSettingsV1();
//		new AppSettingsV2();
//		new AppSettingsV3();

		System.out.println( AppSettingsV1.INSTANCE );
		System.out.println( AppSettingsV2.getInstance() );
		System.out.println( AppSettingsV3.INSTANCE );

	}

}
