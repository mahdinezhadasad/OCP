package dt;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class B05_Zeitumstellung {

	public static void main(String[] args) {
		
		/*
		 * Zeiumstellung (daylight saving)
		 * 
		 * Bekannt ist, dass am 8. März 2015 in der Zeitzone US/Central
		 * um 2:00 Uhr die Uhr umgestellt war (auf 3:00 Uhr)
		 * 
		 * 01:00:00		1. Zeitpunkt
		 * ...
		 * 01:59:57
		 * 01:59:58
		 * 01:59:59
		 * 03:00:00
		 * 03:00:01
		 * 03:00:02
		 * ...
		 * 04:00:00		2. Zeitpunkt
		 * 
		 */
		
		ZoneId zone = ZoneId.of("US/Central");
		
		ZonedDateTime time1 = ZonedDateTime.of(2015, 3, 8, 1, 0, 0, 0, zone);
		ZonedDateTime time2 = ZonedDateTime.of(2015, 3, 8, 4, 0, 0, 0, zone);

		Duration d = Duration.between(time1, time2);
		long diff = d.toHours();
		
		System.out.println("Zeitdifferenz: " + diff + " Stunden"); // 2
	}

}
