package aufgaben;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class TaskRandomInts implements Runnable {
	
	private int numberOfValues;
	private List<Integer> ints = new ArrayList<>(); 
	
	public TaskRandomInts(int numberOfValues) {
		this.numberOfValues = numberOfValues;
	}
	@Override
	public void run() {
		for (int i = 0; i < numberOfValues; i++) {
			int value = 1;
			ints.add(value);
		}
	}
	public List<Integer> getInts() {
		return ints;
	}
}

public class AufgabeThreadsInteract {
	public static void main(String[] args) {
		TaskRandomInts taskA = new TaskRandomInts(20);
		TaskRandomInts taskB = new TaskRandomInts(30);
		
		new Thread(taskA).start();
		new Thread(taskB).start();
		
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
