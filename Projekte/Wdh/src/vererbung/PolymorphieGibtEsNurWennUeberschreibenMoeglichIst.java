package vererbung;


class NormalBase {
	private void m1() {} // für andere nicht sichtbar
}
class NormalDerived extends NormalBase {
	public void m1() {} 
}

public class PolymorphieGibtEsNurWennUeberschreibenMoeglichIst {
	
	static class InnerBase {
		// wird nicht vererbt
		private void m1() { System.out.println("base/m1"); } 
	}
	
	static class InnerDerived extends InnerBase {
		// kein Überschreiben, m1 wird nicht geererbt:
		void m1() { System.out.println("derived/m1"); }
	}
	
	/*
	 * Wenn Überschreiben nicht möglich ist, 
	 * gibt es keine Polymorphie (kein Late Binding)
	 */
	public static void main(String[] args) {
		
		NormalBase ref1 = new NormalDerived();
//		ref1.m1(); // cf: private

		/*
		 * Achtung! Spezieller Fall.
		 */
		InnerBase ref2 = new InnerDerived();
		ref2.m1(); // base/m1
		
	}

}
