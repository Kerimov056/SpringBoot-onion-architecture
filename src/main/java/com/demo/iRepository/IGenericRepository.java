package com.demo.iRepository;

import java.util.List;

public interface IGenericRepository<T, ID> {
	T save(T entity);
	T update(T entity);
	void delete(T entity);
	T findById(ID id);
	List<T> findAll();
}
