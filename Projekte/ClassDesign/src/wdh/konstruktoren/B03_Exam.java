package wdh.konstruktoren;

class Tier {
	int id;
	
	Tier(int id) {
		// super(); // generiert
		this.id = id;
	}
}

/*

Die Klassen kompilieren nicht, weil sie alle den Aufruf super() haben,
aber die Basisklasse keinen solchen Konstruktor hat

class Hund extends Tier {
	// 
	// generierter default-Konstruktor:
	//
	// Hund() {
	//   super();
	// }
}

class Katze extends Tier {
	Katze() {
		// super(); // generiert
	}
}

class Zebra extends Tier {
	Zebra() {
		super();
	}
}
*/

class Maus extends Tier {
	Maus() {
		super(0); // Aufruf vom Konstruktor Tier(int)
	}
}

public class B03_Exam {

	public static void main(String[] args) {
		

	}

}
