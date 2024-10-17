package aufgaben.autos;

public class TestComparableAutos {

	public static void main(String[] args) {
		
		VW vw1 = new VW("Golf", 1990);
		VW vw2 = new VW("Polo", 2021);
		
		int result = vw1.compareTo(vw2);
		System.out.println("vw1 compareTo vw2: " + result); // negativ 
		
		BMW bmw1 = new BMW("Z4", 2000);
		BMW bmw2 = new BMW("Z2", 2021);

		result = bmw1.compareTo(bmw2);
		System.out.println("bmw1 compareTo bmw2: " + result); // positiv 
		
		result = vw1.compareTo(bmw1);
		System.out.println("vw1 compareTo bmw1: " + result);		
		
	}

}
