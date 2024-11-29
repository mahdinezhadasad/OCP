package dt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class B06_Format {

	public static void main(String[] args) {

		LocalDate v1 = LocalDate.now();
		System.out.println("LocalDate: " + v1); // 2024-11-29
		
		LocalTime v2 = LocalTime.now();
		System.out.println("LocalTime: " + v2); // 11:12:39.436039400

		System.out.println("LocalTime: " + 
				v2.truncatedTo(ChronoUnit.SECONDS)); // 11:12:39
		
		LocalDateTime v3 = LocalDateTime.now();
		// 'T' trennt Datum-Teil vom Zeit-Teil: 
		System.out.println("LocalDateTime: " + v3); // 2024-11-29T11:15:21.544967600
		
	}

}
