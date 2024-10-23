package aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Predicate;

public class AufgabeStreamLocales {

	public static void main(String[] args) {
		// a1();
		// a2();
		Locale[] locales = Locale.getAvailableLocales();
		
		Arrays.stream(locales)
			.filter(locale -> locale.getDisplayCountry().contains("t"))
			.sorted(Comparator.comparing(Locale::getDisplayLanguage))
			.findFirst()
			.ifPresent(System.out::println);
			;
	}

	static void a1() {
		Locale[] allLocales = Locale.getAvailableLocales();
//		for (Locale locale : allLocales) {
//			System.out.println(locale.getDisplayCountry());
//		}
		Comparator<Locale> comp = (loc1, loc2) -> loc1.getDisplayCountry().compareTo(loc2.getDisplayCountry());

//		Optional<Locale> optLocaleMax = Arrays.stream(allLocales).max(comp);
//		Optional<Locale> optLocaleMax = Arrays.stream(allLocales).max(Comparator.comparing(loc -> loc.getDisplayCountry()));
		Optional<Locale> optLocaleMax = Arrays.stream(allLocales).max(Comparator.comparing(Locale::getDisplayCountry));
//		if (optLocaleMax.isPresent()) {
//			System.out.println(optLocaleMax.get().getDisplayCountry());
//		}
		optLocaleMax.ifPresent(loc -> System.out.println(loc.getDisplayCountry()));
	}

	static void a2() {
		Locale[] locales = Locale.getAvailableLocales();
		Predicate<Locale> pred = loc -> loc.getLanguage().equals("de");
		long anzahl = Arrays.stream(locales).filter(pred).count();
		System.out.println("anzahl = " + anzahl);
		// Test
		Arrays.stream(locales).filter(pred).forEach(System.out::println);
		Arrays.stream(locales).filter(pred).map(Locale::getDisplayCountry).forEach(System.out::println);
	}

}
