package aufgaben.autos;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AufgabeCollectionsAutos {

	public static void main(String[] args) {
		
		BMW bmw1 = new BMW("Z4", 2000);
		System.out.println(bmw1); // BMW. Modell: Z4, Baujahr 2000

		VW vw1 = new VW("Golf", 1990);
		System.out.println(vw1); // VW. Modell: Golf, Baujahr 1990
		VW vw2 = new VW("Polo", 2021);
		VW vw3 = new VW("Golf", 2024);
		
		/*
		 * A4
		 */
		List<VW> listVW = new LinkedList<>();
		listVW.add(vw1);
		listVW.add(vw2);
		listVW.add(vw3);
		
		print(listVW);
		
		Set<VW> hashSetVW = new HashSet<>();
		hashSetVW.addAll(listVW);
		
		print(hashSetVW);
	}

	static void print(Collection<VW> coll) {
		System.out.println("\n*** " + coll.getClass());
		
		int i = 0;
		for(VW vw : coll) {
			System.out.println(i++ + ". " + vw);
		}
	}
}
