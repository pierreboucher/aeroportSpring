package airport.dao;

public class DaoVilleFactory {
	private static DaoVille dao = null;

	public static DaoVille getInstance() {
		if (dao == null) {
			dao = new DaoVilleJpa();
		}
		return dao;
	}
}