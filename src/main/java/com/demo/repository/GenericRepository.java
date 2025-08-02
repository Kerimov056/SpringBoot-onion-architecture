package com.demo.repository;

import java.util.List;

import com.demo.iRepository.IGenericRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class GenericRepository<T, ID> implements IGenericRepository<T, ID> {
	private final Class<T> entityClass;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	 protected GenericRepository(Class<T> entityClass) {
	        this.entityClass = entityClass;
	 }
	 
	 @Override
	 public T save(T entity) {
		 entityManager.persist(entity);
		 return entity;
	 }
	 
	 @Override
	 public T update(T entity) {
		 entityManager.merge(entity);
		 return entity;
	 }
	 
	 @Override
	 public void delete(T entity) {
         entityManager.remove(entity);
	 }
	 
	 @Override
	 public T findById(ID id) {
		 return entityManager.find(entityClass, id);
	 }
	 
	 @Override
	 public List<T> findAll(){
		 return entityManager.createQuery("from" + entityClass.getSimpleName(), entityClass).getResultList();
	 }
}
