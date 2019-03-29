package airport.dao;

public class DaoReservationFactory {

	private static DaoReservation dao = null;

	private DaoReservationFactory() {

	}

	public static DaoReservation getInstance() {
		if (dao == null) {
			dao = new DaoReservationJpaImpl();
		}
		return dao;
	}
}
