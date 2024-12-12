package innere;

public class AllesUeberThis {

	public static void main(String[] args) {
		
	}
	
	void test() {
		
		/*
		 * this ist die Konstante Referenz
		 * 
		 */
		Object v1 = this;
		AllesUeberThis v2 = this;
		
		/*
		 * der 'echte' Namen von this
		 */
		AllesUeberThis v3 = AllesUeberThis.this;
		
		
		/*
		 * diese this ist auch in nichtstatischen inneren Klassen erreichbar,
		 * aber lokale Klassen haben auch ihre eigene this
		 */
		class MyInnerClass {
			void myMethod() {
				MyInnerClass v4 = this; // implizit MyInnerClass.this
				MyInnerClass v5 = MyInnerClass.this;
				
				AllesUeberThis v6 = AllesUeberThis.this;
			}
		}
		
		
	} // end of test
	
	
	
	class Motor {
		
	}
	
	void innereKlassenInstanziieren() {
		AllesUeberThis v1 = new AllesUeberThis();
		Motor m1 = v1.new Motor();
		
		AllesUeberThis v2 = this;
		Motor m2 = v2.new Motor();
	
		Motor m3 = this.new Motor();
		
		Motor m4 = new Motor(); // implizit this.new Motor();
	}

}
