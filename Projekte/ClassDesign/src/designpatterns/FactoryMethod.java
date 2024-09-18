package designpatterns;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class FactoryMethod {

	/*
	 * Factory Method: Ein Objekt mithilfe einer Methode erzeugen,
	 * die das Bilden des Objektes übernimmt.
	 */
	public static void main(String[] args) {
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(); // factory method
		
		String text = nf.format(12.789);
		System.out.println("text: " + text);

		/*
		 * weitere Beispiele
		 */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM");
		Comparator<String> cmp = Comparator.reverseOrder();
		//...

	}

}
