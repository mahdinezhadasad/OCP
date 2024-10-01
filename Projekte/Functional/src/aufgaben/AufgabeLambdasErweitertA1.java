package aufgaben;

import java.util.function.Consumer;

public class AufgabeLambdasErweitertA1 {

	public static void main(String[] args) {
		class C1 implements Consumer<Integer> {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		}
	
		Consumer<Integer> c1 = new C1();
		c1.accept(12);	
		
		Consumer<Integer> c2 = new Consumer<Integer> () {
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		c2.accept(12);	
		
		Consumer<Integer> c3 = (Integer t) -> {
			System.out.println(t);
		};
		c3.accept(12);

		Consumer<Integer> c4 = t -> System.out.println(t);
		c4.accept(12);
	}

}
