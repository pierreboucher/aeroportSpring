package airport.dao;







public class DaoLoginFactory {
	private static DaoLogin dao = null;

	public static DaoLogin getInstance() {
		if (dao == null) {
			dao = new DaoLoginJpaImpl();
		}
		return dao;
	}
}
