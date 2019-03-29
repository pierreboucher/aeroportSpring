package airport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import airport.context.EntityManagerFactorySingleton;
import airport.entity.Passager;
import airport.entity.Vol;

public class DaoPassagerJpaImpl implements DaoPassager {

	@Override
	public Passager findByKey(Integer key) {
		Passager m = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		m = em.find(Passager.class, key);
		em.close();
		return m;
	}

	@Override
	public void insert(Passager obj) {
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
	public Passager update(Passager obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Passager p = null;
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
	public void delete(Passager obj) {
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
			em.remove(em.find(Passager.class, key));
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
	public List<Passager> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Passager> Passagers = null;
		Query query = em.createQuery("from Passager p");
		Passagers = query.getResultList();
		em.close();
		return Passagers;
	}
	
	@SuppressWarnings("unchecked")
	public List<Passager> findAllInFlight(Vol flight) {
		List<Passager> res = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Query query = em.createNamedQuery("Passager.findAllInFlight");
		query.setParameter("flight", flight);
		res = query.getResultList();
		em.close();
		return res;
	}
	

}
