package aufgaben.zoo;

public class Arzt <P extends KannBehandeltWerden> extends Mensch {
	public Arzt() {
	    super(0);
	}
	
	public void behandeln(P patient) {
		if(!patient.isGesund()) {
			patient.setGesund(true);
		}
	}
}
