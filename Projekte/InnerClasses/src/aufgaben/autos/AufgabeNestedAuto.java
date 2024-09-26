package aufgaben.autos;

public class AufgabeNestedAuto {

	public static void main(String[] args) {
		
	    Rennwagen rw = new Rennwagen("Mercedes");
		
	    Rennwagen.Fahrer f = new Rennwagen.Fahrer("M.", "Schuhmacher");
	    rw.setFahrer(f);
	
	    Rennwagen.Motor m = rw.getMotor();
	
	    System.out.println(rw);	 //Rennwagen Mercedes. Fahrer: M. Schuhmacher
	    System.out.println(m);	 //Motor Type1 aus dem Rennwagen Mercedes

	}

}
