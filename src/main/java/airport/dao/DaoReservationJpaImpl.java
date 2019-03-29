package airport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import airport.context.EntityManagerFactorySingleton;
import airport.entity.Reservation;

public class DaoReservationJpaImpl implements DaoReservation {

	@Override
	public Reservation findByKey(Integer key) {
		Reservation m = null;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		m = em.find(Reservation.class, key);
		em.close();
		return m;
	}

	@Override
	public void insert(Reservation obj) {
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
	public Reservation update(Reservation obj) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EntityTransaction tx = null;
		Reservation r = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			r = em.merge(obj);
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
		return r;
	}

	@Override
	public void delete(Reservation obj) {
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
			em.remove(em.find(Reservation.class, key));
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
	public List<Reservation> findAll() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		List<Reservation> Reservations = null;
		Query query = em.createQuery("from Reservation m");
		Reservations = query.getResultList();
		em.close();
		return Reservations;
	}

	@SuppressWarnings("unchecked")
    public List<Reservation> findAllWithPassagerAndVol() {
        List<Reservation> Reservations = null;
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
        Query query = em.createNamedQuery("Reservation.findAllWithPassagerAndVol");
        Reservations = query.getResultList();
        em.close();
        return Reservations;
    }
}
