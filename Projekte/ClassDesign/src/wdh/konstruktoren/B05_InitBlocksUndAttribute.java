package wdh.konstruktoren;

class Blume {
	int a;
	int b = 12;
	int c = 42;
	
	Blume(int c) {
		// super();
		// {
		//    this.c = 111;
		// }
		// this.a = 0;
		// this.b = 12;
		this.c = c;
	}
	
	{
		c = 111; // this.c = 111; 
	}
}

public class B05_InitBlocksUndAttribute {

	public static void main(String[] args) {

		System.out.println( new Blume(75).c ); // 75
		
	}

}
