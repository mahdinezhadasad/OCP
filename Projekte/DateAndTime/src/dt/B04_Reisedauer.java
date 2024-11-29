package dt;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class B04_Reisedauer {

	public static void main(String[] args) {
		
		final int year = 2024;
		final int month = 1;
		final int day = 1;
		
		
		/*
		 * Abreise. Lokale Zeitangaben
		 */

		int hour1 = 5;
		ZoneId zone1 = ZoneId.of("UTC-7");
		ZonedDateTime time1 = ZonedDateTime.of(year, month, day, 
				hour1, 0, 0, 0, zone1);

		
		/*
		 * Ankunft. Lokale Zeitangaben
		 */
		int hour2 = 11;
		ZoneId zone2 = ZoneId.of("UTC-5");
		ZonedDateTime time2 = ZonedDateTime.of(year, month, day, 
				hour2, 0, 0, 0, zone2);
		
		/*
		 * Lokale Zeiten auf englische Zeit umgerechnet:
		 * 
		 * 5 Uhr + 7 Stunden (da UTC-7) = 12 Uhr in England
		 * 11 Uhr + 5 Stunden (da UTC-5) = 16 Uhr in England
		 * 
		 * Reisedauer = 16 - 12 = 4 Stunden
		 */
		
		long dauer = ChronoUnit.HOURS.between(time1, time2);
		System.out.println("Dauer: " + dauer + " Stunden");  // 4
		
	}

}
