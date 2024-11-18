package aufgaben.philosophenproblem.lock;

import java.util.concurrent.locks.Lock;

public class Philosoph extends Thread {
	
	private String name;
	
	private Lock leftLock;
	private Lock rightLock;
	
	public Philosoph(String name) {
		this.name = name;
	}
	
	public void setLeftLock(Lock leftLock) {
		this.leftLock = leftLock;
	}
	public void setRightGabel(Lock rightLock) {
		this.rightLock = rightLock;
	}

	@Override
	public void run() {
		
		while(true) {
			System.out.println(name + " denkt nach...");
			job(1000);
			
			System.out.println(name + " hat Hunger");
			
			if(leftLock.tryLock()) {
				System.out.println(name + " nimmt die linke Gabel");
//				job(1000);
				
				if(rightLock.tryLock()) {
					System.out.println(name + " nimmt die rechte Gabel");
					System.out.println(name + " isst...");
					job(3000);
					System.out.println(name + " legt die rechte Gabel ab");
					rightLock.unlock();
				} else {
					System.out.println(name + " hat keine rechte Gabel gekriegt");
				}
				
				System.out.println(name + " legt die linke Gabel ab");
				
				leftLock.unlock();
			} else {
				System.out.println(name + " hat keine linke Gabel gekriegt");
			}
		}
		
	}
	
	private static void job(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
}
