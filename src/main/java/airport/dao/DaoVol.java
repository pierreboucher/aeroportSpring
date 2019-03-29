package airport.dao;

import java.util.Date;
import java.util.List;

import airport.entity.Ville;
import airport.entity.Vol;

public interface DaoVol extends DaoGeneric<Vol, Long> {
	public List<Vol> findAllFrom(Ville city);
	public List<Vol> findAllFrom(Ville city, Date date);
	public List<Vol> findAllFromTo(Ville departure, Ville arrival);
}