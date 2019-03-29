package airport.dao;

public class DaoVolFactory {
	private static DaoVol dao = null;

	public static DaoVol getInstance() {
		if (dao == null) {
			dao = new DaoVolJpa();
		}
		return dao;
	}
}