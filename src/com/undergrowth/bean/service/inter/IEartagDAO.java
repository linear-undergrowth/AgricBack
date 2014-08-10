package com.undergrowth.bean.service.inter;

import java.util.List;
import java.util.Set;

import com.undergrowth.bean.Eartag;
import com.undergrowth.bean.EartagId;

/**
 * Interface for EartagDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IEartagDAO {
	/**
	 * Perform an initial save of a previously unsaved Eartag entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * IEartagDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Eartag entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Eartag entity);

	/**
	 * Delete a persistent Eartag entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * IEartagDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Eartag entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Eartag entity);

	/**
	 * Persist a previously saved Eartag entity and return it or a copy of it to
	 * the sender. A copy of the Eartag entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * entity = IEartagDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Eartag entity to update
	 * @return Eartag the persisted Eartag entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Eartag update(Eartag entity);

	public Eartag findById(EartagId id);

	/**
	 * Find all Eartag entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Eartag property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Eartag> found by query
	 */
	public List<Eartag> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Eartag> findByEtSite(Object etSite, int... rowStartIdxAndCount);

	public List<Eartag> findByEtAntiepi(Object etAntiepi,
			int... rowStartIdxAndCount);

	public List<Eartag> findByEtFeeding(Object etFeeding,
			int... rowStartIdxAndCount);

	/**
	 * Find all Eartag entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Eartag> all Eartag entities
	 */
	public List<Eartag> findAll(int... rowStartIdxAndCount);
}