package inner;

abstract class Tier {
	
	static Tier getLieblingstier() {
		return null;
	}
	
}

public class B05_SowasWieClosure {

	public static void main(String[] args) {
		
		Tier t1 = Tier.getLieblingstier();
		
		System.out.println(t1);
		

	}

}
