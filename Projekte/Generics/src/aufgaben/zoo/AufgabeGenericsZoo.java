package aufgaben.zoo;

import java.util.Collection;

public class AufgabeGenericsZoo {

	public static void main(String[] args) {
		
		Zoo zoo = new Zoo();
		
		zoo.addTier(new Affe(1));
		zoo.addTier(new Affe(2));
		
		zoo.addTier(new Zebra(3));
		zoo.addTier(new Zebra(4));
		zoo.addTier(new Zebra(5));

		Collection<Tier> tiere = zoo.getTiere();
		print(tiere);
		
		/*
		 * Tierarzt
		 */
		Arzt<Tier> tierArzt = new Arzt<>();
		for(Tier t : tiere) {
			tierArzt.behandeln(t);
		}
		
		System.out.println();
		print(tiere);
		
//		tierArzt.behandeln(new Mensch(10)); // cf
		tierArzt.behandeln(new Affe(11)); 
		tierArzt.behandeln(new Zebra(12)); 
		
		/*
		 * Affenarzt
		 */
		Arzt<Affe> affenArzt = new Arzt<>();
		affenArzt.behandeln(new Affe(13));
//		affenArzt.behandeln(new Zebra(14));
//		affenArzt.behandeln(new Mensch(15));
		
		/*
		 * Arzt für Tiere und Menschen
		 */
		Arzt<KannBehandeltWerden> superArzt = new Arzt<>();
		superArzt.behandeln(new Mensch(16));
		superArzt.behandeln(new Affe(17));
		superArzt.behandeln(new Zebra(18));
		superArzt.behandeln(tierArzt);
		superArzt.behandeln(affenArzt);
		
	}

	static void print(Collection<Tier> tiere) {
		int count = 1;
		for (Tier t : tiere) {
			System.out.println(count++ + ". " + t); // id, typ, gesund
		}
	}
}
