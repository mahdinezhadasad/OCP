# Aufgabe 'Generics - Generische Methoden - Functional'

Gegeben ist der Code:


		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		Predicate<Integer> isEven = i -> i % 2 == 0;
		System.out.println( count(list1, isEven) ); // 2  

		Predicate<Number> isOdd = b -> b.intValue() % 2 != 0;
		List<Number> list2 = Arrays.asList(1, 1.2, 3, 3.4);
		System.out.println( count(list2, isOdd) ); // 4  
		
		Predicate<String> isEmpty = String::isEmpty;
		List<String> list3 = Arrays.asList("a", "", "b", "", "c");
		System.out.println( count(list3, isEmpty) ); // 2 

		
Definieren Sie bitte die generische Methode `count`, die die Anzahl der Elemente in der übergebenen Liste ermittelt, die mit dem übergebenen Predicate 'true' ergeben.
 
