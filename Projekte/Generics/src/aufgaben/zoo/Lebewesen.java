package aufgaben.zoo;

public abstract class Lebewesen implements KannBehandeltWerden {
	private boolean gesund;
	private int id;
	
	public Lebewesen(int id) {
		this.id = id;
	}

	public boolean isGesund() {
		return gesund;
	}

	public void setGesund(boolean gesund) {
		this.gesund = gesund;
	}
	
	public String toString() {
		return getClass().getSimpleName() + 
				" (id=" + id + ") ist " + 
				(gesund ? "gesund" : "krank");
	}
}
