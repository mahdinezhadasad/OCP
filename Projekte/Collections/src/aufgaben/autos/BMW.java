package aufgaben.autos;

public class BMW extends Auto {
	public BMW(String modell, int baujahr) {
		super(modell, baujahr);
	}
	
	public void setBaujahr(int baujahr) {
		this.baujahr = baujahr;
	}
}
