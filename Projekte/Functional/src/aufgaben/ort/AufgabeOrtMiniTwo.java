package aufgaben.ort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AufgabeOrtMiniTwo {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte geben Sie eine Postleitzahl oder einen Ort ein.");
		String input = sc.next();
		boolean inputPlz = input.matches("\\d+");
		String ergebnis = "";
		if (inputPlz) {
			ergebnis = Files.lines(Paths.get("plz_ort.csv"))
								.map(zeile -> zeile.substring(zeile.indexOf(",") + 1))
								.filter(zeile -> zeile.contains(input) && input.length() == 5)
								.map(zeile -> zeile.substring(0, zeile.indexOf(",")))
								.findFirst()
								.orElse("Kein Ort gefunden");
		} else {
			ergebnis = Files.lines(Paths.get("plz_ort.csv"))
					.map(zeile -> zeile.substring(zeile.indexOf(",") + 1))
					.filter(zeile -> zeile.contains(input))
					.map(zeile -> zeile.split(",")[1])
					.collect(Collectors.joining(", "))
					;
			ergebnis = ergebnis.isEmpty() ? "Keine Postleitzahl(en) gefunden" : ergebnis;
		}
		
		System.out.println("Ergebnis: " + ergebnis);
		
		
		sc.close();
	}

}
