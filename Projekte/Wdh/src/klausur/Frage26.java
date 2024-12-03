package klausur;

import java.util.Map;


class Pairs1 {
	class Element {}
}

class Pairs2 {
	static class Element {}
}

class Pairs3 {
	static class Element <T> {}  // generische Klasse
}
class Pairs4 {
	static class Element <T, X> {}  // generische Klasse
}
class Pairs5 {
	static class Element implements Map.Entry<Integer, String> { // keine generische Klasse
		public Integer getKey() {return null;}
		public String getValue() { return null; }
		public String setValue(String value) { return null;}
	}  
}
class Pairs6 {
	static class Element <T> implements Map.Entry<Integer, String> { // generische Klasse
		public Integer getKey() {return null;}
		public String getValue() { return null; }
		public String setValue(String value) { return null;}
	}  
}
class Pairs7 {
	static class Element <T> implements Map.Entry<T, String> { // generische Klasse
		public T getKey() {return null;}
		public String getValue() { return null; }
		public String setValue(String value) { return null;}
	}  
}



public class Frage26 {

	public static void main(String[] args) {
		
		// new Pairs1.Element();     // cf
		new Pairs1().new Element();
		
		new Pairs2.Element();
		// new Pairs2().new Element(); // cf
		
		Map.Entry<Integer, String> entry1 = new Pairs5.Element();
		
		Map.Entry<Integer, String> entry2 = new Pairs6.Element();
		Map.Entry<Integer, String> entry3 = new Pairs6.Element<Boolean>();
		
		Map.Entry<Integer, String> entry4 = new Pairs7.Element<Integer>();

	}

}
