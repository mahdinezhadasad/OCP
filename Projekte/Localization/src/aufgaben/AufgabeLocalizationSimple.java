package aufgaben;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class AufgabeLocalizationSimple {

	/*
	 * bei System-Sprache 'de':
	 * 
	 * Heute ist 9. Oktober 2018.
	 * Es ist Dienstag.
	 * 
	 * bei anderen System-Sprachen:
	 * 
	 * Today is October 9, 2018.
	 * It's Tuesday.
	 * 
	 */
	public static void main(String[] args) {
//		Locale.setDefault(Locale.UK);
//		Locale.setDefault(Locale.GERMANY);
		Locale.setDefault(Locale.FRANCE);
		
//		LocalDate date = LocalDate.now();
		LocalDate date = LocalDate.of(2018, Month.OCTOBER, 9);

		ResourceBundle bundle = ResourceBundle.getBundle("aufgaben.simpleapp");
		
		String prefixDate = bundle.getString("prefix.date");
		String patternDate = bundle.getString("pattern.date");
		
		DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern(patternDate);
		System.out.format("%s %s.%n", prefixDate, fmtDate.format(date));
		
		String prefixWeekday = bundle.getString("prefix.weekday");
		String patternWeekday = bundle.getString("pattern.weekday");
		
		DateTimeFormatter fmtWeekday = DateTimeFormatter.ofPattern(patternWeekday);
		System.out.format("%s %s.%n", prefixWeekday, fmtWeekday.format(date));
	}

}
