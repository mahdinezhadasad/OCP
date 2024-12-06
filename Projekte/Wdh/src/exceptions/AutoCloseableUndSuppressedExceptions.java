package exceptions;

public class AutoCloseableUndSuppressedExceptions {

	public static void main(String[] args) {
//		b1();
//		b2();
//		b3();
//		b4();
		b5();
	}
	//----------------------------------------
	static class R5 implements AutoCloseable {
		@Override
		public void close() {
			throw new RuntimeException("suppressed ex. aus close");
		}
	}
	
	static void b5() {
		try(R5 r = new R5()) {
			throw new RuntimeException("main ex. aus try");
		} catch (Exception e) {
//			throw e;
			throw new RuntimeException("ex. aus catch");
		}
	}
	
	//----------------------------------------
	static class R4 implements AutoCloseable {
		int index;
		public R4(int index) {
			this.index = index;
		}

		public void close() {
			throw new RuntimeException("ex. " + index + " aus close");
		}
	}
	static void b4() {
		try(R4 r1 = new R4(1);
				R4 r2 = new R4(2)) {
			throw new RuntimeException("ex. aus try");
			
		} catch (Exception e) {
			System.out.println(e); // ex. aus try
			
			Throwable[] suppressed = e.getSuppressed();
			for(Throwable t : suppressed) {
				System.out.println(t); // ex. 2 aus close
										// ex. 1 aus close
			}
		}
	}
	
	//----------------------------------------
	static class R3 implements AutoCloseable {
		public void close() {
			throw new RuntimeException("ex. aus close");
		}
	}
	static void b3() {
		try(R3 r = new R3()) {
			throw new RuntimeException("ex. aus try");
			
		} catch (Exception e) {
			System.out.println(e); // ex. aus try
			
			Throwable[] suppressed = e.getSuppressed();
			for(Throwable t : suppressed) {
				System.out.println(t); // ex. aus close
			}
		}
	}
	
	//----------------------------------------
	static class R2 implements AutoCloseable {
		public void close() {
			throw new RuntimeException("e2");
		}
	}
	static void b2() {
		try(R2 r = new R2()) {
			
		} catch (Exception e) {
			System.out.println(e); // e2
		}
	}
	
	//----------------------------------------
	static class R1 implements AutoCloseable {
		public void close() {
			System.out.println("c1");
		}
	}
	static void b1() {
		try(R1 r = new R1()) {
			throw new RuntimeException("e1");
		} catch (Exception e) {
			System.out.println(e); // e1
		}
	}
	
}
