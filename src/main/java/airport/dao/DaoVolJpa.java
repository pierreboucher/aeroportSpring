package airport.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import airport.context.EntityManagerFactorySingleton;
import airport.entity.Ville;
import airport.entity.Vol;

public class DaoVolJpa implements DaoVol {

	@Override
	public Vol findByKey(Long key) {
		Vol p = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		p = em.find(Vol.class, key);
		em.close();
		return p;
	}

	@Override
	public void insert(Vol obj) {
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
	public Vol update(Vol obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Vol p = null;
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
	public void delete(Vol obj) {
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
	public void deleteByKey(Long key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Vol.class, key));
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
	public List<Vol> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> res = null;
		Query query = em.createNamedQuery("Vol.findAll");
		res = query.getResultList();
		em.close();
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Vol> findAllFrom(Ville city) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> res = null;
		Query query = em.createNamedQuery("Vol.findAllFrom");
		query.setParameter("city", city);
		res = query.getResultList();
		em.close();
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vol> findAllFrom(Ville city, Date date) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> res = null;
		Query query = em.createNamedQuery("Vol.findAllFromDate");
		query.setParameter("city", city);
		query.setParameter("date", date);
		res = query.getResultList();
		em.close();
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vol> findAllFromTo(Ville departure, Ville arrival) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Vol> res = null;
		Query query = em.createNamedQuery("Vol.findAllFromTo");
		query.setParameter("departure", departure);
		query.setParameter("arrival", arrival);
		res = query.getResultList();
		em.close();
		return res;
	}
}
