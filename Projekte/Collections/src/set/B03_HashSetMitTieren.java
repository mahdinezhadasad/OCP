package set;

import java.util.HashSet;
import java.util.Set;

class Tier {
	String name;
	int alter;
	
	Tier(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}
	
	public String toString() {
		return name + " (" + alter + ")";
	}

	/*
	 * equals vergleicht Tiere nach Inhalten
	 */
	public boolean equals(Object obj) {
		Tier t2 = (Tier)obj;
		return name.equals(t2.name) && alter == t2.alter;
	}
	
	/*
	 * Korrekte hashCode:
	 * 		- gleiche Objekte haben denselben Hashcode
	 * 
	 * Sinnvolle hashCode:
	 * 		- Hashcode aus den Attributen berechnen,
	 *        die in der equals zum Vergleichen verwendet werden	
	 */
	public int hashCode() {
//		return 42; // korrekt, aber nicht sinnvoll
		return alter + name.hashCode(); // sinnvoll
	}
}

public class B03_HashSetMitTieren {

	public static void main(String[] args) {
		
		Set<Tier> set = new HashSet<Tier>();
		
		Tier t1 = new Tier("Tom", 5);
		
		set.add(t1);
		set.add(t1);
		
		System.out.println("1. size: " + set.size()); // 1
		
		set.add(new Tier("Jerry", 7));
		
		System.out.println("2. size: " + set.size()); // 2
		
		set.add(new Tier("Tom", 5));

		System.out.println("3. size: " + set.size()); // 2
		
		System.out.println(set);
	}

}
