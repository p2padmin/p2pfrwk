package com.finance.p2p.common;

import java.util.List;


public interface GenericDao<T extends P2PEntity> {
    
	/**
	 * Returns the entity with the specified id.
	 * @param id the entity identifier to look up.
	 * @return the found entity or null if not found.
	 */
	public T get(Integer id);


	/**
	 * @return all the entities in the repository.
	 */
	public List<T> getAll();

	/**
	 * Saves the specified entity in the repository.
	 *
	 * @param object the entity to save.
	 */
	public void save(T object);

	/**
	 * Deletes the specified entity from the repository.
	 * @param object the entity to remove.
	 */
	public void delete(T object);

	/**
	 * Updates the specified entity from the repository.
	 * @param object the entity to update.
	 */
	public T update(T object);

}
