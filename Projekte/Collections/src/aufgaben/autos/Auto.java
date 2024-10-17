package aufgaben.autos;

public abstract class Auto {
	protected String modell;
	protected int baujahr;
	
	public Auto(String modell, int baujahr) {
		this.modell = modell;
		this.baujahr = baujahr;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ". Modell: " + modell + ", Baujahr " + baujahr;
	}
}
