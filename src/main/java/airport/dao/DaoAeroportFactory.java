package airport.dao;

public class DaoAeroportFactory {
	private static DaoAeroport dao = null;

	public static DaoAeroport getInstance() {
		if (dao == null) {
			dao = new DaoAeroportJpa();
		}
		return dao;
	}
}
