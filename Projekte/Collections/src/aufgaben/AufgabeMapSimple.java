package aufgaben;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class AufgabeMapSimple {

	public static void main(String[] args) {
		
		Map<String, LocalDate> map = new TreeMap<>();

		LocalDate heute = LocalDate.now();
		map.put("heute", heute);
		
		map.put("gestern", heute.minusDays(1));
		map.put("morgen", heute.plusDays(1));
		
		System.out.println("*** mit keySet():");
		for(String key : map.keySet()) {
			LocalDate value = map.get(key);
			System.out.println(key + " = " + value);
		}
		
		System.out.println("\n*** mit entrySet():");
		
		for(Map.Entry<String, LocalDate> entry : map.entrySet()) {
			String key = entry.getKey();
			LocalDate value = entry.getValue();
			System.out.println(key + " = " + value);
		}
	}

}
