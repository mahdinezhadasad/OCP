package vererbung;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
interface QuackBehavior {
	void quack(); // Line A
}

class Duck {
	QuackBehavior fb;
	
	public void quack() { // Line B
		fb.quack();
	}
}

class RedheadDuck extends Duck {
	public RedheadDuck() {
		fb = () -> System.out.print("Quack, quack "); // Line C
	}
}

class RubberDuck extends Duck {
	public RubberDuck() {
		fb = () -> System.out.println("Squeak, squeak"); // Line D
	}
}

public class DuckSimulation {
	public static void main(String[] args) {
		//RedheadDuck huey = new RedheadDuck();
	//	RubberDuck louie = new RubberDuck();
		
		//huey.quack();
		//louie.quack();
		
		//Stream<IntStream> si = Stream.of(IntStream.range(0, 5), IntStream.range(5, 10), IntStream.range(10, 15));
	//	si.forEach (i -> System.out.println(i));
		//si.flatMapToInt (i->i).forEach (i-> System.out.println (i + " "));
		
		//LocalDateTime ldt1 = LocalDateTime.of(LocalDate.of(2018, 12, 1), LocalTime.of(10, 10, 0)).plusMonths (1);
		//System.out.println(ldt1);
		
		Stream<String> s = Stream.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
		String result = s.filter(m -> m.startsWith("J"))
				.collect(Collectors.joining(", "))     // L1
				.concat(": Months beginning with J");  // L2
		System.out.println(result);
	}
}