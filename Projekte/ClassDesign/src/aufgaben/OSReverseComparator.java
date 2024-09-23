package aufgaben;

import java.util.Comparator;

public class OSReverseComparator implements Comparator<OS> {

	@Override
	public int compare(OS o1, OS o2) {
		return o2.compareTo(o1) ;
	}
	
}
