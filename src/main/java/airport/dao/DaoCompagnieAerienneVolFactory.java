package airport.dao;

public class DaoCompagnieAerienneVolFactory {
	private static DaoCompagnieAerienneVol dao = null;

	public static DaoCompagnieAerienneVol getInstance() {
		if (dao == null) {
			dao = new DaoCompagnieAerienneVolJpa();
		}
		return dao;
	}
}