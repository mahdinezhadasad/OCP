package aufgaben.philosophenproblem;

public class Philosoph extends Thread {
	
	private String name;
	
	private Object linkeGabel;
	private Object rechteGabel;
	
	public Philosoph(String name) {
		this.name = name;
	}
	
	public void setLinkeGabel(Object linkeGabel) {
		this.linkeGabel = linkeGabel;
	}
	public void setRechteGabel(Object rechteGabel) {
		this.rechteGabel = rechteGabel;
	}

	@Override
	public void run() {
		
		while(true) {
			System.out.println(name + " denkt nach...");
			job(1000);
			
			System.out.println(name + " hat Hunger");
			
			synchronized (linkeGabel) {
				System.out.println(name + " nimmt die linke Gabel");
				
				synchronized (rechteGabel) {
					System.out.println(name + " nimmt die rechte Gabel");
					System.out.println(name + " isst...");
					job(3000);
					System.out.println(name + " legt die rechte Gabel ab");
				}
				
				System.out.println(name + " legt die linke Gabel ab");
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
