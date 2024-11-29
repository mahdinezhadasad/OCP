package dt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
		
		/*
		 * DateTimeFormatter 
		 */
		DateTimeFormatter fmt1 = DateTimeFormatter.BASIC_ISO_DATE;
		
		String s1 = fmt1.format(LocalDate.now());
		System.out.println("BASIC_ISO_DATE: " + s1); // 20241129
		
		System.out.println("ISO_DATE: " + 
				DateTimeFormatter.ISO_DATE.format(LocalDate.now())); // 2024-11-29
		
		System.out.println("ISO_LOCAL_DATE: " + 
				DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now())); // 2024-11-29
		
		System.out.println("ISO_TIME: " + 
				DateTimeFormatter.ISO_TIME.format(LocalTime.now())); // 11:38:17.9850746
		
		System.out.println("ISO_LOCAL_TIME: " + 
				DateTimeFormatter.ISO_LOCAL_TIME.format(LocalTime.now())); // 11:38:17.9850746
		
		/*
		 * ofPatterns
		 * 
		 * 	d	- day
		 *  M	- Month
		 *  y	- year
		 *  
		 *  H 	- Hour (0-23)
		 *  m	- minute
		 *  s	- second
		 */
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d.M.y, H:m:s");
		System.out.println(fmt.format(LocalDateTime.now()));
	}

}
