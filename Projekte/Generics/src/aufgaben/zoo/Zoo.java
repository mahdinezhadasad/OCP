package aufgaben.zoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Zoo {
	private List<Tier> tiere = new ArrayList<>();

	public void addTier(Tier t) {
		tiere.add(t);
	}
	
	public Collection<Tier> getTiere() {
		return Collections.unmodifiableList(tiere);
	}
}
