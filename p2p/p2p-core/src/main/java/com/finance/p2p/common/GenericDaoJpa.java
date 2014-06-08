package com.finance.p2p.common;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;


/**
 * JPA implementation for a generic DAO.
 *
 * @author MJ
 *
 * @param <T> the persistent entity.
 */
public class GenericDaoJpa<T extends P2PEntity> implements GenericDao<T> {

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	protected EntityManager entityManager;
	protected Class<T> entityType;
	protected final static Logger logger = Logger.getLogger("dao");

	/**
	 * Constructor.
	 * @param entityType the class of the persistent objects managed by this DAO.
	 */
	public GenericDaoJpa(Class<T> entityType) {
		this.entityType = entityType;
	}

	@Override
	@Transactional(readOnly=true)
	public T get(Integer id) {
		logger.debug(" Get "+entityType.getName()+" by id");
		if (id == null) {
			logger.error(" id required");
			return null;
		} else {
			return entityManager.find(entityType, id);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<T> getAll() {
		logger.debug(" Get all "+entityType.getName());
		Query query = entityManager.createQuery("select o from " + entityType.getName() + " o");
		return query.getResultList();
	}


  protected Order buildDefaultOrder(CriteriaBuilder criteriaBuilder, Root<T> from) {
    return null;
  }

	/**
	 * Override to provide a default order column.
	 * @return
	 */
  protected String getDefaultOrderAttribute() {
    return null;
  }


	@Override
	public void save(T object) {
		entityManager.persist(object);
	}

	@Override
	public void delete(T object) {
		logger.debug(" Delete the object "+object.getClass().getName());
		entityManager.remove(object);

	}

	@Override
	public T update(T object) {
		logger.debug(" Update the object "+object.getClass().getName());
		return entityManager.merge(object);
	}



}
