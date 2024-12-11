package innere;

class Outer {
	
	class Inner {
		void testAccess() {
			Outer o = Outer.this;
			
			System.out.println(v1); // existiert in Outer.this und ist sichtbar
			System.out.println(v2); // existiert und ist sichtbar
			
			m1(); // wird mit dem Objekt Outer.this aufgerufen und ist sichtbar
			m2(); // sichtbar
		}
	}
	
	static class StaticInner {
		void testAccess() {
			// Outer o = Outer.this;
			
			// System.out.println(v1); // existiert nicht
			System.out.println(v2); // existiert und ist sichtbar
			
			// m1(); // braucht ein Objekt Outer und ist sichtbar
			m2(); // sichtbar
		}
	}
	
	/*
	 * weitere Elemente aus Outer 
	 */
	private int v1; 
	private static int v2;
	
	private void m1() {}
	private static void m2() {}
}

public class GueltigkeitUndSichtbarkeit {

	public static void main(String[] args) {


	}

}
