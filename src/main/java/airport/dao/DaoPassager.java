package airport.dao;

import java.util.List;

import airport.entity.Passager;
import airport.entity.Vol;

public interface DaoPassager extends DaoGeneric<Passager, Integer> {
	public List<Passager> findAllInFlight(Vol flight);
}
