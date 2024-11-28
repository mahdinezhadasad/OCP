package aufgaben.dao.tiere;

import java.util.List;

public interface TierDAO {
	
	static TierDAO getInstance() {
		return new TextFileTierDAO();
//		return new DerbyTierDAO();
	}

	List<Tier> getAllTiere();

	/**
	 * @param id
	 * @return false, falls kein Tier mit der id gefunden war
	 */
	boolean deleteOnId(int id);
	
	/**
	 * 
	 * @param t
	 * @throws IllegalArgumentException wenn es Tier mit der id bereits existiert
	 */
	void add(Tier t) throws IllegalArgumentException;
}
