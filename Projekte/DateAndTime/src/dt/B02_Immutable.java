package dt;

import java.time.LocalDate;
import java.time.Month;

public class B02_Immutable {

	public static void main(String[] args) {

		LocalDate d1 = LocalDate.of(2024, Month.JANUARY, 25);
		
		d1.plusDays(3); // Immutable! plusDays erzeugt ein neues Objekt
		
		System.out.println(d1); // 2024-01-25

		d1 = d1.plusDays(3);

		System.out.println(d1); // 2024-01-28
	}

}
