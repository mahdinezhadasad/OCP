package aufgaben.dao.tiere;

public class Tier {
	
	private int id;
	private String name;
	private String art;
	private int geburtsjahr;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getArt() {
		return art;
	}
	public int getGeburtsjahr() {
		return geburtsjahr;
	}
	
	public Tier(int id, String name, String art, int geburtsjahr) {
		this.id = id;
		this.name = name;
		this.art = art;
		this.geburtsjahr = geburtsjahr;
	}
	
}
