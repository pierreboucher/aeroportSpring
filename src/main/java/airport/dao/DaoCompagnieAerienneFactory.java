package airport.dao;

public class DaoCompagnieAerienneFactory {
	private static DaoCompagnieAerienne dao = null;

	public static DaoCompagnieAerienne getInstance() {
		if (dao == null) {
			dao = new DaoCompagnieAerienneJpa();
		}
		return dao;
	}
}