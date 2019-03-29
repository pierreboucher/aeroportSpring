package airport.dao;

import java.util.List;

public interface DaoGeneric<T, K> {

	T findByKey(K key);

	void insert(T obj);

	T update(T obj);

	void delete(T obj);

	void deleteByKey(K key);

	List<T> findAll();
}
