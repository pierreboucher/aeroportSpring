package airport.dao;

public class DaoConnecterFactory {
	private static DaoConnecter dao = null;

	public static DaoConnecter getInstance() {
		if (dao == null) {
			dao = new DaoConnecterJpa();
		}
		return dao;
	}
}