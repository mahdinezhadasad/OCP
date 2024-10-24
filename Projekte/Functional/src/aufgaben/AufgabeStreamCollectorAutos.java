package aufgaben;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import aufgaben.auto.Auto;

public class AufgabeStreamCollectorAutos {
	
	static List<Auto> autos = Arrays.asList(
			new Auto("VW", "Golf"),
			new Auto("VW", "Polo"),
			new Auto("Opel", "Corsa"),
			new Auto("Opel", "Astra"),
			new Auto("Ford", "Fiesta")
		);

	public static void main(String[] args) {
//		a1();
//		a2();
//		a3();
//		a4();
		a5();
	}
	
	static void a5() {
		Map<Boolean, List<Auto>> map = autos.stream().collect(Collectors.partitioningBy(auto -> auto.getModell().contains("o")));
		map.forEach((key, value) -> System.out.println(key + ": " + value));
		map.forEach((key, value) -> System.out.println((key.equals(true) ? "Mit o" : "Ohne o") + ": " + value));
		
	}
	
	static void a4() {
		Collector<Auto, ?, Map<String, List<Auto>>> collector = Collectors.groupingBy(Auto::getHersteller, TreeMap::new,Collectors.toList());
		Map<String, List<Auto>> map = autos.stream().collect(collector);
		System.out.println(map); 
		// Ausgabe: {Opel=[Opel/Corsa, Opel/Astra], VW=[VW/Golf, VW/Polo]}
	}
	
	static void a3() {
		Collector<Auto, ?, Map<String, List<String>>> collector = 
				Collectors.groupingBy(Auto::getHersteller, Collectors.mapping(Auto::getModell, Collectors.toList()));
		Map<String, List<String>> map = autos.stream().collect(collector);
		System.out.println(map); 
		// mögliche Ausgabe: {VW=[Golf, Polo], Opel=[Corsa, Astra]}
	}
	
	static void a2() {
		Collector<Auto, ?, Map<String, List<Auto>>> collector = Collectors.groupingBy(Auto::getHersteller);
		Map<String, List<Auto>> map = autos.stream().collect(collector);
		System.out.println(map); 
		// mögliche Ausgabe: {VW=[VW/Golf, VW/Polo], Opel=[Opel/Corsa, Opel/Astra]}
	}
	
	static void a1() {
		Collector<String, ?, Set<String>> downstream = Collectors.toSet();
		
		Function<Auto, String> mapper = auto -> auto.getHersteller();
		
		Collector<Auto, ?, Set<String>> collector 
				= Collectors.mapping(mapper, downstream);
		
		Set<String> set = autos.stream().collect(collector);
		System.out.println(set); // mögliche Ausgabe: [VW, Opel]
		
		set = autos.stream().map(Auto::getHersteller).collect(Collectors.toSet());
		System.out.println(set); // mögliche Ausgabe: [VW, Opel]
	}

}

