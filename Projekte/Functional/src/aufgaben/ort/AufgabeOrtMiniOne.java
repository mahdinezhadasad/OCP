package aufgaben.ort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AufgabeOrtMiniOne {

	public static void main(String[] args) throws IOException {
//		a1();
//		a2();
//		a3();
//		a4();
//		buildList().forEach(System.out::println);	
//		a1List();
//		a2List();
//		a3List();
//		a4List();
		a5List();
	}
	
	static void a1() throws IOException {
		Files.lines(Paths.get("plz_ort.csv"))
				.forEach(System.out::println);
	}
	
	static void a2() throws IOException {
		Files.lines(Paths.get("plz_ort.csv"))
				.filter(zeile -> zeile.contains("47058"))
				.forEach(System.out::println);
	}

	static void a3() throws IOException {
		Files.lines(Paths.get("plz_ort.csv"))
				.map(zeile -> zeile.substring(zeile.indexOf(",") + 1))
				.filter(zeile -> zeile.contains("47058"))
				.forEach(System.out::println);
	}

	static void a4() throws IOException {
		Files.lines(Paths.get("plz_ort.csv"))
				.map(zeile -> zeile.substring(zeile.indexOf(",") + 1))
				.filter(zeile -> zeile.contains("47058"))
				.map(zeile -> zeile.substring(0, zeile.indexOf(",")))
				.forEach(System.out::println);
	}

	static ArrayList<Ort> buildList() {
		Function<String, Ort> func = zeile -> {
			String[] arr = zeile.split(",");
			return new Ort(arr[1], arr[2], arr[3]);
		};
		ArrayList<Ort> listOrte = null;
		try {
			listOrte = Files.lines(Paths.get("plz_ort.csv")).skip(1).map(func).filter(ort -> ort.getPostleitzahl().length() == 5)
					.collect(Collectors.toCollection(ArrayList::new));
		} catch (IOException e) {
			e.printStackTrace();
		}
//		listOrte.forEach(System.out::println);
		return listOrte;
	}

	static void a1List() {
		List<Ort> listOrte = buildList();
		listOrte.stream().sorted(Comparator.comparing(Ort::getPostleitzahl)).forEach(System.out::println);
	}

	static void a2List() {
		List<Ort> listOrte = buildList();
		listOrte.stream().max(Comparator.comparing(Ort::getPostleitzahl)).ifPresent(System.out::println);
	}

	static void a3List() {
		List<Ort> listOrte = buildList();
		String bundeslaender = listOrte.stream().map(Ort::getBundesland).distinct().collect(Collectors.joining(","));
		System.out.println("bundeslaender = " + bundeslaender);
	}

	static void a4List() {
		List<Ort> listOrte = buildList();
		Optional<Entry<String,Long>> opt = listOrte.stream()
				.collect(Collectors.groupingBy(Ort::getOrt, Collectors.counting()))
				.entrySet().stream()
				.sorted(Map.Entry.<String,Long>comparingByValue().reversed())
				.findFirst();
		opt.ifPresent(System.out::println);
		
	}

	static void a5List() {
		List<Ort> listOrte = buildList();
		listOrte.stream()
			.collect(Collectors.groupingBy(Ort::getBundesland, Collectors.counting()))
			.forEach((bundesland , anzahl)  -> System.out.println(bundesland + ": " + anzahl));
		System.out.println("*********");
		// sortiert
		listOrte.stream()
			.collect(Collectors.groupingBy(Ort::getBundesland, TreeMap::new, Collectors.counting()))
			.forEach((bundesland , anzahl)  -> System.out.println(bundesland + ": " + anzahl));
		System.out.println("*********");
		// sortiert mit Orten ohne Duplikate
		listOrte.stream()
		.collect(Collectors.groupingBy(Ort::getBundesland, Collectors.mapping(Ort::getOrt, Collectors.toSet())))
		.entrySet().stream()
		.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size() ))
		.forEach((bundesland , anzahl)  -> System.out.println(bundesland + ": " + anzahl));
		
	}

}
