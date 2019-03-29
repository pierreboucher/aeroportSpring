package airport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import airport.context.EntityManagerFactorySingleton;
import airport.entity.CompagnieAerienneVol;
import airport.entity.CompagnieAerienneVolPk;

public class DaoCompagnieAerienneVolJpa implements DaoCompagnieAerienneVol {

	@Override
	public CompagnieAerienneVol findByKey(CompagnieAerienneVolPk key) {
		CompagnieAerienneVol p = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		p = em.find(CompagnieAerienneVol.class, key);
		em.close();
		return p;
	}

	@Override
	public void insert(CompagnieAerienneVol obj) {
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
	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		CompagnieAerienneVol p = null;
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
	public void delete(CompagnieAerienneVol obj) {
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
	public void deleteByKey(CompagnieAerienneVolPk key) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(CompagnieAerienneVol.class, key));
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
	public List<CompagnieAerienneVol> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<CompagnieAerienneVol> res = null;
		Query query = em.createNamedQuery("CompagnieAerienneVol.findAll");
		res = query.getResultList();
		em.close();
		return res;
	}

	
}
