package inner;

public class TestObj {
	public static void main(String[] args) {
		Object o = new Object() { // Anonymous class extending Object
			public boolean equals(Object obj) { // Overriding equals method
				return true;
			}
		};
		System.out.println(o.equals("Fred"));
	}
}