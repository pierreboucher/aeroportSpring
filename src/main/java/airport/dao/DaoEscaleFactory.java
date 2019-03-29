package airport.dao;

public class DaoEscaleFactory {
	private static DaoEscale dao = null;

	public static DaoEscale getInstance() {
		if (dao == null) {
			dao = new DaoEscaleJpa();
		}
		return dao;
	}
}