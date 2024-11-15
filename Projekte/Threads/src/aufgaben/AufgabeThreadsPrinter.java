package aufgaben;

import threads.MyThreadUtils;

class Printer extends Thread {
	
	private char ch;
	private int numberOfCharsPerLine;
	private int numberOfLines;
	
	public Printer(char ch, int numberOfCharsPerLine, int numberOfLines) {
		this.ch = ch;
		this.numberOfCharsPerLine = numberOfCharsPerLine;
		this.numberOfLines = numberOfLines;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < numberOfLines; i++) {
			synchronized(System.out) {
				for (int j = 0; j < numberOfCharsPerLine; j++) {
					System.out.print(ch);
				}
				System.out.println();
			}
			
			MyThreadUtils.pause(1);
		}
	}
	
//	@Override
//	public void run() {
//		String line = new StringBuilder()
//				.repeat(ch, numberOfCharsPerLine)
//				.append("\n")
//				.toString();
//		
//		for (int i = 0; i < numberOfLines; i++) {
//			System.out.print(line);
//		}
//	}
}

public class AufgabeThreadsPrinter {

	public static void main(String[] args) {
		
		Printer p1 = new Printer('a', 10, 20);
		p1.start();
		
		Printer p2 = new Printer('*', 15, 40);
		p2.start();

	}

}
