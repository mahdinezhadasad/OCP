package aufgaben.ort;

public class Ort {
	private String ort;
	private String postleitzahl;
	private String bundesland;
	
	public Ort(String ort, String postleitzahl, String bundesland) {
		this.setOrt(ort);
		this.setPostleitzahl(postleitzahl);
		this.setBundesland(bundesland);
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPostleitzahl() {
		return postleitzahl;
	}

	public void setPostleitzahl(String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	public String getBundesland() {
		return bundesland;
	}

	public void setBundesland(String bundesland) {
		this.bundesland = bundesland;
	}

	@Override
	public String toString() {
		return "Ort [ort=" + ort + ", postleitzahl=" + postleitzahl + ", bundesland=" + bundesland + "]";
	}
	
	
	
}
