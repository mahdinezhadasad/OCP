package aufgaben;

public class OS implements Comparable<OS> {
	private String name;
	private int version;
	
	public OS(String name, int version) {
		this.name = name;
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public int getVersion() {
		return version;
	}
	
	/*
	 * OS os1 = name = Linux, Version = 1
	 * OS os2 = name = Linux, Version = 3
	 */
	
	public int compareTo(OS os2) {
		OS os1 = this;
		
		int result = os1.name.compareTo(os2.name);
		
		if (result==0) {
			result = os1.version - os2.version;
		}
		
		return result;
	}
}
