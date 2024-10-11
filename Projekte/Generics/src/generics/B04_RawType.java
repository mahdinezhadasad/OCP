package generics;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

public class B04_RawType {

	public static void main(String[] args) {
		
		Number n;
		n = (byte)12; 	// Number <- IS-A <- Byte
		n = (short)12; 	// Number <- IS-A <- Short
		n = 12; 	// Number <- IS-A <- Integer
		n = 12L;	// Number <- IS-A <- Long
		n = 12f;	// Number <- IS-A <- Float
		n = 12.0;	// Number <- IS-A <- Double
		
		/*
		 * Bitte niemals mit Raw Type programmieren!
		 * 
		 */
		
		/*
		 * Typsicherheit mit parametrisierten Typen
		 */
		Deque<Long> dequeLong = new ArrayDeque<>();
		dequeLong.add(12L);
//		dequeLong.add(12.0);
		
		Collection<Long> collLong = dequeLong;
		collLong.add(13L);
//		collLong.add(13.0);
		
		Deque<Number> dequeNum = new LinkedList<>();
//		dequeNum = dequeLong;
		dequeNum.add(12L);
		dequeNum.add(12);
		dequeNum.add(12.0);
		
		/*
		 * Keine Typsicherheit mit Raw Type
		 */
		Collection coll; // raw type, bitte so nicht programmieren
		
		coll = dequeLong;
		coll.add("moin");
		coll.add(false);
		System.out.println(dequeLong); // [12, 13, moin, false]

		coll = dequeNum;
		coll.add("jan");
		coll.add(LocalDate.now());
		System.out.println(dequeNum); // [12, 12, 12.0, jan, 2024-10-11]
		
	}
}
