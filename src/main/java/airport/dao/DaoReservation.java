package airport.dao;

import java.util.List;

import airport.entity.Reservation;

public interface DaoReservation extends DaoGeneric<Reservation, Integer> {

	public List<Reservation> findAllWithPassagerAndVol();
	public List<Reservation> findAll();
	
}
