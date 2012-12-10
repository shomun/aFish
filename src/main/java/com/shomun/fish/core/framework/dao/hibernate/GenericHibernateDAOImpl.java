package com.shomun.fish.core.framework.dao.hibernate;

import java.io.Serializable;

import java.util.List;

import com.shomun.fish.core.data.entity.EntityBase;
import com.shomun.fish.core.framework.dao.GenericDAO;

public class GenericHibernateDAOImpl<T extends EntityBase, ID extends Serializable> extends HibernateBaseDAO implements
		GenericDAO<T, ID> {

	Class<T> persistentClass;
	
	public GenericHibernateDAOImpl(Class<T> type){
		this.persistentClass = type;
	}
	
	public T find(ID id) {
		return (T) _get(persistentClass, id);
	}

	public T[] find(ID... ids) {
		return (T[]) _get(persistentClass, ids);
	}

	public T getReference(ID id) {
		return (T) _load(persistentClass, id);
	}

	public T[] getReferences(ID... ids) {
		return _load(persistentClass, ids);
	}

	public boolean save(T entity) {
		return _saveOrUpdateIsNew(entity);
	}

	public boolean[] save(T... entities) {
		return _saveOrUpdateIsNew(entities);
	}

	public boolean remove(T entity) {
		return _deleteEntity(entity);
	}

	public void remove(T... entities) {
		_deleteEntities(entities);
	}

	public boolean removeById(ID id) {
		return _deleteById(persistentClass, id);
	}

	public void removeByIds(ID... ids) {
		_deleteById(persistentClass, ids);
		
	}

	public List<T> findAll() {
		return _all(persistentClass);
	}

	public boolean isAttached(T entity) {
		return _sessionContains(entity);
	}

	public void refresh(T... entities) {
		_refresh(entities);
		
	}

	public void flush() {
		_flush();
		
	}

}
