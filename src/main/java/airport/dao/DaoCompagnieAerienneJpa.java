package airport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import airport.context.EntityManagerFactorySingleton;
import airport.entity.CompagnieAerienne;

public class DaoCompagnieAerienneJpa implements DaoCompagnieAerienne {

	@Override
	public CompagnieAerienne findByKey(Long key) {
		CompagnieAerienne p = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		p = em.find(CompagnieAerienne.class, key);
		em.close();
		return p;
	}

	@Override
	public void insert(CompagnieAerienne obj) {
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
	public CompagnieAerienne update(CompagnieAerienne obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		CompagnieAerienne p = null;
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
	public void delete(CompagnieAerienne obj) {
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
			em.remove(em.find(CompagnieAerienne.class, key));
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
	public List<CompagnieAerienne> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<CompagnieAerienne> res = null;
		Query query = em.createNamedQuery("CompagnieAerienne.findAll");
		res = query.getResultList();
		em.close();
		return res;
	}

	
}