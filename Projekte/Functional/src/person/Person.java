package person;

public class Person implements Comparable<Person>{
	private String name;
	private String beruf;
	
	public Person(String name, String beruf) {
		this.name = name;
		this.setBeruf(beruf);
	}
	
	public String toString() {
		return name;
	}

	public String getBeruf() {
		return beruf;
	}

	public void setBeruf(String beruf) {
		this.beruf = beruf;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Person p) {
		if (this.name.equals(p.name)) {
			return this.beruf.compareTo(p.beruf);
		}
		return this.name.compareTo(p.name);
	}
}
