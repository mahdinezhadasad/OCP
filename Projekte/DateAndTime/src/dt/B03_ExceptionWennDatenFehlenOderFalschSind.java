package dt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class B03_ExceptionWennDatenFehlenOderFalschSind {

	public static void main(String[] args) {
		
		/*
		 * Bsp. 1
		 */
		LocalDate d1 = LocalDate.now();
		
		DateTimeFormatter fmt = DateTimeFormatter.ISO_DATE_TIME;

		try {
			String s1 = fmt.format(d1); // Exception
			
		} catch (Exception e) {
			System.out.println("Exception! ISO_DATE_TIME-Formatierer hat keine Zeit im LocalDate gefunden");
		}
		
		/*
		 * Bsp. 2
		 */
		try {
			LocalDate.of(2024, 3, 35);
		} catch (Exception e) {
			System.out.println("Exception! Falscher Wert für Tag");
		}

	}

}
