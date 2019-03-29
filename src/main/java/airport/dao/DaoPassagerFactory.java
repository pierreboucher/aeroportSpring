package airport.dao;

public class DaoPassagerFactory {

	private static DaoPassager dao = null;

	private DaoPassagerFactory() {

	}

	public static DaoPassager getInstance() {
		if (dao == null) {
			dao = new DaoPassagerJpaImpl();
		}
		return dao;
	}
}
