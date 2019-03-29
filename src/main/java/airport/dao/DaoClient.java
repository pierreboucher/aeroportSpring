package airport.dao;

import java.util.List;

import airport.entity.Client;
import airport.entity.ClientMoral;
import airport.entity.ClientPhysique;

public interface DaoClient extends DaoGeneric<Client, Integer> {
	public List<Client> findByVille(String ville);
	public List<ClientMoral> findAllClientMoral();
	public List<ClientPhysique> findAllClientPhysique();
	public List<Client> findAll();
	
}
