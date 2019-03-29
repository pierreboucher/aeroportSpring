package airport.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import airport.context.EntityManagerFactorySingleton;
import airport.entity.Client;
import airport.entity.ClientMoral;
import airport.entity.ClientPhysique;




class DaoClientJpaImpl implements DaoClient {

	@Override
	public Client findByKey(Integer key) {
		Client p = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		p = em.find(Client.class, key);
		em.close();
		return p;
	}

	@Override
	public void insert(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Client update(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Client p = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			p = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return p;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public void deleteByKey(Integer key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Client.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Client> clients = null;
		// Query query = em.createQuery("from Client p");
		Query query = em.createNamedQuery("Client.findAll");
		clients = query.getResultList();
		em.close();
		return clients;
	}

	@SuppressWarnings("unchecked")
	public List<ClientPhysique> findAllClientPhysique() {
		List<ClientPhysique> clientsPhysiques = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query query = em.createQuery("from ClientPhysique p");
		clientsPhysiques = query.getResultList();
		em.close();
		return clientsPhysiques;
	}

	@SuppressWarnings("unchecked")
	public List<ClientMoral> findAllClientMoral() {
		List<ClientMoral> clientsMorals = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query query = em.createQuery("from ClientMoral m");
		clientsMorals = query.getResultList();
		em.close();
		return clientsMorals;
	}

	public List<Client> findByVille(String ville) {
        List<Client> clients = null;
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        Query query = em.createNamedQuery("Client.findByVille");
        query.setParameter("ville", ville);
        clients = query.getResultList();
        em.close();
        return clients;
    }


}
