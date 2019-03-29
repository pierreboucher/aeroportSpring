package airport.dao;






public class DaoClientFactory {
	private static DaoClient dao = null;

	public static DaoClient getInstance() {
		if (dao == null) {
			dao = new DaoClientJpaImpl();
		}
		return dao;
	}
}
