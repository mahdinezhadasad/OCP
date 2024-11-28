package aufgaben.dao.tiere;

import java.util.List;

public interface TierDAO {
	
	static TierDAO getInstance() {
		return new TextFileTierDAO();
	}

	List<Tier> getAllTiere();

	void deleteOnId(int id);
	
	void add(Tier t);
}
