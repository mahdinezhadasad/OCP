package wdh.konstruktoren;

class Person {
	{ System.out.println("init 1"); }
	
	Person() {
		// super();
		// { System.out.println("init 1"); }
		// { System.out.println("init 2"); }
		System.out.println("Person()");
	}
	
	Person(int x) {
		// super();
		// { System.out.println("init 1"); }
		// { System.out.println("init 2"); }
		System.out.println("Person(int)");
	}
	
	Person(String s) {
		this();
		System.out.println("Person(String)");
	}
	
	{ System.out.println("init 2"); }
}

public class B04_InitBlocks {

	public static void main(String[] args) {
		new Person("asasasa");
	}

}
