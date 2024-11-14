package aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

class TaskRandomInts implements Runnable {
	
	private int numberOfValues;
	private List<Integer> ints = new ArrayList<>(); 
	
	public TaskRandomInts(int numberOfValues) {
		this.numberOfValues = numberOfValues;
	}
	@Override
	public void run() {
//		Random rnd = new Random(); // geht auch
		Random rnd = ThreadLocalRandom.current();
		
		for (int i = 0; i < numberOfValues; i++) {
			int value = rnd.nextInt();
			ints.add(value);
		}
	}
	public List<Integer> getInts() {
		return ints;
	}
}

public class AufgabeThreadsInteractA1 {
	public static void main(String[] args) throws InterruptedException {
		
		TaskRandomInts taskA = new TaskRandomInts(20);
		TaskRandomInts taskB = new TaskRandomInts(30);
		
		Thread tA = new Thread(taskA);
		Thread tB = new Thread(taskB);
		
		tA.start();
		tB.start();
		
		tA.join();
		tB.join();
		
		List<Integer> listA = taskA.getInts();
		List<Integer> listB = taskB.getInts();
		
		int summe = Stream.of(listA, listB) // Stream<List<Integer>>
			.flatMap(List::stream) // Stream<Integer>
			.mapToInt(x -> x)
			.sum();
		
		System.out.println("Summe: " + summe); // 

		/*
		 * so würde es auch gehen:
		 * 
		 */
//		List<Integer> ints = new ArrayList<>();
//		
//		Runnable taskA = () -> {
//			for (int i = 0; i < 20; i++) {
//				int value = 1;
//				ints.add(value);
//			}
//		};
//		
//		new Thread(taskA).start();
//		...
		
	}
}
